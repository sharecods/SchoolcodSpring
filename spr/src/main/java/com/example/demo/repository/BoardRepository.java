package com.example.demo.repository;
import com.example.demo.entity.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class BoardRepository {
    static final Logger log =
            LoggerFactory.getLogger(BoardRepository.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void create(Board board) throws Exception {
        log.info("Repository create()");
        String query = "insert into board(title, content, writer) values(?, ?, ?)";
        jdbcTemplate.update(query, board.getTitle(),
                board.getContent(), board.getWriter());
    }

    public List<Board> list() throws Exception {
        log.info("Repository list()");
        List<Board> results = jdbcTemplate.query("select board_no, title, content, writer, reg_date from board where board_no > 0 order by board_no desc, reg_date desc",
            new RowMapper<Board>() {
                @Override
                public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Board board = new Board();
                    board.setBoardNo(rs.getInt("board_no"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    board.setWriter(rs.getString("writer"));
                    board.setRegDate(rs.getDate("reg_date"));
                    return board;
                }
            });
        return results;
    }

    public Board read(Integer boardNo) throws Exception {
        List<Board> results = jdbcTemplate.query(
            "select board_no, title, content, writer, reg_date from board where board_no = ?",
            new RowMapper<Board>() {
                @Override
                public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Board board = new Board();
                    board.setBoardNo(rs.getInt("board_no"));
                    board.setTitle(rs.getString("title"));
                    board.setWriter(rs.getString("writer"));
                    board.setContent(rs.getString("content"));
                    board.setRegDate(rs.getDate("reg_date"));
                    return board;
                }
            }, boardNo
        );
        return results.isEmpty() ? null : results.get(0);
    }

    public void remove(Integer boardNo) throws Exception {
        String query = "delete from board where board_no = ?";
        jdbcTemplate.update(query, boardNo);
    }

    public void modify(Board board) throws Exception {
        String query = "update board set title = ?, content = ? where board_no = ?";
        jdbcTemplate.update(
                query, board.getTitle(),
                board.getContent(), board.getBoardNo()
        );
    }
}
