package org.wecancodeit.todotask;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.todotask.Models.TaskModel;
import org.wecancodeit.todotask.Models.Enums.CategoryEnum;
import org.wecancodeit.todotask.Models.Enums.PriorityEnum;
import org.wecancodeit.todotask.Services.TaskService;

import jakarta.annotation.Resource;

@Component
public class Populator implements CommandLineRunner{

    @Resource
    private final TaskService taskService;

    public Populator(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {
        TaskModel taskModel = new TaskModel("Finish Database", false, PriorityEnum.IMPORTANT, LocalDate.now(), CategoryEnum.HOME);
        taskService.saveTask(taskModel);
        TaskModel taskModel2 = new TaskModel("Finish Web Interface", false, PriorityEnum.LOW, LocalDate.now(), CategoryEnum.MISC);
        taskService.saveTask(taskModel2);
        TaskModel taskModel3 = new TaskModel("Finish API", false, PriorityEnum.REGULAR, LocalDate.now(), CategoryEnum.WORK);
        taskService.saveTask(taskModel3);
    }
}
