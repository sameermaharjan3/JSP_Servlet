<%--
  Created by IntelliJ IDEA.
  User: sameer
  Date: 2/2/2020
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Number Quiz</title>
</head>
<body>
<form method="post" action="quiz">
    <h2><b>The Number Quiz</b></h2>
    <p>Your current score is ${score}</p>
    <p>Guess the next number in the sequence</p>
    ${question}
    <br/>
    <br/>
    Your Answer: <input type="text" name="answer">
    <br/>
    <br/>
    <input type="SUBMIT">
</form>
</body>
</html>
