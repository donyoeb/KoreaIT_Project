package com.koreait.nemorecipe.controller.client;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.nemorecipe.domain.Checking;
import com.koreait.nemorecipe.domain.Member;
import com.koreait.nemorecipe.domain.Recipe;
import com.koreait.nemorecipe.exception.MemberExistException;
import com.koreait.nemorecipe.model.common.file.FileManager;
import com.koreait.nemorecipe.model.service.member.MemberService;
import com.koreait.nemorecipe.model.service.recipe.RecipeService;

@Controller
public class ClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private FileManager fileManager;
	
	Member obj;
	
	//메인화면 요청처리
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainForm(Model model, HttpServletRequest request) {
		//3단계: 일 시키기
		List recipeList = recipeService.selectAllHit();
		
		//4단계: 결과 저장
		model.addAttribute("recipeList", recipeList);
		
		return "client/main";
	}
	
	//글 목록 요청처리
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) {
		//3단계: 일 시키기
		List recipeList = recipeService.selectAll();
		
		//4단계: 결과 저장
		model.addAttribute("recipeList", recipeList);
		
		return "client/recipe_list";
	}
	
	//글 목록 좋아요순 처리
	@RequestMapping(value="/listLike", method=RequestMethod.GET)
	public String listLike(Model model, HttpServletRequest request) {
		//3단계: 일 시키기
		List recipeList = recipeService.selectAllLike();
		
		//4단계: 결과 저장
		model.addAttribute("recipeList", recipeList);
		
		return "client/recipe_list";
	}
	
	//글 목록 조회수순 처리
	@RequestMapping(value="/listHit", method=RequestMethod.GET)
	public String listHit(Model model, HttpServletRequest request) {
		//3단계: 일 시키기
		List recipeList = recipeService.selectAllHit();
		
		//4단계: 결과 저장
		model.addAttribute("recipeList", recipeList);
		
		return "client/recipe_list";
	}
	
	//검색 요청 처리
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(String word, Model model, HttpServletRequest request) {
		//3단계: 일 시키기
		List recipeList = recipeService.search(word);
		
		logger.info("word는 {} ", word);
		logger.info("recipeList는 {} ", recipeList);
		
		//4단계: 결과 저장
		model.addAttribute("recipeList", recipeList);
		
		return "client/recipe_list";
	}
	
	
	//글작성화면 요청처리
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String registForm(HttpServletRequest request) {
		return "client/regist";
	}
	
	//글 상세화면 요청처리
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detailForm(int recipe_id, HttpServletRequest request, Model model) {
		//3단계: 일 시키기
		Recipe recipe = recipeService.select(recipe_id); //레시피 1개 조회
		recipeService.addHit(recipe_id);
		
		//4단계: 결과 저장
		model.addAttribute("recipe", recipe);
		
		return "client/detail";
	}
	
	//좋아요 여부 체크
  	@GetMapping("/checkLike")
  	public String checkLike(Checking checking, HttpServletRequest request) {
  		//3단계: 일 시키기
  		Member member = ((Member)request.getSession().getAttribute("member")); //Member 설정
  		checking.setMember_id(member.getMember_id()); //member_id 설정
  		
  		logger.info("memeber_id는 {} ", checking.getMember_id());
  		logger.info("recipe_id는 {} ", checking.getRecipe_id());
  		
  		Checking result = recipeService.checkLike(checking);
  		
  		logger.info("result는 {} ", result);
  		
  		return "client/list";
  	}
	
	//랭킹 화면 조회수순 요청처리
	@RequestMapping(value="/ranking_hit", method=RequestMethod.GET)
	public String rankingForm_look(Model model , HttpServletRequest request) {
		
		List recipeList = recipeService.selectAllHit();
		model.addAttribute("recipeList", recipeList);
		
		return "client/ranking_hit";
	}
	
	//랭킹 화면 좋아요순 요청처리
	@RequestMapping(value="/ranking_like", method=RequestMethod.GET)
	public String rankingForm_like(Model model , HttpServletRequest request) {
		
		List recipeList = recipeService.selectAllLike();
		model.addAttribute("recipeList", recipeList);
		
		return "client/ranking_like";
	}
	
	//회원가입 폼 요청처리
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signin(HttpServletRequest request) {
		return "client/signin";
	}
	
	//회원정보수정 폼 요청처리
	@RequestMapping(value="/updateform", method=RequestMethod.GET)
	public String updateform(HttpServletRequest request) {
		return "client/updateform";
	}
		
	//회원정보수정 요청 처리
	@PostMapping("/update")
	public String update(Member member, HttpServletRequest request) {
		//3단계: 일 시키기
		memberService.update(member);
		
		//4단계: 결과 저장
		HttpSession session = request.getSession();
		session.setAttribute("member", null); //request가 아닌 session에 저장함
		
		return "redirect:/client/loginform";
	}
	
	//로그인 폼 요청처리
	@RequestMapping(value="/loginform", method=RequestMethod.GET)
	public String loginform(HttpServletRequest request) {
		return "client/loginform";
	}
	
	//마이페이지 요청처리
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypageForm(Member member ,HttpServletRequest request,Model model) {
		
		List recipeList = recipeService.selectAllMy(member.getMember_id());
		
		logger.info("recipeList는 {} ", recipeList);
		
		model.addAttribute("recipeList", recipeList);

		return "client/mypage";
	}
	
	//로그인 요청처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Member member, HttpServletRequest request) {
		logger.info("아이디는 {} ",member.getUser_id());
		logger.info("비밀번호는 {} ",member.getUser_pass());
		
		//3단계: 일 시키기
		obj = memberService.login(member);
		logger.info("닉네임은 {} ",obj.getUser_nickname());
		
		//4단계: 결과 저장
		HttpSession session = request.getSession();
		session.setAttribute("member", obj); //request가 아닌 session에 저장함
		
		return "redirect:/client/main";
	}
	
	//로그아웃 요청처리
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		//3단계: 일 시키기
		
		//4단계: 결과 저장
		HttpSession session = request.getSession();
		session.setAttribute("member", null); //request가 아닌 session에 저장함
		
		return "redirect:/client/main";
	}
	
	//회원가입 요청 처리
	@PostMapping("/signup")
	public String singup(Member member, HttpServletRequest request) {
		//3단계: 일 시키기
		memberService.regist(member);
		
		return "redirect:/client/loginform";
	}
	
	//레시피 등록
    @RequestMapping(value = "/regist_recipe", method = RequestMethod.POST)
    public String registRecipe(Recipe recipe, HttpServletRequest request) {

        recipe.setMember_id(obj.getMember_id()); //멤버 id 넣기(포린키)
        
        String filename;

        MultipartFile photo=recipe.getPhoto();

        if(photo.isEmpty()) {
        	filename = "none";
        }else {
        	ServletContext context = request.getServletContext();
        	long time=System.currentTimeMillis();
        	filename=time+"."+fileManager.getExt(photo.getOriginalFilename());
        	fileManager.saveFile(context, filename , photo);
        }
        
        recipe.setRecipe_img(filename); //insert 직전에 파일명 결정짓기

        recipeService.regist(recipe);

        return "redirect:/client/list";
    }
    
	
}
