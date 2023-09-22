package parserSAX;


import parserSAX.model.Catalog;
import parserSAX.services.SaxXmlParser;

public class Main {
    public static void main(String[] args) {

        SaxXmlParser saxXmlParser = new SaxXmlParser();
        Catalog catalog = saxXmlParser.parse();

        System.out.println("Catalog " + catalog.toString());

    }
}
