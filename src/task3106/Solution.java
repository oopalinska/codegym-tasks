package task3106;

/*
Unzipping a file

*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        //save names of files from args to variables
        File resultFile = new File(args[0]);
        List<String> fileNames = new ArrayList<>(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileNames);

        //create a list of input streams for all files
        List<FileInputStream> fileInputStreams = new ArrayList<>();
        for (String name : fileNames) {
            fileInputStreams.add(new FileInputStream(name));
        }
        //explanation: SequenceInputStream takes Enumeration object as an argument
        ZipInputStream zipIS = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams)));
        OutputStream resultFileOutputStream = new BufferedOutputStream(new FileOutputStream(resultFile));
        //sequentially write all files contents to resultFile
        while (true) {
            ZipEntry entry = zipIS.getNextEntry();
            if (entry == null) break;
            byte[] buffer = new byte[1024];
            int readBytes;
            while ((readBytes = zipIS.read(buffer, 0, buffer.length)) > -1)
                resultFileOutputStream.write(buffer, 0, readBytes);
        }
        zipIS.close();
        resultFileOutputStream.close();

    }
}
