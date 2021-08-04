package com.koreait.nemorecipe.model.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.nemorecipe.domain.Member;
import com.koreait.nemorecipe.exception.MemberExistException;
import com.koreait.nemorecipe.model.repository.member.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public Member login(Member member) throws MemberExistException{
		return memberDAO.login(member);
	}

	@Override
	public void regist(Member member) {
		memberDAO.regist(member);
	}

	@Override
	public void update(Member member) {
		memberDAO.update(member);
		
	}

	@Override
	public void delete(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
