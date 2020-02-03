package ru.webclassfields.dao.impl;

import org.apache.log4j.Logger;
import ru.webclassfields.dao.AdvertisementDAO;
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

public class AdvertisementDAOImpl implements AdvertisementDAO {

    private static final DataSource DATA_SOURCE = DataBase.getDataSource();
    private static final Logger LOG = Logger.getLogger(AdvertisementDAOImpl.class);

    private static AdvertisementDAO advertisementDAO = new AdvertisementDAOImpl();

    private Connection connection;

    private AdvertisementDAOImpl() {
    }

    public static AdvertisementDAO getInstance() {
        return advertisementDAO;
    }


    public AdvertisementDAOImpl(Connection conn) {
        this.connection = conn;
    }


    @Override
    public Long createAdvertisement(User user, Advertisement advertisement) {

        try {
            this.connection = DATA_SOURCE.getConnection();


            String sql = "insert into  admnts (ad_id, category, head, body, phone, date, user_id) " +
                    "values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setLong(1, advertisement.getAdId());
            preparedStatement.setInt(2, advertisement.getCategory());
            preparedStatement.setString(3, advertisement.getHead());
            preparedStatement.setString(4, advertisement.getBody());
            preparedStatement.setString(5, advertisement.getPhone());
            preparedStatement.setLong(6, advertisement.getDate());
            preparedStatement.setLong(7, user.getUserId());

            int row = preparedStatement.executeUpdate();
            LOG.info("AdvertisementDAOImpl::createAdvertisement. inserted number" + row + " with id " + advertisement.getAdId() + "into admnts");

            return advertisement.getAdId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (this.connection != null) {
                try {
                    this.connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public Advertisement getAdvertidementById(Long adId) {
        try {
            this.connection = DATA_SOURCE.getConnection();
            PreparedStatement st = this.connection.prepareStatement("select * from admnts a where a.ad_id = ?");
            st.setLong(1, adId);
            ResultSet rs = st.executeQuery();

            List<Advertisement> ads = new LinkedList<>();

            while (rs.next()) {
                Advertisement advertisment = new Advertisement();

                advertisment.setAdId(rs.getLong("ad_id"));
                advertisment.setCategory(rs.getInt("category"));
                advertisment.setBody(rs.getString("body"));
                advertisment.setHead(rs.getString("head"));
                advertisment.setPhone(rs.getString("phone"));
                advertisment.setDate(rs.getLong("date"));
                advertisment.setUserId(rs.getLong("user_id"));

                ads.add(advertisment);

            }//while

            return ads.get(0);

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
    public List<Advertisement> listAll() {

        try {
            this.connection = DATA_SOURCE.getConnection();
            PreparedStatement st = this.connection.prepareStatement("select * from admnts");
            ResultSet rs = st.executeQuery();

            List<Advertisement> ads = new LinkedList<>();

            while (rs.next()) {
                Advertisement advertisment = new Advertisement();

                advertisment.setAdId(rs.getLong("ad_id"));
                advertisment.setCategory(rs.getInt("category"));
                advertisment.setBody(rs.getString("body"));
                advertisment.setHead(rs.getString("head"));
                advertisment.setPhone(rs.getString("phone"));
                advertisment.setDate(rs.getLong("date"));
                advertisment.setUserId(rs.getLong("user_id"));

                ads.add(advertisment);

            }//while

            return ads;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Connection getConnectionOrThrowException() {
        try {
            return DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            String msg = "Error at AdvertisementDAOImpl::getConnectionOrThrowException:  " + e.getMessage();
            LOG.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }


    public void closeConnection() {

        try {
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException e) {
            String msg = "Error at AdvertisementDAOImpl::closeConnection:  " + e.getMessage();
            LOG.error(msg, e);
        }

    }

    @Override
    public Integer deleteAdvertisementById(Long userID, Long adId) {

        try {
            this.connection = DATA_SOURCE.getConnection();


            String sql = "delete from admnts WHERE user_id=? and ad_id=?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setLong(1, userID);
            preparedStatement.setLong(2, adId);


            int row = preparedStatement.executeUpdate();
            LOG.info("AdvertisementDAOImpl::createAdvertisement. deleted rows " + row + " with userId " + (userID) + " and with adID from admnts") ;

            return row;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (this.connection != null) {
                try {
                    this.connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }




}