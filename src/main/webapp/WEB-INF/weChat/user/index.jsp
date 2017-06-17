<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>weChat</title>
	<link href='${ctx}/water/css/style.css'  rel='stylesheet' media='screen' />
	<style type="text/css">
	.span_right{float:left;}
	.span_left{float:right;}
	.span_center{ display:inline;}
	</style>
</head>
<body>
fuck you  ${user.name}
	<div id="wrapper">
		<div id="container">
			<c:forEach items="${data }" var="weChat" varStatus="num">
				<div class="grid">
					<div class="imgholder"><img class="lazy" src="${ctx}/water/images/pixel.gif" data-original="${weChat.imgUrl }" width="175" /></div>
					<strong>${weChat.name }</strong>
					<p>${weChat.desc }</p>
					<div class="meta"><span class="span_right"><a href="${weChat.qrCodeUrl }"  target="_blank" title='点击查看' >浏览</a>(<span>${weChat.readNum}</span>)</span><span class="span_left">收藏 (<span>${weChat.collectionNum}</span>)</span></div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div id="addData" style="display:none;"> </div>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
	<script id="test" type="text/html">
  		{{each data as weChat i}}
            	<div class="grid">
					<div class="imgholder"><img class="lazy" src="${ctx}/water/images/pixel.gif" data-original="{{weChat.img_url }}" width="175" /></div>
					<strong>{{weChat.name }}</strong>
					<p>{{weChat.desc }}</p>
					<div class="meta"><span class="span_right"><a href="{{weChat.qr_code_url}}"  target="_blank" title='点击查看' >浏览</a>(<span>{{weChat.read_num}}</span>)</span><span class="span_left">收藏 (<span>{{weChat.collection_num}}</span>)</span></div>
				</div>
 		{{/each}}
    </script> 
	<script type="text/javascript">
		 var page = {currentPage :2};
		 $(function(){
			  var reload = function(){
				  if(${data.size()}<page.currentPage){
					  return;
				  }
					 $.post("${ctx}/getWeChatData.html",{"currentPage":page.currentPage++},function(data,status){
						 if(status=="success"){
							 var html = template('test', data);
							 $("#addData").empty().append(html)
						 }
					 },"json");
				}
				$("img.lazy").lazyload({
					load:function(){
						$('#container').BlocksIt({
							numOfCol:5,
							offsetX: 8,
							offsetY: 8
						});
					}
				});	
				
				$(window).scroll(function(){
						// 当滚动到最底部以上50像素时， 加载新内容
					if ($(document).height() - $(this).scrollTop() - $(this).height()<50){
						reload();
						$('#container').append($("#addData").html());
						$("#addData").empty();
						$('#container').BlocksIt({
							numOfCol:5,
							offsetX: 8,
							offsetY: 8
						});
						$("img.lazy").lazyload();
					}
				});
				
				//window resize
				var currentWidth = 1100;
				$(window).resize(function() {
					var winWidth = $(window).width();
					var conWidth;
					if(winWidth < 660) {
						conWidth = 440;
						col = 2
					} else if(winWidth < 880) {
						conWidth = 660;
						col = 3
					} else if(winWidth < 1100) {
						conWidth = 880;
						col = 4;
					} else {
						conWidth = 1100;
						col = 5;
					}
					
					if(conWidth != currentWidth) {
						currentWidth = conWidth;
						$('#container').width(conWidth);
						$('#container').BlocksIt({
							numOfCol: col,
							offsetX: 8,
							offsetY: 8
						});
					}
				});
			});
	</script>
</html>