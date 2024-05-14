package org.wecancodeit.todotask.Services;

import java.util.*;

import org.springframework.stereotype.Service;
import org.wecancodeit.todotask.Models.TaskModel;
import org.wecancodeit.todotask.Repositories.TaskRepository;

import jakarta.annotation.Resource;

@Service
public class TaskService {

    @Resource
    private TaskRepository taskRepository;

    public TaskService() {
    }

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<TaskModel> findAll(){
        Iterable<TaskModel> tasks = new ArrayList<>();
        try {
            tasks = taskRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return tasks;
    }

    /**
     * Method to find tasks by ID
     * 
     * @param id task id
     * 
     * @return the task
     */
    public TaskModel findById(Long id){
        TaskModel task = null;
        try {
            Optional<TaskModel> optTask = taskRepository.findById(id);
            if (optTask.isPresent()) {
                task = optTask.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return task;
    }

    /**
     * Method to delete an task by ID
     * 
     * @param id task ID
     * 
     * @return if the task was deleted
     */
    public boolean deleteTask(Long id){
        boolean result = false;
        try {
            taskRepository.deleteById(id);
            Optional<TaskModel> optTask = taskRepository.findById(id);
            if (!optTask.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * Method to update and add an task
     * 
     * @param task the task to add or update
     * 
     * @return the added or updated task
     */
    public TaskModel saveTask(TaskModel taskModel){
        try {
            if(TaskService.isValidTask(taskModel)) {
                taskModel = taskRepository.save(taskModel);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return taskModel;
    }

    /**
     * Method that checks if the task is a valid task
     * 
     * @param task task to check
     * 
     * @return if the task is valid
     */
    public static boolean isValidTask(TaskModel taskModel) {
        return true;
    }

}
