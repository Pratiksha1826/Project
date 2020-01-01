 
 
<jsp:useBean id="u" class="Bean.regbean"></jsp:useBean>  
 <jsp:setProperty property="*" name="u"/>  
<html lang="en">
<head>
<title>Registration _Page</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/colorpicker.css" />
<link rel="stylesheet" href="css/datepicker.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link rel="stylesheet" href="css/bootstrap-wysihtml5.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
<%@page import="java.util.*,DAO.*,Bean.*" %>
  
<% 
	System.out.println("in update.jsp page");
	String id =request.getParameter("id");
	regbean k =regDao.UpdateById(Integer.parseInt(id));
	System.out.println("after updatBYID  page");

	String gender =k.getGender();
	String city = k.getCity();
	String lang = k.getLanguage();


	%>  
<div id="content">
  <div class="row-fluid">
  <div class="span6">
     <div class="widget-box">
      
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Registration Form</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="update" method="post" class="form-horizontal">
           <div class="control-group">
              <label class="control-label">Id</label>
              <div class="controls">
                <input type="text" class="span11" name="id"  value="<%=k.getId()%>"/>
              </div>
            </div>
            
            <div class="control-group">
              <label class="control-label">Name</label>
              <div class="controls">
                <input type="text" class="span11" name="name" value="<%=k.getName()%>" />
              </div>
            </div>
            
              <div class="control-group">
              <label class="control-label">Address</label>
              <div class="controls">
                <textarea class="span11" name="address"><%=k.getAddress()%></textarea>
              </div>
            </div>
            
             <div class="control-group">
                <label class="control-label">Contact</label>
                <div class="controls">
                  <input type="text" name="contact" value=<%=k.getContact()%> />
                </div>
            </div>
      		 <div class="control-group">
                <label class="control-label">Email</label>
                <div class="controls">
                  <input type="text" name="email" id="email" value=<%=k.getEmail()  %>/>
                </div>
              </div>
            
            
            <div class="control-group">
              <label class="control-label">Gender</label>
              <div class="controls">
                <label>
                  <input type="radio" <%= gender.contains("Male") ? "checked" : ""%>name="gender" value="Male"/>
      				Male</label>
                <label>
                  <input type="radio"<%= gender.contains("female") ? "checked" : ""%>  name="gender" value="female"/>
                  Female</label>
              </div>
            </div>
           
        
   
            <div class="control-group">
              <label class="control-label">city</label>
              <div class="controls">
                <select  name="city">
                  <option><%=city%></option>
                  <option>Pune</option>
                  <option>Nashik</option>
                  <option>Amravati</option>
                  <option>kolhapure</option>
                  <option>Satara</option>
                  <option>Mumbai</option>
                  <option>Sangali</option>
                </select>
              </div>
            </div>
          
         
            <div class="control-group">
            <label class="control-label">Language</label>
              <div class="controls">
                <label>
                  <input type="checkbox" name="language" value="english"/>
                  English</label>
                <label>
                  <input type="checkbox" name="language"  value="hindi"/>
                  Hindi</label>
                <label>
                  <input type="checkbox" name="language" value="marathi"/>
                  Marathi</label>
              </div>
               <%
           		String[] la = request.getParameterValues("language");
             
           		if(la != null && la.length != 0)
           		{
           			System.out.println("you have select data");
           			for(int i=0;i<la.length;i++)
           			{
           				System.out.println("data selected:"+la[i]);
           			}
           		}
           		%>
            </div>
            
            <div class="control-group">
                  <label class="control-label">Password</label>
                  <div class="controls">
                    <input type="password"  name="pwd" id="pwd" value=<%=k.getPassword() %>/>
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label">Confirm password</label>
                  <div class="controls">
                    <input type="password" name="pwd2" id="pwd2" />
                  </div>
                </div>
            
             <div class="form-actions">
         	<a href="formtab.jsp"><button type="Submit" class="btn btn-success">Update</button></a>
         	
           	<input type="button" class="btn btn-success"  value="Show" />
  
            
            </div>
            
           </form>
          
        </div>
      </div>
    </div>        
          </div></div> 
<!--end-Footer-part--> 
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/bootstrap-colorpicker.js"></script> 
<script src="js/bootstrap-datepicker.js"></script> 
<script src="js/jquery.toggle.buttons.js"></script> 
<script src="js/masked.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.form_common.js"></script> 
<script src="js/wysihtml5-0.3.0.js"></script> 
<script src="js/jquery.peity.min.js"></script> 
<script src="js/bootstrap-wysihtml5.js"></script> 
<script>
	$('.textarea_editor').wysihtml5();
</script>
</body>
</html>
