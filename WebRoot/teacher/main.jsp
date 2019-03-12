<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${path}/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="${path}/themes/IconExtension.css">   
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>   
<script type="text/javascript" src="${path}/js/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="${path}/js/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	<!--菜单处理-->
	$(function(){
		//发送请求
        $.getJSON(
            "${path}/menu/selectAll",
            //拿到集合对象
            function (res) {
            	console.log(res);
                    //遍历集合对象和
                    $.each(res,function (i,c) {
                        var content="<div style='text-align: center'>";
                        //遍历二级标签
                        $.each(c.meuns,function (j,cc) {
                            var s = JSON.stringify(cc);
                            content+="<div onclick='addAccordionTabs("+s+")' data-options=\"plain:true,iconCls:"+cc.conCls+"\" style='width:96%;margin: 3px 0px 3px 0px;border: 1px #95B8E7 solid;' class='easyui-linkbutton'>"+cc.title+"<br/></div>";
                        }); 
                        content+="</div>";
                        //调用空间的添加方法
                        $("#acc").accordion("add",{
                            title:c.title,
                            content:content
                        });
                    });
                }
        );
		
   
	});
		function addAccordionTabs(s){
			//当面板不存在时
            if(!$("#tabs").tabs("exists",s.title)){
                $("#tabs").tabs("add",{
                    title: s.title,
                    iconCls: s.conCls,
                    closable:true,
                    href:"${pageContext.request.contextPath}/"+s.href
                });
            }else{
                $("#tabs").tabs("select",s.title);
            }
		}
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:xxxxx &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <!-- 菜单栏 -->   
    <div region="west" split="true" title="导航菜单" style="width: 200px;">
        <div id="acc" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
        </div>
    
    
    <div data-options="region:'center'">
    	<div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>