package ru.webclassfields.service;

import ru.webclassfields.dao.AdvertisementDAO;
import ru.webclassfields.dao.impl.AdvertisementDAOImpl;
import ru.webclassfields.model.Advertisement;
import ru.webclassfields.model.User;

public class AdvertisementBusiness {
    private AdvertisementDAO advertisementDAO = AdvertisementDAOImpl.getInstance();


    private static AdvertisementBusiness advertisementBusiness = new AdvertisementBusiness();

    public static AdvertisementBusiness getInstance() {
        return advertisementBusiness;
    }


    private AdvertisementBusiness () {

    }


    public Advertisement getAdvertisementById(Long adId) {

        try {
            advertisementDAO.getConnectionOrThrowException();
            Advertisement advertisement = advertisementDAO.getAdvertidementById(adId);

            return advertisement;
        } finally {
            advertisementDAO.closeConnection();
        }

    }


    public Long createAdvertisement(User user, Advertisement advertisement) {
        return advertisementDAO.createAdvertisement(user, advertisement);
    }

    public int deleteAdvertisementById(Long userID, Long adId ) {

        return advertisementDAO.deleteAdvertisementById(userID, adId);
    }

}
