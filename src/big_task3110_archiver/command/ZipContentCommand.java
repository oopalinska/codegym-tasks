package big_task3110_archiver.command;

import big_task3110_archiver.ConsoleHelper;
import big_task3110_archiver.FileProperties;
import big_task3110_archiver.ZipFileManager;

import java.util.List;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Viewing contents of the archive...");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Archive contents:");
        List<FileProperties> fileList = zipFileManager.getFileList();
        if (fileList.isEmpty()) {
            ConsoleHelper.writeMessage("This archive is empty.");
        }
        for (FileProperties properties : fileList) {
            ConsoleHelper.writeMessage(properties.toString());
        }
    }
}

