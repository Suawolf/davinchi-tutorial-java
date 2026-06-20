package edu.tutorial;

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
        System.out.println(father.prettyPrint()); //MUST BE toString, but modified to see the difference
        System.out.println(father.hashCode());


    }
}
