<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>去发布</title>
	<meta name="description" content="jiangliGO">
	<meta name="viewport" content="width=800, user-scalable=no">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/collection.css">
	<link rel="stylesheet" href="css/goods-master.css">
	<link rel="stylesheet" href="css/release.css" />
		
		
	<style>#BAIDU_DSPUI_FLOWBAR,.adsbygoogle,.ad,div[class^="ad-widsget"],div[id^="div-gpt-ad-"],a[href*="@"][href*=".exe"],a[href*="/?/"][href*=".exe"],.adpushwin{display:none !important;}</style></head>

	<body class=" meny-left " style="perspective: 800px; perspective-origin: 0px 50%;">

<!--导航部分-->
		<div class="meny" style="width: 260px; height: 100%;position: fixed; display: block; z-index: 1; transform-origin: 100% 50% 0px; transition: all 0.5s ease; transform: translateX(-100%) translateX(6px) scale(1.01) rotateY(-30deg);">
			<jsp:include page="nav.jsp"></jsp:include>
		</div>
		
	<!-- 左侧箭头 -->
		<div class="meny-arrow"></div>
	<!-- 主要内容 -->
		<div class="contents" style="padding: 0 ;transform-origin: 0px 50% 0px; transition: all 0.5s ease;">
		<!-- 头部 -->
			<jsp:include page="/indexHeader2.jsp"></jsp:include>
			<div>
				<!--template 1-->
				<div class="til"><h3>发布商品</h3></div>
				<div class="til">
					<div class="container">
						<div class="tab-pane col-xs-8 col-sm-8 col-md-8">
							<form action="goods/release.do" id="myform" enctype="multipart/form-data" method="post">
									<div class="form-group">
										<label for="f-name" class="control-label">标题</label>
										<input type="text" class="form-control " id="f-name" name="name" placeholder="标题" />
									</div>
									<div class="form-group">
										<label for="f-info">描述一下</label>
										<textarea id="f-info" name="info" class="form-control" rows="3" placeholder="描述一下" style="resize: none;"></textarea>
									</div>
									<div class="form-group">
										<label for="f-price">价格</label>
										<div class="input-group">
											<span class="input-group-addon">￥</span>
											<input type="number" class="form-control" name="price" placeholder="价格" id="f-price"/>
										</div>
									</div>
									<div class="form-group">
										<label for="pics">图片</label>
										<div class="form-control-static">
											<div class="row">
											  <div class="col-xs-3 col-sm-3 col-md-3">
											  	  <span class="glyphicon glyphicon-remove-circle" style="visibility: hidden;cursor: pointer;" onclick="del(this)"></span>
											      <img src="images/release/add_icon.png" alt="..." class="thumbnail"/>
											      
											      <input type="file" accept="image/*" id="pic1" name="pics" placeholder="选择图片"/>
											  </div>
											  <div class="col-xs-3 col-sm-3 col-md-3">
											      <span class="glyphicon glyphicon-remove-circle" style="visibility: hidden;cursor: pointer;" onclick="del(this)"></span>
											      <img src="images/release/add_icon.png" alt="..." class="thumbnail"/>
											      
											      <input type="file" accept="image/*" id="pic2" name="pics" placeholder="选择图片"/>
											  </div>
											  
											  <div class="col-xs-3 col-sm-3 col-md-3">
											      <span class="glyphicon glyphicon-remove-circle" style="visibility: hidden;cursor: pointer;" onclick="del(this)"></span>
											      <img src="images/release/add_icon.png" alt="..." class="thumbnail"/>
											      
											      <input type="file" accept="image/*" id="pic3" name="pics" placeholder="选择图片"/>
											  </div>
											  <div class="col-xs-3 col-sm-3 col-md-3">
											      <span class="glyphicon glyphicon-remove-circle" style="visibility: hidden;cursor: pointer;" onclick="del(this)"></span>
											      <img src="images/release/add_icon.png" alt="..." class="thumbnail"/>
											      
											      <input type="file" accept="image/*" id="pic4" name="pics" placeholder="选择图片"/>
											  </div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="f-sort">分类</label>
										<select id="sel-sort" class="form-control" id="f-sort" name="sort_id">
										</select>
									</div>
								<div class="form-control-static">
									<button type="submit" id="f-btn" class="btn btn-info btn-block">发布</button>
								</div>
								
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	<!-- 底部 -->
		<%-- <jsp:include page="/footer.jsp"></jsp:include> --%>
		<script type="text/javascript" src="js/jquery-3.0.0.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script src="js/jquery.validate.min.js"></script>
		<script src="js/goods-master.js"></script>
		<script type="text/javascript" src="js/release.js" ></script>
		
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