<%@ page contentType="text/html;charset=UTF-8"%>
<!--
=========================================================
Material Kit - v2.0.7
=========================================================

Product Page: https://www.creative-tim.com/product/material-kit
Copyright 2020 Creative Tim (https://www.creative-tim.com/)

Coded by Creative Tim

=========================================================

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. -->
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="/resources/client/assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="/resources/client/assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Nemo Recipe
  </title>
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="/resources/client/assets/css/material-kit.css" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="/resources/client/assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="index-page sidebar-collapse">

<!-- 상단 네비게이션 바 -->
	<nav
		class="navbar navbar-transparent navbar-color-on-scroll fixed-top navbar-expand-lg"
		color-on-scroll="100" id="sectionsNav">
		<div class="container">
			<div class="navbar-translate">

				<!-- 좌상단 제목 -->
				<a class="navbar-brand" href="/client/main">Nemo Recipe </a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="sr-only">Toggle navigation</span> <span
						class="navbar-toggler-icon"></span> <span
						class="navbar-toggler-icon"></span> <span
						class="navbar-toggler-icon"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav ml-auto">
					<!-- Home -->
					<li class="nav-item"><a class="nav-link"
						href="/client/main" onclick=""> Home </a></li>
					<!-- Recipe -->
					<li class="nav-item"><a class="nav-link"
						href="javascript:void(0)" onclick=""> Recipe </a></li>
					<!-- Ranking -->
					<li class="nav-item"><a class="nav-link"
						href="/client/ranking" onclick=""> Ranking </a></li>
					<!-- MyPage -->
					<li class="nav-item"><a class="nav-link"
						href="javascript:void(0)" onclick=""> MyPage </a></li>
					<!-- 구분선 -->
					<li><a> || </a></li>
					<!-- 로그인 연결 -->
					<li class="nav-item"><a class="nav-link"
						href="/client/loginform"> Login </a></li>
					<!-- 구분선 -->
					<li><a> || </a></li>
					<!-- 트위터 연결 -->
					<li class="nav-item"><a class="nav-link" rel="tooltip"
						title="" data-placement="bottom"
						href="https://twitter.com/CreativeTim" target="_blank"
						data-original-title="Follow us on Twitter" rel="nofollow"> <i
							class="fa fa-twitter"></i>
					</a></li>
					<!-- 페이스북 연결 -->
					<li class="nav-item"><a class="nav-link" rel="tooltip"
						title="" data-placement="bottom"
						href="https://www.facebook.com/CreativeTim" target="_blank"
						data-original-title="Like us on Facebook" rel="nofollow"> <i
							class="fa fa-facebook-square"></i>
					</a></li>
					<!-- 인스타그램 연결 -->
					<li class="nav-item"><a class="nav-link" rel="tooltip"
						title="" data-placement="bottom"
						href="https://www.instagram.com/CreativeTimOfficial"
						target="_blank" data-original-title="Follow us on Instagram"
						rel="nofollow"> <i class="fa fa-instagram"></i>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- 상단 네비게이션 바 끝 -->
  
  <!-- 상단 최초 이미지 메인 -->
  <div class="page-header header-filter clear-filter purple-filter"
		data-parallax="true" style="background-color: white;">
	<!-- NEMO LOGO TITLE -->
	<div class="logo_face"></div>
	<div class="logo_title"></div>
  </div>
  
  <!-- 상단 최초 이미지 메인 End -->
  
  <!-- 메인 전체 -->
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
    
    <!-- 슬라이드 View -->
    <div class="section" id="carousel">
      <div class="container">
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
                    <img class="d-block w-100" src="/resources/client/assets/img/bg2.jpg" alt="First slide">
                    <div class="carousel-caption d-none d-md-block">
                      <h4>
                        <i class="material-icons">location_on</i>
                        Yellowstone National Park, United States
                      </h4>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="/resources/client/assets/img/bg3.jpg" alt="Second slide">
                    <div class="carousel-caption d-none d-md-block">
                      <h4>
                        <i class="material-icons">location_on</i>
                        Somewhere Beyond, United States
                      </h4>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="/resources/client/assets/img/bg.jpg" alt="Third slide">
                    <div class="carousel-caption d-none d-md-block">
                      <h4>
                        <i class="material-icons">location_on</i>
                        Yellowstone National Park, United States
                      </h4>
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
	        <button class="btn btn-success"  style="float: right; margin-top: 30px;">더보기</button>
	      </div>
	      <!-- 중간 제목 End -->
	      <br>
	      <hr style="border: 1px solid grey;"> <!-- 수평선 -->
	      <br><br><br>
	      <!-- 아이템 전체 -->
	      <div class="row" style="position: relative;">
	        
	        <!-- 아이템 -->
	        <div style="width: 200px; height: 200px; float: left; margin: 0px 2.5rem; margin-left: 3rem;">
	          <img src="/resources/client/assets/img/faces/avatar.jpg" alt="Rounded Image" class="rounded img-fluid">
	          <h4 class="title" style="text-align: center;">음식 제목</h4>
	          <h6>음식 설명</h6>
	          <h6 style="text-align: right; color: #00bcd4">닉네임/수정날짜</h6>
	        </div>
	        
	        <div style="width: 200px; height: 200px; float: left; margin: 0px 2.5rem;">
	          <img src="/resources/client/assets/img/faces/avatar.jpg" alt="Rounded Image" class="rounded img-fluid">
	          <h4 class="title" style="text-align: center;">음식 제목</h4>
	          <h6>음식 설명</h6>
	          <h6 style="text-align: right; color: #00bcd4">닉네임/수정날짜</h6>
	        </div>
	        
	        <div style="width: 200px; height: 200px; float: left; margin: 0px 2.5rem;">
	          <img src="/resources/client/assets/img/faces/avatar.jpg" alt="Rounded Image" class="rounded img-fluid">
	          <h4 class="title" style="text-align: center;">음식 제목</h4>
	          <h6>음식 설명</h6>
	          <h6 style="text-align: right; color: #00bcd4">닉네임/수정날짜</h6>
	        </div>
	        
	        <div style="width: 200px; height: 200px; float: left; margin: 0px 2.5rem;">
	          <img src="/resources/client/assets/img/faces/avatar.jpg" alt="Rounded Image" class="rounded img-fluid">
	          <h4 class="title" style="text-align: center;">음식 제목</h4>
	          <h6>음식 설명</h6>
	          <h6 style="text-align: right; color: #00bcd4">닉네임/수정날짜</h6>
	        </div>
	      </div>
	      <!-- 아이템 전체 End -->
	    </div>
	  </div>
	</div>
	<!-- 인기 레시피 View End -->
	
	<div class="space-50"></div> <!-- 페이지 공백 -->
	<div class="space-50"></div> <!-- 페이지 공백 -->
	
	<!-- 인기 레시피 View -->
    <div class="section">
      <div class="container tim-container">
	    <div id="images">
	      <!-- 중간 제목 -->
	      <div class="title" style="position: relative;">
	        <h2 style="float: left;">Nemo Recipe의 인기 레시피</h2>
	        <button class="btn btn-success"  style="float: right; margin-top: 30px;">더보기</button>
	      </div>
	      <!-- 중간 제목 End -->
	      <br>
	      <hr style="border: 1px solid grey;"> <!-- 수평선 -->
	      <br><br><br>
	      <!-- 아이템 전체 -->
	      <div class="row" style="position: relative;">
	        
	        <!-- 아이템 -->
	        <div style="width: 200px; height: 200px; float: left; margin: 0px 2.5rem; margin-left: 3rem;">
	          <img src="/resources/client/assets/img/faces/avatar.jpg" alt="Rounded Image" class="rounded img-fluid">
	          <h4 class="title" style="text-align: center;">음식 제목</h4>
	          <h6>음식 설명</h6>
	          <h6 style="text-align: right; color: #00bcd4">닉네임/수정날짜</h6>
	        </div>
	        
	        <div style="width: 200px; height: 200px; float: left; margin: 0px 2.5rem;">
	          <img src="/resources/client/assets/img/faces/avatar.jpg" alt="Rounded Image" class="rounded img-fluid">
	          <h4 class="title" style="text-align: center;">음식 제목</h4>
	          <h6>음식 설명</h6>
	          <h6 style="text-align: right; color: #00bcd4">닉네임/수정날짜</h6>
	        </div>
	        
	        <div style="width: 200px; height: 200px; float: left; margin: 0px 2.5rem;">
	          <img src="/resources/client/assets/img/faces/avatar.jpg" alt="Rounded Image" class="rounded img-fluid">
	          <h4 class="title" style="text-align: center;">음식 제목</h4>
	          <h6>음식 설명</h6>
	          <h6 style="text-align: right; color: #00bcd4">닉네임/수정날짜</h6>
	        </div>
	        
	        <div style="width: 200px; height: 200px; float: left; margin: 0px 2.5rem;">
	          <img src="/resources/client/assets/img/faces/avatar.jpg" alt="Rounded Image" class="rounded img-fluid">
	          <h4 class="title" style="text-align: center;">음식 제목</h4>
	          <h6>음식 설명</h6>
	          <h6 style="text-align: right; color: #00bcd4">닉네임/수정날짜</h6>
	        </div>
	      </div>
	      <!-- 아이템 전체 End -->
	    </div>
	  </div>
	</div>
	<!-- 인기 레시피 View End -->
	
	<div class="space-50"></div> <!-- 페이지 공백 -->
	<div class="space-50"></div> <!-- 페이지 공백 -->
    
    <!-- 마지막 SNS 참조 -->
    <div class="section section-download" id="downloadSection">
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
    </div>
    <!-- 마지막 SNS 참조 End -->
    
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