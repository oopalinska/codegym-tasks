package task3110_archiver.command;

import task3110_archiver.ConsoleHelper;
import task3110_archiver.ZipFileManager;
import task3110_archiver.exception.PathNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Unpacking archive...");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Please enter the path where the archive will be unpacked:");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(destinationPath);

            ConsoleHelper.writeMessage("Archive unpacked.");

        } catch (PathNotFoundException e) {
            ConsoleHelper.writeMessage("Invalid path for unpacking.");
        }
    }
}
