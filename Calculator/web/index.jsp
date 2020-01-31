<%--
  Created by IntelliJ IDEA.
  User: 610537
  Date: 1/30/2020
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Simple Calculator</title>
</head>
<body>

<h1>Simple Calculator</h1>
<hr />
<form method='post' action='Calculator'>

  <input type='text' value='${num1}' name='numOne' > +
  <input type='text' value='${num2}' name='numTwo' > =
  <input type='text' value="${sumResult}" disabled>

  <br /><br />
  <input type='text' value='${num3}' name='numThree' > *
  <input type='text' value='${num4}' name='numFour' > =
  <input type='text' value='${productResult}' disabled>
  <br /><br />
  <input type='submit' name='btnSubmit' value='Submit'/>
</form>

<p>${result}</p>
</body>
</html>
