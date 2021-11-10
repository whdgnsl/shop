package com.tyranitar.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyranitar.board.dto.BoardDTO;

@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> noticeList() {
		
		List<BoardDTO> noticeList = sqlSession.selectList("board.noticeList");
		
		return noticeList;
	}

}
