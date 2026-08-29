package edu.tutorial;

import edu.tutorial.classes.Contact;
import edu.tutorial.classes.Post;
import edu.tutorial.design_patterns.builder.Person;
import edu.tutorial.design_patterns.singleton.Singleton;
import edu.tutorial.design_patterns.strategy.PaymentInterface;
import edu.tutorial.design_patterns.strategy.PaymentType;
import edu.tutorial.design_patterns.strategy.strategies.AmexPaymentStrategy;
import edu.tutorial.design_patterns.strategy.strategies.MastercardPaymentStrategy;
import edu.tutorial.design_patterns.strategy.strategies.VisaPaymentStrategy;
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
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        //Video 17 & 18

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 5);
        List<Contact> people = List.of(
                new Contact(List.of("7491028365", "4821"), 34L),
                new Contact(List.of("1092837465", "8319"), 34L),
                new Contact(List.of("5820193847", "1042"), 15L),
                new Contact(List.of("9382017456", "9284"), 18L),
                new Contact(List.of("3847102956", "3175"), 45L),
                new Contact(List.of("6201948375", "5019"), 45L),
                new Contact(List.of("8102938475", "7483"), 18L),
                new Contact(List.of("2938471056", "2910"), 18L),
                new Contact(List.of("4019283746", "6381"), 45L),
                new Contact(List.of("5920183749", "4028"), 45L)
        );
        double total = integers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();

        System.out.println("Average value: " + total);

        int max = integers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();

        System.out.println("Max value: " + max);

        int min = integers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();

        System.out.println("Min value: " + min);

        long count = integers.stream()
//                .mapToInt(Integer::intValue)
                .count();

        System.out.println("Count value: " + count);

        boolean anyMatch = integers.stream()
                .anyMatch(integer -> integer > 4);

        System.out.println("Any match: " + anyMatch);

        boolean allMatch = integers.stream()
                .allMatch(integer -> integer > 4);

        System.out.println("All match: " + allMatch);

        Map<Integer, Long> countByItem = integers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Count by item: " + countByItem);

        Map<Long, List<Contact>> peopleResult = people.stream()
                .collect(Collectors.groupingBy(Contact::getAge));

        System.out.println("People result: " + peopleResult);

        Optional<Contact> person = people.stream()
                .filter(p -> p.getAge() > 18)
                .findFirst();

        Contact firstAdult;
        if (person.isEmpty()) {
            throw new RuntimeException("Person is empty");
        }


        if (person.isPresent()) {
            firstAdult = person.get();
        } else {
            throw new RuntimeException("Person not found");
        }


        System.out.println("Person: " + firstAdult);

        System.out.println("EntrySet by item");
        countByItem.entrySet().stream().forEach(System.out::println);

        System.out.print("EntrySet by count: ");
        countByItem.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(System.out::println);

        System.out.print("EntrySet by entry: ");
        countByItem.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        Map<Long, List<Contact>> collectByAge = people.stream()
                .collect(Collectors.groupingBy(Contact::getAge));

        System.out.println("People collect by age: " + collectByAge);

        Map<Long, Long> countByAge = people.stream()
                .collect(Collectors.groupingBy(Contact::getAge, Collectors.counting()));

        System.out.println("People count by age: " + countByAge);

        countByAge.entrySet().forEach(System.out::println);

        System.out.println("Only duplicates: ");
        countByAge.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        System.out.println("Now sorted by higher: ");
        countByAge.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .forEach(System.out::println);

        System.out.println("Sorted by age: ");
        countByAge.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        System.out.println("Sorted by age reversed: ");
        countByAge.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .sorted(Map.Entry.<Long, Long>comparingByKey().reversed())
                .forEach(System.out::println);

        System.out.println("Let's try parallel: ");
        people.stream().parallel().forEach(System.out::println);
        System.out.println("Same but shorter: ");
        people.parallelStream().forEach(System.out::println);

        System.out.println("Sorted by age reversed parallel: ");
        countByAge.entrySet().stream()
                .parallel()
                .filter(entry -> entry.getValue() > 1)
//                .sorted(Map.Entry.<Long, Long>comparingByKey().reversed()) // This for reversed
                .forEachOrdered(System.out::println); //This for ordered

        System.out.println("Getting integer only once: ");

        List<Integer> singleIntegers = integers.stream().parallel()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .keySet().stream()
                .toList();

        System.out.println("List of integers once: " + singleIntegers);

        List<Integer> countIntegers = integers.stream().parallel()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .map(Long::intValue)
                .toList();

        System.out.println("List of counts in integers converted from Long: " + countIntegers);

        singleIntegers.parallelStream()
                .map(integer -> {
                    String url = "https://jsonplaceholder.typicode.com/posts/" + integer;
                    return httpService.get(url, Post.class);
                })
                .forEach(System.out::println);

        //Design Patterns
        //Creational
        Singleton instance1 = Singleton.getInstance("1");
        Singleton instance2 = Singleton.getInstance("2");

        System.out.println("Singleton 1: " + instance1);
        System.out.println("Singleton 2: " + instance2);

        Person person1 = new Person.PersonBuilder()
                .setName("John")
                .setAge(25)
                .setCountry("USA")
                .setCity("Washington")
                .setEmail("john@email.com")
                .setPassword("password")
                .setState("DC")
                .build();

        System.out.println("Person 1: " + person1);

        //Structural


        //Behavioral
        List<PaymentInterface> paymentTypes = List.of(new VisaPaymentStrategy(), new MastercardPaymentStrategy(), new AmexPaymentStrategy());
        Map<PaymentType, PaymentInterface> collect = paymentTypes.stream()
                .collect(Collectors.toMap(PaymentInterface::getPaymentType, Function.identity()));

        PaymentType paymentType = PaymentType.MASTERCARD;

        PaymentInterface paymentInterface = collect.get(paymentType);

        if (paymentInterface == null) {
            throw new RuntimeException("Payment type not found");
        }

        paymentInterface.paid();


    }
}
