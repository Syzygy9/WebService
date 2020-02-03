package ru.webclassfields.dao;

import ru.webclassfields.model.Advertisement;
import ru.webclassfields.model.User;

import java.sql.Connection;
import java.util.List;

public interface AdvertisementDAO {
    Connection getConnectionOrThrowException();

    void closeConnection ();

    Long createAdvertisement(User user, Advertisement advertisement);

    Advertisement getAdvertidementById(Long adId);

    List<Advertisement> listAll();

    Integer deleteAdvertisementById(Long userID, Long adId);

    void update(User user, Advertisement advertisement);
}


//        1) Cоздавать объявление
//        3) Удалять
//        4) Искать обьявление по уникальному идентификатору
//        5) Выводить список всех объявлений по уникальному идентификатору пользователя (все обявления одного пользователя)
