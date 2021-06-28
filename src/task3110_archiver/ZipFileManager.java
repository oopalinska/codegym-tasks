package task3110_archiver;

import task3110_archiver.exception.PathNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(final Path zipFile) {
        this.zipFile = zipFile;
    }
    public void createZip(Path source) throws Exception {
        final Path parent = zipFile.getParent();
        if (Files.notExists(parent)) {
            Files.createDirectories(parent);
        }
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            if (Files.isRegularFile(source)) {
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else if (Files.isDirectory(source)) {
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for (Path file : fileNames) {
                    addNewZipEntry(zipOutputStream, source, file);
                }
            } else {
                throw new PathNotFoundException();
            }
        }
    }
    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        try (InputStream inputStream = Files.newInputStream(filePath.resolve(fileName))) {
            ZipEntry zipEntry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zipEntry);
            copyData(inputStream, zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }
    private void copyData(InputStream in, OutputStream out) throws Exception {
        while (in.available() > 0) {
            out.write(in.read());
        }
    }
}

