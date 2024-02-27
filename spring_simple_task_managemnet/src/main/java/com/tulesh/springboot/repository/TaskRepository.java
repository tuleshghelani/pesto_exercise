package com.tulesh.springboot.repository;

import com.tulesh.springboot.DTO.TaskDTO;
import com.tulesh.springboot.enun.TaskStatus;
import com.tulesh.springboot.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);

    //    @Query(nativeQuery = true, value = "SELECT t.id, t.title FROM Task t WHERE t.created_by = :id")
    @Query(name = "TaskDTOMapping", nativeQuery = true, value = "SELECT t.id, t.title, t.description, t.status, t.due_date, t.created_at, t.updated_at, t.created_by FROM Task t WHERE t.created_by = :id")
    List<TaskDTO> getUserTask(Long id);

    @Query("SELECT t FROM Task t WHERE t.dueDate between :startDate AND :endDate AND t.status != 'Done'")
    List<Task> findByDueDateBetween(LocalDate startDate, LocalDate endDate);
}
