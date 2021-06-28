package task3110_archiver;

import task3110_archiver.command.ExitCommand;

import java.nio.file.Paths;
import java.util.Scanner;

public class Archiver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the full path to the archive:");
        final String path = scanner.nextLine();
        final ZipFileManager zipFileManager = new ZipFileManager(Paths.get(path));
        System.out.println("Please enter the path to the file to be zipped:");
        final String fileToZip = scanner.nextLine();
        try {
            zipFileManager.createZip(Paths.get(fileToZip));
            new ExitCommand().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
