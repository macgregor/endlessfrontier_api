package com.macgregor.ef.dataload;

import com.macgregor.ef.exceptions.DataLoadException;
import com.macgregor.ef.model.Unit;

import java.util.List;
import java.util.logging.Logger;

public class EndlessFrontierDataLoader {
    private static final Logger logger = Logger.getLogger(EndlessFrontierDataLoader.class.getName());

    public static void load() throws DataLoadException {
        XmlPOJOExtractor unitExtractor = new XmlPOJOExtractor();
        List<Unit> units = unitExtractor.extract("src/main/resources/ef/unitbook.xml", "//unit", Unit.class);
        for(Unit unit : units){
            logger.info(unit.toString());
        }

    }
}
