package org.wecancodeit.todotask.Controllers;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.todotask.Models.TaskDto;
import org.wecancodeit.todotask.Models.TaskModel;
import org.wecancodeit.todotask.Models.Enums.CategoryEnum;
import org.wecancodeit.todotask.Models.Enums.PriorityEnum;
import org.wecancodeit.todotask.Services.TaskService;

import jakarta.annotation.Resource;

@Controller
@RequestMapping("/")
public class TaskController {

    @Resource
    private final TaskService taskService;

    /**
     * Parameterized Constructor
     * 
     * @param taskService task services
     */
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Method to map getting all tasks
     * 
     * @return all tasks
     */
    @GetMapping
    public String getAllTasks(Model model) {
        Iterable<TaskModel> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    /**
     * Method to get a task by id
     * 
     * @param id task id
     * 
     * @return task
     */
    @GetMapping("{id}")
    public String getTask(@PathVariable Long id, Model model) {
        TaskModel task = taskService.findById(id);
        model.addAttribute("task", task);
        return "details";
    }

    @GetMapping("edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        TaskModel tasks = taskService.findById(id);
        TaskDto task = new TaskDto(tasks);
        model.addAttribute("task", task);
        List<String> listCategory = enumToList(CategoryEnum.class);
        model.addAttribute("listCategory", listCategory);
        List<String> listPriority = enumToList(PriorityEnum.class);
        model.addAttribute("listPriority", listPriority);
        return "edittask";
    }

    @GetMapping("delete/confirmDelete/{id}")
    public String confirmDeleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteTask(@PathVariable Long id, Model model) {
        TaskModel task = taskService.findById(id);
        model.addAttribute("task", task);
        return "confirmDelete";
    }

    @GetMapping("addtask")
    public String addTask(Model model) {
        TaskDto taskModel = new TaskDto();
        model.addAttribute("task", taskModel);
        List<String> listCategory = enumToList(CategoryEnum.class);
        model.addAttribute("listCategory", listCategory);
        List<String> listPriority = enumToList(PriorityEnum.class);
        model.addAttribute("listPriority", listPriority);
        return "addtask";
    }

    @PostMapping("save")
    public String saveTask(@ModelAttribute("task") TaskDto taskModel) {
        taskService.saveTask(taskModel.copyTask());
        return "redirect:/";
    }

    /**
     * Method to convert Enum to List of Strings
     * 
     * @param <T>
     * @param class1
     * 
     * @return list of enumerators
     */
    public <T extends Enum<T>> List<String> enumToList(Class<T> class1) {
        List<String> list = new ArrayList<>();
        T[] enumConstants = class1.getEnumConstants();
        for (T enumConstant : enumConstants) {
            list.add(enumConstant.name());
        }
        return list;
    }

    @GetMapping("status/{id}")
    public String toggleStatus(@PathVariable Long id){
        TaskModel taskModel = taskService.findById(id);
        taskModel.setStatus(!taskModel.isStatus());
        taskService.saveTask(taskModel);
        return "redirect:/"; 
    }
}
