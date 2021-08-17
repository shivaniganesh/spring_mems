<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
<title>Insert title here</title>
</head>
<body>

<form action="update" method="get">
		<div class="form-row">

			<div class="form-group">
				<label for="lbleid">Employee ID </label> 
				<input type="text" class="form-control" id="lbleid" name="eid" value="">
					
			</div>
			<div class="form-group">
				<label for="lblfname">First Name </label> 
				<input type="text" class="form-control" id="lblfname" name="fname" value="">
					
			</div>
			<div class="form-group">
				<label for="lbllname">Last Name </label> 
				<input type="text" class="form-control" id="lbllname" name="lname" value="">
					
			</div>
			<div>
				<label for="lblgender">Gender </label> <br/>
				<div class="form-check-inline">
				
				<label class="form-check-label" for="lblrdmale"> Male </label>
				<input class="form-check-input" type="radio" name="gender" id="gender" value="Male" checked> 
			
				<label class="form-check-label" for="lblrdfemale"> Female </label>
				<input class="form-check-input" type="radio" name="gender" id="gender" value="Female"> 
			</div>
			</div>
			
			<div class="form-group">
				<label for="lblemail">Email</label> 
				<input type="email" class="form-control" id="lblemail" name="email" value=""
					placeholder="Enter Email" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="lblpassword">Password</label> 
				<input type="password" class="form-control" id="lblpassword" name="password" value="">
			</div>
		</div>
		<button type="submit" value="update" class="btn btn-primary">UPDATE EMPLOYEE</button>
	
	</form>

</body>
</html>