package com.example.otherpatterns.event_sourcing_pattern.processor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.example.otherpatterns.event_sourcing_pattern.event.AccountCreateEvent;
import com.example.otherpatterns.event_sourcing_pattern.event.DomainEvent;
import com.example.otherpatterns.event_sourcing_pattern.event.MoneyDepositEvent;
import com.example.otherpatterns.event_sourcing_pattern.event.MoneyTransferEvent;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonFileJournal {

    private final File file;
    private final List<String> events = new ArrayList<String>();
    private int index = 0;

    public JsonFileJournal() {
        this.file = new File("C:\\Users\\hdargaye\\Desktop\\JUNKS\\Journal.json");
        if (this.file.exists()) {
            try (BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(this.file), "UTF-8"))) {
                String line;
                while ((line = input.readLine()) != null) {
                    this.events.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            this.reset();
        }
    }

    public void write(DomainEvent domainEvent) {
        Gson gson = new Gson();
        JsonElement jsonElement;
        if (domainEvent instanceof AccountCreateEvent) {
            jsonElement = gson.toJsonTree(domainEvent, AccountCreateEvent.class);
        } else if (domainEvent instanceof MoneyDepositEvent) {
            jsonElement = gson.toJsonTree(domainEvent, MoneyDepositEvent.class);
        } else if (domainEvent instanceof MoneyTransferEvent) {
            jsonElement = gson.toJsonTree(domainEvent, MoneyTransferEvent.class);
        } else {
            throw new RuntimeException(" event not recognised");
        }

        try (Writer output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.file, true), "UTF-8"))) {
            String eventString = jsonElement.toString();
            output.write(eventString + "\r\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public DomainEvent readNext() {
        if (this.index >= this.events.size()) {
            return null;
        }
        String event = this.events.get(this.index);
        this.index++;

        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(event);

        String eventClassName = jsonElement.getAsJsonObject().get("eventClassName").getAsString();
        Gson gson = new Gson();
        DomainEvent domainEvent;
        if (eventClassName.equals("AccountCreateEvent")) {
            domainEvent = gson.fromJson(jsonElement, AccountCreateEvent.class);
        } else if (eventClassName.equals("MoneyDepositEvent")) {
            domainEvent = gson.fromJson(jsonElement, MoneyDepositEvent.class);
        } else if (eventClassName.equals("MoneyTransferEvent")) {
            domainEvent = gson.fromJson(jsonElement, MoneyTransferEvent.class);
        } else {
            throw new RuntimeException("event not recognised");
        }
        domainEvent.setRealTime(true);
        return domainEvent;
    }

    public void reset() {
        this.file.delete();
    }

}
