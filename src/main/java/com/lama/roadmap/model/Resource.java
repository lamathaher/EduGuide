package com.lama.roadmap.model;

public class Resource {

    private String path;
    private String topic;
    private String stepName;
    private String resourceName;
    private String link;
    private String type;

    public Resource(String path, String topic, String stepName, String resourceName, String link, String type) {
        this.path = path;
        this.topic = topic;
        this.stepName = stepName;
        this.resourceName = resourceName;
        this.link = link;
        this.type = type;
    }

    public String getPath() { return path; }
    public String getTopic() { return topic; }
    public String getStepName() { return stepName; }
    public String getResourceName() { return resourceName; }
    public String getLink() { return link; }
    public String getType() { return type; }
}