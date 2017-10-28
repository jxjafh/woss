//头部导航栏
$(function(){
	$("header .ul1 li").hover(function(){
		$(this).find('.ul2').css("display","block");
	},function(){
		$(this).find('.ul2').css("display","none");
	})
})