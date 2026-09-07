package edu.tutorial.options.strategies;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tutorial.options.OptionInterface;
import edu.tutorial.options.OptionType;
import edu.tutorial.options.Post;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static edu.tutorial.App.FILE_PATH;

public class AddPostStrategy implements OptionInterface {

    private final ObjectMapper objectMapper;

    public AddPostStrategy() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String getMessage() {
        return getOptionType().getValue().toString().concat(": Add post");
    }

    @Override
    public void execute(Scanner scanner) {
        File file = new File(FILE_PATH);

        List<Post> posts;

        try {
            if (file.exists()) {
                posts = objectMapper.readValue(file, new TypeReference<>() {

                });
            } else {
                posts = new ArrayList<>();
            }

            System.out.println("Write your post: ");
            String message = scanner.nextLine();

            posts.add(new Post(message));
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, posts);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public OptionType getOptionType() {
        return OptionType.ADD_POST;
    }
}
