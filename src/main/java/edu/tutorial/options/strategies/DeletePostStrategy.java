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
import java.util.stream.IntStream;

import static edu.tutorial.App.FILE_PATH;

public class DeletePostStrategy implements OptionInterface {

    private final ObjectMapper objectMapper;

    public DeletePostStrategy() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String getMessage() {
        return getOptionType().getValue().toString().concat(": Delete Post");
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

            System.out.println("Select post to be deleted: ");
            IntStream.range(0, posts.size())
                    .forEach(i -> System.out.println(i + ": " + posts.get(i).getMessage()));

            int postId = scanner.nextInt();

            posts.remove(postId);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, posts);
            System.out.println("Post " + postId + " deleted!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public OptionType getOptionType() {
        return OptionType.DELETE_POST;
    }
}
