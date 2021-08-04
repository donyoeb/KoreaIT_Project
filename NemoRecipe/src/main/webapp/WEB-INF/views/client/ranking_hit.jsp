<%@page import="com.koreait.nemorecipe.domain.Recipe"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Recipe> recipeList = (List)request.getAttribute("recipeList");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Nemo recipe 기본 head -->
<link rel="apple-touch-icon" sizes="76x76"
	href="/resources/client/assets/img/apple-icon.png">
<link rel="icon" type="image/png"
	href="/resources/client/assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Nemo Recipe</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<!-- Nemo recipe 기본 head 끝 -->

<!-- <meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport" /> -->

<!-- Canonical SEO -->
<!-- <link rel="canonical"
	href="https://www.creative-tim.com/product/fresh-bootstrap-table" />
 -->
<!--  Social tags    -->
<!-- <meta name="keywords"
	content="creative tim, html table, html css table, web table, freebie, free bootstrap table, bootstrap, css3 table, bootstrap table, fresh bootstrap table, frontend, modern table, responsive bootstrap table, responsive bootstrap table">

<meta name="description"
	content="Probably the most beautiful and complex bootstrap table you've ever seen on the internet, this bootstrap table is one of the essential plugins you will need.">
 -->
<!-- Schema.org markup for Google+ 삭제 (Fresh Bootstrap Table by Creative Tim)-->
<!-- Twitter Card data 삭제 -->
<!-- Open Graph data -->
<!-- <meta property="og:title"
	content="Fresh Bootstrap Table by Creative Tim" />
<meta property="og:type" content="article" />
<meta property="og:url"
	content="https://wenzhixin.github.io/fresh-bootstrap-table/compact-table.html" />
<meta property="og:image"
	content="http://s3.amazonaws.com/creativetim_bucket/products/31/original/opt_fbt_thumbnail.jpg" />
<meta property="og:description"
	content="Probably the most beautiful and complex bootstrap table you've ever seen on the internet, this bootstrap table is one of the essential plugins you will need." />
<meta property="og:site_name" content="Creative Tim" /> -->

<!-- CSS -->
<!-- <link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css"/> -->
<!-- <link rel="stylesheet"	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<link href="http://fonts.googleapis.com/css?family=Roboto:400,700,300"	rel="stylesheet" type="text/css"> -->

<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<!-- CSS Files -->
<link href="/resources/client/assets/css/material-kit.css"
	rel="stylesheet" />
<link href="/resources/client/assets2/css/fresh-bootstrap-table.css"
	rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table/dist/bootstrap-table.min.js"></script>
<!-- Demo 삭제 -->


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
	<!--   Creative Tim Branding 로고 삭제  -->
	<!-- 메인 div -->
	<div class="main main-raised">
		<div class="section section-basic">
			<div class="container">
				<div class="ranking_title"></div>
				<div class="row">
					<div class="col-md-8 col-md-offset-2"
						style="padding: 0px; margin: 0px">
						<div class="fresh-table full-color-orange"
							style="width: 1200px; left: 0px; margin: 0px;">
							<!--
          Available colors for the full background: full-color-blue, full-color-azure, full-color-green, full-color-red, full-color-orange
          Available colors only for the toolbar: toolbar-color-blue, toolbar-color-azure, toolbar-color-green, toolbar-color-red, toolbar-color-orange
        -->
								
							<div class="toolbar">
								<button onClick="location.href='/client/ranking_hit'" class="btn btn-default">조회순 랭킹</button>
								<button onClick="location.href='/client/ranking_like'" class="btn btn-default">좋아요 랭킹</button>
							</div>

							<table id="fresh-table" class="table">
								<thead>
									<th data-field="rank">Ranking</th>
									<th data-field="img" data-sortable="true">이미지</th>
									<th data-field="name" data-sortable="true">제목</th>
									<th data-field="user" data-sortable="true">닉네임</th>
									<th data-field="cnt">조회수</th>
									<th data-field="actions" data-events="operateEvents"></th>
									<!-- data-formatter="operateFormatter" 삭제-->
								</thead>
								<tbody>
									<!-- 보기용 데이터 1개 빼고 데이터 삭제 -->
									<%int n=0; %>
									<%for(Recipe recipe : recipeList){%>
									<tr onclick="">
										<td><%=++n%></td>
										<td>
											<%if(recipe.getRecipe_img().equals("none")){ %> <img
											src="/resources/client/assets/img/noimage.jpg"
											alt="Rounded Image" class="rounded img-fluid"
											style="width: 50px; height: 40px"> <%}else{ %> <img
											src="/resources/data/<%=recipe.getRecipe_img() %>"
											alt="Rounded Image" class="rounded img-fluid"
											style="width: 50px; height: 40px"> <%} %>
										</td>
										<td><%=recipe.getRecipe_name()%></td>
										<td><%=recipe.getMember().getUser_nickname()  %></td>
										<td><%=recipe.getRecipe_hit() %></td>
									</tr>
									<%} %>
								</tbody>
							</table>
						</div>

						<div class="description description-footer">
							<!-- 트위터, 페이스북 공유 버튼 & 공유 횟수 보여주는 부분 삭제 -->
							<!-- Copyright -->

							<!-- <p>
									Copyright &copy; 2019 <a href="http://creative-tim.com">Creative
										Tim</a>, made with <i class="fa fa-heart ct-heart"></i> for a
									better web.
								</p> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 하단부 내용 -->
	<div class="title"></div>
	</div>



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
	<!-- div class="fixed-plugin" : 설정 버튼 삭제 -->

</body>



<script type="text/javascript">
	var $table = $('#fresh-table')
	var $lookBtn = $('#lookBtn')
	var $likeBtn = $('#likeBtn')
	
	
	window.operateEvents = {
		'click .like' : function(e, value, row, index) {
			alert('You click like icon, row: ' + JSON.stringify(row))
			console.log(value, row, index)
		},
		'click .edit' : function(e, value, row, index) {
			alert('You click edit icon, row: ' + JSON.stringify(row))
			console.log(value, row, index)
		},
		'click .remove' : function(e, value, row, index) {
			$table.bootstrapTable('remove', {
				field : 'id',
				values : [ row.id ]
			})
		}
	}

	function operateFormatter(value, row, index) {
		return [
				'<a rel="tooltip" title="Like" class="table-action like" href="javascript:void(0)" title="Like">',
				'<i class="fa fa-heart"></i>',
				'</a>',
				'<a rel="tooltip" title="Edit" class="table-action edit" href="javascript:void(0)" title="Edit">',
				'<i class="fa fa-edit"></i>',
				'</a>',
				'<a rel="tooltip" title="Remove" class="table-action remove" href="javascript:void(0)" title="Remove">',
				'<i class="fa fa-remove"></i>', '</a>' ].join('')
	}

	$(function() {
		$table.bootstrapTable({
			classes : 'table table-hover table-striped',
			toolbar : '.toolbar',

			search : true,
			showRefresh : true,
			showToggle : true,
			showColumns : true,
			pagination : true,
			striped : true,
			sortable : true,
			pageSize : 8,
			pageList : [ 8, 10, 25, 50, 100 ],

			formatShowingRows : function(pageFrom, pageTo, totalRows) {
				return ''
			},
			formatRecordsPerPage : function(pageNumber) {
				return pageNumber /* + ' rows visible' */
			}
		})

		$alertBtn.click(function() {
			alert('You pressed on Alert')
		})
	})

	$('#sharrreTitle').sharrre(
			{
				share : {
					twitter : true,
					facebook : true
				},
				template : '',
				enableHover : false,
				enableTracking : true,
				render : function(api, options) {
					$("#sharrreTitle").html(
							'Thank you for ' + options.total + ' shares!')
				},
				enableTracking : true,
				url : location.href
			})
	/* 아래 라인 트위터, 페이스북 공유 코드 */
	/*  $('#twitter').sharrre({
	   share: {
	     twitter: true
	   },
	   enableHover: false,
	   enableTracking: true,
	   buttons: { twitter: {via: 'CreativeTim'}},
	   click: function (api, options) {
	     api.simulateClick()
	     api.openPopup('twitter')
	   },
	   template: '<i class="fa fa-twitter"></i> {total}',
	   url: location.href
	 })

	 $('#facebook').sharrre({
	   share: {
	     facebook: true
	   },
	   enableHover: false,
	   enableTracking: true,
	   click: function (api, options) {
	     api.simulateClick()
	     api.openPopup('facebook')
	   },
	   template: '<i class="fa fa-facebook-square"></i> {total}',
	   url: location.href
	 }) */
</script>

<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga')

	ga('create', 'UA-46172202-1', 'auto')
	ga('send', 'pageview')
</script>

</html>