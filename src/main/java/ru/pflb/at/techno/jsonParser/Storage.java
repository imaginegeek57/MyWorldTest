package ru.pflb.at.techno.jsonParser;


public class Storage {

    private String url;
    private String image_url;

    protected Storage() {
    }

    protected Storage(String url, String image_url) {
        this.url = url;
        this.image_url = image_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
