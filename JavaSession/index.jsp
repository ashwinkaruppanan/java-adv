<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="core.bean.SessBean" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>    
    <body style="font-family: monospace">
    <center>    
        <h1>Session Data Sharing through MVC</h1>
        <form action="/Ex8/Hit">
            <table style="border: solid 2px black; border-radius: 4px">
                <tr>
                    <td>First Name :</td>
                    <td>
                        <input title="user name" type="text" name="t1" >
                    </td>
                </tr>
                <tr>
                    <td>Last Name  &nbsp;:</td>
                    <td>
                        <input type="text" name="t2" title="Expand Initials" >
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input style="font-family: monospace" type="SUBMIT" name="t3" VALUE="Observe" title="TO SUBMIT CLICK HERE" >
                    </td>
                </tr>
            </table>
            <br>
            <div style="text-align: left; display: inline-block">
                <b>Note:</b> <br><br>1. Run the application by simply clicking observe <font
                    color="red">without giving names</font><br>
                2. Run the application by clicking observe giving <font color="red">first
                name alone</font><br>
                3. Run the application by clicking observe giving <font
                    color="red">second name and clear first name</font> 
            </div>
        </form><br><br>
        <%         
            SessBean sbeen = (SessBean) request.getSession().getAttribute("NB");
            if(sbeen.getName1() == "" && sbeen.getName2() == "") {
        %> 
        <p style="color: red"> Enter the valid name. </p>
        <% } else if (sbeen.getName1() != "" && sbeen.getName2() == ""){ %>
        <p>Hi <%= sbeen.getName1() %> </p>
        <% } else if (sbeen.getName2() != "" && sbeen.getName1() == ""){ %>
        <p>Enter your first name</p>
        <%
            } else {
        %> <p> Hi <%= sbeen.getName1() %> <%= sbeen.getName2() %> </p> <%
            }
            HttpSession sion = request.getSession();
            sion.invalidate();
        %>
    </center>
</body>
</html>
