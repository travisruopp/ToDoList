package org.wecancodeit.todotask.Models;

import java.time.LocalDate;

import org.wecancodeit.todotask.Models.Enums.*;

import jakarta.persistence.*;

/**
 * Class that models the tasks for the to do list
 */
@Entity
@Table(name = "t_Task")
public class TaskModel {
    @Id
    @GeneratedValue
    private Long taskID;

    private String description;
    private boolean status;
    private PriorityEnum priority;
    private LocalDate dueDate = LocalDate.now();
    private CategoryEnum category;
    
    /**
     * Default Constructor
     */
    public TaskModel() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param description description of task
     * @param status status of task
     * @param priority priority of task (Enum)
     * @param dueDate due date of task
     * @param category category of the task (Enum)
     */
    public TaskModel(String description, boolean status, PriorityEnum priority, LocalDate dueDate, CategoryEnum category) {
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
        this.category = category;
    }

    /**
     * Method that gets the task id
     * 
     * @return task id
     */
    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    /**
     * Method to get the task description
     * 
     * @return task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to get the the status of the task
     * 
     * @return status of task
     */
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Method to get the priority of the task
     * 
     * @return priority of the task
     */
    public PriorityEnum getPriority() {
        return priority;
    }

    /**
     * Method to get the due date of the task
     * 
     * @return due date of the task
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Method to get the category of the task
     * 
     * @return category of the task
     */
    public CategoryEnum getCategory() {
        return category;
    }

    /**
     * Override method for the toString
     */
    @Override
    public String toString() {
        return "TaskModel [taskID=" + taskID + ", description=" + description + ", status=" + status + ", priority="
                + priority + ", dueDate=" + dueDate + ", category=" + category + "]";
    }
}
