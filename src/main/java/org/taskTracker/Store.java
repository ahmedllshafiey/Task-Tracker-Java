package org.taskTracker;

class Store {
	Model[] tasks;
    int count;

    public Store() {
        this.tasks = new Model[100];
        this.count = 0;
    }

    public void add(Model task) {
        if (count < tasks.length) {
            tasks[count] = task;
            count++;
        } else {
            System.out.println("Store is full!");
        }
    }

    public void update(Model task) {
        for (int i = 0; i < count; i++) {
            if (tasks[i].id == task.id) {
                tasks[i] = task;
                tasks[i].updatedAt = java.time.LocalDateTime.now();
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public void delete(int id) {
        for (int i = 0; i < count; i++) {
            if (tasks[i].id == id) {
                tasks[i] = tasks[count - 1];
                tasks[count - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public Model[] getAll() {
        Model[] result = new Model[count];
        System.arraycopy(tasks, 0, result, 0, count);
        return result;
    }

    public Model[] getAllDone() {
        Model[] doneTasks = new Model[count];
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

    public Model[] getAllInProgress() {
        Model[] inProgressTasks = new Model[count];
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

    public Model[] getAllToDo() {
        Model[] toDoTasks = new Model[count];
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