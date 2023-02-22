package org.example.IO;

import org.example.description_for_collection.*;

import java.util.Scanner;

public class ScannerManager {
    private final double MAX_X=576;
    private final float MIN_Y=-596;
    private Scanner scanner;

    public ScannerManager(Scanner scanner){
        this.scanner=scanner;
    }

    public String askName(String inputTitle, int minLength, String typeOfName){
        String name;
        while (true){
            name = scanner.nextLine().trim();
            break;
        }
        return name;
    }
    public String askPersonName(){
        return new String();
    }


    public Double askCoordinatesX(){
        return null;
    }

    public Float askCoordinatesY(){
        return null;
    }

    public Coordinates askCoordinates(){
        return null;
    }

    public int askStudentCount(){
        return 9;
    }

    public Integer askShouldBeExpelled(){
        return null;
    }

    public double askAvarageMark(){
        return 3;
    }
    public Semester askSemesterEnum(){
        return Semester.FIFTH;
    }

    public Person askPerson(){
        return null;
        //askBirthday
        //askEyeColor
        //askHairColor
        //askNationakity
    }
    public java.util.Date askBirthday(){
        return null;
    }
    public ColorEye askEyeColor(){
        return null;
    }
    public ColorHair askHairColor(){
        return null;
    }

    public Country askNationakity(){
        return null;
    }




}
