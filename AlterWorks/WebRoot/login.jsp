<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<script type="text/javascript">
	window.onload  = function(){
		var form = document.getElementById("my_form");
		var error = document.getElementById("error");
		form.onsubmit = function(){
			var login_name = document.getElementById("login_name");
			if(!login_name.value){
				error.innerHTML = "用户名不能为空!";
				return false;
				}
			var login_pass = document.getElementById("login_pass");
			if(!login_pass.value){
				error.innerHTML = "密码不能为空!";
				return false;
			}
		}	
	}
</script>
<div class="wrap">
    <div class="header">
        <a><img src="./imges/logo1.png" width="180" height="120"/></a>
        <div class="name">
             <h2>作业提交系统</h2>
        </div>
    </div>
    <div class="content">
        <div class="form">
            <form action="LoginServer.ao" method="post" id="my_form">
               <h1>用户登录</h1>
                <hr/>
                 <div class="error" id="error">
                 <%=request.getAttribute("error")==null?"":request.getAttribute("error")%>
                 </div>
                <div class="username">
                <input type="hidden" name="method" value="login"/>
                    用户名:<input type="text" value="" name="username" id="login_name" onhover="hovers"/>
                </div>
                <div class="pass">
                    密&nbsp;码:<input type="password" value="" name="password" id="login_pass"/>
                </div>
                <div><input type="submit" value=""/></div>
            </form>
        </div>
    </div>
    <div class="footer">
    </div>
</div>
</body>
</html>