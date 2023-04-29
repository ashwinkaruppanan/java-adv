<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tasks</title>
</head>
<body style="font-family: monospace">
    <div style="display: flex; justify-content: space-between; height: 500px">
    
    <div style="border-right: solid 2px black; padding-right: 10px;height: 150px ">
        <form action="/Ex4JSP/manage" method="post">
            <label>Select item here : </label>
            <SELECT name="task" style="font-family: monospace">
                <OPTION value="Programming in C"> Programming in C
                <OPTION value="Embedded System Programming"> Embedded System Programming
                <OPTION value="Algorithms and Problem Solving Methods"> Algorithms and Problem Solving Methods
                <OPTION value="Data Structures and Model Representation"> Data Structures and Model Representation
            </SELECT>
            <button style="font-family: monospace" type="submit" name="action" value="add">Add</button>
            <button style="font-family: monospace" type="submit" name="action" value="remove">Remove</button>
        </form>
    </div>
        <div style="width: 420px">
        <h2 >Your Cart</h2>
        <ul><%
            HashSet<String> tasks = (HashSet<String>) request.getAttribute("tasks");
            if (tasks != null) {
                for (String task : tasks) {
                %>
                <li>
                <%=task%>
                </li>
                <%
                }
            }
            %>
        </ul>
    </div>
    </div>
</body>
</html>