package com.todo.task;

import com.todo.utils.ToDoConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long taskId;

    @Transient
    private boolean check;

    private String description;

    private String title;

    private String status;

    private LocalDateTime startDate;

    @DateTimeFormat(pattern = ToDoConstants.DATE_TIME_PATTERN)
    private LocalDateTime endDate;
}
