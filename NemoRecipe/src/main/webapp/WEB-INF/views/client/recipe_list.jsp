<%@page import="com.koreait.nemorecipe.domain.Recipe"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Recipe> recipeList = (List)request.getAttribute("recipeList");
%>
<%
	/* List<Board> boardList = boardDAO.selectAll(); //총 레코드수 가져오기 */
	/* int totalRecord=boardList.size();//총 게시물 수
	
	out.print(totalRecord);
	
	int pageSize=10;//총 게시물을 몇건씩 나누어서 보여줄지를 결정짓는 변수, 즉 페이지당 보여줄 레코드 수
	
	int totalPage=(int)Math.ceil((float)totalRecord/pageSize); //총 페이지 수(나머지 숨겨진 데이터를 보기위한 페이지 분할된 총 수)
	int blockSize=10;
	
	int currentPage=1;//현재 페이지
	//단, 사용자가 아래의 페이지 링크를 눌러 currentPage파라미터 값을 넘길경우엔 그 넘어온 값을 우선해야 한다!!
	if(request.getParameter("currentPage")!=null){
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	}
	int firstPage=currentPage- ((currentPage-1)%blockSize);
	int lastPage=firstPage+(blockSize-1);
	int curPos=(currentPage-1)*pageSize;//페이지당 List의 시작 index구하기
	int num=totalRecord - curPos; */
%>
<%-- <%="당신이 보고 잇는 페이지는 "+currentPage+"<br>" %> --%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="/resources/client/assets/img/apple-icon.png">
<link rel="icon" type="image/png"
	href="/resources/client/assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Nemo Recipe</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/earlyaccess/nanumpenscript.css">
<!-- CSS Files -->
<link href="/resources/client/assets/css/material-kit.css" rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="/resources/client/assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="index-page sidebar-collapse">

	  <!-- navi -->
	<%@ include file="inc/top_navi.jsp" %>
  <!-- navi -->
	<div class="page-header header-filter clear-filter purple-filter"
		data-parallax="true" style="background-color: white;">
		<!-- NEMO LOGO TITLE -->
		<div class="logo_face"></div>
		<div class="logo_title"></div>
	</div>

	<!-- 메인 div -->
  <div class="main main-raised">
  
	<!-- 메인 검색 창 -->  
  	<div class="section section-basic">
      <div class="container">
      
        <!--                 inputs -->
        <div id="inputs">
          <div style="width: 100%; position: relative; margin-top: -30px">
	       	<div style="background-image: url('/resources/client/assets/img/nemo_logo_title.png'); background-size: 200px; width: 200px; height: 200px; float: left; margin-top: -50px;"></div>
	        <div class="form-group" style="width: 68%; float: left; margin-left: 10px;">
	          <label for="exampleInput1" class="bmd-label-floating">원하는 레시피를 입력해주세요</label>
	          <input type="text" class="form-control" id="exampleInput1">
	          <span class="bmd-help">네가 좋아할만한 모든 레시피!!</span>
	        </div>
	        <button class="btn btn-primary btn-round" style="margin-left: 20px; margin-top: 15px;">Search</button>
	      </div>
        </div>
        <!--                 end inputs -->
        
      </div>
    </div>
    <!-- 메인 검색 창 End -->  
    
    <div class="space-50"></div> <!-- 페이지 공백 -->
    
    <!-- 인기 레시피 View -->
    <div class="section">
      <div class="container tim-container">
	    <div id="images">
	      <!-- 중간 제목 -->
	      <div class="title" style="position: relative;">
	        <h2 style="float: left;">Nemo Recipe</h2>
	        <!-- 좋아요 순 /조회 순 정렬 Start-->
	        <div class = "button_area">
	          <a href="" style="font: dotum;">좋아요 순</a>
	          <a>/</a>
	          <a href="">조회 순</a>
    		</div>
        	<!-- 좋아요 순 /조회 순 정렬 End -->
	      </div>
	      <!-- 중간 제목 End -->
	      <br>
	      <hr style="border: 1px solid grey;"> <!-- 수평선 -->
	      <br><br><br>
	      <!-- 아이템 전체 -->
	      <div class="row" style="position: relative;">
	        
	        <%for(Recipe recipe : recipeList){ %>
	        <!-- 아이템 -->
	        <div style="width: 200px; height: 370px; float: left; margin: 0px 2.5rem; margin-left: 2.5rem; text-align: center">
	        	<%if(recipe.getRecipe_img().equals("none")){ %>
	        	<img src="/resources/client/assets/img/noimage.jpg" alt="Rounded Image" class="rounded img-fluid" style="width: 200px; height: 200px">
	        	<%}else{ %>
	          	<img src="/resources/data/<%=recipe.getRecipe_img() %>" alt="Rounded Image" class="rounded img-fluid" style="width: 200px; height: 200px">
	          	<%} %>
	          	<h4 class="title" style="text-align: center;"><%=recipe.getRecipe_name() %></h4>
	          	<h6 style="text-align: right; color: #00bcd4"><%=member.getUser_nickname()%> / <%=recipe.getRecipe_date() %></h6>
	        </div>
	        
	        <%} %>
	        
	      </div>
	      <!-- 아이템 전체 End -->
	    </div>
	  </div>
	  <div>
	  
	  </div>
	<div class="space-50"></div> <!-- 페이지 공백 -->
	<tr>
		<td colspan="5" style="text-align:center">
		<%-- 	<a href="/board/list.jsp?currentPage=<%=firstPage-1%>">◀</a>
			<%for(int i=firstPage;i<=lastPage;i++){%>
				<%if(i>totalPage)break; //i가 총 페이지수를 넘어서면 반복문은 멈춘다 %>
				<a href="/board/list.jsp?currentPage=<%=i%>" <%if(currentPage==i){%>class="pageNum"<%}%>   >[<%=i%>]</a>
			<%}%>
			<a href="/board/list.jsp?currentPage=<%=lastPage+1%>">▶</a> --%>
		</td>
	</tr>
	<div class="space-50"></div> <!-- 페이지 공백 -->
	  	<button class="list_button" onClick="location.href='/client/regist';">글쓰기</button>
	<div class="space-50"></div> <!-- 페이지 공백 -->
	</div>
	<!-- 인기 레시피 View End -->
	
    
    
  </div>
  <!-- 메인 전체 End -->
  
  
  <!--  Footer -->
  <footer class="footer" data-background-color="black">
    <div class="container">
      <nav class="float-left">
        <ul>
          <li>
            <a href="https://www.creative-tim.com/">
              Creative Tim
            </a>
          </li>
          <li>
            <a href="https://www.creative-tim.com/presentation">
              About Us
            </a>
          </li>
          <li>
            <a href="https://www.creative-tim.com/blog">
              Blog
            </a>
          </li>
          <li>
            <a href="https://www.creative-tim.com/license">
              Licenses
            </a>
          </li>
        </ul>
      </nav>
      <div class="copyright float-right">
        &copy;
        <script>
          document.write(new Date().getFullYear())
        </script>, made with <i class="material-icons">favorite</i> by
        <a href="https://www.creative-tim.com/" target="_blank">Creative Tim</a> for a better web.
      </div>
    </div>
  </footer>
  <!-- Footer End -->
  
  <!--   Core JS Files   -->
  <script src="/resources/client/assets/js/core/jquery.min.js" type="text/javascript"></script>
  <script src="/resources/client/assets/js/core/popper.min.js" type="text/javascript"></script>
  <script src="/resources/client/assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
  <script src="/resources/client/assets/js/plugins/moment.min.js"></script>
  <!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
  <script src="/resources/client/assets/js/plugins/bootstrap-datetimepicker.js" type="text/javascript"></script>
  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="/resources/client/assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
  <!--  Google Maps Plugin    -->
  <!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
  <script src="/resources/client/assets/js/material-kit.js" type="text/javascript"></script>
  <script>
    $(document).ready(function() {
      //init DateTimePickers
      materialKit.initFormExtendedDatetimepickers();

      // Sliders Init
      materialKit.initSliders();
    });


    function scrollToDownload() {
      if ($('.section-download').length != 0) {
        $("html, body").animate({
          scrollTop: $('.section-download').offset().top
        }, 1000);
      }
    }
  </script>
</body>

</html>