<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/public/head.jspf" %>
<style type="text/css">

@charset "utf-8";
* {
    margin: 0;
    padding: 0;
}

body {
    font-family: "\5FAE\8F6F\96C5\9ED1", Helvetica, sans-serif;
    font-size: 14px;
    color: #000;
    background: #f1f1f1;
}

ul, li {
    list-style: none;
}

a, a:active, a:hover, a:visited, a:target {
    text-decoration: none;
    color: #000;
}



.box {
    margin: 40px auto;
    padding: 40px;
    width: 400px;
    border: 1px solid green;
    border-radius: 12px;
    box-shadow:0 0 10px 5px #ccc;
    background: #fff;
    text-align: center;
}

.box div {
    margin-bottom: 20px;
}
.box h3{
    height: 36px;
    line-height: 36px;
    font-weight: normal;
    margin-bottom: 20px;
}




</style>
	<script type="text/javascript">
		$(function(){
			//自定义验证方法向validatebox.defaults.rules中注册新函数
			$.extend($.fn.validatebox.defaults.rules,{
				//函数的名称：{函数的实现体(又是一个json对象，里面包括函数的实现，和错误消息的设置)} 
				format:{
					//函数实现，如果返回为false，则验证失败
					validator: function(value,param){
						//获取当前文件的后缀名
						var ext = value.substring(value.lastIndexOf('.') + 1);
						//获取支持的文件后缀名，然后比较即可
						var arr = param[0].split(",");
						for(var i = 0; i < arr.length; i++) {
							if(ext == arr[i])
								return true;
						}
						return false;
					},
					//错误消息
					message: '文件后缀必须为:{0}'
				}
			});
			
			
				
			$("input[name=name]").validatebox({
				required:true,
				missingMessage:'请输入用户名'
			});
			$("input[name=login]").validatebox({
				required:true,
				missingMessage:'请输入账号',
				//设置自定义方法
				
			});

			$("input[name=pass]").numberbox({
				required:true,
				missingMessage:'请输入密码',
		       
				
			});
			
	
			$("textarea[name=sex]").validatebox({
				required:true,
				missingMessage:'请输入性别'
			});
			
			$("textarea[name=phone]").validatebox({
				required:true,
				missingMessage:'请输入电话号码'
			});
			$("textarea[name=email]").validatebox({
				required:true,
				missingMessage:'请输入邮箱',
					validType: 'email'   
			});
			
			//窗体弹出默认时禁用验证
			$("#ff").form("disableValidation");
			
			//注册button的事件
			$("#submit").click(function(){
				//开启验证
				$("#ff").form("enableValidation");
				//如果验证成功，则提交数据
				if($("#ff").form("validate")) {
					//调用submit方法提交数据
					$("#ff").form('submit', {
						url: 'user_save.action',
						success: function(){
							//如果成功了，关闭当前窗口
							parent.$("#win").window("close");
							parent.$("iframe[title='用户管理']").get(0).contentWindow.$("#dg").datagrid("reload");
						}
					});
				}
			});
			
			//注册button的事件
			$("#reset").click(function(){
				$("#ff").form("disableValidation");//重置不需要表单验证
				//重置当前表单数据
				$("#ff").form("reset");
			});
		});
	</script>
  </head>
  
  <body>
	  <form title="添加用户" id="ff" method="post" enctype="multipart/form-data">
        
		<div class="box">
		<div>
			<label>用戶名:</label> <input type="text" name="name" />
		</div>

		<div>
			<label>賬號:</label> <input type="text" name="login" />
		</div>
		<div>
			<label>密碼:</label> <input type="text" name="pass" />
		</div>
          	<div>
				<label>性別:</label> 
				
						男<input type="radio" name="sex" checked="checked" value="男" />  
						女<input type="radio" name="sex" value="女" /> 
				
			</div>
		
		 
		<div>
			<label>電話號碼:</label>
		 <input type="text" name="phone" />
		</div>
		<div>
			<label>郵箱:</label>
			 <input type="text" name="email" />
		</div>
		<div>
			<a id="submit" href="#" class="easyui-linkbutton">添 加</a> 
			<input type="hidden" name="id" />
			<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
		</div>
		</div>
	  </form>	
                
  </body>
</html>