<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'diQu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main1" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        $(function(){
          /* myChart.setOption(option); */
           var myChart = echarts.init(document.getElementById('main1'));
        $.post('${pageContext.request.contextPath}/user/diTu.do',function(date){
      	  /* var myChart = echarts.init(document.getElementById('main1')); */
      	  option = {
      			    title : {
      			        text: 'iphone销量',
      			        subtext: '纯属虚构',
      			        left: 'center'
      			    },
      			    tooltip : {
      			        trigger: 'item'
      			    },
      			    legend: {
      			        orient: 'vertical',
      			        left: 'left',
      			        data:['iphone3']
      			    },
      			    visualMap: {
      			        min: 0,
      			        max: 100,
      			        left: 'left',
      			        top: 'bottom',
      			        text:['高','低'],           // 文本，默认为数值文本
      			        calculable : true
      			    },
      			    toolbox: {
      			        show: true,
      			        orient : 'vertical',
      			        left: 'right',
      			        top: 'center',
      			        feature : {
      			            mark : {show: true},
      			            dataView : {show: true, readOnly: false},
      			            restore : {show: true},
      			            saveAsImage : {show: true}
      			        }
      			    },
      			    series : [
      			        {
      			            name: 'iphone3',
      			            type: 'map',
      			            mapType: 'china',
      			            roam: false,
      			            label: {
      			                normal: {
      			                    show: false
      			                },
      			                emphasis: {
      			                    show: true
      			                }
      			            },
      			            data:date
      			        },
      			    ]
      			};
      	 
      	 myChart.setOption(option);
      	 
      	 },"json");
        });
        </script>
  </body>
</html>
