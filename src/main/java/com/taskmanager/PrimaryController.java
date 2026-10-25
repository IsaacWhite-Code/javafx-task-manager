
package com.taskmanager;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

public class PrimaryController {

    @FXML
    private TextField taskTitleField;

    @FXML
    private ListView<Task> taskListView;

    private TaskManager taskManager = new TaskManager();

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
    private void addTask() {
        String title = taskTitleField.getText();

        if (title == null || title.trim().isEmpty()) {
            return;
        }

        Task task = new Task(title.trim(), 1);
        taskManager.addTask(task);

        taskListView.getItems().add(task);
        taskTitleField.clear();
    }

    
    @FXML
    private void completeTask() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();

        if (selectedTask == null) {
            return;
        }

        boolean success = taskManager.completeTask(selectedTask.getTitle());

        if (success) {
            taskListView.refresh();
        }
    }

}
