package com.example.snippets.file.file_watching;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

/**
 * Watch a directory for any changes
 *
 * @author hdargaye
 *
 */
public class FileWatcher {

    public static void main(String[] args) throws IOException {

        // new try with resources - no need to close
        try (WatchService service = FileSystems.getDefault().newWatchService()) {

            Map<WatchKey, Path> keyMap = new HashMap<>();
            Path path = Paths.get("files");

            // map to configure watch service -> register a watchService on path
            keyMap.put(path.register(service, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY), path);

            WatchKey watchKey;
            do {
                // Retrieves and removes next watch key, waiting if none are yet present.
                watchKey = service.take();
                Path eventDir = keyMap.get(watchKey);

                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    Path eventPath = (Path) event.context();
                    System.out.println(eventDir + ":" + kind + ":" + eventPath);
                }
            } while (watchKey.reset());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
