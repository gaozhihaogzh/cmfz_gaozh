<%@page pageEncoding="utf-8" %>
<% pageContext.setAttribute("path", request.getContextPath()); %>
<!DOCTYPE HTML>

<html>
	<head>
		<link style="text/css" rel="stylesheet" href="${path }/css/themes/default/easyui.css"/>
		<link style="text/css" rel="stylesheet" href="${path }/css/themes/icon.css"/>
		<script type="text/javascript" src="${path }/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${path }/js/jquery.easyui.min.js"></script>
	</head>
	<body class="easyui-layout" id="body">
		<div id="center" class="easyui-tabs"  data-options="region:'center',split:true"></div>
		
		<div class="easyui-accordion" data-options="region:'west',split:true,title:'导航菜单'" style="width:15%">
			<div data-options="title:'用户管理',fit:true"></div>
			<div data-options="title:'商品管理',selected:true,fit:true" style="text-align:center;">
				<span data-options="fit:true">
					<a class="easyui-linkbutton" data-options="plain:true,width:220" onclick="showAllProducts();">展示所有商品</a>
				</span>
			</div>
			<div data-options="title:'类别管理',fit:true"></div>
		</div>
		
		<div data-options="region:'south',split:true,noheader:true,title:'南'" style="height:7%;text-align:center;background:skyblue;">©注册信息0000-0000</div>
		
		<div data-options="region:'north',split:true,noheader:true" style="height:10%;text-align:center;background:skyblue;" >
			<span style="position:absolute;bottom:2px;left:30%;font-family:楷体;font-weight:bold;font-size:36px;">小商品后台管理系统</span>
			<span style="position:absolute;bottom:2px;right:10px;">
				<span>欢迎${sessionScope.user.username} |</span>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'修改密码'" onclick="modifyPassword();"></a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-back',text:'退出登录'" href="${path }/user/logout"></a>
			</span>
		</div>
		
		<!-- 登录  -->
		<div id="log">
			<form id="login" method="post">
				用户名：<input class="easyui-textbox" name="username" data-options="required:true,prompt:'请输入用户名'"/><br/>
				密码：&nbsp;<input class="easyui-passwordbox" name="password" data-options="required:true,prompt:'请输入密码'"/>
			</form>
		</div>
		
		<!-- 修改密码  -->
		<div id="modi">
			<form id="modify" method="post">
				原密码:<input class="easyui-passwordbox" name="password" data-options="required:true,prompt:'请输入原密码'"/><br/>
				新密码:<input class="easyui-passwordbox" name="repassword" data-options="required:true,prompt:'请输入新密码'"/>
			</form>
		</div>
		
		<script type="text/javascript">
			$(function(){
			
			
			//修改密码的事件
			function modifyPassword(){
				//初始化修改密码的form表单
				$("#modify").form({
					url:"${path}/user/modifyPassword",
					onSubmit:function(){
						return $("#modify").form("validate");
					},
					success:function(r){
						if(r=="ok"){
							$("#modi").dialog("close");
							$.messager.alert("提示","修改成功","info");
						}else{
							$.messager.alert("提示","修改失败","warning");
						}
					}
				});
				//初始化修改密码的dialog
				$("#modi").dialog({
					title:"修改密码",
					width:500,
					height:300,
					modal:true,
					buttons:[
					         {
					        	 text:"提交",
					        	 iconCls:"icon-ok",
					        	 handler:function(){
					        		 $("#modify").submit();
					        	 }
					         }
					         ]
				});
			}
			
			});
			//展示所有商品的事件
			function showAllProducts(){
				addTab({
					title:"所有商品信息",
					href:"${path}/product.jsp",
					closable:true
				});
			}
			
			
			//封装一个添加选项卡（tabs）的方法
			function addTab(options){
				if(!$("#center").tabs("exists",options.title)){
					$("#center").tabs("add",options);
				}else{
					$("#center").tabs("select",options.title);
				}
			}
			
		
			
			
		</script>
		
		
	</body>
</html>