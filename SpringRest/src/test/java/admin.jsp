<%! String uname; %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>E-Care Help desk</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body> 
	<div class="navbar navbar-static-top" id="topBar">
        <div id="header" class="col-xs-10">
            <h1>E-Care Help desk</h1>
        </div>
        <div class="col-xs-2" id="welcomeBox">
            <%
                HttpSession sess = request.getSession(false);
                if(sess!=null)
                {
                    uname = (String)sess.getAttribute("username");
                    
                }
                else
                {
                    out.println("Please login");
                    request.getRequestDispatcher("login.html").include(request, response);
                }
            %>
            <h4>Welcome <%=uname %>!</h4>
        	<p><a href="logout.jsp">Logout</a></p>
        </div>
    </div>
	<div class="container">
    	<div class="col-sm-3" id="verticalNav">
            <ul class="nav nav-pills nav-stacked">
              <li><a href="getReport.jsp">View Reports</a></li>
              <li><a href="giveSolution.jsp">Give Solutions</a></li>
             
              
            </ul>
		</div>  
            <div class="col-sm-9 grayBg">
        	
		</div>
    	
    </div>


    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
		$('#myTab a').click(function (e) {
		  e.preventDefault()
		  $(this).tab('show')
		})
	</script>
  </body>
</html>