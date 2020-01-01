<!DOCTYPE html>
<html lang="en">
<head>
<title>Matrix Admin</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
<form action="regaction" method="post"></form>
<%@page import="DAO.regDao,Bean.regbean,java.util.*,java.sql.*"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">Matrix Admin</a></h1>
</div>
<!--close-Header-part--> 

<!--sidebar-menu-->


<div id="content">
  <div id="content-header">
    <h3><a href="Registration.jsp" style="color:red">Add User</a></h3>
  </div>
  <div class="container-fluid">
  <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
		            <th>Id</th>
					<th>Name</th>
					<th>Address</th>
					<th>Contact</th>
					<th>Email</th>
					<th>Gender</th>
					<th>City</th>
					<th>Language</th>
					<th>Password</th>
					<th>Action</th>
                </tr>
              </thead>
             
         
           <%
           		int p=0,i=1;
				//System.out.println("from table tab");
				ArrayList<regbean> l = regDao.show();
		       //	System.out.println("from table tab");
				for(regbean db : l)
				{
					p=db.getId();
			%>
			 <tbody>
			<tr>
			   	<td><%=i++%></td>
				<td><%=db.getName()%></td>
				<td><%=db.getAddress()%></td>
				<td><%=db.getContact()%></td>
				<td><%=db.getEmail()%></td>
				<td><%=db.getGender()%></td>
				<td><%=db.getCity()%></td>
				<td><%=db.getLanguage()%></td>
				<td><%=db.getPassword()%></td>
			<td>	
			<a href="Delete_servlet"></a>
				 <a href="Delete_servlet?id=<%=p%>">Delete/</a>
				 <a href="update.jsp?id=<%=p%>">update</a>
				<!-- <a href="update?id=<%=p%>" onclick='javascript:windowsopen("update.jsp", "_blank", "height=600,width=500");' title='Pop Up'>Update</a>			
			--></td>
			</tr>
		          <%
		          } %>
			
             </tbody> 
            </table>
            
          </div>
        </div>
       
    </div>
  </div>
</div>
</div>
<script>
function windowsopen()
{
	window.open("Registration.jsp", "_blank", "height=600,width=500");
}
</script>
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/jquery.dataTables.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.tables.js"></script>
</body>
</html>
