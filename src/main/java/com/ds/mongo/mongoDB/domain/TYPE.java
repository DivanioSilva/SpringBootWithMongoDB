package com.ds.mongo.mongoDB.domain;

public enum TYPE {
    FATHER("father"), MOTHER("mother");

    private String value;

    TYPE(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
