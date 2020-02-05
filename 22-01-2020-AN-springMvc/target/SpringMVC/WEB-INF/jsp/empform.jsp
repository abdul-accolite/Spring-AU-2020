<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<head>
	<style>
	   div{
	          text-align:center;
	          margin-top:200px;
	     }
	     form{
	        display:inline-block;
	     }
	     form input{
	        border-radius:4px solid black;
	     }
	     #button{
	           background-color: #4CAF50; /* Green */
			  border: none;
			  color: white;
			  padding: 15px 32px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 16px;
			  margin: 4px 2px;
			  cursor: pointer;
	     }
	</style>
</head>
<body>
<div>
		<h1>Add New Employee</h1>
       <form:form method="post" action="save">  
      	<table >  
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>Salary :</td>  
          <td><form:input path="salary" /></td>
         </tr> 
         <tr>  
          <td>Designation :</td>  
          <td><form:input path="designation" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input id="button" type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
</div>
</body>