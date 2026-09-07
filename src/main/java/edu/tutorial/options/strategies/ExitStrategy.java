package edu.tutorial.options.strategies;

import edu.tutorial.options.OptionInterface;
import edu.tutorial.options.OptionType;

import java.util.Scanner;

public class ExitStrategy implements OptionInterface {
    @Override
    public String getMessage() {
        return getOptionType().getValue().toString().concat(": Exit");
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Exiting...");
    }

    @Override
    public OptionType getOptionType() {
        return OptionType.EXIT;
    }
}
