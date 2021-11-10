package com.tyranitar.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tyranitar.member.dto.MemberDTO;

@Repository("memberDAO")
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public MemberDTO login(Map<String, Object> memberInfo) throws DataAccessException {
		MemberDTO memberDTO = (MemberDTO)sqlSession.selectOne("member.login", memberInfo);
		return memberDTO;
	}

	public void joinMember(MemberDTO memberDTO) {
		sqlSession.insert("member.joinMember", memberDTO);
	}

	public MemberDTO myPage(MemberDTO memberDTO) {
		MemberDTO myInfo = (MemberDTO) sqlSession.selectOne("member.myPage", memberDTO);
		
		return myInfo;
	}

}
