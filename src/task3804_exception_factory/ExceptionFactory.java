package task3804_exception_factory;

public class ExceptionFactory {

    public static Throwable getException(Enum theEnum) {
        if (theEnum == null) {
            return new IllegalArgumentException();
        }
        String messageLower = theEnum.name().toLowerCase().replaceAll("[_]", " ");
        String message = messageLower.substring(0,1).toUpperCase() + messageLower.substring(1);
        switch (theEnum.getClass().getSimpleName()) {
            case "ApplicationExceptionMessage":
                return new Exception(message);
            case "DatabaseExceptionMessage":
                return new RuntimeException(message);
            case "UserExceptionMessage":
                return new Error(message);
            default:
                return new IllegalArgumentException();
        }
    }
}
