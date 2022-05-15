package com.tutorapp.model;

public enum Topic {
    HTML5("HTML5"),
    ANGULAR("Angular") ,
    PYTHON("Python"),
    DIGITAL("Digital_Marketing"),
    NODE("Node_JS"),
    REACT("React_JS"),
    CSS("CSS"),
    DJANGO("Django"),
    SPRING("Spring"),
    JAVA("Java"),
    MONGO_DB("MongoDB"),
    COUCH_DB("CouchDB"),
    POSTMAN("Postman"),
    SELENIUM("Selenium");

    public String topicName;

    Topic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
}
