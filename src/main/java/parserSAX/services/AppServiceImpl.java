package parserSAX.services;

import parserSAX.dao.CatalogDao;
import parserSAX.dao.CatalogDaoImpl;
import parserSAX.utils.Props;

public class AppServiceImpl implements AppService {
    private final ParserXml parserXml = new ParserXmlSaxImpl();
    private final CatalogDao catalogDao = new CatalogDaoImpl(new Props());

    @Override
    public void start() {

        parserXml.getAll();

        catalogDao.insert(parserXml);

    }
}

