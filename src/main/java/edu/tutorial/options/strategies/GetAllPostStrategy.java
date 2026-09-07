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

public class GetAllPostStrategy implements OptionInterface {

    private final ObjectMapper objectMapper;

    public GetAllPostStrategy() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String getMessage() {
        return getOptionType().getValue().toString().concat(": Get All Posts");
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

            System.out.println("List of posts: ");
            posts.stream()
                    .map(Post::getMessage)
                    .map("- "::concat)
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public OptionType getOptionType() {
        return OptionType.GET_POST;
    }
}
