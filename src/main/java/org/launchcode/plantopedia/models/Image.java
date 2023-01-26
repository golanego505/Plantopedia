package org.launchcode.plantopedia.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
    private Integer id;
    @JsonProperty("image_url")
    private String imageUrl;
    private String copyright;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", copyright='" + copyright + '\'' +
                '}';
    }
}
