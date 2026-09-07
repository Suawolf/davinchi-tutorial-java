package edu.tutorial.options;

public enum OptionType {

    EXIT(0),
    ADD_POST(1),
    DELETE_POST(2),
    UPDATE_POST(3),
    GET_POST(4);

    private final Integer value;

    OptionType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static OptionType getOptionType(Integer value) {
        for (OptionType optionType : OptionType.values()) {
            if (optionType.getValue().equals(value)) {
                return optionType;
            }
        }
        return null;
    }
}
