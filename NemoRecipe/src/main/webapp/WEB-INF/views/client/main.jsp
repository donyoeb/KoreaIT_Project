<%@page import="com.koreait.nemorecipe.domain.Recipe"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Recipe> recipeList = (List)request.getAttribute("recipeList");
%>
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
<!-- CSS Files -->
<link href="/resources/client/assets/css/material-kit.css" rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="/resources/client/assets/demo/demo.css" rel="stylesheet" />
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
function search(){
	var word = $('#exampleInput1').val();
	location.href="/client/search?word="+word;
}
</script>

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
	       	<div style="background-image: url('/resources/client/assets/img/nemo_logo/nemo_logo_title.png'); background-size: 200px; width: 200px; height: 200px; float: left; margin-top: -50px;"></div>
	        <div class="form-group" style="width: 68%; float: left; margin-left: 10px;">
	          <label for="exampleInput1" class="bmd-label-floating">원하는 레시피를 입력해주세요</label>
	          <form>
	          	<input type="text" class="form-control" id="exampleInput1">
	          </form>
	          <span class="bmd-help">네가 좋아할만한 모든 레시피!!</span>
	        </div>
	        <button class="btn btn-primary btn-round" style="margin-left: 20px; margin-top: 15px;" onclick="search();">Search</button>
	      </div>
        </div>
        <!--                 end inputs -->
        
      </div>
    </div>
    <!-- 메인 검색 창 End -->  
    
    <!-- 슬라이드 View -->
    <div class="section" id="carousel">
      <div class="" style="width: 1300px; height: 100%; margin-left: auto; margin-right: auto;">
        <div class="row">
          <div class="col-md-8 mr-auto ml-auto">
            <!-- Carousel Card -->
            <div class="card card-raised card-carousel">
              <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" data-interval="3000">
                <ol class="carousel-indicators">
                  <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <a href="/client/list"><img class="d-block w-100" style="height: 550px;" src="/resources/client/assets/img/cook.jpg" alt="First slide" itemref="/client/list"></a>
                    <div class="carousel-caption d-none d-md-block">
                      <h3>
                        <i class="material-icons">location_on</i>
                        당신이 좋아할만한 레시피들을 구경해보세요
                      </h3>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <a href="/client/ranking_hit"><img class="d-block w-100" style="height: 550px;" src="/resources/client/assets/img/ranking/ranking_crop.png" alt="Second slide"></a>
                    <div class="carousel-caption d-none d-md-block">
                      <h3>
                        <i class="material-icons">location_on</i>
                       	어떤 레시피가 가장 인기가 많을까요?
                      </h3>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <a href="/client/detail?recipe_id=<%=recipeList.get(0).getRecipe_id() %>"><img class="d-block w-100" style="height: 550px;" src="/resources/data/<%=recipeList.get(0).getRecipe_img() %>" alt="Third slide"></a>
                    <div class="carousel-caption d-none d-md-block">
                      <h3>
                        <i class="material-icons">location_on</i>
                        가장 인기있는 레시피!! 한 번 구경해보세요
                      </h3>
                    </div>
                  </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                  <i class="material-icons">keyboard_arrow_left</i>
                  <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                  <i class="material-icons">keyboard_arrow_right</i>
                  <span class="sr-only">Next</span>
                </a>
              </div>
            </div>
            <!-- End Carousel Card -->
          </div>
        </div>
      </div>
    </div>
    <!-- 슬라이드 View End -->
    
    <div class="space-50"></div> <!-- 페이지 공백 -->
    
    <!-- 인기 레시피 View -->
    <div class="section">
      <div class="container tim-container">
	    <div id="images">
	      <!-- 중간 제목 -->
	      <div class="title" style="position: relative;">
	        <h2 style="float: left;">Nemo Recipe의 인기 레시피</h2>
	        <button class="btn btn-success"  style="float: right; margin-top: 30px;" onClick="location.href='/client/list';">더보기</button>
	      </div>
	      <!-- 중간 제목 End -->
	      <br>
	      <hr style="border: 1px solid grey;"> <!-- 수평선 -->
	      <br><br><br>
	      <!-- 아이템 전체 -->
	      <div class="row" style="position: relative;">
	        
	        <%for(int i=0;i<4;i++){ %>
	        <!-- 아이템 -->
	        <div style="width: 200px; height: 370px; float: left; margin: 0px 2.5rem; margin-left: 2.5rem; text-align: center; cursor: pointer;"  onClick="location.href='/client/detail?recipe_id=<%=recipeList.get(i).getRecipe_id()%>';">
	          <%if(recipeList.get(i).getRecipe_img().equals("none")){ %>
        	  <img src="/resources/client/assets/img/noimage.jpg" alt="Rounded Image" class="rounded img-fluid" style="width: 200px; height: 200px">
        	  <%}else{ %>
          	  <img src="/resources/data/<%=recipeList.get(i).getRecipe_img() %>" alt="Rounded Image" class="rounded img-fluid" style="width: 200px; height: 200px">
          	  <%} %>
	          <h4 class="title" style="text-align: center;"><%=recipeList.get(i).getRecipe_name() %></h4>
	          <h6 style="text-align: right; color: #00bcd4"><%=recipeList.get(i).getMember().getUser_nickname() %> / <%=recipeList.get(i).getRecipe_date() %></h6>
	        </div>
	        <%} %>
	        
	        
	      </div>
	      <!-- 아이템 전체 End -->
	    </div>
	  </div>
	</div>
	<!-- 인기 레시피 View End -->
	
	<div class="space-50"></div> <!-- 페이지 공백 -->
	<div class="space-50"></div> <!-- 페이지 공백 -->
	
	
    
    <!-- 마지막 SNS 참조 -->
    <!-- <div class="section section-download" id="downloadSection">
      <div class="container">
        <br><br>
        <div class="sharing-area text-center">
          <div class="row justify-content-center">
            <h3>Thank you for supporting us!</h3>
          </div>
          <a id="twitter" class="btn btn-raised btn-twitter" href="https://twitter.com/CreativeTim" rel="nofollow">
            <i class="fa fa-twitter"></i>
            Tweet
          </a>
          <a id="facebook" class="btn btn-raised btn-facebook" href="https://www.facebook.com/CreativeTim" rel="nofollow">
            <i class="fa fa-facebook-square"></i>
            Facebook
          </a>
          <a id="instagram" class="btn btn-raised btn-instagram" href="https://www.instagram.com/CreativeTimOfficial" rel="nofollow">
            <i class="fa fa-instagram"></i>
            Instagram
          </a>
          <a id="github" href="https://github.com/creativetimofficial/material-kit" target="_blank" class="btn btn-raised btn-github" rel="nofollow">
            <i class="fa fa-github"></i>
            Star
          </a>
        </div>
      </div>
    </div> -->
    <!-- 마지막 SNS 참조 End -->
    
  </div>
  <!-- 메인 전체 End -->
  
  
  <!-- Footer -->
  <%@ include file="inc/footer.jsp" %>
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
  <script src="/resources/client/assets/js/material-kit.js?v=2.0.7" type="text/javascript"></script>
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