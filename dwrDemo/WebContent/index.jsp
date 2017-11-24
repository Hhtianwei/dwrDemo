<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type='text/javascript' src='<%=path %>/dwr/engine.js'> </script>
<script type='text/javascript' src='<%=path %>/dwr/util.js'> </script>
<script type='text/javascript' src='<%=path %>/dwr/interface/helloService.js'> </script>
<script type="text/javascript" src="<%=path %>/jquery-1.10.0.js"></script>

<script type="text/javascript">
	
	$(function(){
		console.info("===========================");
		
		 dwr.engine.setActiveReverseAjax(true);
		
		$("#send").on("click",function(){
			var name = $("input[name='name']").val();
			///helloService.sayHi(name);
			
			
			/* var callMetaData = { 
					  callback:callback, 
					  arg: dataFromBrowser, // specify an argument to pass to the exeptionHandler
					  callbackArg: dataFromBrowser2, // overrides args will be passed to the callback
					  exceptionHandler: exceptionHandlerFunction
					}; */

			helloService.push(name, {
				callback:function(dataFromServer) {
					callback(dataFromServer);
				  }
			});
			
			$("input[name='name']").val("");
			
		});
	});
	
	function callback(msg){
		var $span = $("#msg");
		console.info("======"+$span.html()+"=====");
		if(msg != 'null'){
			$span.html(msg + "</br>" + $span.html());
		}
	}
	
</script>
<title>Insert title here</title>
</head>
<body>
this is index!

<br>
name:<input name="name" type="text"/><button id="send">send</button>
<br>

<br>

<br>
show:<span id="msg"></span>
<br>

<br>



</body>
</html>