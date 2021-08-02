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



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	$(function(){
		$("button[name='registbutton']").click(function(){
				registbt();
		})
	});
	
	function registbt(){
		//서버에 등록요청
		$("form").attr({
				"action":"/client/regist_recipe",
				"method":"post"
		});
		$("form").submit();
	}

</script>

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
	<div class="page-header header-filter clear-filter purple-filter"
		data-parallax="true" style="background-color: white;">
		<!-- NEMO LOGO TITLE -->
		<div class="logo_face"></div>
		<div class="logo_title"></div>
	</div>


	<form>
	<!-- 메인 div -->
	<div class="main main-raised">
		<div class="section section-basic">
			<div class="container">
				<!-- Title -->
				<div>
					<label style="font-size: 30px; font-weight: bold;">레시피 등록</a>
				</div>
				<!-- 요리 사진 등록 -->
				<div class="regist_recipe">
					<label style="text-align: left;">요리 사진 등록</label>
					<div style="text-align: right;">
					<input 
						type="button" class="recipe_content" value="사진 업로드" onclick="" />
					</div>
				</div>
				<!-- 레시피 제목 -->
				<div class="regist_recipe">
					<label style="text-align: left;">레시피 제목</label>
					<div style="text-align: right;">
					<input name="recipe_name" type="text"
						placeholder="예) 갈비탕 끓이기" onclick="" />
					
					</div>
				</div>
				<!-- 요리소개 -->
				<div class="regist_recipe">
					<label style="text-align: left;">요리소개</label>
					<div style="text-align: right;">
						<textarea rows="5" cols="50"></textarea>
					</div>
				</div>
				<!-- 카테고리 -->
				<div class="regist_recipe">
					<label style="text-align: left;">카테고리</label>
					<div style="text-align: right;">
						<select style="width: 100px;">
							<option value="0" name="type_id">종류별</option>
							<option value="1"></option>
							<option value="2"></option>
						</select> <select style="width: 100px;">
							<option value="0" name="situation_id">상황별</option>
							<option value="1"></option>
							<option value="2"></option>
						</select> <select style="width: 100px;">
							<option value="0" name="method_id">방법별</option>
							<option value="1"></option>
							<option value="2"></option>
						</select> <select style="width: 100px;">
							<option value="0" name="ingredient_id">재료별</option>
							<option value="1"></option>
							<option value="2"></option>
						</select>
					</div>
				</div>
				<!-- 요리정보 -->
				<div class="regist_recipe">
					<label style="text-align: left;">요리정보</label>
					<div>
						<div style="text-align: right;">
							<label style="text-align: left; width: 100px;">몇 인분</label>
							<label style="text-align: left; width: 100px;">조리시간</label>
							<label style="text-align: left; width: 100px;">난이도</label>
						</div>
						<div style="text-align: right;">
							<select style="width: 100px" name="serving">
								<option value="0">1인분</option>
								<option value="1"></option>
								<option value="2"></option>
							</select>
							<select style="width: 100px" name="time_id">
								<option value="0">1시간</option>
								<option value="1"></option>
								<option value="2"></option>
							</select> <select style="width: 100px;" name="level_id">
								<option value="0">A</option>
								<option value="1"></option>
								<option value="2"></option>
							</select>
						</div>
					</div>
				</div>
				<!-- 재료 -->
				<div class="regist_recipe">
					<label style="text-align: left;">재료</label>
					<div>
						<div style="text-align: right;">
							<label style="text-align: left; width: 350px;">* 재료가 남지 않도록 정확하게 작성해주세요.</label>
						</div>
						<div style="text-align: right;">
							<input name="recipe_ingredient" type="text" placeholder="예) 소스 / 재료" onclick="" />
							<input name="recipe_ingredient" type="text" placeholder="예) 간장 / 소고기" onclick="" />
							<input name="recipe_ingredient" type="text" placeholder="예) 3큰술 / 600g" onclick="" />
							<input type="button" onclick="" value="+"></>
							<input type="button" onclick="" value="-"/>
						</div>
					</div>
				</div>
				<!-- 요리순서 -->
				<div class="regist_recipe">
					<label style="text-align: left;">요리순서</label>
					<div style="text-align: right;">
						<textarea name="recipe_order" rows="5" cols="50"></textarea>
					</div>
				</div>
				<!-- 내용 끝 -->
			</div>
			<button name="registbutton" class="regist_button">글쓰기 등록</button>
		</div>
	</div>

	</form>
	
	
	<!-- 하단부 내용 -->
	<div class="title"></div>
	</div>
	


	<!--  End Modal -->
	<footer class="footer" data-background-color="black">
		<div class="container">
			<nav class="float-left">
				<ul>
					<li><a href="https://www.creative-tim.com/"> Creative Tim
					</a></li>
					<li><a href="https://www.creative-tim.com/presentation">
							About Us </a></li>
					<li><a href="https://www.creative-tim.com/blog"> Blog </a></li>
					<li><a href="https://www.creative-tim.com/license">
							Licenses </a></li>
				</ul>
			</nav>
			<div class="copyright float-right">
				&copy;
				<script>
					document.write(new Date().getFullYear())
				</script>
				, made with <i class="material-icons">favorite</i> by <a
					href="https://www.creative-tim.com/" target="_blank">NemoForU</a>
				for a better web.
			</div>
		</div>
	</footer>
	<!--   Core JS Files   -->
	<script src="/resources/client/assets/js/core/jquery.min.js"
		type="text/javascript"></script>
	<script src="/resources/client/assets/js/core/popper.min.js"
		type="text/javascript"></script>
	<script
		src="/resources/client/assets/js/core/bootstrap-material-design.min.js"
		type="text/javascript"></script>
	<script src="/resources/client/assets/js/plugins/moment.min.js"></script>
	<!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
	<script
		src="/resources/client/assets/js/plugins/bootstrap-datetimepicker.js"
		type="text/javascript"></script>
	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script src="/resources/client/assets/js/plugins/nouislider.min.js"
		type="text/javascript"></script>
	<!--  Google Maps Plugin    -->
	<!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
	<script src="/resources/client/assets/js/material-kit.js?v=2.0.7"
		type="text/javascript"></script>
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
					scrollTop : $('.section-download').offset().top
				}, 1000);
			}
		}
	</script>
</body>

</html>