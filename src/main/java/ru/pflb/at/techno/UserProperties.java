package ru.pflb.at.techno;

import java.io.InputStream;
import java.util.Properties;

public class UserProperties {

    private static final String PROPERTIES_FILE = "/User.properties";

    private String login;

    private String mail;

    private String password;

    public String getLogin() {
        return login;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public UserProperties() {
        readFileProperties();
    }

    public void readFileProperties() {
        try (InputStream in = UserProperties.class.getResourceAsStream(PROPERTIES_FILE)) {
            Properties config = new Properties();
            config.load(in);

            login = config.getProperty("LOGIN");
            password = config.getProperty("PASSWORD");
            mail = config.getProperty("MAIL");

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}