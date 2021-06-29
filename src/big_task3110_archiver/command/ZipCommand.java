package big_task3110_archiver.command;

import big_task3110_archiver.ConsoleHelper;
import big_task3110_archiver.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {
    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Please enter the full path to the archive:");
        final String s = ConsoleHelper.readString();
        Path path = Paths.get(s);
        return new ZipFileManager(path);
    }
}
