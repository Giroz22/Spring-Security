package com.ghost.SpringSecurity.adapter.input.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghost.SpringSecurity.adapter.input.api.dto.request.UserRequest;
import com.ghost.SpringSecurity.adapter.input.api.dto.response.UserResponse;
import com.ghost.SpringSecurity.adapter.input.api.mapper.UserApiMapper;
import com.ghost.SpringSecurity.domain.port.input.UserServicePort;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServicePort service;
    private final UserApiMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll(@RequestParam UserRequest request) {
        return ResponseEntity.ok().body(
            this.mapper.EntityToResponse(
                this.service.getAll()
            )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@RequestParam String id) {
        return ResponseEntity.ok().body(
            this.mapper.EntityToResponse(
                this.service.getById(id)
            )
        );
    }
    
    
    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getByEmail(@RequestParam String email) {
        return ResponseEntity.ok().body(
            this.mapper.EntityToResponse(
                this.service.getByEmail(email)
            )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable String id, @RequestBody UserRequest request) {
        return ResponseEntity.ok().body(
            this.mapper.EntityToResponse(
                this.service.update(
                    id, 
                    this.mapper.RequestToEntity(request)
                )
            )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
