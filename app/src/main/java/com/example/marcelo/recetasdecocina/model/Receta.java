package com.example.marcelo.recetasdecocina.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Marcelo on 14/09/2017.
 */

public class Receta {

    private String publisher;
    private String title;
    @SerializedName("image_url")
    private String imageURL;
    @SerializedName("social_rank")
    private float socialRank;
    @SerializedName("source_url")
    private String sourceURL;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public float getSocialRank() {
        return socialRank;
    }

    public void setSocialRank(float socialRank) {
        this.socialRank = socialRank;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }

}
