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
	
	//로그인
	public MemberDTO login(MemberDTO vo) throws DataAccessException {
		MemberDTO memberDTO = (MemberDTO)sqlSession.selectOne("member.login", vo);
		return memberDTO;
	}

	//회원가입 처리
	public void joinMember(MemberDTO memberDTO) {
		sqlSession.insert("member.joinMember", memberDTO);
	}

	//아이디 중복 확인
	public int idChk(MemberDTO memberDTO) {
		int result = sqlSession.selectOne("member.idChk", memberDTO);
		return result;
	}
	
	//닉네임 중복 확인
	public int nickNameChk(MemberDTO memberDTO) {
		int result = sqlSession.selectOne("member.nickChk", memberDTO);
		return result;
	}
	
	//이메일 중복 확인
	public int emailChk(MemberDTO memberDTO) {
		int result = sqlSession.selectOne("member.emailChk", memberDTO);
		return result;
	}
	
	//마이페이지
	public MemberDTO myPage(MemberDTO vo) {
		MemberDTO myInfo = (MemberDTO) sqlSession.selectOne("member.myPage", vo);
		
		return myInfo;
	}

}
