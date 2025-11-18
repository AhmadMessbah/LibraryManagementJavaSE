package com.mftplus.model.utils;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class ConnectionProvider {
    @Getter
    private final static ConnectionProvider instance = new ConnectionProvider();
    private final BasicDataSource dataSource = new BasicDataSource();

    private ConnectionProvider() {
        log.info("ConnectionPool created");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:./db/library_db;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE;MODE=ORACLE;");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setMinIdle(5);
        dataSource.setMaxTotal(20);
    }

    public Connection getConnection() throws SQLException {
        log.info("Get Connection from ConnectionPool");
        return dataSource.getConnection();
    }

    public Long getNextId(String sequenceName) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(String.format( "select %s.nextval as NEXT_ID from dual",sequenceName));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            log.info(sequenceName + " NEXT_ID fetched from database");
            return resultSet.getLong("NEXT_ID");
        }
    }

    public void close() throws SQLException {
        log.info("ConnectionPool closed");
        dataSource.close();
    }
}
