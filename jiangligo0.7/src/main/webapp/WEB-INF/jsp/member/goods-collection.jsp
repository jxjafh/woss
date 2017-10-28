<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收藏的商品</title>
	<meta name="description" content="jiangliGO">
	<meta name="viewport" content="width=800, user-scalable=no">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/collection.css">
	<link rel="stylesheet" href="css/goods-master.css">
		
		
	<style>#BAIDU_DSPUI_FLOWBAR,.adsbygoogle,.ad,div[class^="ad-widsget"],div[id^="div-gpt-ad-"],a[href*="@"][href*=".exe"],a[href*="/?/"][href*=".exe"],.adpushwin{display:none !important;}</style></head>

	<body class=" meny-left " style="perspective: 800px; perspective-origin: 0px 50%;">

<!--导航部分-->
		<div class="meny" style="width: 260px; height: 100%;position: fixed; display: block; z-index: 1; transform-origin: 100% 50% 0px; transition: all 0.5s ease; transform: translateX(-100%) translateX(6px) scale(1.01) rotateY(-30deg);">
			<jsp:include page="nav.jsp"></jsp:include>
		</div>
		
	<!-- 左侧箭头 -->
		<div class="meny-arrow"></div>
	<!-- 主要内容 -->
		<div class="contents" style="padding: 0;transform-origin: 0px 50% 0px; transition: all 0.5s ease;">
			<jsp:include page="/indexHeader2.jsp"></jsp:include>
			
			<div >
				<!--template 1-->
				<div  class="til"><h3>收藏的商品</h3></div>
				<div  class="til">
				<c:forEach items="${membercgs }" var="it">
					<div class="box">
						<div class="he-wrap tpl1">
						<a href="admin/goodsdetails.do?id=${it.id}">
							<img src=${it.goods.pic } />
						</a>
							<div class="he-view">
								<div>
									<span>${it.goods.name }</span>
									<br />
									<span class="pull-left" style="color: red;">￥ ${it.goods.price }</span>
									<!-- <script type="text/javascript">
										$(function(){
											$('.a-delete').on('click', function () {
												$(this).closest('.box').find('.modal').modal({backdrop: 'static', keyboard: false});
											});
										});
									</script> -->
									<a href="javascript:void(0)" class="glyphicon glyphicon-remove pull-right a-delete" data-toggle="modal" data-target="#${it.id }" role="button"></a>
							<!-- 删除提示 -->
									<div id=${it.id } class="modal fade bs-example-modal-sm div-delete" tabindex="-1" role="dialog" style="position:absolute;">
									  <div class="modal-dialog modal-sm" role="document">
									    <div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
													<h2 class="modal-title">确定删除?</h2>
												</div>
												<div class="modal-body">
									        <span>${it.goods.name }</span>
									      </div>
									      <div class="modal-footer">
									      	<form action="membercg/del.do" method="POST">
									      	<input type="hidden" name="id" value="${it.id }">
									      	<button type="button" class="btn btn-success" data-dismiss="modal">取消</button>
									        <button type="submit" class="btn btn-danger">确定</button>
									        </form>
									      </div>
									    </div><!-- /.modal-content -->
									  </div><!-- /.modal-dialog -->
									</div><!-- /.modal -->
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				</div>
			</div>
		</div>
		
		<!-- 底部 -->
	<%-- 	<jsp:include page="/footer.jsp"></jsp:include>	 --%>	
			
		<script type="text/javascript" src="js/jquery-3.0.0.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script src="js/goods-master.js"></script>
		
		<script>
//			$(function(){
//				$('.meny ul a').click(function(){
//					$('.contents iframe').attr('src',$(this).attr('id'));
//				})
//			});
//			
		</script>
		
		<script>
			// Create an instance of Meny
			var meny = Meny.create({
				// The element that will be animated in from off screen
				menuElement: document.querySelector( '.meny' ),

				// The contents that gets pushed aside while Meny is active
				contentsElement: document.querySelector( '.contents' ),

				// [optional] The alignment of the menu (top/right/bottom/left)
				position: Meny.getQuery().p || 'left',

				// [optional] The height of the menu (when using top/bottom position)
				height: 200,

				// [optional] The width of the menu (when using left/right position)
				width: 260,

				// [optional] Distance from mouse (in pixels) when menu should open
				threshold: 40,

				// [optional] Use mouse movement to automatically open/close
				mouse: true,

				// [optional] Use touch swipe events to open/close
				touch: true
			});
		</script>

</body>
</html>