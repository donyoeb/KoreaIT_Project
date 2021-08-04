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
    NemoRecipe Sign in
  </title>
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="/resources/client/assets/css/material-kit.css?v=2.0.7" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="/resources/client/assets/demo/demo.css" rel="stylesheet" />
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("button[name='sign']").click(function(){
		signUp();
	});
});

function signUp(){
	//서버에 회원가입 요청
	$("form").attr({
		"action":"/client/signup",
		"method":"post"
	});
	$("form").submit();
}

</script>
</head>

<!-- 상단 네비게이션 바 -->
<body class="login-page sidebar-collapse">
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
  
  <!-- 회원가입 폼 배경화면(300KB 넘어가면 이미지가 나오지 않음) -->
  <div class="page-header header-filter" style="background-image: url('/resources/client/assets/img/city.jpg'); background-size: cover; background-position: top center;">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 col-md-6 ml-auto mr-auto">
          <div class="card card-login">
            
            <!-- 회원가입 카드 영역 -->
            <form class="form">
              <div class="card-header card-header-primary text-center">
                <h4 class="card-title">Sign in</h4>
                
              <!-- 회원가입 데이터 영역 -->
              </div>
              <p class="description text-center">Nemo Recipe Sign in</p>
              
              <div class="card-body" style="height: 400px;">
              
              	<!-- ID 입력 -->
                <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="material-icons">face</i>
                    </span>
                  </div>
                  <input type="text" class="form-control" placeholder="ID..." name="user_id">
                </div>
                
                <!-- Password 입력 -->
                <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="material-icons">lock_outline</i>
                    </span>
                  </div>
                  <input type="password" class="form-control" placeholder="Password..." name="user_pass">
                </div>
                
                <!-- nickname 입력 -->
                <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="material-icons">textsms</i>
                    </span>
                  </div>
                  <input type="text" class="form-control" placeholder="Nickname..." name="user_nickname">
                </div>
                
              </div>
              
              <!-- 로그인 데이터 영역 끝 -->
              
              <!-- Sign in 버튼 -->  
              <div class="footer text-center">
                <button name="sign" class="btn btn-primary btn-link btn-wd btn-lg">Sign Up</button>
              </div>
              
            </form>
            <!-- Sign in 데이터 폼 끝부분 -->
          </div>
        </div>
      </div>
    </div>
    
    
    <!-- Footer -->
    <%@ include file="inc/footer.jsp" %>
    <!-- Footer End -->
    
    
  </div>
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
</body>

</html>