package ru.webclassfields.dao.impl;

import org.apache.log4j.Logger;
import ru.webclassfields.dao.UserDAO;
import ru.webclassfields.model.Advertisement;
import ru.webclassfields.model.User;
import ru.webclassfields.util.DataBase;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static DataSource DATA_SOURCE = DataBase.getDataSource();
    private static Logger LOG = Logger.getLogger(UserDAOImpl.class);

    private Connection connection;

    private static UserDAO userDAO =  new UserDAOImpl();

    public static UserDAO getInstance() {
        return userDAO;
    }

    @Override
    public Long getUserId() {

        return null;
    }

    @Override
    public User getIdUserByEmail(String email) {
        try {
            this.connection = DATA_SOURCE.getConnection();
            PreparedStatement st = this.connection.prepareStatement("select a.user_id from user a where a.e_mail = ?");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();

            List<User> users = new LinkedList<>();

            while (rs.next()) {
                User user = new User();

                user.setUserId(rs.getLong("user_id"));


                users.add(user);

            }//while

            return users.get(0);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
