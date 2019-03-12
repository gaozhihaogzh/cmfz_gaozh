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
    
    <title>My JSP 'zhuCeTime.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->     
	<div id="main" style="width: 600px;height:400px;"></div>
	<script type="text/javascript">
	$(function(){
		   // 基于准备好的dom，初始化echarts实例
	    var myChart = echarts.init(document.getElementById('main'));
		 var goEasy = new GoEasy({
				appkey: 'BC-afb5d4858ff74c5abc85b7bbeeb067fc'
			});
		goEasy.subscribe({
			channel:'demo_channel',
			onMessage: function(message){
			var a=JSON.parse(message.content);
			myChart.setOption({
				 series: [{
		                name: '男',
		                type: 'bar',
		                data: a.man
		            },{
		                name: '女',
		                type: 'bar',
		                data: a.woman
		            }]
			});
			}
			});
	 
	    $.post("${pageContext.request.contextPath}/user/registTime.do",function(data){
	        // 指定图表的配置项和数据
	        	option = {
	            title: {
	                text: '2018年每月注册人数统计'
	            },
	            tooltip: {},
	            legend: {
	                data:['男','女'],
	            },
	            xAxis: {
	                data: data.mm
	            },
	            yAxis: {},
	            series: [{
	                name: '男',
	                type: 'bar',
	                data: data.man
	            },{
	                name: '女',
	                type: 'bar',
	                data: data.woman
	            }]
	        };
	        // 使用刚指定的配置项和数据显示图表。
	        myChart.setOption(option);
	    },"json");
	   
	});
    </script> 
  </body>
</html>
