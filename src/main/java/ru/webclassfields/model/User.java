package ru.webclassfields.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class User {
    private Long userId;
    private String surName;
    private String firstName;
    private String email;
    private Long category;

    @JsonProperty (value = "user-id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @JsonProperty (value = "surname")
    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
    @JsonProperty (value = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @JsonProperty (value = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty (value = "category")
    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}

