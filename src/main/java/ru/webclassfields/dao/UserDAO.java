package ru.webclassfields.dao;

import ru.webclassfields.model.User;

public interface UserDAO {

    Long getUserId();

    User getIdUserByEmail(String name);

    String getSurname();

    String getName();

    String getEmail();

    Long getCategory();

}
