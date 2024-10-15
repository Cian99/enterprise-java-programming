<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="UTF-8">
<title>Customer</title>

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

	<h1>Customer</h1>
	
	<table>
		<tr>
			<td>
				Customer Number
			</td>
			<td>
				Customer Name
			</td>
			<td>
				Phone
			</td>
			<td>
				Last Name
			</td>
			<td>
				First Name
			</td>
			<td>
				Address 1
			</td>
			<td>
				Address 2
			</td>
			<td>
				City
			</td>
			<td>
				State
			</td>
			<td>
				Postal Code
			</td>
			<td>
				Country
			</td>
			<td>
				Rep No.
			</td>
			<td>
				Credit Limit
			</td>
		</tr>
		<tr>
			<td>${customer.customerNumber} </td>
			<td>${customer.customerName} </td>
			<td>${customer.phone} </td>
			<td>${customer.contactLastName} </td>
			<td>${customer.contactFirstName} </td>
			<td>${customer.addressLine1} </td>
			<td>${customer.addressLine2} </td>
			<td>${customer.city} </td>
			<td>${customer.state} </td>
			<td>${customer.postalCode} </td>
			<td>${customer.country} </td>
			<td>${customer.salesRepEmployeeNumber} </td>
			<td>${customer.creditLimit} </td>
		</tr>
	</table>

</body>
</html>