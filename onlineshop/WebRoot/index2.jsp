<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="stylesheet" href="${shop }/css/public.css" />
<link rel="stylesheet" href="${shop }/css/style.css" />
<!-- 下面是easyui的环境 -->
<link rel="stylesheet" href="${shop }/jquery-easyui-1.3.5/themes/icon.css" type="text/css"></link>
<link rel="stylesheet" href="${shop }/jquery-easyui-1.3.5/themes/default/easyui.css" type="text/css"></link>
<script type="text/javascript" src="${shop }/jquery-easyui-1.3.5/jquery.min.js"></script>
<script type="text/javascript" src="${shop }/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${shop }/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
  
  	<style>
        *{
            margin:0;
            padding:0;
            font-size:20px;
            font-family: "\5FAE\8F6F\96C5\9ED1", Helvetica, sans-serif;
            -webkit-user-select: none;
        }
        input,button{
            outline: none;
            border: 0;
        }
        body{
        background: #f1f1f1;
      
        }
        .box{
            position: absolute;
            margin: auto;
            top:0;
            left:0;
            bottom: 0;
            right:0;
            width:400px;
            height:300px;
            padding:20px;
            border:1px solid #ccc;
            border-radius: 10px;
            box-shadow:0 0 10px 5px #ccc;
            background: -webkit-linear-gradient(to bottom,lightblue,lightgreen);
            background: linear-gradient(to bottom,lightblue,lightgreen);
        }
        .box label:nth-of-type(1){
            position: absolute;
            top:30%;
            left:10%;
        }

        .box input,.box label{
            height: 36px;
            line-height: 36px;
            padding: 0 5px;
        }
        .box input:nth-of-type(1){
            position: absolute;
            top:30%;
            left:30%;
            border-radius: 5px;
        }
        .box label:nth-of-type(2){
            position: absolute;
            top:45%;
            left:10%;
        }
        .box input:nth-of-type(2){
            position: absolute;
            top:45%;
            left:30%;
            border-radius: 5px;
        }
        .box button{
            position: absolute;
            display: block;
            width:150px;
            height:50px;
            line-height:50px;
            text-align: center;
            top:70%;
            left:50%;
            margin-left:-75px ;
            background: darkorange;
            color: #fff;
            border-radius: 5px;
        }
        .box button:hover{
            background: tomato;
        }

        h2{
            text-align: center;
        }
    </style>
  </head>
  <body>
  <div class="section_container">
			
			<div class="box">
					<form method="post" action="account_login.action">
					<h1>SONG商店管理系统</h1>

                <label for="login">账号:&nbsp;</label>
                <input type="text" name="login" />
                <label for="pass">密码:&nbsp; </label>
                <input type="text" name="pass" />

               
                    <button id="submit">登录</button>
                     </form>
			   <div style="clear:both"></div>
			</div>
		
  </body>
</html>
