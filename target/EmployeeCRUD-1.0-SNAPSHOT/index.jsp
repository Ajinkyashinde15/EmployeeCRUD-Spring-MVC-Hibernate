
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="angularjs.js"></script>
</head>
<body>

	<div ng-app ="">

		<p>Input something in the input box:</p>
		<p>
			Name: <input type="text" ng-model="name">
		</p>
		
		<p>
			hi : <input type="text" ng-model="pass">
		</p>

		<span ng-bind="pass"></span>
		<p ng-bind="name"></p>
	</div>

</body>
</html>