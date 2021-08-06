package task3810_annotations;

public @interface Revision {
    // Write your own code
    int revision();
    Date date();
    Author[] authors() default {};
    String comment() default "";
}