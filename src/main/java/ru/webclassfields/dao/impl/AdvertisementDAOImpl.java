package ru.webclassfields.dao.impl;

import org.apache.log4j.Logger;
import ru.webclassfields.dao.AdvertisementDAO;
import ru.webclassfields.model.Advertisement;
import ru.webclassfields.util.DataBase;

import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AdvertisementDAOImpl implements AdvertisementDAO {

    private static final DataSource DATA_SOURCE = DataBase.getDataSource();
    private static final Logger LOG = Logger.getLogger(AdvertisementDAOImpl.class);

    private Connection connection;

    public AdvertisementDAOImpl() {
    }

    public AdvertisementDAOImpl(Connection conn) {
        this.connection = conn;
    }

    @Override
    public void createAdvertisement() {

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
            return  DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            String msg = "Error at AdvertisementDAOImpl::getConnectionOrThrowException:  " + e.getMessage();
            LOG.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }



    public void closeConnection () {

        try {
            if(this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException e) {
            String msg = "Error at AdvertisementDAOImpl::closeConnection:  " + e.getMessage();
            LOG.error(msg, e);
        }

    }

    @Override
    public Long deleteAdvertisementById(Long adId) {
        return null;
    }







}