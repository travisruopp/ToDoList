package org.wecancodeit.todotask.Models;

import java.time.LocalDate;

import org.wecancodeit.todotask.Models.Enums.CategoryEnum;
import org.wecancodeit.todotask.Models.Enums.PriorityEnum;

public class TaskDto {

    private Long taskID;
    private String description;
    private boolean status;
    private PriorityEnum priority;
    private LocalDate dueDate = LocalDate.now();
    private CategoryEnum category;

    public TaskDto() {
    }

    public TaskDto(Long taskID, String description, boolean status, PriorityEnum priority, LocalDate dueDate,
            CategoryEnum category) {
        this.taskID = taskID;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
        this.category = category;
    }

    public TaskDto(TaskModel taskModel) {
        this.taskID = taskModel.getTaskID();
        this.description = taskModel.getDescription();
        this.status = taskModel.isStatus();
        this.priority = taskModel.getPriority();
        this.dueDate = taskModel.getDueDate();
        this.category = taskModel.getCategory();
    }

    public TaskModel copyTask() {
        TaskModel taskModel = new TaskModel(this.description, this.status, this.priority, this.dueDate, this.category);
        taskModel.setTaskID(taskID);
        return taskModel;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

}
