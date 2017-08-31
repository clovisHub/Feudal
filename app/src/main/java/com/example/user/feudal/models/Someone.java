package com.example.user.feudal.models;


 public class Someone {

    String name;

    int personImage;

    public Someone(String persoName,int persoImage)
    {
        this.personImage = persoImage;
        this.name = persoName;
    }

    public String getName()
    {
        return name;
    }
    public int getImage()
    {
        return personImage;
    }
}




