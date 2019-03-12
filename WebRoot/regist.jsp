<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<% pageContext.setAttribute("path", request.getContextPath()); %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style>
			.erro{
				color: red;
			}
			.ok{}
			.success{
				color: green;
			}
		</style>
	<link rel="icon" href="${path }/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${path }/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${path }/css/login.css" type="text/css"></link>
	<script type="text/javascript" src="${path }/script/jquery.js"></script>
	<script type="text/javascript" src="${path }/script/common.js"></script>
	<script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
				$(this).prop("src","${pageContext.request.contextPath }/ajax/Captcha.do?time="+new Date().getTime());
			});
			
			/* //  form 表单提交
			$("#loginForm").bind("submit",function(){
				alert("自己做");
				return false;
			}); */
			$("input").blur(function(){
				$(this).parent().find(".ok").remove();
				if($(this).is("#name")){
					if($(this).val()==""){
						$(this).parent().append("<span  class='erro ok'> 账号不能为空 </span>");
					}else{
						if($(this).val().length<1){
							$(this).parent().append("<span  class='erro ok'> 账号格式不正确 </span>");
						}else{
							var xhr;
						var email=$("#name").val();
						if(window.ActiveXObject){
							xhr= new ActiceXObject("Microsoft.XMLHTTP");
						}else{
							xhr=new XMLHttpRequest();
						}
						xhr.open("POST","${pageContext.request.contextPath}/ajax/findByName.do");
						xhr.setRequestHeader("ConTent-Type","application/x-www-form-urlencoded");
						xhr.send("name="+$("#name").val());
						xhr.onreadystatechange=function(){
							if(xhr.readyState==4 && xhr.status==200){
								var txt =xhr.responseText;
								$("#sp").html(txt);
							}
						} 
					}
				} 
			}
				if($(this).is("#password")){
					if($(this).val()==""){
						$(this).parent().append("<span  class='erro ok'> 密码不能为空 </span>");
					}else{
						if($(this).val().length<1){
							$(this).parent().append("<span  class='erro ok'> 密码不能小于六位 </span>");
						}else{
							$(this).parent().append("<span  class='success ok'> 密码可用</span>");
						}
					}
				}
				if($(this).is("#enCode")){
					if($(this).val()==""){
						$(this).parent().append("<span  class='erro ok'> 验证码不能为空 </span>");
						}else{
						 	 var xhr;
							var enCode=$("#enCode").val();
							if(window.ActiveXObject){
								xhr= new ActiceXObject("Microsoft.XMLHTTP");
							}else{
								xhr=new XMLHttpRequest();
							}
							xhr.open("POST","${pageContext.request.contextPath}/ajax/findByCode.do");
							xhr.setRequestHeader("ConTent-Type","application/x-www-form-urlencoded");
							xhr.send("enCode="+$("#enCode").val());
							xhr.onreadystatechange=function(){
								if(xhr.readyState==4 && xhr.status==200){
									var txt =xhr.responseText;
									$("#sp").html(txt);
								}
							} 
					} 
				}
			});
			$("form").submit(function(){
				$("input").trigger("blur");
				if($(".erro").length>0){return false;}
			});
		});
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/admin/zhuCe.do" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text"  name="name" id="name" class="text"  maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="password" id="password" class="text"  maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath }/ajax/Captcha.do" title="点击更换验证码"/><br/>
								<span id="sp"></span>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="注册">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>