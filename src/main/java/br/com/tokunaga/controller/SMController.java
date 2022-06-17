package br.com.tokunaga.controller;

import br.com.tokunaga.service.SecretManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
public class SMController {

    private final SecretManagerService service;

    @GetMapping("/sm")
    public ResponseEntity get(@PathParam("content") String content) {
        return ResponseEntity.ok(service.get(content));
    }
}