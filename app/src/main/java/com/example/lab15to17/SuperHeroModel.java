package com.example.lab15to17;
public class SuperHeroModel {
    private String name;
    private String power;
    private String imageUrl;
    private int drawableId;

    public SuperHeroModel(String name, String power, String imageUrl, int drawableId) {
        this.name = name;
        this.power = power;
        this.imageUrl = imageUrl;
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public String getPower() {
        return power;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getDrawableId() {
        return drawableId;
    }
}
