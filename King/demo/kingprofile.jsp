<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>皇帝档案</title>
</head>
<body>
<a href="javascript:void()" onclick="go('../main')">回到首页</a>
<input id="obj" type="hidden" name="obj" value='<%=request.getAttribute("obj") %>' />
<li></li>
</body>
<script type="text/javascript" src="/King/js/jquery-compressed.js"></script>
<script type="text/javascript" src="/King/js/main.js"></script>
<script type="text/javascript">
var king = getJSONObject();
$.each(king,function(i,n){
	$('li').append("<ol>" + i + ": " + trimNull(n) + "</ol>");
});
</script>
</html>