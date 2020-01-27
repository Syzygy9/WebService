package ru.webclassfields.dao;

import ru.webclassfields.model.Advertisement;

import java.sql.Connection;
import java.util.List;

public interface AdvertisementDAO {
    Connection getConnectionOrThrowException();

    void closeConnection ();

    void createAdvertisement();

    Advertisement getAdvertidementById(Long adId);

    List<Advertisement> listAll();

    Long deleteAdvertisementById(Long adId);

}


//1) Cоздавать объявление
//        3) Удалять
//        4) Искать обьявление по уникальному идентификатору
//        5) Выводить список всех объявлений по уникальному идентификатору пользователя (все обявления одного пользователя)
