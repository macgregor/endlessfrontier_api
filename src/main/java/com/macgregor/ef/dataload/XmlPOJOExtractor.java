package com.macgregor.ef.dataload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.macgregor.ef.exceptions.DataLoadException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class XmlPOJOExtractor<T> {
    private static final Logger logger = Logger.getLogger(XmlPOJOExtractor.class.getName());
    private static final ObjectMapper XML_MAPPER = new XmlMapper();

    private Class<T> t;

    public XmlPOJOExtractor(Class<T> t){
        this.t = t;
    }

    private Document loadXml(String uri) throws DataLoadException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            try {
                InputSource input = new InputSource(uri);
                input.setEncoding("UTF-8");
                Document doc = builder.parse(input);
                return doc;
            } catch (SAXException e) {
                throw new DataLoadException("Error parsing document " + uri + " make sure the file is well formed xml", e);
            } catch (IOException e) {
                throw new DataLoadException("Error loading file " + uri, e);
            }
        } catch (ParserConfigurationException e) {
            throw new DataLoadException("Something is very wrong with the xml library, this shouldnt happen", e);
        }
    }

    private XPathExpression compileXPathExpression(String rawXPath) throws DataLoadException {
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = null;
        try {
            expr = xpath.compile(rawXPath);
            return expr;
        } catch (XPathExpressionException e) {
            throw new DataLoadException("Invalid xpath " + rawXPath, e);
        }
    }

    public List<T> extract(String uri, String rawXPath) throws DataLoadException {
        Document doc = loadXml(uri);
        XPathExpression expr = compileXPathExpression(rawXPath);
        try {
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            logger.info(String.format("Matched %d nodes", nodes.getLength()));
            List<T> extracted = new ArrayList<T>();
            for(int i = 0; i < nodes.getLength(); i++){
                try {
                    logger.info(String.format("Node %d: %s", i, nodeToString(nodes.item(i))));
                    T parsed = XML_MAPPER.readValue(nodeToString(nodes.item(i)), t);
                    extracted.add(parsed);
                } catch (IOException e) {
                    throw new DataLoadException("Error mapping xml to " + t.getSimpleName(), e);
                }
            }
            return extracted;
        } catch (XPathExpressionException e) {
            throw new DataLoadException("Error evaluating xpath expression against document", e);
        }
    }

    private static String nodeToString(Node node) throws DataLoadException {
        StringWriter buf = new StringWriter();
        try {
            Transformer xform = TransformerFactory.newInstance().newTransformer();
            xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            xform.transform(new DOMSource(node), new StreamResult(buf));
            return(buf.toString());
        } catch (TransformerException e) {
            throw new DataLoadException("Error transforming XML Node into string", e);
        }
    }
}
