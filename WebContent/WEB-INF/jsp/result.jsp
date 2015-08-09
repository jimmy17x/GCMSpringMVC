<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC GCM</title>
</head>
<body>

<h2>GCM result</h2>
   <table>
    <tr>
        <td>Push Status</td>
        <td>${status}</td>
    </tr>
    <tr>
        <td>Message</td>
        <td>${message}</td>
    </tr>
    <tr>
        <td>Device id</td>
        <td>${id}</td>
    </tr>
    
</table>  
</body>
</html>