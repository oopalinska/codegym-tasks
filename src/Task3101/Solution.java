package Task3101;

/*
Iterating through a file tree

*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        File directory = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        //2.2 (rename file): we have to change only the last part of its name!
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "\\allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        //this will be the list to store the files under 50 bytes
        List<File> filesList = new ArrayList<>();

        //this queue iterates through all directory tree
        // when it finds a file then checks if its under 50
        //if yes - save it to filesList
        Queue<File> queue = new LinkedList<>();
        queue.add(directory);
        while (!queue.isEmpty()) {
            File current = queue.poll();
            File[] filesInsideCurrent = current.listFiles();
            //if current is a directory
            if (filesInsideCurrent != null) {
                queue.addAll(Arrays.asList(filesInsideCurrent));
            }
            //if current is an empty directory or a file
            else {
                if (current.isFile() && current.length() <= 50)  filesList.add(current);
            }
        }
        //sort the result list by file names
        filesList.sort(new FilesComparator());

        //2.3
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(allFilesContent)))) {
            for (File file : filesList) {
                if (file.equals(allFilesContent)) continue;
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (reader.ready()) {
                    writer.write(reader.readLine());
                }
                reader.close();
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("IOException!");
        }

    }

    static class FilesComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return ((File) o1).getName().compareTo(((File) o2).getName());
        }
    }
}