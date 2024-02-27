package com.tulesh.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tulesh.springboot.DTO.TaskDTO;
import com.tulesh.springboot.enun.TaskStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "getUserTask",
                classes = @ConstructorResult(
                        targetClass = TaskDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "title", type = String.class),
                                @ColumnResult(name = "description", type = String.class),
                                @ColumnResult(name = "status", type = String.class),
                                @ColumnResult(name = "due_date", type = LocalDate.class),
                                @ColumnResult(name = "created_at", type = Date.class),
                                @ColumnResult(name = "updated_at", type = Date.class),
                                @ColumnResult(name = "created_by", type = Long.class)
                        }
                )
        )
})

@Entity
@Table(name = "task")
@Data
@Getter
@Setter
//@JsonIgnoreProperties({"createdBy"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "varchar(16) DEFAULT 'TODO'")
    private TaskStatus status = TaskStatus.ToDo; // To Do, In Progress, Done

    private LocalDate dueDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, length = 29, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", length = 29, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;
}
