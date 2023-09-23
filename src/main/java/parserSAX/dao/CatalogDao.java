package parserSAX.dao;

import parserSAX.model.CompactDisc;
import parserSAX.services.ParserXml;
import parserSAX.services.ParserXmlSaxImpl;

import java.util.Set;

public interface CatalogDao {

    void insert(ParserXml parserXml);

}
