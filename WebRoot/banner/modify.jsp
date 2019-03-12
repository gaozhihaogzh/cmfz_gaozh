<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% pageContext.setAttribute("path", request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<link style="text/css" rel="stylesheet" href="${path }/css/themes/default/easyui.css"/>
		<link style="text/css" rel="stylesheet" href="${path }/css/themes/icon.css"/>
		<script type="text/javascript" src="${path }/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${path }/js/jquery.easyui.min.js"></script>
</head>
<body>
	<table id="dg1" class="easyui-datagrid"></table>
	
	<!-- 修改 -->
	<div id="edi1">
			<form id="edit1" method="post">
				标题：<input class="easyui-textbox" data-options="prompt:'请输入标题',required:true" name="title" id="title1"/><br/>
				描述信息：<input class="easyui-numberbox" data-options="prompt:'请输入描述信息',required:true" name="description" id="description1"/><br/>
			</form>
		</div>
		<!-- 添加 -->
		<div id="ad1">
			<form method="post" id="add1" enctype="multipart/form-data">
				<table>
					<tr>
						<td>标题：</td><td><input class="easyui-textbox" data-options="prompt:'请输入标题',required:true" name="title" id="title1"/></td>
					</tr>
					<tr>
						<td>描述信息：</td><td><input class="easyui-textbox" data-options="prompt:'请输入描述信息,required:true" name="description" id="description1"/></td>
					</tr>
					<tr>
						<td>商品图片:</td><td><img src="" /></td>
					</tr>
					<tr>
						<td><input type="file" name="upFile" data-options="required:true" /></td>
					</tr>
				</table>
			</form>
		</div>
	<script type="text/javascript">
	$(function(){
		$('#dg1').datagrid({ 
			title:'轮播图管理', 
			fit:true, 
			remoteSort:false, 
			selectOnCheck:true, 
			nowrap:false, 
			fitColumns:true, 
			rownumbers:true,
			url:'${path}/banner/selectAll', 
			columns:[[ 
			{field:'ck',checkbox:true,width:100},
			{field:'title',title:'名称',width:100}, 
			{field:'description',title:'描述',width:100,sortable:true}, 
			{field:'status',title:'状态（是否为轮播状态）',width:100,align:'right',sortable:true,
				formatter:function(value,row,index){
					if(value==1){
						return "轮播";
					}else{
						return "未轮播";
					}
			}}, 
			{field:'createTime',title:'上传时间',width:80,align:'right',sortable:true}, 
			{field:'xz',title:'操作',width:100,sortable:true,
				formatter:function(value,row,index){
					if(row.status==0){
						return "<a href='javascript:void(0)' onclick=\"modifyStatusYes('"+row.id+"');\">选中为轮播图</a>";
					}else{
						return "<a href='javascript:void(0)' onclick=\"modifyStatusNo('"+row.id+"');\">撤销</a>";
					}
				}	
			},
			/* {field:'cx',title:'撤销轮播状态',width:100,sortable:true,
				formatter:function(value,row,index){
					if(row.status==1){
						return "<a href='javascript:void(0)' onclick=\"modifyStatusNo('"+row.id+"');\">撤销</a>";
					}else{
						return "未轮播";
					}
				}	
			} */
			]], 
			toolbar:[
			{
				text:"添加",
				iconCls:"icon-add",
		  		handler:function(){
		  			//初始化dialog
				$("#ad1").dialog({
					title:"添加",
					width:500,
					height:350,
					buttons:[
					         {
					        	 text:"提交",
					        	 iconCls:"icon-ok",
					        	 handler:function(){
					        		 $("#add1").submit();
					        	 }
					         }
					         ]
				});
		  			//初始化form表单
		  			$("#add1").form({
		  				url:"${path}/banner/saveBanner",
		  				onSubmit:function(){
		  					return $("#add1").form("validate");
		  				},
		  				success:function(){
		  					$("#ad1").dialog("close");
		  					$("#dg1").datagrid("reload");
		  					$.messager.alert("提示信息","添加成功","info");
		  				}
		  			});
			 }	
			},
			{
				text:"删除",
				iconCls:"icon-remove",
			 	handler:function(){
				var ch=$("#dg1").datagrid("getSelections");
				if(ch.length!=0){
					var checks=new Array();
					for(var i=0;i<ch.length;i++){
						checks.push(ch[i].id);
					}
					var json=JSON.stringify(checks);
					$.ajax({
						url:"${path}/banner/deleteSome",
						data:json,
						type:"post",
						contentType:"application/json",
						success:function(){
							$("#dg1").datagrid("reload");
						},
						error:function(){
							$.messager.alert("提示信息","删除失败","warning");
						}
					});
				}else{
					$.messager.alert("提示信息","请选中至少一条数据","warning");
				}
			 }	
			},
			{
				text:"修改",
				iconCls:"icon-edit",
			 	handler:function(){
				var s=$("#dg1").datagrid("getSelected");
				if(s){
					$("#edit1").form({
						url:"${path}/banner/modifyBanner",
						queryParams:{"id":s.id},
						onSubmit:function(){
							return $("#dg1").form("validate");
						},
						success:function(){
							$("#edi1").dialog("close");
							$("#dg1").datagrid("reload");
						}
					});
					$("#edit1").form("load",{
						title:s.title,
						description:s.description
					});
					$("#edi1").dialog({
						title:"编辑",
        				width:500,
        				height:350,
        				closable:true,
        				modal:true,
        				buttons:[
        				         {
        				        	 text:"提交",
        				        	 iconCls:"icon-ok",
        				        	 handler:function(){
        				        		 $("#edit1").submit();
        				        	 }
        				         }
        				         ]
					});
				}else{
					$.messager.alert("提示信息","请选中一条信息","warning");
				}
			 }	
			}
			       ],
			view:detailview,
			detailFormatter: function(rowIndex, rowData){ 
				console.log(rowData);
			if(rowData.status==0){
				return '<table><tr>' + 
				'<td rowspan=2 style="border:0"><img src="${path}/'+rowData.img_path+'" style="height:50px;"></td>' + 
				'<td style="border:0">' + 
				'<p>Status: 未轮播</p>' + 
				'</td>' + 
				'</tr></table>';
			}else{
				return '<table><tr>' + 
				'<td rowspan=2 style="border:0"><img src="${path}/'+rowData.img_path+'" style="height:50px;"></td>' + 
				'<td style="border:0">' + 
				'<p>Status: 轮播中</p>' + 
				'</td>' + 
				'</tr></table>'; 
			}
			},
			pagination:true,
			pagePosition:"bottom",
			pageNumber:1,
			pageSize:5,
			pageList:[5,10,15,20,25]
			});
	});
	

	//修改轮播状态为yes
	function modifyStatusYes(id){
		$.ajax({
			url:"${path}/banner/modifyStatusYes",
			data:"id="+id,
			type:"POST",
			success:function(r){
				//alert(r=="ok");
				//if(r=="ok"){
					$("#dg1").datagrid("reload");
				/* }else{
					$.messager.alert("提示信息","修改失败","warning");
				} */
			}
		});
	}
	//修改轮播状态为no
	function modifyStatusNo(id){
		$.ajax({
			url:"${path}/banner/modifyStatusNo",
			data:"id="+id,
			type:"POST",
			success:function(r){
				//alert(r=="ok");
 				//if(r=="ok"){
					$("#dg1").datagrid("reload");
				/* }else{
					$.messager.alert("提示信息","修改失败","warning");
				} */
			}
		});
	}
	
	</script>
</body>
</html>