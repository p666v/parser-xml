package parserSAX;


import parserSAX.model.CompactDisc;
import parserSAX.services.AppService;
import parserSAX.services.AppServiceImpl;
import parserSAX.services.ParserXml;
import parserSAX.services.ParserXmlSaxImpl;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AppService appService = new AppServiceImpl();
        appService.start();
    }
}
