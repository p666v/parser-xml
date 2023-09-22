package parserSAX.services;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import parserSAX.model.Catalog;
import parserSAX.model.CompactDisc;
import parserSAX.model.TagXml;

import java.util.ArrayList;
import java.util.List;

public class SaxParserHandler extends DefaultHandler {

    private Catalog catalog = new Catalog();
    private List<CompactDisc> compactDiscList = new ArrayList<>();

    private String currentTagName;
    private boolean isCatalog = false;
    private boolean isCD = false;

    private String title;
    private String artist;
    private String country;
    private String company;
    private double price;
    private int year;

    public Catalog getCatalog() {
        return catalog;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {

        catalog.setDiscList(compactDiscList);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;
        if (currentTagName.equals(String.valueOf(TagXml.CATALOG))) {
            isCatalog = true;
        } else if (currentTagName.equals(String.valueOf(TagXml.CD))) {
            isCD = true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {


        if (qName.equals(String.valueOf(TagXml.CATALOG))) {
            isCatalog = false;
        } else if (qName.equals(String.valueOf(TagXml.CD))) {
            isCD = false;
            CompactDisc compactDisc = new CompactDisc(title, artist, country, company, price, year);
            compactDiscList.add(compactDisc);
        }

        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (currentTagName == null) {
            return;
        }

        if (isCatalog && isCD) {
            if (currentTagName.equals(String.valueOf(TagXml.TITLE))) {
                title = new String(ch, start, length);
            } else if (currentTagName.equals(String.valueOf(TagXml.ARTIST))) {
                artist = new String(ch, start, length);
            } else if (currentTagName.equals(String.valueOf(TagXml.COUNTRY))) {
                country = new String(ch, start, length);
            } else if (currentTagName.equals(String.valueOf(TagXml.COMPANY))) {
                company = new String(ch, start, length);
            } else if (currentTagName.equals(String.valueOf(TagXml.PRICE))) {
                price = Double.parseDouble(new String(ch, start, length));
            } else if (currentTagName.equals(String.valueOf(TagXml.YEAR))) {
                year = Integer.parseInt(new String(ch, start, length));
            }


        }
    }


}
