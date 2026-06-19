package edu.tutorial.classes;

import java.math.BigDecimal;
import java.util.*;

public class FlowStructures {

    public static void flowStructures() {

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

        int age = Integer.parseInt(value);

        //Using lambdas to save the break;
        switch (age) {
            case 17 -> System.out.println("Vales chetos");
            case 18 -> System.out.println("Mayor de edad");
            default -> System.out.println("Vales chetos de nuevo");
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Loop cycle <: " + i);
        }

        for (int i = 0; i <= 5; i++) {
            System.out.println("Loop cycle <=: " + i);
        }

        //Filling up matrix
        int[][] matrix = new int[5][5];


        //Traditional way
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = j;
            }
        }

        System.out.println("Matrix: " + Arrays.deepToString(matrix));
        //Consider alternative
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], i);
        }

        System.out.println("Matrix: " + Arrays.deepToString(matrix));

        int[][][] world = new int[5][5][5];
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                Arrays.fill(world[i][j], i);
            }
        }

        System.out.println("World: " + Arrays.deepToString(world));

        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        for (Integer integer : integerList) {
            System.out.println("Integer : " + integer);
        }

        integerList.forEach(integer -> System.out.println("Integer lambda: " + integer));

        integerList.forEach(System.out::println);
        int i = 0;

        while (i < integerList.size()) {
            System.out.print("before i++: " + i);
            i++;
            System.out.println(" - after i++: " + i);
        }

        for (Integer integer : integerList) {
            if (integer % 2 == 0) {
                continue; //Skips one iteration
            }
            System.out.println("i: " + integer);
        }

        int[] arrayInt = integerList.stream()
                .filter(k -> k % 2 != 0)
                .map(k -> k * k)
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println("Array: " + Arrays.toString(arrayInt));

    }
}
