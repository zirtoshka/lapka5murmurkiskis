package org.example.description_for_collection;

public class Coordinates {
    private Double x; //Максимальное значение поля: 576, Поле не может быть null
    private Float y; //Значение поля должно быть больше -596, Поле не может быть null

    public Coordinates(Double x, Float y){
        this.x=x;
        this.y=y;
    }

    public void setX(Double x){
        this.x=x;
    }

    public void setY(Float y){
        this.y=y;
    }

}
