package com.taskmanager;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import java.util.List;

public class PrimaryController {

    @FXML
    private TextField taskTitleField;
    @FXML
    private ListView<Task> taskListView;
    @FXML
    private TaskManager taskManager = new TaskManager();
    @FXML
    private CheckBox hideCompletedBox;

    @FXML
    public void initialize() {
        taskListView.setCellFactory(new Callback<ListView<Task>, ListCell<Task>>() {
            @Override
            public ListCell<Task> call(ListView<Task> listView) {
                return new ListCell<Task>() {
                    @Override
                    protected void updateItem(Task task, boolean empty) {
                        super.updateItem(task, empty);

                        if (empty || task == null) {
                            setText(null);
                        } else if (task.isCompleted()) {
                            setText("✓ " + task.getTitle() + " - Completed");
                        } else {
                            setText(task.getTitle());
                        }
                    }
                };
            }
        });
    }
    
    @FXML
    private void refreshList() {
        List<Task> tasksToShow;

        if (hideCompletedBox.isSelected()) {
            tasksToShow = taskManager.getIncompleteTasks();
        } else {
            tasksToShow = taskManager.getTasks();
        }

        taskListView.getItems().setAll(tasksToShow);
    }

    @FXML
    private void addTask() {
        String title = taskTitleField.getText();

        if (title == null || title.trim().isEmpty()) {
            return;
        }

        taskManager.addTask(new Task(title.trim(), 1));
        taskTitleField.clear();
        refreshList();
    }

    @FXML
    private void completeTask() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();

        if (selectedTask == null) {
            return;
        }

        if (taskManager.completeTask(selectedTask)) {
            refreshList();
        }
    }

    @FXML
    private void deleteTask() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();

        if (selectedTask == null) {
            return;
        }

        if (taskManager.removeTask(selectedTask)) {
            refreshList();
        }
    }

    @FXML
    private void onFilterChanged() {
        refreshList();
    }

}
