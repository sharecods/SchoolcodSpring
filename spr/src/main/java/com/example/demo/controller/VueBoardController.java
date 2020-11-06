package com.example.demo.controller;

import com.example.demo.entity.VueBoard;
import com.example.demo.service.VueBoardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueBoardController {
    @Autowired
    private VueBoardService service;
    @GetMapping("")//
    public ResponseEntity<List<VueBoard>> list() throws Exception {
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<VueBoard> register(@Validated @RequestBody VueBoard board, UriComponentsBuilder uriBuilder) throws Exception {
        service.register(board);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }
}
