<html>
    <body style="font-family: monospace">
        <h1>Random Number Generator</h1>
        <jsp:useBean id="rndno" type="rand.DSBean" scope="request" />
        These RANDOM numbers are generated by a Servlet(DSServlett) and passed on  to bean(DSBean) and rerouted to this JSP to get printed here
        <br><br>
        Number1 (X) : <jsp:getProperty name="rndno" property="number1"/><br>
        Number2 (Y) : <jsp:getProperty name="rndno" property="number2"/><br>
        <% try{
        double x=rndno.getNumber1();
        double y=rndno.getNumber2();
        if(y<x)
        { %>
        <h3>
        y is smaller
        </h3>
        <% } else { %>
        <h3>
        x is smaller
        </h3>
        <% }
        }
        catch(Exception e)
        {
        }
        %>
    </body>
</html>
