package ru.webclassfields.dao.impl;

import org.apache.log4j.Logger;
import ru.webclassfields.dao.UserDAO;
import ru.webclassfields.util.DataBase;

import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO {

    private DataSource datasource = DataBase.getDataSource();
    private Logger logger = Logger.getLogger(UserDAOImpl.class);

    @Override
    public Long getUserId() {

        return null;
    }

    @Override
    public String getSurname() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public Long getCategory() {
        return null;
    }
}
