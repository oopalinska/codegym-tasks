package task3810_annotations;

public @interface Author {
    // Write your own code
    String value();
    Position position() default Position.OTHER;
}