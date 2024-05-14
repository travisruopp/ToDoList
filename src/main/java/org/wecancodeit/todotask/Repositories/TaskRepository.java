package org.wecancodeit.todotask.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.todotask.Models.TaskModel;

public interface TaskRepository extends CrudRepository<TaskModel, Long>{

}
