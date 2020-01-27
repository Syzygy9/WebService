package ru.webclassfields.util;

import org.apache.log4j.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataBase {
    static Logger logger = Logger.getLogger(DataBase.class);
    private static DataSource ds = null;

    static {
        logger.info("Inside Database() static method... ");
        Context context;
        try {
            context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/usersads");
        } catch (NamingException e) {
            logger.error("Unable to get Datasource...");
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
