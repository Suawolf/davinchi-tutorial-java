package edu.tutorial;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

//        System.out.println("Hello World!");
        String clave = System.getenv().get("clave");
        System.out.println("clave: " + clave);

//        int value = System.in.read();

        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();

        System.out.println("Value".concat(value));
    }
}
