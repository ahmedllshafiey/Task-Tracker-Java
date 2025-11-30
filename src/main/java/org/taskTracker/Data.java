package org.taskTracker;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Data {
    
    static final String DATA_FILE = "tasks.json";

    public static void writeJson(Model[] tasks) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try (FileWriter writer = new FileWriter(DATA_FILE)) {
            gson.toJson(tasks, writer);
            writer.close();
        }
    }

    public static Model[] readJson() throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get(DATA_FILE);
        if (!java.nio.file.Files.exists(path)) {
            return new Model[0];
        }
        String json = new String(java.nio.file.Files.readAllBytes(path));
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(json, Model[].class);
    }
}