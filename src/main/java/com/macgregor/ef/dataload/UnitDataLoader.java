package com.macgregor.ef.dataload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.macgregor.ef.dao.UnitDAO;
import com.macgregor.ef.model.Unit;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

public class UnitDataLoader {
    private UnitDAO unitDAO;
    private ObjectMapper xmlMapper;

    public UnitDataLoader(UnitDAO unitDAO){
        unitDAO = unitDAO;
        ObjectMapper xmlMapper = new XmlMapper();
    }

    public void loadUnitData(String uri, String unitListXPath) throws IOException, SAXException, XPathExpressionException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(uri);
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile(unitListXPath);
        NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        for(int i = 0; i < nl.getLength(); i++){
            Unit unit = xmlMapper.readValue(nl.item(i).toString(), Unit.class);
            unitDAO.insert(unit);
        }
    }
}
