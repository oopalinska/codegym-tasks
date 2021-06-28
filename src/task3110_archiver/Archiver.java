package task3110_archiver;

import task3110_archiver.exception.NoSuchZipFileException;
import java.io.IOException;

public class Archiver {
    public static void main(String[] args) {
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (NoSuchZipFileException e) {
                ConsoleHelper.writeMessage("You didn't select an archive or you selected an invalid file.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("An error occurred. Please check the entered data.");
            }
        } while (operation != Operation.EXIT);
    }
    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Select an operation:\n" +
                "0 - Zip files into an archive\n" +
                "1 - Add a file to an archive\n" +
                "2 - Remove a file from an archive\n" +
                "3 - Extract an archive\n" +
                "4 - View the contents of an archive\n" +
                "5 - Exit");
        final int chosen = ConsoleHelper.readInt();
        return Operation.values()[chosen];
    }
}
