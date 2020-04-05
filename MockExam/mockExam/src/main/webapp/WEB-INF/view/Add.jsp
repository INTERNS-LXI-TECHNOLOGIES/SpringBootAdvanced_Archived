<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body bgcolor="FloralWhite">
<style>
      body {
  background-image: url('78.png');
    background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 100%
}
.container {
  height: 700px;
  position: relative;
  border: 5px solid midnightblue;
}

.center {
  margin: 0;
  position: absolute;
  top: 50%;
  left: 30%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}

.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid #4CAF50;
  border-radius: 12px;
}

.button1:hover {
  background-color: #4CAF50;
  color: white;
}

input[type=text] {
  width: 230%;
  padding: 12px 20px;
  border: 2px solid red;
  border-radius: 4px;
}
</style>
<div class="container">
<div class="center">
    <div align="center">
        <font size="6" color="midnightblue"><i><b>Welcome to Add Page</b></i></font><br><br><br>
        <form:form action="save" method="post" modelAttribute="exam">
        <table>
            <form:hidden path="slno"/>
            <tr>
                <td><font size="5" color="midnightblue">Question : </font></td>
                <td><form:input path="qn" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">Option 1 : </font></td>
                <td><form:input path="opt1" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">Option 2 : </font></td>
                <td><form:input path="opt2" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">Option 3 : </font></td>
                <td><form:input path="opt3" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">Option 4 : </font></td>
                <td><form:input path="opt4" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">Ans : </font></td>
                <td><form:input path="ans" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" class="button button1" value="add"></td>
            </tr>
        </table>
        </form:form>
    </div>
    </div>
    </div>
</body>
</html>