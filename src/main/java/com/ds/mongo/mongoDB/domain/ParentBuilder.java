package com.ds.mongo.mongoDB.domain;

public class ParentBuilder {
    private String name;
    private String type;

    public ParentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ParentBuilder setType(TYPE type) {
        this.type = type.getValue();
        return this;
    }

    public Parent createParent() {
        return new Parent(name, type);
    }
}