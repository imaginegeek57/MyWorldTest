package ru.pflb.at.techno.webConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class WebConfig {

    private WebConfigModel webConfigModel;

    public WebConfig() {
        readJsonFile();
    }

    public void readJsonFile() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            webConfigModel = mapper
                    .readValue(WebConfig.class.getResource("/WebProperties.json"), WebConfigModel.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return webConfigModel.getUrl();
    }

    public String getImageUrl() {
        return webConfigModel.getImageUrl();
    }
}

