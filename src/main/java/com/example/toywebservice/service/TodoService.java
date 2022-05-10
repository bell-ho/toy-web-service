package com.example.toywebservice.service;

import com.example.toywebservice.model.TodoEntity;
import com.example.toywebservice.persistence.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository repository;

    public String testS() {
        TodoEntity entity = TodoEntity.builder().title("first").build();
        repository.save(entity);
        TodoEntity saved = repository.findById(entity.getId()).get();
        return saved.getTitle();
    }

}
