
$(function(){
	//头部导航栏
	
	$("header .ul1 li").hover(function(){
		$(this).find('.ul2').css("display","block");
	},function(){
		$(this).find('.ul2').css("display","none");
	})
	
	///*第二部分导航栏搜索栏*/
	$(".section .ul3 li").hover(function(){
		$(this).find(".ul4").css("display","block");
	},function(){
		$(this).find(".ul4").css("display","none");
	})

	//聊天框

	$(".section .ul3 .ul4 .chatLi").click(function(){
		var sessionname=$(".sessionname").html();
		if(sessionname==""||sessionname==null){
			alert("请先登录");
			location.href="Login.jsp";
		}else{
		
		$(".chatList1").css("display","block");
		}
	})
	$(".chatList .close .button1").click(function(){
		parent.document.getElementById("#chatList1").display = "none"; 
		$(".chatList1").css("display","none");
		
	})
	
	//热门商品轮播区
	var index=0;
	//li标签点击区
	$(".tab ul li").click(function(){
		index=$(this).index();
		change();
	})
	//按钮点击区
	$("#left").click(function(){
		index--;
		if(index<0){
			index=4;
		}
		change();
	})
	$("#right").click(function(){
		index++;
		if(index>4){
			index=0;
		}
		change();
	})
	//定时轮播
   var timer;
   autoplay();
//鼠标移入停止定时器
$("#banner").mouseenter(function(){
clearInterval(timer);
})
//鼠标移出开始定时器
$("#banner").mouseleave(function(){
	autoplay();
})
	//打开聊天面板
function openchatmianban(obj){
	var receiver=$(""+$(obj).html()+">p").html();
	$(".chatiframe").attr("src","chat.jsp?receiver="+receiver+"");
	$(".chatmianban").css("diaplay","block");
	$(".chatmianban").show();
}
	//封装函数
	function change(){
		$(".pic a img").eq(index).fadeIn().parent().siblings().children().fadeOut();
		$(".tab ul li").eq(index).addClass("on").siblings().removeClass("on");
	}
	function autoplay(){
		timer=setInterval(function(){
			index++;
			if(index>4){
				index=0;
			}
			change();
		},2000)
	}
})