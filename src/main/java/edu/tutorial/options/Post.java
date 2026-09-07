package edu.tutorial.options;

public class Post {

    private String message;

    //Not used but necessary to allow rewrite
    public Post() {

    }

    public Post(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Post setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "Post{" +
                "message='" + message + '\'' +
                '}';
    }
}
