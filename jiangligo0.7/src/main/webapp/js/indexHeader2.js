
$(function(){
	//头部导航栏
	
	$("header .ul1 li").hover(function(){
		$(this).find('.ul2').css("display","block");
	},function(){
		$(this).find('.ul2').css("display","none");
	});
	
	///*第二部分导航栏搜索栏*/
	$(".section .ul3 li").hover(function(){
		$(this).find(".ul4").css("display","block");
	},function(){
		$(this).find(".ul4").css("display","none");
	}) ;
});