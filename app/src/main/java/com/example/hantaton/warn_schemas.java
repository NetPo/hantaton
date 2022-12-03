package com.example.hantaton;

public class warn_schemas {
    private String name;
    private String risks;
    private int image;

    public warn_schemas(String name, String risks, int image) {
        this.name = name;
        this.risks = risks;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRisks() {
        return risks;
    }

    public void setRisks(String risks) {
        this.risks = risks;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
