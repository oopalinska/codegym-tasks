package big_task3110_archiver.command;

import big_task3110_archiver.ConsoleHelper;
import big_task3110_archiver.ZipFileManager;
import big_task3110_archiver.exception.PathNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Unpacking archive...");
            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Please enter the full path to a file you are adding:");
            Path filePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.addFile(filePath);

            ConsoleHelper.writeMessage("File added.");

        } catch (PathNotFoundException e) {
            ConsoleHelper.writeMessage("Invalid path for file.");
        }
    }
}
