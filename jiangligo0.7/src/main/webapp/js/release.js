$(function(){
	$('form input[type=file]').change(function(){
		var span = $(this).siblings('span');
		var preview = $(this).siblings('img');
		var file = $(this).get(0).files[0];
		//判断是否为图片文件
		if(/\.(jpe?g|png|gif)$/i.test(file.name) ) {
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.addEventListener("load", function () {
				preview.attr('src',reader.result);
    		}, true);
		}
		span.css('visibility','visible');
	});
	$('form img').click(function(){
		
		$(this).siblings('input[type=file]').click();
		
	});
})

//加载分类
$(function(){
	$.ajax({
		url: "sort/list.do",
		success: function(data){
			for(var i = 0;i<data.length;i++){
				$('#sel-sort').append('<option value="'+data[i].id+'">'+data[i].sortname+'</option>');
			}
		}
	});
})

//表单验证
$(function(){
	$('#myform button[type=submit]').click(function(){
		var flag1 = true;
		var flag2 = true;
		var flag3 = true;
		var flag4 = true;
		//标题为空验证
		if(flag1 = !isNull($('#f-name'),'标题不能为空')){
			//标题长度验证
			flag1 = isLengthInRang($('#f-name'),'标题要在6-150字符内',5,150);
		}
		//描述为空验证
		if(flag2 = !isNull($('#f-info'),'描述不能为空')){
			//描述长度验证
			flag2 = isLengthInRang($('#f-info'),'描述要在10-150字符内',9,300);
		}
		//价格为空验证
		if(flag3 = !isNull($('#f-price'),'价格不能为空或有误')){
			//价格大小验证
			flag3 = isInRang($('#f-price'),'价格要在0-10000元内',0,10000);
		}
		
		//图片全为空
		var pic_label = $('label[for=pics]');
		if(($('#pic1').val()=='')&&($('#pic2').val()=='')&&($('#pic3').val()=='')&&($('#pic4').val()=='')){
			pic_label.attr({"data-trigger":"manual","data-placement":"right","data-content":"未选择图片"});
			pic_label.popover('show');
			flag4 = false;
		}else{
			pic_label.popover('hide');
		}
		return flag1&&flag2&&flag3&&flag4;
	})
})
function isNull(ipt,msg){
//	var label = ipt.siblings('label');
	if(ipt.val()==''){
		ipt.attr({"data-trigger":"manual","data-placement":"right","data-content":msg});
		ipt.popover('show');
		return true;
	}else{
		ipt.popover('hide');
		return false;
	}
}
function isLengthInRang(ipt,msg,minLen,maxLen){
	
	if(ipt.val().length<=minLen||ipt.val().length>maxLen){
		ipt.attr({"data-trigger":"manual","data-placement":"right","data-content":msg});
		setTimeout(function(){
			ipt.popover('show');
		},200);
		return false;
	}else{
		ipt.popover('hide');
			return true;
		}
}
function isInRang(ipt,msg,min,max){
	if(eval(ipt.val())<min||eval(ipt.val())>=max){
		ipt.attr({"data-trigger":"manual","data-placement":"right","data-content":msg});
		ipt.popover('show');
		return false;
	}else{
		ipt.popover('hide');
		return true;
	}
}
function del(s){
	$(s).siblings('img').attr('src','images/release/add_icon.png');
	$(s).siblings('input').val('');
	s.remove();
}
