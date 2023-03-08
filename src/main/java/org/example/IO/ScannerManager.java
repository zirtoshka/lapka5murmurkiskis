package org.example.IO;

import org.example.Main;
import org.example.description_for_collection.*;
import org.example.exceptions.IncorrectValueException;
import org.example.exceptions.NotNullException;
import org.example.exceptions.WrongNameException;

import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerManager {
    private final double MAX_X = 576;
    private final float MIN_Y = -596;
    private Pattern patternSymbols = Pattern.compile("\\w*");
    private Pattern patternNumber = Pattern.compile("(-?)\\d+(.\\d+)?");

    private Scanner scanner;

    public ScannerManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String askName(String inputTitle, String typeOfName) {
        String name;
        while (true) {
            try {
                System.out.println(inputTitle);
                System.out.print(Main.INPUT_INFO);
                name = scanner.nextLine().trim();
                if (name.equals("")) throw new NotNullException();
                if (!patternSymbols.matcher(name).matches()) throw new WrongNameException();
                break;
            } catch (NotNullException e) {
                ConsoleManager.printError(String.format("%s can't be empty!!!", typeOfName));
            } catch (WrongNameException e) {
                ConsoleManager.printError("I can parse only char symbol! (letters, numbers and '_')");
            }


        }
        return name;
    }

    public String askGroupName() {
        return askName("Enter Study Group name",  "Study Group name");
    }

    public String askPersonName() {
        return askName("Enter Admin name:",  "Person name");
    }


    public Double askCoordinatesX() {
        String strX;
        Double x;
        while (true) {
            try {
                System.out.println("Enter X coord: ");
                System.out.print(Main.INPUT_INFO);
                strX = scanner.nextLine().trim();
                if (strX.equals("")) throw new NotNullException();
                if (!patternNumber.matcher(strX).matches()) throw new WrongNameException();
                x = Double.parseDouble(strX);
                if (x > MAX_X) throw new IncorrectValueException();
                break;
            } catch (NumberFormatException e) {
                ConsoleManager.printError("Given String is not parsable to Double");
            } catch (NotNullException e) {
                ConsoleManager.printError("It can't be empty!!!");
            } catch (WrongNameException e) {
                ConsoleManager.printError("hmm.. You use symbols not for numbers... why?");
            } catch (IncorrectValueException e) {
                ConsoleManager.printError("This value has to be less than " + MAX_X);
            }
        }
        return x;
    }

    public Float askCoordinatesY() {
        String strY;
        Float y;
        while (true) {
            try {
                System.out.println("Enter Y coord:");
                System.out.print(Main.INPUT_INFO);
                strY = scanner.nextLine().trim();
                if (strY.equals("")) throw new NotNullException();
                if (!patternNumber.matcher(strY).matches()) throw new WrongNameException();
                y = Float.parseFloat(strY);
                if (y < MIN_Y) throw new IncorrectValueException();
                break;
            } catch (NumberFormatException e) {
                ConsoleManager.printError("Given String is not parsable to Float");
            } catch (NotNullException e) {
                ConsoleManager.printError("It can't be empty!!!");
            } catch (WrongNameException e) {
                ConsoleManager.printError("hmm.. You use symbols not for numbers... why?");
            } catch (IncorrectValueException e) {
                ConsoleManager.printError("This value has to be more than " + MIN_Y);
            }

        }
        return y;
    }

    public Coordinates askCoordinates() {
        Double x = askCoordinatesX();
        Float y = askCoordinatesY();
        return new Coordinates(x, y);
    }

    public int askStudentCount() {
        String strCount;
        int count;
        while (true) {
            try {
                System.out.println("Enter the number of students in a group:");
                System.out.print(Main.INPUT_INFO);
                strCount = scanner.nextLine().trim();
                if (strCount.equals("")) throw new NotNullException();
                count = Integer.parseInt(strCount);
                if (count <= 0) throw new IncorrectValueException();
                break;
            } catch (NotNullException e) {
                count = 0;
                break;
            } catch (IncorrectValueException e) {
                ConsoleManager.printError("Are you sure it could be the number of students??");
            }
        }
        return count;
    }

    public Integer askShouldBeExpelled() {
        String strCountExpelled;
        Integer countExpelled;
        while (true) {
            try {
                System.out.println("Enter the number of students to be expelled:");
                System.out.print(Main.INPUT_INFO);
                strCountExpelled = scanner.nextLine().trim();
                if (strCountExpelled.equals("")) throw new NotNullException();
                countExpelled = Integer.parseInt(strCountExpelled);
                if (countExpelled <= 0) throw new IncorrectValueException();
                break;
            } catch (NotNullException e) {
                ConsoleManager.printError("It can't be empty!!!");
            } catch (IncorrectValueException e) {
                ConsoleManager.printError("It has to be more than 0");
            } catch (NumberFormatException e) {
                ConsoleManager.printError("Given String is not parsable to Integer");
            }
        }
        return countExpelled;
    }

    public double askAverageMark() {
        String strMark;
        double countMarkd;
        while (true) {
            try {
                System.out.println("Enter average mark:");
                System.out.print(Main.INPUT_INFO);
                strMark = scanner.nextLine().trim();
                countMarkd = Double.parseDouble(strMark);
                if (countMarkd <= 0) throw new IncorrectValueException();
                break;
            } catch (IncorrectValueException e) {
                ConsoleManager.printError("It has to be more than 0");
            } catch (NumberFormatException e) {
                ConsoleManager.printError("Given String is not parsable to double");
            }
        }
        return countMarkd;
    }

    public Semester askSemesterEnum() {
        String strSemester;
        Semester semester;
        while (true) {
            try {
                System.out.println("Semester list - " + Semester.getList());
                System.out.println("Enter your semester:");
                System.out.print(Main.INPUT_INFO);
                strSemester = scanner.nextLine().trim();
                if (strSemester.equals("")) throw new NotNullException();
                semester = Semester.valueOf(strSemester.toUpperCase());
                break;
            } catch (NotNullException e) {
                ConsoleManager.printError("It can't be empty!!");
            } catch (IllegalArgumentException e) {
                ConsoleManager.printError("I don't know this semester(");
            }
        }
        return semester;
    }

    public Person askPerson() {
        return new Person(askPersonName(), askBirthday(), askEyeColor(), askHairColor(), askNationality());
    }

    public java.util.Date askBirthday() {
        String strDate;
        Date date;
        while (true) {
            try {
                System.out.println("You can use formats: 'January 19, 1970', '01/19/1970'");
                System.out.println("Enter your birthday for admin: ");
                System.out.print(Main.INPUT_INFO);
                strDate = scanner.nextLine().trim();
                if (strDate.equals("")) throw new NotNullException();
                date = new Date(strDate);
                break;
            } catch (NotNullException e) {
                ConsoleManager.printError("It can't be empty!");
            } catch (IllegalArgumentException e) {
                ConsoleManager.printError("You use a very strange format");
            }
        }
        return date;
    }

    public ColorEye askEyeColor() {
        String strEyeColor;
        ColorEye colorEye;
        while (true) {
            try {
                System.out.println("Color eye list - " + ColorEye.getList());
                System.out.println("Enter your color eye:");
                System.out.print(Main.INPUT_INFO);
                strEyeColor = scanner.nextLine().trim();
                if (strEyeColor.equals("")) throw new NotNullException();
                colorEye = ColorEye.valueOf(strEyeColor.toUpperCase());
                break;
            } catch (NotNullException e) {
                ConsoleManager.printError("It can't be empty!!");
            } catch (IllegalArgumentException e) {
                ConsoleManager.printError("I don't know this eye color(");
            }
        }
        return colorEye;
    }

    public ColorHair askHairColor() {
        String strHairColor;
        ColorHair colorHair;
        while (true) {
            try {
                System.out.println("Color hair list - " + ColorHair.getList());
                System.out.println("Enter your color hair:");
                System.out.print(Main.INPUT_INFO);
                strHairColor = scanner.nextLine().trim();
                if (strHairColor.equals("")) throw new NotNullException();
                colorHair = ColorHair.valueOf(strHairColor.toUpperCase());
                break;
            } catch (NotNullException e) {
                ConsoleManager.printError("It can't be empty!!");
            } catch (IllegalArgumentException e) {
                ConsoleManager.printError("I don't know this hair color(");
            }
        }
        return colorHair;
    }

    public Country askNationality() {
        String strCountry;
        Country country;
        while (true) {
            try {
            System.out.println("Country list - " + Country.getList());
            System.out.println("Enter your county:");
            System.out.print(Main.INPUT_INFO);
            strCountry = scanner.nextLine().trim();
            if (strCountry.isEmpty()) throw new NotNullException();
            country = Country.valueOf(strCountry.toUpperCase());
            break;
        }catch (NotNullException e){
                ConsoleManager.printError("It can't be empty!!");
            } catch (IllegalArgumentException e) {
                ConsoleManager.printError("I don't know this nationality(");
            }
        }
        return country;
    }

    public boolean askQuestion(String question) {
        String finalQuestion = question + " (+/-):";
        String answer;
        while (true) {
            try {
                System.out.println(finalQuestion);
                System.out.print(Main.INPUT_INFO);
                answer = scanner.nextLine().trim();
                if (answer.equals("")) throw new NotNullException();
                if(!(answer.equals("+")&&answer.equals("-"))) throw new IncorrectValueException();
                break;
            }catch (NotNullException e){
                ConsoleManager.printError("I know that silence is golden. But what should I do with it? I only understand + and -");
            }catch (IncorrectValueException e){
                ConsoleManager.printError("I believed that you are a smart person and able to distinguish other characters from +/-");
            }
        }
        return answer.equals("+");
    }
}
