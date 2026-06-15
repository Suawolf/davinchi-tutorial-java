package edu.tutorial;

import java.math.BigDecimal;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

//        System.out.println("Hello World!");
        String key = System.getenv().get("key");
        System.out.println("key: " + key);

//        int value = System.in.read();

        Scanner sc = new Scanner(System.in);
        System.out.print("Press a key to continue: ");
        String value = sc.nextLine();
        System.out.print("Press another key to continue: ");
        String value2 = sc.nextLine();

        System.out.println("Value: ".concat(value));

        List<String> list = new ArrayList<>();
        list.add(value);
        System.out.println("List: " + list);

        Map<String, String> map = new HashMap<>();
        map.put("key", value);

        System.out.println("Map: " + map);
        System.out.println("Key: " + map.get("key"));

        Set<String> set = new HashSet<>();
        set.add(value);
        set.add(value2);
        System.out.println("Set: " + set);
        System.out.println("Contains key: " + set.contains("key"));
        System.out.println("Contains key: " + set.contains(value2));

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        Integer peek = queue.peek();
        System.out.println("peek: " + peek);
        System.out.println("Queue: " + queue);
        Integer poll = queue.poll();
        System.out.println("poll: " + poll);
        System.out.println("Queue: " + queue);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Stack: " + stack);
        stack.pop();
        System.out.println("Stack: " + stack);

        BigDecimal bigDecimal = new BigDecimal("0.1");
        BigDecimal bigDecimal2 = new BigDecimal("0.2");
        BigDecimal result = bigDecimal.add(bigDecimal2);
        System.out.println("BigDecimal: " + result);
    }
}
