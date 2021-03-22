<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <script src="scriptForSignIn.js"></script>
</head>
<body>
<div id="org_div1"> </div>
<p>
Login: <br>
<label>
    <input id = "input1" type="text" size="40">
</label>
</p>

<p>
    Password: <br>
    <label>
        <input type="text" size="40">
    </label>
</p>

<p>
    Confirmation password: <br>
    <label>
        <input type="text" size="40">
    </label>

</p>

<button onclick="onButtonSignInClick()">Sign In</button>
</body>
