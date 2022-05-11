package com.example.toywebservice.service;

import com.example.toywebservice.model.TodoEntity;
import com.example.toywebservice.persistence.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository repository;

    public List<TodoEntity> create(final TodoEntity entity) {
        validate(entity);
        repository.save(entity);

        return repository.findByUserId(entity.getUserId());
    }

    private void validate(final TodoEntity entity) {
        if (entity == null) {
            log.warn("error");
            throw new RuntimeException("unknown user");
        }
        if (entity.getUserId() == null) {
            log.warn("error getUserId");
            throw new RuntimeException("unknown getUserId");
        }
    }
}
