package com.example.demo.service;

import com.example.demo.entity.VueBoard;
import com.example.demo.repository.VueBoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueBoardServiceImpl implements  VueBoardService {
    @Autowired
    private VueBoardRepository repository;
    @Override
    public void register(VueBoard board) throws Exception {
        repository.create(board);
    }
    @Override
    public List<VueBoard> list() throws Exception {
        return repository.list();
    }
}
