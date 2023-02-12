package org.example.description_for_collection;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date birthday; //Поле может быть null
    private ColorEye eyeColor; //Поле не может быть null
    private ColorHair hairColor; //Поле может быть null
    private Country nationality; //Поле может быть null

    public Person(String name, java.util.Date birthday, ColorEye eyeColor, ColorHair hairColor, Country nationality) {
        this.name = name;
        this.birthday = birthday;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }
}
