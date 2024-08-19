package com.dbconnection.dbpool;
import java.sql.Connection;
import java.sql.SQLException;
 
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
 
public class HikariCPDataSource {
 
    private static HikariConfig config = new HikariConfig();
 
    private static HikariDataSource ds;
 
    static {
        config.setDriverClassName(DBPoolConfig.DB_DRIVER);
        config.setJdbcUrl(DBPoolConfig.CONNECTION_URL);
        config.setUsername(DBPoolConfig.USER_NAME);
        config.setPassword(DBPoolConfig.PASSWORD);
        config.setMinimumIdle(DBPoolConfig.DB_MIN_CONNECTIONS);
        config.setMaximumPoolSize(DBPoolConfig.DB_MAX_CONNECTIONS);
        // Some additional properties
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }
 
    private HikariCPDataSource() {
        super();
    }
 
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}