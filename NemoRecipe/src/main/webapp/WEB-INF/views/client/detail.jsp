<%@page import="com.koreait.nemorecipe.domain.Recipe"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Recipe recipe = (Recipe)request.getAttribute("recipe");
%>
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
						<img src="/resources/client/assets/img/list/like.png" style="float: right; width: 100px; height: 100px; cursor: pointer;">
					</div>
					<div>
						<h4>조회 수 : <%=recipe.getRecipe_hit() %> / 좋아요 수 : <%=recipe.getRecipe_like() %></h4>
					</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<!-- 이미지 -->
					<div class="title_section" >요리 사진</div>
					<div class="space-50"></div> <!-- 페이지 공백 -->
					<div class="detail_section">
					<div style="width: 600px; height:400px; margin: auto;">
						<%if(recipe.getRecipe_img().equals("none")){ %>
			        	<img src="/resources/client/assets/img/noimage.jpg" alt="Rounded Image" class="rounded img-fluid" style="width: 100%; height: 100%">
			        	<%}else{ %>
			          	<img src="/resources/data/<%=recipe.getRecipe_img() %>" alt="Rounded Image" class="rounded img-fluid" style="width: 100%; height: 100%">
			          	<%} %>
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
								<input type="text" name="category" value="<%=recipe.getLevel() %>" style="border: none;" readonly/>
							</div>
							<div class="button_area">
								<div class="detail_category" style="background-image: url('/resources/client/assets/img/detail/cook_time.png');"></div>
								<input type="text" name="category" value="<%=recipe.getTime() %>" style="border: none;" readonly/>
							</div>
							<div class="button_area">
								<div class="detail_category" style="background-image: url('/resources/client/assets/img/detail/cook_level.png');"></div>
								<input type="text" name="category" value="<%=recipe.getServing() %>" style="border: none;" readonly/>
							</div>
						</div>
					</div>
					<!-- 인분, 시간, 난이도 끝 -->
					
					<div class="space-50"></div> <!-- 페이지 공백 -->
					
					
					<!-- 재료 -->
					<div class="title_section" >요리 재료</div>
					
					<div class="space-50"></div> <!-- 페이지 공백 -->
					
					<%
						String str = recipe.getRecipe_ingredient();
						String[] arr_recipe_ing = str.split(",");
					%>
					<div class="detail_section">
						<%for(int i=0;i<arr_recipe_ing.length;i++){ %>
						<div class="detail_ingredient" style="border-bottom-color: gray; border-bottom-style: solid; border-width: thin; text-align: center;">
							<input style="text-align: left; border: none; width: 500px;" name="recipe_ingredient" type="text" value="<%=arr_recipe_ing[i++] %>" readonly/>
							<input style="text-align: right;border: none; width: auto;"	name="recipe_in redient" type="text" value="<%=arr_recipe_ing[i] %>" readonly/>
						</div>
						<%} %>
						
					</div>
					<!-- 재료 끝 -->
					
					<div class="space-50"></div> <!-- 페이지 공백 -->
					
					<!-- 요리 순서 -->
					<div class="title_section" >요리 순서</div>
					
					<div class="space-50"></div> <!-- 페이지 공백 -->
					
					<%
						String order = recipe.getRecipe_order().replace("\r\n", "<br>"); 
					%>
					<div class="">
						<div style="width: 100%; height:auto; margin: auto; border: solid 2px black; padding: 40px 30px;">
							<span><%=order %></span>
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
	
	<!-- Footer -->
    <%@ include file="inc/footer.jsp" %>
    <!-- Footer End -->
	
	
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