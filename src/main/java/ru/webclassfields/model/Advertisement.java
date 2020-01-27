package ru.webclassfields.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Advertisement {

    private Long adId;
    private Integer category;
    private String head;
    private String body;
    private String phone;
    private Long date;
    private Long userId;

    @JsonProperty (value="ad_id")
    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }
    @JsonProperty (value="category")
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
    @JsonProperty (value="head")
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
    @JsonProperty (value="body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    @JsonProperty (value="phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @JsonProperty (value="date")
    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
    @JsonProperty (value="user-id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
