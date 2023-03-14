package org.example.description_for_collection;

import org.example.IO.ConsoleManager;
import org.example.exceptions.IncorrectValueException;

public class Coordinates {

    private Double coordinatesX; //Максимальное значение поля: 576, Поле не может быть null
    private static final Double MAX_X = 576D;
    private static final Float MIN_Y=-596F;
    private Float coordinatesY; //Значение поля должно быть больше -596, Поле не может быть null


    public Coordinates() {
    }

    public Coordinates(Double x, Float y) {
        this.coordinatesX = x;
        this.coordinatesY = y;
    }

    public boolean setX(Double coordinatesX) {
        try{
            if(coordinatesX>MAX_X) throw new IncorrectValueException();
            this.coordinatesX=coordinatesX;
            return true;
        } catch (IncorrectValueException e){
            ConsoleManager.printError("This value has to be less than " + MAX_X);
            return false;
        }
    }

    public Double getCoordinatesX() {
        return coordinatesX;
    }

    public boolean setY(Float coordinatesY) {
        try{
            if(coordinatesY<MIN_Y) throw new IncorrectValueException();
            this.coordinatesY=coordinatesY;
            return true;
        } catch (IncorrectValueException e){
            ConsoleManager.printError("This value has to be more than " + MIN_Y);
            return false;
        }
    }

    public Float getCoordinatesY() {
        return coordinatesY;
    }

    @Override
    public String toString() {
        return getCoordinatesX() + " " + getCoordinatesY();
    }
}
