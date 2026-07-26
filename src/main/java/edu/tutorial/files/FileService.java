package edu.tutorial.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class FileService {

    private final String FILE_PATH = "src/main/resources/data.txt";
    private static final String RESOURCES = "src/main/resources";

    public void readAllLines() throws IOException {
        File file = new File(FILE_PATH);

        Files.readAllLines(Path.of(file.getPath())).forEach(System.out::println);
    }

    public void writeAllLines(List<String> content) throws IOException {
        Files.write(Path.of(FILE_PATH), content, StandardOpenOption.APPEND);
    }

    public void listFiles() throws IOException {
        try (Stream<Path> pathStream = Files.list(Path.of(RESOURCES))) {
            pathStream.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error finding list of files");
        }

    }
}
