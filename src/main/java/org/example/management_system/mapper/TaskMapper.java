package org.example.management_system.mapper;

import org.example.management_system.dto.TaskRequestTo;
import org.example.management_system.dto.TaskResponseTo;
import org.example.management_system.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TaskMapper {
    Task toEntity(TaskRequestTo taskRequestTo);

    TaskResponseTo toResponseTo(Task task);
}
