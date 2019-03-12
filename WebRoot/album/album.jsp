<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% pageContext.setAttribute("path", request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="dg2" style="width:600px;height:400px"></table>
	<!-- 专辑详情展示 -->
	<div id="dv1">
		<form id="for1" method="post">
			<table>
				<tr><td>名字：</td><td><input name="title" readonly/></td></tr>
				<tr><td>评分：</td><td><input name="score" readonly/></td></tr>
				<tr><td>播音：</td><td><input name="brodcast" readonly/></td></tr>
				<tr><td>作者：</td><td><input name="author" readonly/></td></tr>
				<tr><td>简介：</td><td><input name="brief" readonly/></td></tr>
				<tr><td>上架时间：</td><td><input name="publicTime" readonly/></td></tr>
				<tr><td>音频数量：</td><td><input name="count" readonly/></td></tr>
				<tr><td>封面：</td><td><img id="im1" width="150" height="150" src="" name="coverImg" /></td></tr>
				<tr><td>状态：</td><td><input name="status" readonly/></td></tr>
			</table>
		</form>
	</div>
	<!-- 添加专辑 -->
	<div id="dv2">
		<form id="for2" method="post" enctype="multipart/form-data">
			<table>
				<tr><td>名字：</td><td><input class="easyui-textbox" data-options="prompt:'请输入专辑名称',required:true" name="title"/></td></tr>
				<tr><td>评分：</td><td><input class="easyui-textbox" data-options="prompt:'请输入评分',required:true" name="score"/></td></tr>
				<tr><td>播音：</td><td><input class="easyui-textbox" data-options="prompt:'请输入播音姓名',required:true" name="brodcast"/></td></tr>
				<tr><td>作者：</td><td><input class="easyui-textbox" data-options="prompt:'请输入作者姓名',required:true" name="author"/></td></tr>
				<tr><td>简介：</td><td><input class="easyui-textbox" data-options="prompt:'请输入专辑简介',required:true" name="brief"/></td></tr>
				<tr><td>音频数量：</td><td><input class="easyui-numberbox" data-options="prompt:'请输入专辑中音频数量',required:true" name="count"/></td></tr>
				<tr><td>请选择一张图片：</td><td><input data-options="prompt:'请选择一个图片',required:true" type="file" name="upFile"/></td></tr>
				<tr><td>状态：</td><td><input class="easyui-textbox" data-options="prompt:'请输入专辑状态',required:true" name="status"/></td></tr>
			</table>
		</form>
	</div>
	<!-- 添加章节 -->
	<div id="dv3">
		<form id="for3" method="post" enctype="multipart/form-data">
			<table>
				<tr><td>名字：</td><td><input class="easyui-textbox" data-options="prompt:'请输入文件名',required:true" name="title"/></td></tr>
				<tr><td>请选择一个音频文件：</td><td><input  type="file" data-options="prompt:'请选择一个音频文件',required:true" name="upFile"/></td></tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
	$('#dg2').treegrid({    
	    url:'${path}/album/selectAll',    
	    idField:'id',    
	    treeField:'title',    
	    fitColumns:true,
	    fit:true,
	    pagination:true,
		pagePosition:"bottom",
		pageNumber:1,
		pageSize:5,
		pageList:[5,10,15,20,25],
	    columns:[[    
	        {field:'title',title:'名字',width:100},    
	        {field:'url',title:'下载路径',width:100,align:'right'},    
	        {field:'size',title:'章节大小',width:100},    
	        {field:'duration',title:'章节时长',width:100}    
	    ]],
	    toolbar: [{
	    	text:"专辑详情",
			iconCls: 'icon-tip',
			handler: function(){
				var s=$("#dg2").treegrid("getSelected");
				//初始化dialog
				if(s){
					if(s.status){
						$("#dv1").dialog({
							title:"专辑详情信息",
							width:500,
							height:350,
							modal:true,
							buttons:[
							         {
							        	 text:"关闭",
							        	 iconCls:"icon-cancel",
							        	 handler:function(){
							        		 $("#dv1").dialog("close");
							        		 //$("#dg2").datagrid("reload");
							        	 }
							         }
							         ]
						});
						//初始化form表单加载信息
						$("#for1").form("load",{
							title:s.title,
							score:s.score,
							brodcast:s.brodcast,
							author:s.author,
							brief:s.brief,
							publicTime:s.publicTime,
							count:s.count,
							status:s.status
						});
						$("#im1").prop("src","${path}/"+s.coverImg);
					}else{
						$.messager.alert("提示信息","请选中专辑","warning");
					}
				}
				else{
					$.messager.alert("提示信息","请选中专辑","warning");
				}
				
			}
		},'-',{
			text:"添加专辑",
			iconCls: 'icon-large-smartart',
			handler: function(){
				//初始化dialog
				$("#dv2").dialog({
					title:"添加专辑",
					width:500,
					height:350,
					modal:true,
					buttons:[
					         {
					        	 text:"提交",
					        	 iconCls:"icon-ok",
					        	 handler:function(){
					        		 $("#for2").submit();
					        	 }
					         }
					         ]
				});
				//初始化form表单
				$("#for2").form({
					url:"${path}/album/saveAlbum",
					onSubmit:function(){
						return $("#for2").form("validate");
					},
					success:function(){
						$("#dv2").dialog("close");
						$("#dg2").treegrid("reload");
					}
				});
			}
		},'-',{
			text:"添加章节",
			iconCls: 'icon-large-clipart',
			handler: function(){
				var s=$("#dg2").treegrid("getSelected");
				if(s){
					if(s.status){
						//初始化dialog
						$("#dv3").dialog({
							title:"添加章节",
							width:500,
							height:350,
							modal:true,
							buttons:[
							         {
							        	 text:"提交",
							        	 iconCls:"icon-ok",
							        	 handler:function(){
							        		 $("#for3").submit();
							        	 }
							         }
							         ]
						});
						//初始化form表单
						$("#for3").form({
							url:"${path}/chapter/saveChapter",
							queryParams:{
								"id":s.id
							},
							onSubmit:function(){
								return $("#for3").form("validate");
							},
							success:function(){
								$("#dv3").dialog("close");
								$("#dg2").treegrid("reload");
							}
						});
					}else{
						$.messager.alert("提示信息","请选择您所添加文件对应的专辑","warning");
					}
				}else{
					$.messager.alert("提示信息","请选择您所添加文件对应的专辑","info");
				}
			}
		},'-',{
			text:"下载音频",
			iconCls: 'icon-undo',
			handler: function(){
				var s=$("#dg2").treegrid("getSelected");
				if(s){
					if(s.album){
						download1(s.id);
						/* $.ajax({
							type:"post",
							data:"id="+s.id,
							url:"${path}/chapter/download",
							success:function(){
								$.messager.show({
									title:"提示信息",
									msg:"下载成功",
									timeout:5000,
									showType:"slide"
								});
							},
							error:function(){
								$.messager.alert("提示信息","下载失败","warning");
							}
						}); */
					}else{
						$.messager.alert("提示信息","请选中要下载的音频文件","warning");
					}
				}
				else{
					$.messager.alert("提示信息","请选中要下载的音频文件","warning");
				}
				
			}
		}]

	});
	function download1(id){
		window.location.href="${path}/chapter/download?id="+id;
	}
	</script>
</body>
</html>