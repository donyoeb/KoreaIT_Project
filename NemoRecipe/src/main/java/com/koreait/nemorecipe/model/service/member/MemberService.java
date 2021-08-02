package com.koreait.nemorecipe.model.service.member;

import java.util.List;

import com.koreait.nemorecipe.domain.Member;

public interface MemberService {
		public Member login(Member member); //로그인
		public void regist(Member member); //회원가입
		public void update(Member member); //회원 수정
		public void delete(Member member); //아이디, 패스워드가 모두 일치할 때 탈퇴시킴
		public List selectAll();
}
