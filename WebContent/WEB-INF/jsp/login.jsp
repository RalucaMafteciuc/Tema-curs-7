<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
	<title>Login</title>
	<style>
		*, *:before, *:after {
			box-sizing: border-box;
		}
		.form-container {
			width: 600px;
			margin: 0 auto;
			font-family: Arial, sans-serif;
			font-size: 16px;
			padding: 30px;
		    border-radius: 5px;	
		    border: 1px solid #d1d5da;	
			box-shadow: inset 0 1px 2px rgba(27,31,35,.075);		    		
		}
		.form-container .form-group {
			margin:15px 0;
		}
		.form-container .form-label {
		    display: block;
		    font-size: 14px;
		    font-weight: inherit;
		    margin-bottom: 5px;
		    text-align: left;
		    color: #586069;
		}
		.form-container .form-control {
			display: block;
		    border-radius: 5px;
		    font-size: 16px;
		    min-height: 46px;
		    padding: 10px;
		    width: 100%;
		    padding-right: 30px;
		    margin-right: 5px;
		    max-width: 100%;
		    border: 1px solid #d1d5da;	
			box-shadow: inset 0 1px 2px rgba(27,31,35,.075);
			vertical-align: middle;
			outline: none;	    	    		    
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
		.form-container span.error {
			color: red;
			font-size: 12px;
		}		
		.btn-form {
		    background-color: #2ebc4f;
		    border: 1px solid #2ebc4f;
		}
		p {
			text-align:center;
		}
	</style>
</head>
<body>
	<div class="form-container">
		<form method="post" accept-charset="UTF-8">  
			<div class="form-group">         
				<label class="form-label" for="username">Username</label>
	            <input type="text" name="username" id="username" class="form-control">          
	   		</div>   
			<div class="form-group">         
				<label class="form-label" for="password">Password</label>
	            <input type="password" name="password" id="password" class="form-control">	            
	   		</div>
            <span class="error">
            	${LoginError}
            </span>   		
	   		<button class="btn btn-form" type="submit">Login</button>
		</form>         
	</div>	
</body>
</html>