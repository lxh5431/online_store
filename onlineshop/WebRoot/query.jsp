<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/public/head.jspf" %>
	<style type="text/css">
		body {
			margin: 1px;
		}
		.searchbox {
		  margin: -3;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({   
				//url地址改为请求categoryAction
			    url:'log_query.action',
			    loadMsg:'Loading......',
			    queryParams:{name:''},//这里不需要传具体的name，因为我们要显示所有的
			    //width:300,
			    fitColumns:true,//水平自动展开，如果设置此属性，则不会有水平滚动条，演示冻结列时，该参数不要设置
			    //显示斑马线
			    striped:true,
			    //当数据多的时候不换行
			    nowrap:true,
			    singleSelect:false, //如果为真，只允许单行显示，全显功能失效
			    //设置分页
			    pagination:true,
			    //设置每页显示的记录数，默认是10个
				pageSize:5,
				//设置可选的每页记录数，供用户选择，默认是10,20,30,40...
				pageList:[5,10,15,20],
				idField:'id',//指定id为标识字段，在删除，更新的时候有用，如果配置此字段，在翻页时，换页不会影响选中的项
				
				//toolbar定义添加、删除、更新按钮以及搜索框
				toolbar: [{
					iconCls: 'icon-add',
					text:'添加角色',
					handler: function(){
						parent.$("#win").window({
							title:"添加角色",
							width:650,
							height:600,
							content:'<iframe src="send_roles_save.action" frameborder="0" width="100%" height="100%"/>'
						});
					}
				},'-',{
					iconCls: 'icon-edit',
					text:'更新角色',
					handler: function(){
						//判断是否有选中行记录，使用getSelections获取选中的所有行
						var rows = $("#dg").datagrid("getSelections");
						if(rows.length == 0) {
							//弹出提示信息
							$.messager.show({ //语法类似于java中的静态方法，直接对象调用
								title:'错误提示',
								msg:'至少要选择一条记录',
								timeout:2000,
								showType:'slide',
							});
						}else if(rows.length != 1) {
							//弹出提示信息
							$.messager.show({ //语法类似于java中的静态方法，直接对象调用
								title:'错误提示',
								msg:'每次只能更新一条记录',
								timeout:2000,
								showType:'slide',
							});
						} else{
							//1. 弹出更新的页面
							parent.$("#win").window({
								title:"更新用户",
								width:650,
								height:600,
								content:'<iframe src="send_roles_update.action" frameborder="0" width="100%" height="100%"/>'
							});
						 
						}
					}
				},'-',{
					iconCls: 'icon-remove',
					text:'删除用户',
					handler: function(){
						//判断是否有选中行记录，使用getSelections获取选中的所有行
						var rows = $("#dg").datagrid("getSelections");
						//返回被选中的行，如果没有任何行被选中，则返回空数组
						if(rows.length == 0) {
							//弹出提示信息
							$.messager.show({ //语法类似于java中的静态方法，直接对象调用
								title:'错误提示',
								msg:'至少要选择一条记录',
								timeout:2000,
								showType:'slide',
							});
						} else {
							//提示是否确认删除，如果确认则执行删除的逻辑
							$.messager.confirm('删除的确认对话框', '您确定要删除此项吗？', function(r){
								if (r){
								    //1. 从获取的记录中获取相应的的id,拼接id的值，然后发送后台1,2,3,4
								    var ids = "";
								    for(var i = 0; i < rows.length; i ++) {
								    	ids += rows[i].id + ",";
								    }
								    ids = ids.substr(0, ids.lastIndexOf(","));
								    //2. 发送ajax请求
								    $.post("roles_deleteByIds.action",{ids:ids},function(result){
								    	if(result == "true") {
								    		//将刚刚选中的记录删除，要不然会影响后面更新的操作
								    		$("#dg").datagrid("uncheckAll");
								    		//刷新当前页，查询的时候我们用的是load，刷新第一页，reload是刷新当前页
								    		$("#dg").datagrid("reload");//不带参数默认为上面的queryParams		
								    	} else {
								    		$.messager.show({ 
												title:'删除异常',
												msg:'删除失败，请检查操作',
												timeout:2000,
												showType:'slide',
											});
								    	}
								    },"text");
								}
							});
						}						
					}
				},'-',{ //查询按钮不是LinkButton，它有语法，但是也支持解析HTML标签
					text:"<input id='ss' name='serach' />"
				}],
			    rowStyler: function(index,row){
			    	console.info("index" + index + "," + row)
			    	if(index % 2 == 0) {
			    		return 'background-color:#fff;';
			    	} else {
			    		return 'background-color:#c4e1e1;';
			    	}
			    	
			    },
			    frozenColumns:[[
			        {field:'checkbox',checkbox:true},
					{field:'id',title:'编号',width:50}   
			    ]],
			    columns:[[
			    	   {field:'username',title:'用户名',width:100}, //
			        {field:'module',title:'模块',width:100},    
			     
			        {field:'action',title:'描述',width:100},
			        {field:'actionTime',title:'开始时间',width:100},
			        {field:'operTime',title:'操作时间',width:100},
			        {field:'enable',title:'是否禁止',width:100, },
			        {field:'userIp',title:'用户ip',width:100 ,}
						
			       
			    ]]    
			}); 
			//把普通的文本框转化为查询搜索文本框
			$('#ss').searchbox({ 
				//触发查询事件
				searcher:function(value,name){ //value表示输入的值
					//alert(value + "," + name)
					//获取当前查询的关键字，通过DataGrid加载相应的信息，使用load加载和显示第一页的所有行。
					//如果指定了参数，它将取代'queryParams'属性。通常可以通过传递一些参数执行一次查询，通过调用这个方法会向上面url指定的action去发送请求，从服务器加载新数据。
					$('#dg').datagrid('load',{
						name: value
					});

				}, 
				prompt:'请输入搜索关键字' 
			}); 
		});
	</script>
  </head>
  
  <body>
  	<form id="bg" name="fenye" action="${pageContext.servletContext.contextPath }/background/log/query.html" method="post">

         
  <td align="center">
  <!-- 这里的表单 name 必须是fenye -->
  	<div class="search_k" align="left">
		<fieldset class="search">
			
			<div class="search_content">
				用户名：<input type="text" name="username" value="${param.username}" style="height: 20px"/>　　
				模块：<input type="text" name="module" value="${param.module}" style="height: 20px"/>　
				<input type="submit" value="开始查询" class="input_btn_style1"/>&nbsp;&nbsp;
				<input type="reset" value="重置" class="input_btn_style1"/>
			</div>
		</fieldset>
	</div>
  </td>
  </tr>
  <tr>
    <td><table class="listtable" width="100%">
      <tr>
        <td width="8" background="${pageContext.servletContext.contextPath }/images/tab_12.gif">&nbsp;</td>
        <td><table class="ttab" width="100%" cellspacing="1" onMouseOver="changeto()"  onmouseout="changeback()">
          <tr>
 			<td width="5%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" ><span class="STYLE1">用户名</span></td>
            <td width="5%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" ><span class="STYLE1">模块</span></td>
            <td width="12%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" ><span class="STYLE1">执行操作</span></td>
            <td width="12%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" ><span class="STYLE1">花费时间</span></td>
            <td width="15%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">执行时间</td>
            <td width="15%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">用户ＩＰ</td>
            </tr>
          
          <c:forEach var="log" items="${pageView.records}">
          <tr>
            <td height="20" ><span class="STYLE1">${log.username}</span></td>
            <td height="20" ><span class="STYLE1">${log.module}</span></td>
            <td height="20" ><span class="STYLE1">${log.action}</span></td>
            <td height="20" ><span class="STYLE1">${log.actionTime}</span></td>
            <td height="20" ><span class="STYLE1">
            <fmt:formatDate value="${log.operTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </span></td>
			<td height="20" ><span class="STYLE1">${log.userIP}</span></td>
			</tr>
          </c:forEach>
        </table></td>
        <td width="8" background="${pageContext.servletContext.contextPath }/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" >    </td>
  </tr>
</table>
</form>
  	
  	
  </body>
</html>