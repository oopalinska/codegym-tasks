package task3113_java_nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
What's in the folder?

*/

public class Solution {
    // create static variables for counting
    static int folderCount;
    static int fileCount;
    static long sizeCount;

    public static void main(String[] args) throws IOException {
        // read the folder path from the console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path enteredPath = Paths.get(reader.readLine());
        // if entered path is not a directory, display a message and exit
        if (!Files.isDirectory(enteredPath))
            System.out.println(enteredPath.toString() + " is not a folder");
            // else iterate through folder/file tree, counting desired information
        else {
            Files.walkFileTree(enteredPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    // I'm not supposed to add the given directory to folderCount - only the folders inside of it
                    if (!dir.equals(enteredPath)) folderCount++;
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    fileCount++;
                    sizeCount += attrs.size();
                    return FileVisitResult.CONTINUE;
                }
            });
            // display calculated information
            System.out.println("Total folders: " + folderCount);
            System.out.println("Total files: " + fileCount);
            System.out.println("Total size: " + sizeCount);
        }
    }
}