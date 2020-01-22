package ru.pflb.at.techno.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonParser {

    public JacksonParser() {
        reader();
    }

    private Storage storage;

    public void reader() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            storage = mapper
                    .readValue(new File("C:\\projects\\MyWorldTest\\src\\main\\resources\\OtherProperties.jsonParser"), Storage.class);
            System.out.println(storage);

            storage.getImage_url();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get_Url() {
        return storage.getUrl();
    }

    public String get_Image_url() {
        return storage.getImage_url();
    }
}

