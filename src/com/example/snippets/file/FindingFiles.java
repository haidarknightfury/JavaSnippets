package com.example.snippets.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FindingFiles {

    public static void main(String[] args) throws IOException {
        Path fileDir = Paths.get("files");
        // FileFinder finder = new FileFinder("lorem.txt");
        FileFinder finder = new FileFinder("*.txt");
        // walk the file tree
        Files.walkFileTree(fileDir, finder);

        ArrayList<Path> foundFiles = finder.foundPath;
        if (foundFiles.size() > 0) {
            foundFiles.stream().forEach(path -> {
                try {
                    System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } else {
            System.out.println("No files were found");
        }
    }

}
