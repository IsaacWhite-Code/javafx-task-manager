# JavaFX Task Manager

A desktop task management application built with Java and JavaFX. I built it to practice object-oriented design, graphical user interface development, and software engineering fundamentals.

## Features

- **Add tasks:** Enter a title to create a task. Empty or whitespace-only titles are ignored.
- **Complete tasks:** Select a task and mark it completed. Completed tasks display with a checkmark.
- **Delete tasks:** Select a task and remove it from the list.
- **Hide completed tasks:** Use the checkbox to show only incomplete tasks.
- **Duplicate-safe:** Tasks are tracked as objects, so tasks that share a title are handled independently.

## Technologies Used

- **Java:** Application logic and object-oriented design
- **JavaFX:** Desktop graphical user interface
- **FXML:** Interface layout
- **Maven:** Project configuration and dependency management
- **Git and GitHub:** Version control and source code hosting

## Project Structure

```
javafx-task-manager/
├── pom.xml
├── .gitignore
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── taskmanager/
        │           ├── App.java
        │           ├── PrimaryController.java
        │           ├── Task.java
        │           ├── TaskInterface.java
        │           └── TaskManager.java
        └── resources/
            └── com/
                └── taskmanager/
                    └── primary.fxml
```

## How It Works

- **`Task`** represents a single task with a title, a priority value, and a completion status. Its fields are private, and a task can only change state through `markCompleted()`.
- **`TaskInterface`** defines the operations a task manager must support: add, remove, complete, get all tasks, and get incomplete tasks.
- **`TaskManager`** implements `TaskInterface` and stores tasks in an `ArrayList`.
- **`PrimaryController`** connects the FXML interface to the task logic. It never changes task data directly. It calls the manager, then rebuilds the on-screen list from the manager's data so the two always stay in sync.
- **`primary.fxml`** defines the layout: a text field, buttons, a filter checkbox, and the task list.

## Running the Project

1. Install a compatible JDK and Apache Maven.
2. Clone the repository:
   ```
   git clone https://github.com/IsaacWhite-Code/javafx-task-manager.git
   ```
3. Open the project folder containing `pom.xml`.
4. Run the application:
   ```
   mvn clean javafx:run
   ```

## Future Improvements

- Add automated unit tests for `TaskManager`
- Save tasks between application sessions
- Let users choose a task priority and sort by it
- Improve the visual design of the interface

## Learning Goals

This project is part of my ongoing development as a software engineer. I used it to strengthen my Java skills, practice object-oriented design, build a desktop application, and gain experience with Git, GitHub, and Maven.