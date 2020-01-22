package ru.pflb.at.techno.webConfig;


import com.fasterxml.jackson.annotation.JsonProperty;

public class WebConfigModel {

    @JsonProperty("url")
    private String url;

    @JsonProperty("image_url")
    private String imageUrl;

    protected WebConfigModel() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getUrl() {
        return url;
    }

}
