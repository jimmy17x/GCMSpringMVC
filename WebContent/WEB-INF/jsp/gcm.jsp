<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Google Cloud Messaging (GCM) Server in PHP</title>
</head>
<body>

	<h1>Google Cloud Messaging (GCM) Server in Java</h1>
	<form:form method="POST" action="/GCM/sendMessage">

		<table>
			<tr>
				<td><form:label path="regId">Device registration id</form:label></td>
				<td><form:input path="regId" /></td>
			</tr>
			<tr>
				<td><form:label path="message">Message</form:label></td>
				<td><form:input path="message" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="Send Push Notification via GCM" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>