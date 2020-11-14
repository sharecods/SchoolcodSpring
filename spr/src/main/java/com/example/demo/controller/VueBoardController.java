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

@Log
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

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("remove");

        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<VueBoard> modify(@PathVariable("boardNo") Long boardNo, @Validated @RequestBody VueBoard board) throws Exception {
        log.info("Put - modify()");
        System.out.println(board);

        board.setBoardNo(boardNo);
        service.modify(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }
}
