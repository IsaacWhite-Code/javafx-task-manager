# JavaFX Task Manager

A desktop task management application built with Java and JavaFX. This project is an opportunity to practice object-oriented programming, graphical user interface development, and software engineering fundamentals.

## Features

- **Add Tasks:** Create new tasks by entering a title.
- **View Tasks:** Display tasks in an interactive list.
- **Complete Tasks:** Select a task and mark it as completed.
- **Task Management:** Organize task-related functionality using separate Java classes and interfaces.

## Technologies Used

- **Java** — Application logic and object-oriented programming.
- **JavaFX** — Desktop graphical user interface.
- **FXML** — Defines the layout of the application interface.
- **Maven** — Project configuration and dependency management.
- **Git and GitHub** — Version control and source code hosting.

## Project Structure

```text
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

The application uses a `Task` class to represent individual tasks, including their titles, priorities, and completion status.

The `TaskManager` class handles task-related operations, while `TaskInterface` defines the operations that the task manager supports.

The JavaFX interface allows users to enter tasks, view them in a list, and interact with them through buttons. The `PrimaryController` connects the interface to the application's task management logic.

## Running the Project

1. Install a compatible JDK.
2. Install the Java extensions for Visual Studio Code.
3. Open the project folder containing `pom.xml`.
4. Run the application using the JavaFX Maven configuration provided by the project.

## Future Improvements

- Add the ability to delete tasks.
- Improve the visual design of the interface.
- Add task priorities and sorting.
- Save tasks between application sessions.
- Add automated tests for task management functionality.

## Learning Goals

This project is part of my ongoing development as a software engineer. I am using it to strengthen my Java skills, understand object-oriented design, build desktop applications, and gain experience with Git, GitHub, and Maven.
