package edu.tutorial;

import edu.tutorial.files.FileService;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    //Main method cleaned up to avoid warnings
    static void main() {
//        flowStructures();

//        Integer number = plusOneTo(1, 5);
//        System.out.println(number);

        Father father = new Father("Luis");
        Father father1 = new Father("Carlos");
        System.out.println(father.equals(father1));
        System.out.println(father.getName());
        father.setName("Carlos");
        System.out.println(father.getName());
        System.out.println(father);
//        System.out.println(father.prettyPrint()); //MUST BE toString, but modified to see the difference
        System.out.println(father.hashCode());


        UserDto user = new UserDto("Sua", "sua@email.com", "1234");
        System.out.println("Username: " + user.name() + " Email: " + user.email() + " Password: " + user.password());
        GenderType gender = father.getGender();
        System.out.println("Gender: " + gender.getName() + " position: " + gender.ordinal());
        Daughter daughter = new Daughter("Leia");
        System.out.println("Gender: " + daughter.getGender().getName() + " position: " + daughter.getGender().ordinal());
        System.out.println("Gender: " + GenderType.valueOf("FEMALE").getName());

        try {
            throw new InvalidAge("Invalid Age");
        } catch (IllegalAccessError | Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        } finally {
            System.out.println("Finally");
        }

        InfoAuthor annotation = father.getClass().getAnnotation(InfoAuthor.class);
        String email = annotation.email();
        String name = annotation.name();
        System.out.println("Email: " + email);
        System.out.println("Name: " + name);

        //Video 10

        FileService fileService = new FileService();

        try {
            fileService.readAllLines();
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        try {
            fileService.writeAllLines(List.of("Line 1", "Line 2", "Line 3"));
        } catch (IOException e) {
            System.out.println("Error writing file");
        }


        fileService.listFiles();

        fileService.writeAllLinesWithBuffer(List.of("Line 4", "Line 5", "Line 6"));
        fileService.readAllLinesWithBuffer();

//        try {
//            fileService.deleteFile();
//        } catch (IOException e) {
//            System.out.println("Error deleting file");
//        }

    }
}
