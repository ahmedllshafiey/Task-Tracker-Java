# Task Tracker Java

Task Tracker Java is a simple command-line application for managing tasks. It allows users to add, update, delete, and list tasks with different statuses such as TODO, IN_PROGRESS, and DONE. The application is built using Java and utilizes Gson for JSON serialization and deserialization.

## Features

- **Add Tasks**: Add new tasks with a description.
- **Update Tasks**: Update existing tasks by their ID.
- **Delete Tasks**: Delete tasks by their ID.
- **List Tasks**: List all tasks or filter tasks by their status (TODO, IN_PROGRESS, DONE).
- **Persistent Storage**: Tasks are stored in a JSON file (`tasks.json`).

## Prerequisites

- Java 17 or higher
- Maven

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/ahmedllshafiey/Task-Tracker-Java.git
   ```
2. Navigate to the project directory:
   ```bash
   cd Task-Tracker-Java
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Usage

Run the application from the command line:
```bash
java -cp target/task-tracker-java-1.0-SNAPSHOT.jar org.taskTracker.Main <command> [arguments]
```

### Commands

- **Add a Task**:
  ```bash
  java -cp target/task-tracker-java-1.0-SNAPSHOT.jar org.taskTracker.Main add "Task Description"
  ```
- **Update a Task**:
  ```bash
  java -cp target/task-tracker-java-1.0-SNAPSHOT.jar org.taskTracker.Main update <task_id> "Updated Description"
  ```
- **Delete a Task**:
  ```bash
  java -cp target/task-tracker-java-1.0-SNAPSHOT.jar org.taskTracker.Main delete <task_id>
  ```
- **List All Tasks**:
  ```bash
  java -cp target/task-tracker-java-1.0-SNAPSHOT.jar org.taskTracker.Main list
  ```
- **List Tasks by Status**:
  - TODO:
    ```bash
    java -cp target/task-tracker-java-1.0-SNAPSHOT.jar org.taskTracker.Main list todo
    ```
  - IN_PROGRESS:
    ```bash
    java -cp target/task-tracker-java-1.0-SNAPSHOT.jar org.taskTracker.Main list in-progress
    ```
  - DONE:
    ```bash
    java -cp target/task-tracker-java-1.0-SNAPSHOT.jar org.taskTracker.Main list done
    ```

## Project Structure

```
Task-Tracker-Java/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/taskTracker/
│   │   │       ├── Data.java
│   │   │       ├── Main.java
│   │   │       ├── Model.java
│   │   │       ├── Store.java
│   │   │       └── UI.java
│   └── test/
│       └── java/
├── target/
│   ├── classes/
│   ├── generated-sources/
│   ├── generated-test-sources/
│   ├── maven-status/
│   └── test-classes/
├── pom.xml
```

## Dependencies

- [Gson](https://github.com/google/gson): For JSON serialization and deserialization.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Author

Ahmed Elshafiey