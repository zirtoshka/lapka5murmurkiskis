package org.example.commands;

import org.example.CollectionManager;
import org.example.CommandManager;
import org.example.IO.ConsoleManager;
import org.example.IO.ScannerManager;
import org.example.description_for_collection.Coordinates;
import org.example.description_for_collection.Person;
import org.example.description_for_collection.Semester;
import org.example.description_for_collection.StudyGroup;

import java.time.LocalDateTime;

public class UpdateByIdCommand extends Command {
    //ffff
    private final CollectionManager collectionManager;
    private final ScannerManager scannerManager;

    public UpdateByIdCommand(CollectionManager collectionManager, ScannerManager scannerManager) {
        super("update id {element}", "update element by id");
        this.collectionManager = collectionManager;
        this.scannerManager = scannerManager;
    }

    @Override
    public boolean execute(String arg) {
        Integer id = Integer.parseInt(arg);
        StudyGroup studyGroup = collectionManager.getById(id);
        String name = studyGroup.getName();
        Coordinates coordinates = studyGroup.getCoordinates();
        LocalDateTime creationDate = studyGroup.getCreationDate();
        int studentsCount = studyGroup.getStudentsCount();
        Integer shouldBeExpelled = studyGroup.getShouldBeExpelled();
        double averageMark = studyGroup.getAverageMark();
        Semester semesterEnum = studyGroup.getSemesterEnum();
        Person groupAdmin = studyGroup.getGroupAdmin();

        collectionManager.removeFromCollection(studyGroup);//метод ничего не делает с множеством поэтом idможно присвоить тот же и все будет норм
        //id генерируются, поэтому будет колллекция, с новым id м
        if (scannerManager.askQuestion("Change study group name?")) {
            name = scannerManager.askGroupName();
        }
        if (scannerManager.askQuestion("Change study group coordinates?")) {
            coordinates = scannerManager.askCoordinates();
        }
        if (scannerManager.askQuestion("Change the number of students in a group??")) {
            studentsCount = scannerManager.askStudentCount();
        }
        if (scannerManager.askQuestion("Change the number of students to be expelled??")) {
            shouldBeExpelled = scannerManager.askShouldBeExpelled();
        }
        if (scannerManager.askQuestion("Change study group average mark?")) {
            averageMark = scannerManager.askAvarageMark();
        }
        if (scannerManager.askQuestion("Change study group semester?")) {
            semesterEnum = scannerManager.askSemesterEnum();
        }
        if (scannerManager.askQuestion("Change study group admin?")) {
            groupAdmin = scannerManager.askPerson();
        }

        collectionManager.addToCollection(new StudyGroup(id, name, coordinates,creationDate,studentsCount,
                shouldBeExpelled,averageMark,semesterEnum,groupAdmin));
        ConsoleManager.printSuccess("Info was successfully updated");
        return true;
    }
}
