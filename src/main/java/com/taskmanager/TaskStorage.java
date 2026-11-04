package com.taskmanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private final Path file;

    public TaskStorage(Path file) {
        this.file = file;
    }

    public void save(List<Task> tasks) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Task task : tasks) {
            lines.add(task.isCompleted() + "\t" + task.getPriority() + "\t" + task.getTitle());
        }
        Files.write(file, lines);
    }

    public List<Task> load() throws IOException {
        List<Task> tasks = new ArrayList<>();

        if (!Files.exists(file)) {
            return tasks;
        }

        for (String line : Files.readAllLines(file)) {
            String[] parts = line.split("\t", 3);
            if (parts.length < 3) {
                continue;
            }

            try {
                Task task = new Task(parts[2], Integer.parseInt(parts[1]));
                if (Boolean.parseBoolean(parts[0])) {
                    task.markCompleted();
                }
                tasks.add(task);
            } catch (NumberFormatException e) {
                // skip a corrupted line instead of crashing
            }
        }
        return tasks;
    }
}