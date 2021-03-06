<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf" %>
	<style type="text/css">
		#menu {
			width:60px;
			border:1px solid red;
		}
		#menu ul {
			list-style: none;
			padding: 0px;
			margin: 0px;
		}
		#menu ul li {
			border-bottom: 1px solid #fff;
			
		}
		#menu ul li a {
			/*先将a标签转换为块级元素，才能设置宽和内间距*/
			display: block;
			background-color: #00a6ac;
			color: #fff;
			padding: 5px;
			text-decoration: none;
		}
		#menu ul li a:hover {
			background-color: #008792;
		}
	
		
	</style>
	
	<script type="text/javascript">
		$(function(){
			$("a[title]").click(function(){
				var text = $(this).text();
				var href = $(this).attr("title");
				//判断当前右边是否已有相应的tab
				if($("#tt").tabs("exists", text)) {
					$("#tt").tabs("select", text);
				} else {
					//如果没有则创建一个新的tab，否则切换到当前tag
					$("#tt").tabs("add",{
						title:text,
						closable:true,
						content:'<iframe title=' + text + ' src=' + href + ' frameborder="0" width="100%" height="100%" />'
					});
				}
				
			});
		});
	</script>
</head>

	<body class="easyui-layout">
	    <div data-options="region:'north',title:'欢迎来到SONG后台管理',split:true" style="height:100px">
	    <div style=" background-image: image/p31749018.jpg">
	    <li><a href="#" title="send_category_query.action">类别管理</a>
	    </div>
	    </div>  
      
	    <div data-options="region:'west',title:'系统操作',split:true" style="width:200px;">
	    	<!-- 此处显示的是系统菜单 -->
	    	<div id="menu" class="easyui-accordion" data-options="fit:true">   
    			<div title="基本操作">   
        			<ul>
						<li><a href="#" title="send_category_query.action">类别管理</a>
						<li><a href="#" title="send_product_query.action">商品管理</a>
					</ul>
    			</div>   
    			<div title="销售管理">
    				<ul>
						<li><a href="#" title="send_sale_sale.action">销售管理</a>
					</ul>
    			</div>
    			<div title="用户管理">
    				<ul>
						<li><a href="#" title="send_user_query.action">注册用户管理</a>
					</ul>
    			</div>
    			<div title="角色管理">
    				<ul>
						<li><a href="#" title="send_roles_query.action">角色管理</a>
					</ul>
    			</div>
    			<div title="日记管理">
    				<ul>
						<li><a href="#" title="send_log_query.action">管理员日记管理</a>
						<li><a href="#" title="send_sale_sale.action">用户日记管理</a>
					</ul>
    			</div>   
			</div>   
	    </div>   
	    <div data-options="region:'center',title:'后台操作页面'" style="padding:1px;background:#eee;">
	    	<div id="tt" class="easyui-tabs" data-options="fit:true">   
    			<div title="系统缺省页面" style="padding:10px;">
    			<div>
<center style="color: white;font-weight: 800;font-size: 30px;" >尊贵的：<span style="color: yellow;font-weight: 800;">${admin.userName}${admin.superName}</span>　　您好！！！！ 欢迎进入蓝缘管理系统:</center>
<dir style="color: white;font-size: 20px;">
你的身份是: <span style="color: yellow;">
 <c:if test="${admin.level eq '0'}">超级管理员</c:if> 
  <c:if test="${admin.level ne '0'}"> 普通用户</c:if>
  </span>
　　现在的时间是:<span class="STYLE7"><b><SPAN id=clock style="color: yellow;"></SPAN></b>
 <script type=text/javascript>
    var clock = new Clock();
    clock.display(document.getElementById("clock"));
</script></span>
</dir>　
</div>
    				
    </div> 
    			</div>   
    			
    		</div>      		    	
	    </div> 
	    <div id="win" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>  
	</body>  

</html>