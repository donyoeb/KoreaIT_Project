<%@page import="com.koreait.nemorecipe.domain.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Member member = (Member)session.getAttribute("member");
%>
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
<script>
function updated(){  
      $("#nick").load(window.location.href + "#nick");
}
</script>
</head>
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
						href="/client/list" onclick=""> Recipe </a></li>
					<!-- Ranking -->
					<li class="nav-item"><a class="nav-link"
						href="/client/ranking" onclick=""> Ranking </a></li>
					<!-- MyPage -->
					<li class="nav-item"><a class="nav-link"
						href="javascript:void(0)" onclick=""> MyPage </a></li>
						
					<!-- 구분선 -->
					<li><a> || </a></li>
					<%if(member!=null){ %>
					<!-- 로그인 했을 때 -->
					<% %>
					<li class="nav-item"><a class="nav-link"
						href="/client/updateform" id="nick" style="color: orange;"> <%=member.getUser_nickname() %> 님 </a></li>
					<li class="nav-item"><a class="nav-link"
						href="/client/logout"> Logout </a></li>
					<%}else{ %>	
					<!-- 로그인 아직 안했을 때 -->
					<li class="nav-item"><a class="nav-link"
						href="/client/loginform"> Login </a></li>
					<%} %>
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