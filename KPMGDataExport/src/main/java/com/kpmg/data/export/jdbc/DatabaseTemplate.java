package com.kpmg.data.export.jdbc;

import com.kpmg.data.export.utils.DataConvertUtil;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseTemplate {

    private static Logger logger = Logger.getLogger("DatabaseTemplate");

    public static boolean testLink(String driver, String url, String username, String password) {

        Connection conn = getConnection(driver, url, username, password);
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.warning("colse conn fail :" + e);
            }
            return true;
        } else {
            return false;
        }

    }

    /**
     * 获取连接
     *
     * @param driver
     * @param url
     * @param username
     * @param password
     * @return
     */
    public static Connection getConnection(String driver, String url, String username, String password) {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        String driverName = DataConvertUtil.getDataBaseDriver(driver);
        String realUrl = DataConvertUtil.getRealUrl(driver, url.trim());
        ds.setDriverClassName(driverName);
        ds.setUrl(realUrl);
        ds.setUsername(username);
        ds.setPassword(password);
        try {
            Connection actualCon = ds.getConnection();
            return actualCon;

        } catch (SQLException e) {
            logger.warning("connection database fail :" + e);
        }
        return null;
    }


}
