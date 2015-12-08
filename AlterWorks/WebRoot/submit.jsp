<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/submit.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<script>
window.onload=function(){
	var my_form=document.getElementById("my_form");
	var text=document.getElementById("text");
	my_form.onsubmit=function(){
		if(text.value){
			alert("提交成功!请在该路径:e:/文本框.txt下查看");
		}else{
			alert("请填写要提交的作业!");
		}
	}
			
}
</script>
<div class="wrap">
    <div class="header">
        <a><img src="./imges/logo1.png" width="180" height="100"/></a>
        <div class="name">
            <h2>作业提交系统</h2>
        </div>
        <div class="item">
        <% String login=(String)session.getAttribute("loginname");%>
            <ul>
                <li><a href="alterwork.html"><%=login%>|</a></li>
                <li><a href="login.jsp">退出</a></li>
            </ul>
        </div>
    </div>
    <hr/>
    <div class="content">
        <h1>请填写您要提交的作业</h1>
          <form action="SubmitServer.ao" method="post" id="my_form">
        <textarea rows="25" cols="80" class="text" id
        ="text" name="text"></textarea>
        <div class="submitwork">
        	<input type="hidden" name="method" value="write"/>
            <input type="submit" value="提交" />
            <input type="button" value="取消"/>
        </div>
        </form>
    </div>
    <div class="footer">
        <ul>
            <li>
                <a href="alterwork.html">©2015 Submit Work版权所有|</a>
            </li>
            <li>
                <a href="alterwork.html">开放平台|</a>
            </li>
            <li>
                <a href="alterwork.html">关于我们</a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>