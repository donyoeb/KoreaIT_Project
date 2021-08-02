package com.koreait.nemorecipe.controller.client;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.nemorecipe.domain.Member;
import com.koreait.nemorecipe.domain.Recipe;
import com.koreait.nemorecipe.exception.MemberExistException;
import com.koreait.nemorecipe.model.service.member.MemberService;
import com.koreait.nemorecipe.model.service.recipe.RecipeService;


@Controller
public class ClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private RecipeService recipeService;
	
	//메인화면 요청처리
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainForm() {
		return "client/main";
	}
	
	//글작성화면 요청처리
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String registForm() {
		return "client/regist";
	}
	
	/////////////////////////////////// 레시피등록?
	@RequestMapping(value="/regist_recipe", method=RequestMethod.POST)
	public String registRecipe(Recipe recipe) {
	
		recipe.setMember_id(1);
		recipe.setType_id(1);
		recipe.setSituation_id(1);
		recipe.setIngredient_id(1);
		recipe.setMethod_id(1);
		recipe.setTime_id(1);
		recipe.setLevel_id(1);
		
		
		
		logger.info("레시피 이름은 {} ",recipe);
		recipeService.regist(recipe);
		
		return "client/regist";
	}
	
	
	//글작성화면 요청처리
	@RequestMapping(value="/ranking", method=RequestMethod.GET)
	public String rankingForm() {
		return "client/ranking";
	}
	
	//회원가입 폼 요청처리
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signin() {
		return "client/signin";
	}
	
	//로그인 폼 요청처리
	@RequestMapping(value="/loginform", method=RequestMethod.GET)
	public String loginform() {
		return "client/loginform";
	}
	
	//로그인 요청처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		logger.info("이름은 {} ",member.getUser_id());
		
		//3단계: 일 시키기
		Member obj = memberService.login(member);
		
		//4단계: 결과 저장
		session.setAttribute("member", obj); //request가 아닌 session에 저장함
		
		return "client/main";
	}
	
	//위의 요청을 처리하는 메서드 중에서, 어느 것 하나라도 예외가 발생하면 아래의 메서드가 동작하게 됨
	@ExceptionHandler(MemberExistException.class)
	public String handleException(MemberExistException e, Model model) {
		model.addAttribute("e", e);
		
		return "error/result";
	}
	
}
