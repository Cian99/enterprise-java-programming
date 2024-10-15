<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="UTF-8">
<title>All Customers</title>

<style>
		h1 {
			text-align: center;
		}
        /* Define CSS styles for the table */
        table {
            width: 100%;
            border-collapse: collapse;
        }
        
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        
        th {
            background-color: #f2f2f2;
        }
        
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        
        tr:hover {
            background-color: #ddd;
        }
    </style>

</head>
<body>

	<h1>Customers</h1>
	
	<table>
		<tr>
			<td>
				Customer Number
			</td>
			<td>
				&nbsp;&nbsp;
			</td>
			<td>
				Customer Name
			</td>
			<td>
				&nbsp;&nbsp;
			</td>
			<td>
				Phone
			</td>
			<td>
				&nbsp;&nbsp;
			</td>
			<td>
				Link
			</td>
		</tr>
		<c:forEach var="customer" items="${customers}">
			<tr>
				<td>${customer.customerNumber} </td>
				<td>&nbsp;</td>
				<td>${customer.customerName} </td>
				<td>&nbsp;</td>
				<td>${customer.phone} </td>
				<td>&nbsp;</td>
				<td><a href="/EEProgA4/GetOneCustServlet?custid=${customer.customerNumber}">More details</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>