package parserSAX.services;

import org.xml.sax.SAXException;
import parserSAX.model.Catalog;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxXmlParser implements ParserXml{

    @Override
    public Catalog parse() {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;

        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open parsing error" + e.toString());
            return null;
        }

        File file = new File("src/main/resources/catalog.xml");

        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("Sax parsing error" + e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("IO parsing error" + e.toString());
            return null;
        }

        return handler.getCatalog();
    }


}
