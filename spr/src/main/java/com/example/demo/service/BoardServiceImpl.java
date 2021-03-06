package com.example.demo.service;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepository;
    @Override
    public void register(Board board) throws Exception {
        boardRepository.create(board);
    }
    @Override
    public List<Board> list() throws Exception {
        return boardRepository.list();
    }
    @Override
    public Board read(Integer boardNo) throws Exception {
        return boardRepository.read(boardNo);
    }
    @Override
    public void remove(Integer boardNo) throws Exception {
        boardRepository.remove(boardNo);
    }
    @Override
    public void modify(Board board) throws Exception {
        boardRepository.modify(board);
    }
}
