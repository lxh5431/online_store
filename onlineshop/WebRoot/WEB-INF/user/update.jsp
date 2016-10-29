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
			//iframe中的datagrid对象
			var dg = parent.$("iframe[title='用户更新']").get(0).contentWindow.$("#dg");
			
			//对管理员的下拉列表框进行远程加载
			$("#ff").combobox({   
				//将请求发送给accountAction中的query方法处理，这里需要将处理好的数据返回到这边来显示了 ，所以后台需要将数据打包成json格式发过来
			    url:'user_query.action',  
			    valueField:'id',    
			    textField:'login', //我们下拉列表中显示的是管理员的登录名
			    panelHeight:'auto', //自适应高度
			    panelWidth:120,//下拉列表是两个组件组成的
			    width:120, //要同时设置两个宽度才行
			    editable:false //下拉框不允许编辑
			});  
			
			// 完成数据的回显，更新时，用户肯定先选择了要更新的那一行，首先我们得拿到那一行
			var rows = dg.datagrid("getSelections");
			//将拿到的那一行对应的数据字段加载到表单里，实现回显
			$("#ff").form('load',{
				id:rows[0].id,
				name:rows[0].name,
				login:rows[0].login,
				pass:rows[0].pass,
				sex:rows[0].sex,
				phone:rows[0].phone,
				email:rows[0].email,
				'user.id':rows[0].user.id //EasyUI不支持account.id这种点操作，所以要加个引号
			});

			//回显完了数据后，设置一下验证功能
			$("input[name=name]").validatebox({
				required:true,
				missingMessage:'请输入用户名'
			});	
			$("input[name=login]").validatebox({
				required:true,
				missingMessage:'请输入登陆账号'
			});
			$("input[name=pass]").numberbox({
				required:true,
				missingMessage:'请输入密码',
			});	
			
			
			$("input[name=phone]").validatebox({
				required:true,
				missingMessage:'请输入电话号码'
			});
			$("input[name=email]").validatebox({
				required:true,
				missingMessage:'请输入邮箱'
			});
			//窗体弹出默认时禁用验证
			$("#ff").form("disableValidation");
			//注册button的事件
			$("#btn").click(function(){
				//开启验证
				$("#ff").form("enableValidation");
				//如果验证成功，则提交数据
				if($("#ff").form("validate")) {
					//调用submit方法提交数据
					$("#ff").form('submit', {
						url: 'user_update.action', //提交时将请求传给productAction的update方法执行
						success: function(){
							//如果成功了，关闭当前窗口，并刷新页面
							parent.$("#win").window("close");
							dg.datagrid("reload");
						}
					});
				}
			});
		});
	</script>
  </head>
  
  <body>
  	<form title="更新用户" id="ff" method="post" enctype="multipart/form-data">
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
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新</a>  
	    	<input type="hidden" name="id" />
	    </div>  `
	    </div>
	</form>  	
  </body>
</html>