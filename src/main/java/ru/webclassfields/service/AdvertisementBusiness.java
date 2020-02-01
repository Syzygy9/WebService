package ru.webclassfields.service;

import ru.webclassfields.dao.AdvertisementDAO;
import ru.webclassfields.dao.impl.AdvertisementDAOImpl;
import ru.webclassfields.model.Advertisement;

public class AdvertisementBusiness {
    private AdvertisementDAO advertisementDAO = new AdvertisementDAOImpl();
    public Advertisement getAdvertidementById(Long adId) {

        try {
            advertisementDAO.getConnectionOrThrowException();
            Advertisement advertisement = advertisementDAO.getAdvertidementById(adId);

            return advertisement;
        } finally {
            advertisementDAO.closeConnection();
        }

    }

}
