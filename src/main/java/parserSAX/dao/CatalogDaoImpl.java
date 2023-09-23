package parserSAX.dao;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import parserSAX.model.CompactDisc;
import parserSAX.services.ParserXml;
import parserSAX.utils.Props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

@AllArgsConstructor

public class CatalogDaoImpl implements CatalogDao {
    private final Props props;

    @Override
    public void insert(ParserXml parserXml) {
        Set<CompactDisc> discSet = parserXml.getAll();
        String insertEmployeeSQL =
                "REPLACE into schema_itsjava.catalog_cd (title, artist, country, company, price, year) values (?, ?, ?, ?, ?, ?)";


        try (Connection connection = DriverManager.getConnection(
                props.getValue("db.url"),
                props.getValue("db.login"),
                props.getValue("db.password"));
        ) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertEmployeeSQL);
            for (CompactDisc disc : discSet) {
                preparedStatement.setString(1, disc.getTitle());
                preparedStatement.setString(2, disc.getArtist());
                preparedStatement.setString(3, disc.getCountry());
                preparedStatement.setString(4, disc.getCompany());
                preparedStatement.setDouble(5, disc.getPrice());
                preparedStatement.setInt(6, disc.getYear());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
