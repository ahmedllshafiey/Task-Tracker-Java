package org.taskTracker;

import java.io.IOException;

class Store {
	Model[] tasks;
    int count;

    public Store() {
        this.tasks = new Model[100];
        this.count = 0;
    }

    public void add(Model task) throws IOException {
        if (count < tasks.length) {
            tasks[count] = task;
            count++;
            Data.writeJson(tasks);
        } else {
            System.out.println("Store is full!");
        }
    }

    public void update(int id, Model task) throws IOException {
        for (int i = 0; i < count; i++) {
            if (tasks[i].id == id) {
                tasks[i] = task;
                tasks[i].updatedAt = java.time.LocalDateTime.now();
                Data.writeJson(tasks);
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public void delete(int id) throws IOException {
        for (int i = 0; i < count; i++) {
            if (tasks[i].id == id) {
                tasks[i] = tasks[count - 1];
                tasks[count - 1] = null;
                count--;
                Data.writeJson(tasks);
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public Model[] getAll() throws IOException {
        Model[] result = Data.readJson();
        System.arraycopy(tasks, 0, result, 0, count);
        return result;
    }

    public Model[] getAllDone() throws IOException {
        Model[] doneTasks = Data.readJson();
        int doneCount = 0;
        for (int i = 0; i < count; i++) {
            if (tasks[i].status == Model.Status.DONE) {
                doneTasks[doneCount] = tasks[i];
                doneCount++;
            }
        }
        Model[] result = new Model[doneCount];
        System.arraycopy(doneTasks, 0, result, 0, doneCount);
        return result;
    }

    public Model[] getAllInProgress() throws IOException {
        Model[] inProgressTasks = Data.readJson();
        int inProgressCount = 0;
        for (int i = 0; i < count; i++) {
            if (tasks[i].status == Model.Status.IN_PROGRESS) {
                inProgressTasks[inProgressCount] = tasks[i];
                inProgressCount++;
            }
        }
        Model[] result = new Model[inProgressCount];
        System.arraycopy(inProgressTasks, 0, result, 0, inProgressCount);
        return result;
    }

    public Model[] getAllToDo() throws IOException {
        Model[] toDoTasks = Data.readJson();
        int toDoCount = 0;
        for (int i = 0; i < count; i++) {
            if (tasks[i].status == Model.Status.TODO) {
                toDoTasks[toDoCount] = tasks[i];
                toDoCount++;
            }
        }
        Model[] result = new Model[toDoCount];
        System.arraycopy(toDoTasks, 0, result, 0, toDoCount);
        return result;
    }
}