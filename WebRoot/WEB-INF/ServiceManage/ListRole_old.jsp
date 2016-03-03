<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html lang="en">
	<head>
		<title>Bootstrap Template</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
	<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>
	<body>
		<div class="container-fluid">
		  <div class="row-fluid">
			<div class="span9">
			  <div class="hero-unit">
				<!-- <h1></h1> -->
				<p>点击查看可以看到现有服务的基本信息</p>
				<form name="form1" action="" method="post">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>角色ID</th>
								<th>角色名</th>
								<th>角色描述</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="roles" status="L">
							<tr>
								<td><s:property value="roleId"/> </td>
								<td><s:property value="roleName"/></td>
								<td><s:property value="roleDesc"/></td>
								<td><a href="#" class="btn btn-primary">详情 &raquo;</a></td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
					<br>选择角色ID
					<select class="form-control" name="opt1" id="opt1">
						<s:iterator value="roles" status="L2">
							<option><s:property value="roleId"/></option>
						</s:iterator>
					</select>
					<br>
					<br>删除角色
					<button type="button" class="btn" onclick="changeValue(); form1.action='deleteRole.action'; form1.submit();">删除&raquo; </button>
					<input name="option1" type="hidden" value="" id="option1">
					<input name="option2" type="hidden" value="" id="option2">
				</form>
			  </div>
			</div><!--/span-->
		  </div><!--/row-->

		  <hr>

		</div><!--/.fluid-container-->
		
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="http://code.jquery.com/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script>
			function openWin()
			{
				window.open ('error.jsp', 'newwindow', 'height=100, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
			}
			function changeValue()
			{
				var selectIndex1 = document.getElementById("opt1").selectedIndex;
				document.getElementById("option1").value = document.getElementById("opt1").options[selectIndex1].text;
			}
		</script>
	</body>
</html>