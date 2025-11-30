package org.taskTracker;

import java.time.LocalDateTime;
import java.util.UUID;

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

    public Model(String description) {
        this.id = UUID.randomUUID().hashCode();
        this.status = Status.TODO;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}