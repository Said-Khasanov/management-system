package org.example.management_system.dto;

import lombok.*;
import org.example.management_system.entity.Priority;
import org.example.management_system.entity.TaskStatus;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TaskRequestTo {
    private String title;
    private String description;
    private TaskStatus status;
    private Priority priority;
    private Long authorId;
    private Long executorId;
    private List<String> comments;
}
