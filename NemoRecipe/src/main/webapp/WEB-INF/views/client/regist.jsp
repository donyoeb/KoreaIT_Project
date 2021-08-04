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
				"method":"post",
				"enctype":"multipart/form-data"
		});
		$("form").submit();
	}
</script>

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
<form>
	<!-- 메인 div -->
	<div class="main main-raised">
		<div class="section section-basic">
			<div class="container">
				<!-- Title -->
				<div>
					<input type="text" style="font-size: 30px; font-weight: bold; border: none;" value="레시피 등록" readonly/>
				</div>
				<div class="space-50"></div> <!-- 페이지 공백 -->
				<!-- 요리 사진 등록 -->
				<div class="regist_recipe">
					<div class="title_section" >요리 사진 등록</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<div style="text-align: right;">
					<input style="width: 610px" type="file" class="recipe_content" name="photo" />
					</div>
				</div>
				<div class="space-50"></div> <!-- 페이지 공백 -->
				<!-- 레시피 제목 -->
				<div class="regist_recipe">
					<div class="title_section" >레시피 제목</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<div style="text-align: right;">
					<input style="width: 610px" name="recipe_name" type="text"
						placeholder="예) 갈비탕 끓이기" onclick="" />
					</div>
				</div>
				<div class="space-50"></div> <!-- 페이지 공백 -->
				<!-- 요리소개 -->
				<div class="regist_recipe">
					<div class="title_section" >요리 소개</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<div style="text-align: right;">
						<textarea rows="5" style="width: 610px"></textarea>
					</div>
				</div>
				<div class="space-50"></div> <!-- 페이지 공백 -->
				<!-- 카테고리 -->
				<div class="regist_recipe">
					<div class="title_section" >카테고리</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<div style="text-align: right;">
						<select style="width: 150px;" name="type">
							<option value="종류별" >종류별</option>
							<option value="메인반찬">메인반찬</option>
							<option value="밑반찬">밑반찬</option>
							<option value="국/탕/찌개">국/탕/찌개</option>
							<option value="면/밀가루">면/밀가루</option>
							<option value="밥/죽/떡">밥/죽/떡</option>
							<option value="기타">기타</option>
						</select> <select style="width: 150px;" name="situation">
							<option value="상황별">상황별</option>
							<option value="야식">야식</option>
							<option value="간편">간편</option>
							<option value="손님접대">손님접대</option>
							<option value="술안주">술안주</option>
							<option value="다이어트">다이어트</option>
							<option value="기타">기타</option>
						</select> <select style="width: 150px;" name="method">
							<option value="방법별" >방법별</option>
							<option value="볶음">볶음</option>
							<option value="부침">부침</option>
							<option value="조림">조림</option>
							<option value="찜">찜</option>
							<option value="튀김">튀김</option>
							<option value="기타">기타</option>
						</select> <select style="width: 150px;" name="ingredient">
							<option value="재료별" >재료별</option>
							<option value="고기류">고기류</option>
							<option value="채소류">채소류</option>
							<option value="해물류">해물류</option>
							<option value="가공류">가공류</option>
							<option value="기타">기타</option>
						</select>
					</div>
				</div>
				<div class="space-50"></div> <!-- 페이지 공백 -->
				<!-- 요리정보 -->
				<div class="regist_recipe">
					<div class="title_section" >요리 정보</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<div>
						<div style="text-align: right;">
							<label style="text-align: left; width: 200px;">몇 인분</label>
							<label style="text-align: left; width: 200px;">조리시간</label>
							<label style="text-align: left; width: 200px;">난이도</label>
						</div>
						<div style="text-align: right;">
							<select style="width: 200px" name="serving">
								<option value="1인분">1인분</option>
								<option value="2~3인분">2~3인분</option>
								<option value="4~5인분">4~5인분</option>
								<option value="6~10인분">6~10인분</option>
								<option value="10인분 이상">10인분 이상</option>
							</select>
							<select style="width: 200px" name="time">
								<option value="3분 미만">3분 미만</option>
								<option value="3분~5분">3분~5분</option>
								<option value="5분~10분">5분~10분</option>
								<option value="10분~30분">10분~30분</option>
								<option value="30분~1시간">30분~1시간</option>
								<option value="1시간이상">1시간이상</option>
							</select> <select style="width: 200px;" name="level">
								<option value="상">상</option>
								<option value="중">중</option>
								<option value="하">하</option>
								<option value="누구든지">누구든지</option>
							</select>
						</div>
					</div>
				</div>
				<div class="space-50"></div> <!-- 페이지 공백 -->
				<!-- 재료 -->
				<div class="regist_recipe">
					<div class="title_section" >요리 재료</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<div>
						<div style="text-align: right;">
							<label style="text-align: left; width: 350px;">* 재료가 남지 않도록 정확하게 작성해주세요.</label>
						</div>
						<div style="text-align: right;">
							<input style="width: 275px" name="recipe_ingredient" type="text" placeholder="예) 소스 / 재료" onclick="" />
							<input style="width: 275px" name="recipe_ingredient" type="text" placeholder="예) 3큰술 / 600g" onclick="" />
							<input type="button" onclick="" value="+"></>
							<input type="button" onclick="" value="-"/>
						</div>
					</div>
				</div>
				<div class="space-50"></div> <!-- 페이지 공백 -->
				<!-- 요리순서 -->
				<div class="regist_recipe">
					<div class="title_section" >요리 순서</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<div style="text-align: right;">
						<textarea name="recipe_order" rows="5" style="width: 610px"></textarea>
					</div>
				</div>
				<div class="space-50"></div> <!-- 페이지 공백 -->
				<!-- 내용 끝 -->
			</div>
			<div class="space-50"></div> <!-- 페이지 공백 -->
			<div class="detail_section">
					<div class="button_area">
						<button class="pretty_button" name="registbutton">글 등록</button>
					</div>
				</div>
		</div>
	</div>

	</form>
	
	
	
	<!-- 하단부 내용 -->
	<div class="title"></div>
	</div>


	  <!-- footer -->
	<%@ include file="inc/footer.jsp" %>
  <!-- footer -->

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
<script src="/resources/client/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- bs-custom-file-input -->
<script src="/resources/client/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
<!-- AdminLTE App -->
<script src="/resources/client/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/resources/client/dist/js/demo.js"></script>
	
	
</body>

</html>