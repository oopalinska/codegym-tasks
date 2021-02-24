package task3105_zip_file;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Adding a file to an archive

*/
//NOTE: I'VE GOT MOST OF THE METHODS CODE FROM COMMUNITY HELP SECTION ON CODEGYM

public class Solution {
    public static File fileToBeAdded;

    public static void main(String[] args) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]));
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]));
        fileToBeAdded = new File(args[0]);
        Map<String, byte[]> archiveContents = saveFilesInMap(zipInputStream);
        addFileToArchive(fileToBeAdded, zipOutputStream);
        addByteArraysToArchive(archiveContents, zipOutputStream);
        zipInputStream.close();
        zipOutputStream.close();
    }

    //first we have to save all the contents of all the zip entries somewhere
    //we can't make a temp file, as it's written in Conditions (Hint)
    public static Map<String, byte[]> saveFilesInMap(ZipInputStream zipInputStream) {
        Map<String, byte[]> archiveContents = new HashMap<>();
        ZipEntry zipEntry;
        try {
            //this loop is sequentially copying data from all zip entries to our map
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                int length;
                byte[] buffer = new byte[1024];
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                //first we write all the content from one zipEntry to "baos"
                while ((length = zipInputStream.read(buffer)) > 0) {
                    baos.write(buffer, 0, length);
                }
                //now we put previously gained content as value and the name of zipEntry as key
                //and in the next pass we will do same thing with next zipEntry
                archiveContents.put(zipEntry.getName(), baos.toByteArray());
                baos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archiveContents;
    }
    //here we are adding only the new file to archive
    //(all the previous content from archive must be saved in a map first!)
    public static void addFileToArchive(File fileToBeAdded, ZipOutputStream zipOutputStream) {
        try {
            zipOutputStream.putNextEntry(new ZipEntry("new/" + fileToBeAdded.getName()));
            //I guess it automatically copies to the entry that we put last, so we don't have to point it
            Files.copy(fileToBeAdded.toPath(), zipOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //at the end we have to add all previously saved files back to our zip archive
    public static void addByteArraysToArchive(Map<String, byte[]> byteArrays, ZipOutputStream zipOutputStream) {
        for (Map.Entry<String, byte[]> entry : byteArrays.entrySet()) {
            String name = entry.getKey();
            if (!(name.equals("new/" + fileToBeAdded.getName()))) {
                byte[] bytes = entry.getValue();
                try {
                    ZipEntry zipEntry = new ZipEntry(name);
                    zipEntry.setSize(bytes.length);
                    zipOutputStream.putNextEntry(zipEntry);
                    zipOutputStream.write(bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
