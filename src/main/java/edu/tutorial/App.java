package edu.tutorial;

import edu.tutorial.classes.Post;
import edu.tutorial.services.DateService;
import edu.tutorial.services.FileService;
import edu.tutorial.services.HttpService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

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

        //Video 11

        fileService.listFiles();

        fileService.writeAllLinesWithBuffer(List.of("Line 4", "Line 5", "Line 6"));
        fileService.readAllLinesWithBuffer();

        //Video 12
        fileService.encrypt();
        try {
            fileService.deleteFile();
        } catch (IOException e) {
            System.out.println("Error deleting file");
        }

        fileService.decrypt();

        //Video 13

        DateService dateService = new DateService();
        dateService.getCurrentDate();
        dateService.getSpecificDate("2026/08/08");

        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now(ZoneId.of("Europe/Madrid")));
        System.out.println(LocalDateTime.now(ZoneId.of("America/Mexico_City")));

        System.out.println(LocalDate.of(2025, 8, 7));
        System.out.println(LocalDate.parse("2015-09-18"));
        dateService.getDateParsed("09/01/2023", "dd/MM/yyyy");

        System.out.println(LocalDate.now().plusDays(1));
        System.out.println(LocalDate.now().getMonth());
        System.out.println(LocalDate.now().getMonthValue());
        System.out.println(LocalDate.now().getYear());
        System.out.println(LocalDate.now().getDayOfMonth());
        System.out.println(LocalDate.now().getDayOfYear());
        System.out.println(LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
        Period period = LocalDate.now().until(LocalDate.now().plusYears(1));
        System.out.println(period);
        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.now().plusYears(1)));


        //Video 15 & 16

        HttpService httpService = new HttpService();

        Post getPost = httpService.get("https://jsonplaceholder.typicode.com/posts/1", Post.class);
        System.out.println("GET: " + getPost);

        Post request = new Post(null, 1, "Java Course", "Vini, Vid, Vici");
        Post postPost = httpService.post("https://jsonplaceholder.typicode.com/posts/", request, Post.class);
        System.out.println("POST: " + postPost);

        Post deletePost = httpService.delete("https://jsonplaceholder.typicode.com/posts/1", Post.class);
        System.out.println("DELETE: " + deletePost);

        httpService.put("https://jsonplaceholder.typicode.com/posts/1");


    }
}
