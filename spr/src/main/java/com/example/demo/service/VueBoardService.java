package com.example.demo.service;

import com.example.demo.entity.VueBoard;

import java.util.List;

public interface VueBoardService {
    public void register(VueBoard board) throws Exception;
    public List<VueBoard> list() throws Exception;
    public void remove(Long boardNo) throws Exception;
    public void modify(VueBoard board) throws Exception;
}
