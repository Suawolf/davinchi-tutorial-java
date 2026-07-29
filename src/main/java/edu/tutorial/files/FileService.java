package edu.tutorial.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

    public void listFiles() {
        try (Stream<Path> pathStream = Files.list(Path.of(RESOURCES))) {
            pathStream.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error finding list of files");
        }
    }

    public void readAllLinesWithBuffer() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(FILE_PATH))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    //Try this approach when opening files
    public void writeAllLinesWithBuffer(List<String> content) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(FILE_PATH), StandardOpenOption.APPEND)) {
            for (String line : content) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public void deleteFile() throws IOException {
        Files.delete(Path.of(FILE_PATH));
    }
}
