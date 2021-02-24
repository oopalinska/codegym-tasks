package task3112_java_nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
File downloader

*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://codegym.cc/testdata/secretPasswords.txt",
                Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        //figuring out the file name from URL
        String fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
        //creating the path for final file
        Path filePath = downloadDirectory.resolve(fileName);

        // downloading the file to a temporary file: try-with-resources for safety
        URL urlObject = new URL(urlString);
        Path tempFile = Files.createTempFile(null, null);
        try (InputStream inputStream = urlObject.openStream()) {
            Files.copy(inputStream, tempFile);
        } catch (IOException e) {
            System.out.println("IOException!");
        }
        Files.move(tempFile, filePath);
        return filePath;
    }
}
