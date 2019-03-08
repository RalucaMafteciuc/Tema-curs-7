<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
	<title>Home</title>
	<style>
		*, *:before, *:after {
			box-sizing: border-box;
		}
		.container {
			width: 600px;
			margin: 0 auto;
			font-family: Arial, sans-serif;
			font-size: 16px;
			padding: 30px;
		    border-radius: 5px;	
		    border: 1px solid #d1d5da;	
			box-shadow: inset 0 1px 2px rgba(27,31,35,.075);		    		
		}
		#usersContainer {
			margin:20px;
		}
		.btn {
		    background-color: #1277eb;
		    border: 1px solid #1277eb;		    
		    border-radius: 3px;
		    color: #fff;
		    cursor: pointer;
		    display: inline-block;
		    font-size: 16px;
		    font-weight: 500;
		    padding: 16px 24px;
		    transition: .2s;
		    vertical-align: middle;
		    width: 100%;
		    text-align: center;
		    text-decoration: none;
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>Welcome, ${IsVisitor}${username}!</h1>
		<a href="${ButtonPath}" class="btn">${ButtonText}</a> 
	</div>	
</body>
</html>