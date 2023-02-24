package org.example.IO;

import org.example.description_for_collection.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
            System.out.println(inputTitle);
            name = scanner.nextLine().trim();
            //exceptions
            break;
        }
        return name;
    }
    public String askGroupName(){
        return askName("Enter Study Group name", 0, "Study Group name");}
    public String askPersonName(){
        return askName("Enter Admin name:", 0,"Person name");
    }


    public Double askCoordinatesX(){
        String strX;
        Double x;
        while (true){
            //exceptions
            System.out.println("Enter X coord: ");
            strX = scanner.nextLine().trim();
            x=Double.parseDouble(strX);
            break;
        }
        return x;
    }

    public Float askCoordinatesY(){
        String strY;
        Float y;
        while (true){
            //exceptions
            System.out.println("Enter Y coord:");
            strY = scanner.nextLine().trim();
            y = Float.parseFloat(strY);
            break;
        }
        return y;
    }

    public Coordinates askCoordinates(){
        Double x = askCoordinatesX();
        Float y = askCoordinatesY();
        return new Coordinates(x,y);
    }

    public int askStudentCount(){
        return 9;
    }

    public Integer askShouldBeExpelled(){
        return 3;
    }

    public double askAvarageMark(){
        return 5;
    }
    public Semester askSemesterEnum(){
        return Semester.FIFTH;
    }

    public Person askPerson(){
        Person admin = new Person();
        String name = askPersonName();
        admin.setName(name);
        Date date = askBirthday();
        admin.setBirthday(date);
        return admin;

        //askBirthday
        //askEyeColor
        //askHairColor
        //askNationakity
    }
    public java.util.Date askBirthday(){
        //xp[ how wtf
        Date date = new Date("January 1, 1970");
        return date;
    }
    public ColorEye askEyeColor(){
        return ColorEye.BROWN;
    }
    public ColorHair askHairColor(){
        return ColorHair.RED;
    }

    public Country askNationakity(){
        return Country.NORTH_KOREA;
    }




}
