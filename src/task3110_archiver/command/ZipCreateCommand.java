package task3110_archiver.command;

import task3110_archiver.ConsoleHelper;
import task3110_archiver.ZipFileManager;
import task3110_archiver.exception.PathNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Creating an archive...");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Please enter the full path to the file or directory to be zipped:");
            final Path pathToZip = Paths.get(ConsoleHelper.readString());
            zipFileManager.createZip(pathToZip);
            ConsoleHelper.writeMessage("Archive created.");
        } catch (PathNotFoundException e) {
            ConsoleHelper.writeMessage("You didn't correctly enter a file name or directory.");
        }
    }
}