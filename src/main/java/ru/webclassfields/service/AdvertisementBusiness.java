package ru.webclassfields.service;

import ru.webclassfields.dao.AdvertisementDAO;
import ru.webclassfields.dao.impl.AdvertisementDAOImpl;
import ru.webclassfields.model.Advertisement;
import ru.webclassfields.model.User;

public class AdvertisementBusiness {
    private AdvertisementDAO advertisementDAO = AdvertisementDAOImpl.getInstance();
    public Advertisement getAdvertidementById(Long adId) {

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

}
