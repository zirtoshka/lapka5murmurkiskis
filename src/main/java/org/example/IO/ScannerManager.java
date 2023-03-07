package org.example.IO;

import org.example.Main;
import org.example.description_for_collection.*;
import org.example.exceptions.NotNullException;
import org.example.exceptions.WrongNameException;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerManager {
    private final double MAX_X=576;
    private final float MIN_Y=-596;
    private Pattern patternSymbols = Pattern.compile("\\w*");
    private Pattern patternNumber = Pattern.compile("(-?)\\d+");

    private Scanner scanner;

    public ScannerManager(Scanner scanner){
        this.scanner=scanner;
    }

    public String askName(String inputTitle, int minLength, String typeOfName){
        String name="d";//ошибка иначе требует иницилизации
        while (true){
            try {
                System.out.println(inputTitle);
                System.out.print(Main.INPUT_INFO);
                name = scanner.nextLine().trim();
                if (name.equals("")) throw new NotNullException();
                if (!patternSymbols.matcher(name).matches()) throw new WrongNameException();
                break;
            } catch (NotNullException e){
                ConsoleManager.printError(String.format("%s can't be empty!!!", typeOfName));
            } catch (WrongNameException e){
                ConsoleManager.printError("I can parse only char symbol! (letters, numbers and '_')");
            }
            //exceptions

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
            System.out.print(Main.INPUT_INFO);
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
            System.out.print(Main.INPUT_INFO);
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
        String strCount;
        int count;
        while (true){
            //exceptions
            System.out.println("Enter the number of students in a group:");
            System.out.print(Main.INPUT_INFO);
            strCount = scanner.nextLine().trim();
            count =  Integer.parseInt(strCount);
            break;
        }
        return count;
    }

    public Integer askShouldBeExpelled(){
        String strCountExpelled;
        int countExpelled;
        while (true){
            //exceptions
            System.out.println("Enter the number of students to be expelled:");
            System.out.print(Main.INPUT_INFO);
            strCountExpelled = scanner.nextLine().trim();
            countExpelled = Integer.parseInt(strCountExpelled);
            break;
        }
        return countExpelled;
    }

    public double askAverageMark(){
        String strMark;
        double countMarkd;
        while (true){
            //exceptions
            System.out.println("Enter average mark:");
            System.out.print(Main.INPUT_INFO);
            strMark = scanner.nextLine().trim();
            countMarkd=(double) Double.parseDouble(strMark);
            break;
        }
        return countMarkd;
    }
    public Semester askSemesterEnum(){
        String strSemester;
        Semester semester;
        while (true){
            System.out.println("Semester list - "+Semester.getList());
            System.out.println("Enter your semester:");
            System.out.print(Main.INPUT_INFO);
            strSemester=scanner.nextLine().trim();
            semester=Semester.valueOf(strSemester.toUpperCase());
            break;
        }
        return semester;
    }

    public Person askPerson(){
        return new Person(askPersonName(),askBirthday(),askEyeColor(),askHairColor(),askNationality());
    }
    public java.util.Date askBirthday(){
        //xp[ how wtf
        String strDate;
        Date date;
        while (true){
            System.out.println("You can use format - 'January 19, 1970'");
            System.out.println("Enter your birthday for admin: ");
            System.out.print(Main.INPUT_INFO);
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
            System.out.print(Main.INPUT_INFO);
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
            System.out.print(Main.INPUT_INFO);
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
            System.out.print(Main.INPUT_INFO);
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
            System.out.print(Main.INPUT_INFO);
            answer = scanner.nextLine().trim();
            break;
        }
        return answer.equals("+");
    }
}
