package org.taskTracker;

import java.io.IOException;

public class UI {
    
    public UI(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("No arguments provided.");
        }
        else {
            Store store = new Store();
            switch (args[0]) {
                case "add" -> {
                    Model task = new Model(args[1]);
                    store.add(task);
                    System.out.println("Task added successfully (" + task.id + ")");
                }
                case "update" -> {
                    int id = Integer.parseInt(args[1]);
                    Model updateTask = new Model(args[2]);
                    store.update(id, updateTask);
                    System.out.println("Task updated successfully (" + updateTask.id + ")");
                }
                case "delete" -> {
                    int deleteId = Integer.parseInt(args[1]);
                    store.delete(deleteId);
                    System.out.println("Task deleted successfully (" + deleteId + ")");
                }
                case "list" -> {
                    if (args.length == 1) {
                        Model[] allTasks = store.getAll();
                        for (Model t : allTasks) {
                            System.out.println("ID: " + t.id + ", Description: " + t.description + ", Status: " + t.status);
                        }
                    } else if (args.length > 1 && args[1].equals("done")) {
                        Model[] doneTasks = store.getAllDone();
                        for (Model t : doneTasks) {
                            System.out.println("ID: " + t.id + ", Description: " + t.description + ", Status: " + t.status);
                        }
                    } else if (args.length > 1 && args[1].equals("todo")) {
                        Model[] toDoneTasks = store.getAllToDo();
                        for (Model t : toDoneTasks) {
                            System.out.println("ID: " + t.id + ", Description: " + t.description + ", Status: " + t.status);
                        }
                    } else if (args.length > 1 && args[1].equals("in-progress")) {
                        Model[] progressTasks = store.getAllInProgress();
                        for (Model t : progressTasks) {
                            System.out.println("ID: " + t.id + ", Description: " + t.description + ", Status: " + t.status);
                        }
                    }
                }
                default -> System.out.println("Invalid command.");
            }
        } 
    }
}
