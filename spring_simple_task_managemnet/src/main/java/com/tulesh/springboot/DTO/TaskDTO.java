package com.tulesh.springboot.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tulesh.springboot.constant.ValidationMsgs;
import com.tulesh.springboot.enun.TaskStatus;
import com.tulesh.springboot.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDTO {
    private Long id;

    @NotNull(message = "title "+ ValidationMsgs.NOT_NULL_MSG)
    @NotEmpty(message="title " + ValidationMsgs.NOT_EMPTY_MSG)
    private String title;

    @NotNull(message = "description "+ ValidationMsgs.NOT_NULL_MSG)
    @NotEmpty(message="description " + ValidationMsgs.NOT_EMPTY_MSG)
    private String description;
    private String status;

    private LocalDate dueDate;
    private Date createdAt;
    private Date updatedAt;
    private Long createdBy;

    public TaskDTO(Long id, String title, String description, String status, LocalDate dueDate, Date createdAt, Date updatedAt, Long createdBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = TaskStatus.getDisplayValueFromString(status);
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
    }

    public TaskDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
