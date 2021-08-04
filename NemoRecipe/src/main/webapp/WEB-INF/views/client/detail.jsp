<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>
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
<link href="/resources/client/assets/css/material-kit.css"
	rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="/resources/client/assets/demo/demo.css" rel="stylesheet" />


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>



<script>
/* text area 자동 높이 설정 */



	$(function() {
		CKEDITOR.replace("content");

		//버튼에 이벤트 연결하기 
		$("#bt_edit").click(function() {
			if (confirm("수정하시겠어요?")) {
				edit();
			}
		});
		$("#bt_del").click(function() {
			if (confirm("삭제하시겠어요?")) {
				del()
			}
		});
		$("#bt_list").click(function() {
			location.href = "/board/list";
		});
	});
	function del() {
		$("form").attr({
			"action" : "/board/del",
			"method" : "post"
		});
		$("form").submit();
	}
	function edit() {
		$("form").attr({
			"action" : "/board/update",
			"method" : "post"
		});
		$("form").submit();
	}
</script>

</head>

<body class="index-page sidebar-collapse">

	<!-- navi -->
	<%@ include file="inc/top_navi.jsp"%>
	<!-- navi -->
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
					<div class="detail_section">
						<input type="text" style="font-size: 30px; font-weight: bold; border: none;" value="레시피 등록" readonly/>
					</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<!-- 이미지 -->
					<div class="title_section" >요리 사진</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<div class="detail_section">
					<div style="width: 400px; height:400px; margin: auto;">
						<img class="detail_img" src="">
					</div>
					</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					
					
					<!-- 인분, 시간, 난이도 -->
					<div class="title_section" >요리 정보</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<div class="detail_section">
					<div style="width: 600px; height:100px; margin: auto;">
					<div class="button_area">
						<div class="detail_category" style="background-image: url('/resources/client/assets/img/detail/cook_for.png');"></div>
						<input type="text" name="category" value="인분" style="border: none;" readonly/>
					</div>
					<div class="button_area">
						<div class="detail_category" style="background-image: url('/resources/client/assets/img/detail/cook_time.png');"></div>
						<input type="text" name="category" value="조리시간" style="border: none;" readonly/>
					</div>
					<div class="button_area">
						<div class="detail_category" style="background-image: url('/resources/client/assets/img/detail/cook_level.png');"></div>
						<input type="text" name="category" value="난이도" style="border: none;" readonly/>
					</div>
					</div>
					</div>
					<!-- 인분, 시간, 난이도 끝 -->
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<!-- 재료 -->
					<div class="title_section" >요리 재료</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<div class="detail_section">
						<div class="detail_ingredient" style="border-bottom-color: gray; border-bottom-style: solid; border-width: thin;">
							<input style="text-align: left; border: none; width: 500px;" name="recipe_ingredient" type="text" value="재료 이름" readonly/>
							<input style="text-align: right;border: none; width: auto;"	name="recipe_in redient" type="text" value="재료 무게" readonly/>
						</div>
						<div class="detail_ingredient" style="border-bottom-color: gray; border-bottom-style: solid; border-width: thin;">
							<input style="text-align: left; border: none; width: 500px;" name="recipe_ingredient" type="text" value="재료 이름" readonly/>
							<input style="text-align: right;border: none; width: auto;"	name="recipe_in redient" type="text" value="재료 무게" readonly/>
						</div>
					</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<!-- 요리 순서 -->
					<div class="title_section" >요리 순서</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<div class="detail_section">
						<div style="width: 800px; height:auto; margin: auto;">
							<textarea class="recipe_order" name="recipe_order" rows="50" readonly="readonly">
							
							</textarea>
							<span>
							
							</span>
						</div>
					</div>
					
					<!-- 내용 끝 -->
				</div>
				<div class="space-50"></div> <!-- 페이지 공백 -->
				<div class="space-50"></div> <!-- 페이지 공백 -->
				<div class="detail_section">
					<div class="button_area">
						<input class="pretty_button" type="button" value="수정" id="bt_edit">
						<input	class="pretty_button" type="button" value="삭제" id="bt_del">
						<input	class="pretty_button" type="button" value="목록" id="bt_list">
					</div>
				</div>
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


	<!-- 등록폼 관련 시작-->
	<!-- jQuery -->
	<script src="/resources/client/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="/resources/client/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- bs-custom-file-input -->
	<script
		src="/resources/client/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
	<!-- AdminLTE App -->
	<script src="/resources/client/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="/resources/client/dist/js/demo.js"></script>


</body>

</html>