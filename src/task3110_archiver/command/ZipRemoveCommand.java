package task3110_archiver.command;

import task3110_archiver.ConsoleHelper;
import task3110_archiver.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Unpacking archive...");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Enter the file to be removed:");
        Path filePath = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(filePath);
    }
}
