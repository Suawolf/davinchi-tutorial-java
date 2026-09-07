package edu.tutorial.options;

import java.util.Scanner;

public interface OptionInterface {

    String getMessage();

    void execute(Scanner scanner);

    OptionType getOptionType();
}
