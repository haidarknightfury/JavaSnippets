package com.example.snippets.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;

public class FileManipulation {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\NDC\\JavaSnippets\\files\\lorem.txt");
        System.out.println(path.toString());
        System.out.println(path.getFileName());
        System.out.println(path.getName(1));
        System.out.println(path.getNameCount());

        // actual path name
        Path realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
        System.out.println(realPath.toString());

        // FileSystem, WatchKey (listeners on directories) - use Path class instead of file
        // CopyFile();
        // deleteFIle();
        // createDir();

        // readAndWriteTextFiles();
        NavigateDirectory();
    }

    public static void CopyFile() throws IOException {
        Path source = Paths.get("C:\\NDC\\JavaSnippets\\files\\lorem.txt");
        Path target = Paths.get("C:\\NDC\\JavaSnippets\\files\\newfile.txt");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void deleteFIle() throws IOException {
        Path toDelete = Paths.get("C:\\NDC\\JavaSnippets\\files\\newfile.txt");
        Files.delete(toDelete);
    }

    public static void createDir() throws IOException {
        Path source = Paths.get("C:\\NDC\\JavaSnippets\\files\\lorem.txt");
        Path newDir = Paths.get("C:\\NDC\\JavaSnippets\\files\\newDir");
        Files.createDirectories(newDir);

        // resolve - file name as string - new file
        Files.move(source, newDir.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void readAndWriteTextFiles() {
        Path source = Paths.get("C:\\NDC\\JavaSnippets\\files\\lorem.txt");
        Path target = Paths.get("C:\\NDC\\JavaSnippets\\files\\target.txt");

        Charset charset = Charset.forName("US-ASCII");
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(source)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try (BufferedWriter writer = Files.newBufferedWriter(target, charset)) {
            Iterator<String> iterator = lines.iterator();
            while (iterator.hasNext()) {
                String s = iterator.next();
                // append at to end of file
                writer.append(s, 0, s.length());
                writer.newLine();
            }
        } catch (Exception e) {
            System.err.println(e.getCause());
        }
    }

    public static void NavigateDirectory() throws IOException {
        Path source = Paths.get("C:\\NDC\\JavaSnippets\\files");
        MyFileVisitor visitor = new MyFileVisitor();
        Files.walkFileTree(source, visitor);
    }

}
