<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/includes/header.html" />
<body>
    <h1>Thanks for joining our email list</h1>
    <p>Here is the information that you entered:</p>
    <table cellspacing="5" cellpadding="5" border="1">
        <tr>
            <td align="right">First name:</td>
            <td><c:out value="${cart.totalPrice}"/></td>
        </tr>
        <tr>
            <td align="right">Last name:</td>
            <td><c:out value=""/></td>
        </tr>
        <tr>
            <td align="right">Email address:</td>
            <td><c:out value="" /></td>
        </tr>
    </table>
    <p> emails registered </p>
  

        <p> my email: ${initParam.custServEmail}<br>
        </p>
        <p>To enter another email address, click on the Back <br>
            button in your browser or the Return button shown <br>
            below.</p>
        <form action="index.jsp" method="post">
            <input type="submit" value="Return">
        </form>
        <p> ${requestScope.currentDate}<br> </p>
        <jsp:include page="/includes/footer.jsp" />