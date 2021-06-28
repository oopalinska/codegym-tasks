package task3110_archiver;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(final Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
            InputStream inputStream = Files.newInputStream(source)) {
            zipOutputStream.putNextEntry(new ZipEntry(source.getFileName().toString()));
            while (inputStream.available() > 0) {
                zipOutputStream.write(inputStream.read());
            }
            zipOutputStream.closeEntry();
        }
    }


}
