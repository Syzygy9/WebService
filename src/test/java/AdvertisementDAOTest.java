import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.webclassfields.dao.AdvertisementDAO;
import ru.webclassfields.dao.impl.AdvertisementDAOImpl;
import ru.webclassfields.model.Advertisement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdvertisementDAOTest {
    private Connection conn;


    @Before
    public void initDBConn() {
        this.getConnectionOrThrowException();

    }

    @After
    public void deInit() {
        this.closeConnection();
    }

    @Test
    public void testListAll() {
        AdvertisementDAO advertisementDAO = new AdvertisementDAOImpl(this.conn);
        List<Advertisement> ads =  advertisementDAO.listAll();

        assertTrue(!ads.isEmpty());
    }

    @Test
    public void testGetAdById () {
        AdvertisementDAO advertisementDAO = new AdvertisementDAOImpl(this.conn);
        Advertisement ad =  advertisementDAO.getAdvertidementById(1L);

        assertTrue(ad!= null);
    }


    private void getConnectionOrThrowException() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        Connection conn = null;

        try {

            this.conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/usersads?" +
                            "user=user&password=user_user&useUnicode=true&serverTimezone=UTC");


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    private void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
