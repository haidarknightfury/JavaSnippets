package com.example.snippets.file.finding_file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindingFiles {

    public static List<File> listAllFilesRecursive(String path) {
        List<File> all = new ArrayList<>();
        File[] list = new File(path).listFiles();
        if (list != null) {
            for (File f : list) {
                if (f.isDirectory()) {
                    all.addAll(listAllFilesRecursive(f.getAbsolutePath()));
                } else {
                    all.add(f.getAbsoluteFile());
                }
            }
        }
        return all;
    }

    public static File[] listFilesInDirectory(final File folder) {
        return folder.listFiles(File::isFile);
    }

    public static void main(String[] args) throws IOException {
        Path fileDir = Paths.get("src");

        System.out.println("File in Directory : ");
        Arrays.asList(listFilesInDirectory(fileDir.toFile())).stream().forEach(f -> System.out.println(f.getName()));

        // FileFinder finder = new FileFinder("lorem.txt");
        FileFinder finder = new FileFinder("*.txt");
        // walk the file tree
        Files.walkFileTree(fileDir, finder);

        ArrayList<Path> foundFiles = finder.foundPath;
        if (foundFiles.size() > 0) {
            foundFiles.stream().forEach(path ->
                {
                    try {
                        System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        } else {
            System.out.println("No files were found");
        }
    }

}
