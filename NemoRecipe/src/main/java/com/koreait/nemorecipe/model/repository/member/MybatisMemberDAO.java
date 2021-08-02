package com.koreait.nemorecipe.model.repository.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.nemorecipe.domain.Member;
import com.koreait.nemorecipe.exception.MemberExistException;

@Repository
public class MybatisMemberDAO implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Member login(Member member) throws MemberExistException{
		Member obj = sqlSessionTemplate.selectOne("Member.login", member);
		if(obj==null) {
			throw new MemberExistException("관리자 정보가 올바르지 않습니다");
		}
		return obj;
	}

	@Override
	public void regist(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		
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
