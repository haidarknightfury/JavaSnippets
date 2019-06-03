package com.example.otherpatterns.event_sourcing_pattern.processor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonFileJournal {

    private final File file;
    private final List<String> events = new ArrayList<String>();
    private int index = 0;

    public JsonFileJournal() {
        this.file = new File("journal.json");

    }

}
