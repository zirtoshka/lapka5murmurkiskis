package org.example.IO;

import org.example.description_for_collection.*;

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
        int a=10;
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
        return new Person(askPersonName(),askBirthday(),askEyeColor(),askHairColor(),askNationality());

        //askBirthday
        //askEyeColor
        //askHairColor
        //askNationakity
    }
    public java.util.Date askBirthday(){
        //xp[ how wtf
        String strDate;
        Date date;
        while (true){
            System.out.println("You can use format - 'January 19, 1970'");
            System.out.println("Enter your birthday for admin: ");
            strDate = scanner.nextLine().trim();
            date = new Date(strDate);
            break;
        }
        return date;
    }
    public ColorEye askEyeColor(){
        String strEyeColor;
        ColorEye colorEye;
        while (true){
            System.out.println("Color eye list - "+ColorEye.getList());
            System.out.println("Enter your color eye:");
            strEyeColor=scanner.nextLine().trim();
            colorEye=ColorEye.valueOf(strEyeColor.toUpperCase());
            break;
        }
        return colorEye;
    }
    public ColorHair askHairColor(){
        String strHairColor;
        ColorHair colorHair;
        while (true){
            System.out.println("Color hair list - "+ColorHair.getList());
            System.out.println("Enter your color hair:");
            strHairColor=scanner.nextLine().trim();
            colorHair=ColorHair.valueOf(strHairColor.toUpperCase());
            break;
        }
        return colorHair;
    }

    public Country askNationality(){
        String strCountry;
        Country country;
        while (true){
            System.out.println("Country list - "+Country.getList());
            System.out.println("Enter your county:");
            strCountry=scanner.nextLine().trim();
            country=Country.valueOf(strCountry.toUpperCase());
            break;
        }
        return country;
    }
    public boolean askQuestion(String question){
        String finalQuestion = question+" (+/-):";
        String answer;
        while (true){
            System.out.println(finalQuestion);
            answer = scanner.nextLine().trim();
            break;
        }
        return answer.equals("+");
    }
}
