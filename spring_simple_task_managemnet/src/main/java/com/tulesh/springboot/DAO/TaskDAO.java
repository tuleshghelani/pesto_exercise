package com.tulesh.springboot.DAO;

import com.tulesh.springboot.DTO.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class TaskDAO {

    @Autowired
    private EntityManager entityManager;

    public List<TaskDTO> getUserTask(Long id) {
        try {
            String query = "SELECT t.id, t.title, t.description, t.status, t.due_date, t.created_at, t.updated_at, t.created_by FROM Task t WHERE t.created_by = " + id;
            List<TaskDTO> result = (List<TaskDTO>) entityManager.createNativeQuery(query, "getUserTask").getResultList();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TaskDTO> getAllTask() {
        try {
            String query = "SELECT t.id, t.title, t.description, t.status, t.due_date, t.created_at, t.updated_at, t.created_by FROM Task t";
            List<TaskDTO> result = (List<TaskDTO>) entityManager.createNativeQuery(query, "getUserTask").getResultList();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TaskDTO findById(Long taskId) {
        try {
            String query = "SELECT t.id, t.title, t.description, t.status, t.due_date, t.created_at, t.updated_at, t.created_by FROM Task t where t.id = " + taskId;
            TaskDTO result = (TaskDTO) entityManager.createNativeQuery(query, "getUserTask").getSingleResult();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
