package parserSAX.services;

import org.xml.sax.SAXException;
import parserSAX.model.CompactDisc;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class ParserXmlSaxImpl implements ParserXml {

    @Override
    public Set<CompactDisc> getAll() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;

        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open parsing error" + e.toString());
        }

        File file = new File("src/main/resources/catalog.xml");

        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("Sax parsing error" + e.toString());
        } catch (IOException e) {
            System.out.println("IO parsing error" + e.toString());
        }

        return handler.getCompactDiscList();


    }


}
