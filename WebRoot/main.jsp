<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% pageContext.setAttribute("path", request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>持明法州APP后台管理系统</title>
	
		<link style="text/css" rel="stylesheet" href="${path }/css/themes/default/easyui.css"/>
		<link style="text/css" rel="stylesheet" href="${path }/css/themes/icon.css"/>
		<script type="text/javascript" src="${path }/js/echarts.min.js"></script>
		<script type="text/javascript" src="${path }/js/china.js"></script>
		<script type="text/javascript" src="${path }/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${path }/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${path }/js/datagrid-detailview.js"></script>
		<script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
		
		
</head>
<body class="easyui-layout" id="body">
	
	<div id="center" class="easyui-tabs" data-options="region:'center',split:true"></div>
	
	<div id="west" class="easyui-accordion" data-options="region:'west',split:true,title:'导航菜单'" style="width:15%">
		
	</div>
	<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:xxxxx &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${path }/admin/exit.do" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
	
	
	<script type="text/javascript">
	
	$(function(){
		//向后台请求菜单功能数据
		$.ajax({
			type:"post",
			url:"${path}/menu/selectAll",
			dataType:"json",
			success:function(rs){
				var west=$("#west");
				
				for(var i=0;i<rs.length;i++){
					if(rs[i].parentId==null){
							var html="";
							for(var j=0;j<rs[i].menuList.length;j++){
								//html+="<span data-options='fit:true'><a class='easyui-linkbutton' data-options='width:220' onclick=\"modifyLunBo('"+rs[i].menuList[j].title+"');\'>"+rs[i].menuList[j].title+"</a></span>";
								html+="<p style='text-align:center'><a href='#' onclick=\"modifyLunBo('"+rs[i].menuList[j].title+"','"+rs[i].menuList[j].href+"','"+rs[i].menuList[j].iconCls+"')\" class='easyui-linkbutton' data-options=\"iconCls:'icon-add'\">"+rs[i].menuList[j].title+"</a></p>";
								}
							west.accordion("add",{
								id:rs[i].id,
								title:rs[i].title,
								fit:true,
								content:html,
								iconCls:rs[i].iconCls,
							});
					}
				}
			},
			error:function(){
				alert("error");
			}
		});
	});
	
	//封装一个添加选项卡的方法
	function addTab(options){
		if(!$("#center").tabs("exists",options.title)){
			$("#center").tabs("add",options);
		}else{
			$("#center").tabs("select",options.title);
		}
	}
	//修改轮播图
	function modifyLunBo(title,href,iconCls){
		addTab({
			title:title,
			href:"${path}/"+href,
			iconCls:iconCls,
			closable:true
		});
	}		
		
	</script>
	
</body>
</html>