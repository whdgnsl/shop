package com.tyranitar.admin.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyranitar.member.dto.MemberDTO;

@Repository("adMemberDAO")
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MemberDTO> memberList()throws Exception {
		
		List<MemberDTO> list = sqlSession.selectList("adMember.memberList");
		
		return list;
	}

	@Override
	public MemberDTO memberOne(int members_no) throws Exception {
		MemberDTO memberDTO = sqlSession.selectOne("adMember.memberOne", members_no);
		return memberDTO;
	}

	@Override
	public void memberMdDone(MemberDTO memberDTO) throws Exception {
		sqlSession.update("adMember.memberUpdate", memberDTO);
		
	}
}
