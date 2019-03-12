<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <% pageContext.setAttribute("path", request.getContextPath()); %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link style="text/css" rel="stylesheet" href="${path }/css/themes/default/easyui.css"/>
		<link style="text/css" rel="stylesheet" href="${path }/css/themes/icon.css"/>
		<script type="text/javascript" src="${path }/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${path }/js/jquery.easyui.min.js"></script>
  </head>
  
  <body>
  
  <div id="dd">Dialog Content.</div>  
  
  
  <script type="text/javascript">
  	$(function(){
  		$('#dd').datagrid({    
  		    title: '用户管理',    
  		  fit:true, 
			remoteSort:false, 
			selectOnCheck:true, 
			nowrap:false, 
			fitColumns:true, 
			rownumbers:true,
			url:'${path }/user/findAll.do', 
  		  columns:[[ 
  					{field:'ck',checkbox:true,width:100},
  					{field:'photo',title:'头像',width:100}, 
  					{field:'dharmaName',title:'法名',width:100,sortable:true}, 
  					{field:'realname',title:'名字',width:100}, 
  					{field:'sex',title:'性别',width:100,align:'right',sortable:true,
  						/* formatter:function(value,row,index){
  							if(value==1){
  								return "男";
  							}else{
  								return "女";
  							} */
  					},
  					{field:'privoince',title:'省份',width:100}, 
  					{field:'city',title:'城市',width:100}, 
  					{field:'phoneNum',title:'手机号',width:100}, 
  					{field:'creatTime',title:'创建时间',width:100,align:'right',sortable:true}, 
  					{field:'status',title:'状态',width:100}, 
  					]],
  					toolbar:[
  					         {
	  					        text:'导出',
	  					        iconCls:'icon-redo',
	  					      	handler: function(){
	  					      	 location.href="${path}/user/findUser.do";
	  					      	
	  					      	}
  					         }
  					         ],
  					pagination:true,
  					pagePosition:"bottom",
  					pageNumber:1,
  					pageSize:5,
  					pageList:[5,10,15,20,25]
  		});
  		
  	});
  </script>
  
  </body>
</html>
