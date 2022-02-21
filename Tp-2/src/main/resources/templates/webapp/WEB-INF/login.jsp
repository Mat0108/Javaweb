<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<html>
	<body>
		<h1 id="banner">Login sping boot personnalisé</h1>
		<form name="f" action="j_spring_security_check" method="POST">
			<table>
				<tr>
					<td>Username:</td>
					<td><input type='text' name='j_username' /></td>
				</tr>
				<tr>
					 <td>Password:</td>
					 <td><input type='password' name='j_password'></td>
				 </tr>
				 <tr>
					 <td colspan="2">&nbsp;</td>
				 </tr>
				 <tr>
					 <td colspan='2'><input name="submit" type="submit">&nbsp;<input name="reset" type="reset"></td>
				 </tr>
			 </table>
		</form>
	 </body>
 </html>