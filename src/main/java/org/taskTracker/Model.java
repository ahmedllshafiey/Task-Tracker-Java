package org.taskTracker;

import java.time.LocalDateTime;

class Model {
	int id;
    String description;
    public enum Status {
        TODO,
        IN_PROGRESS,
        DONE
    }
    Status status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Model(int id, String description, Status stat) {
        this.id = id;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}