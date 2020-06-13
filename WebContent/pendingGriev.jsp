<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="model.PendGriev" %>
    
<%
	/********Java Code*************/

List<PendGriev> list=(List<PendGriev>)request.getAttribute("list");
%>
<!DOCTYPE html>

<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Pending Grievances - Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Default Description">
<meta name="keywords" content="fashion, store, E-commerce">
<meta name="robots" content="*">
<link rel="icon" href="http://themesground.com/motocart-demo/V1/#" type="image/x-icon">
<link rel="shortcut icon" href="http://themesground.com/motocart-demo/V1/#" type="image/x-icon">


<link rel="stylesheet" type="text/css" href="./bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./font-awesome.css" media="all">
<link rel="stylesheet" type="text/css" href="./bootstrap-select.css">
<link rel="stylesheet" type="text/css" href="./revslider.css">
<link rel="stylesheet" type="text/css" href="./owl.carousel.css">
<link rel="stylesheet" type="text/css" href="./owl.theme.css">
<link rel="stylesheet" type="text/css" href="./jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="./jquery.mobile-menu.css">
<link rel="stylesheet" type="text/css" href="./style.css" media="all">
<link rel="stylesheet" type="text/css" href="./responsive.css" media="all">
<link href="./css" rel="stylesheet" type="text/css">
<link href="./css(1)" rel="stylesheet">
<link href="./css(2)" rel="stylesheet">
    
    <style>
        .h3:hover{
            cursor: pointer;
        }
        .fl-links::selection{
            background-color: #ffd800;
        }
       .login-box{
    width: 600px;
    height: 400px;
   background:rgba(0,0,0,0.5);
    color: red;
    top:20%;
    left:50%;
    position: absolute;
    transform: translate(-50%,-50);
    box-sizing:border-box;
    padding-bottom:500px;
    padding-left: 30px;
    padding-right: 30px;
}
h1{
    margin:40px;
    padding: 0 0 20px;
    text-align: center;
    font-size: 20px;
}
.login-box p{

    margin:0;
    padding: 0;
    font-weight: bold;
    font-size: 20px;
    font-style: oblique;
}
.im{
    width: 100px;
    height: 100px;
    padding-top: 50px;
    padding-left: 57px;
}
    </style>
</head>
<body>
<div id="page">
  <header>
  <div class="header-banner">
  <div class="container">
  <div class="row">
                <div class="col-lg-6 col-xs-12 col-sm-6 col-md-6">
                  <div class="assetBlock">
                    <div style="height: 20px; overflow: hidden;" id="slideshow">
                        <p style="display: block;">Save up to <span>40%</span> Hurry limited offer!</p><p style="display: none;">Hot days! - <span>50%</span> Get ready for summer! </p></div>
                  </div>
                </div>
                <div class="col-lg-6 col-lg-6 col-xs-12 col-sm-6 col-md-6 call-us"style="color: fuchsia;"><i class="fa fa-clock-o"></i> Mon - Fri : 09am to 06pm <i class="fa fa-phone"></i> 7979085633</div>
              </div>
              </div>
              </div>
    <div class="container">
      <div class="row">
        <div id="header">
          <div class="header-container">
            <div >
                <div><h2><b><marquee   direction="left"><b><font size="5" color="red">WELCOME TO AUTOMOBILE SERVICE CENTER
    </font></b>
    </marquee></b></h2></div>
              
              </div>
            <div class="header__nav" style="margin-left: 0px;">
              <div class="fl-header-right" >
                <div class="fl-links">
                    <div class="no-js"> <font class="h3"  style="color: red;font-size: 20px;font-weight:600;text-align: left;float: left">My Account</font>
                    <div class="fl-nav-links">
                      <ul class="links">
                        <li><a href="SignoutServlet" title="Login">Sign Out</a></li>
                        </ul>
                    </div>
                  </div>
                </div>
               
               </div>
              <div class="fl-nav-menu">
                <nav>
                  <div class="mm-toggle-wrap">
                    <div class="mm-toggle"><i class="fa fa-bars"></i><span class="mm-label">Menu</span> </div>
                  </div>
                  <div class="nav-inner"> 
                     <ul id="nav" class="hidden-xs">
                      <li class="active"> <a class="level-top" href="homepage.html"><span>Home</span></a></li>
                      <li class="mega-menu"> <a class="level-top" href="serreq.html"><span>Service Request</span></a>
                        
                       </li>
                      <li class="level0 parent drop-menu"> <a class="level-top" href="contact.html"><span>Contact Us</span></a>
                       </li>
                      <li class="level0 parent drop-menu"> <a class="level-top" href="ReviewController"><span>Reviews</span></a>
                       </li>
                      <li class="mega-menu hidden-sm"> <a class="level-top" href="PriceDispController"><span>Price List</span></a> </li>
                      <li class="level0 parent drop-menu"><a href="about.html"><span>About Us</span> </a> 
                      </li>
                    </ul>
                  </div>
                </nav>
              </div>
            </div>
           </div>
        </div>
      </div>
    </div>
  </header>
    
    
    
    
    
    
    <div class="page-heading" style="background-image:url(back.jpg);border:3px solid red;">
        <fieldset style="height: 500px;">
        <div class="container">
      <div class="row">
 <div class="Register">
   

<br>
<center>
 

<form method="get" action="GrievChangeServlet">
    <table border="1" width="60%">
		<thead>
			<tr>
				<td>Grievance ID</td>
				<td>Service No.</td>
				<td>Problem</td>
				<td>Status</td>
			</tr>
		</thead>
		<tbody>
		
		<%
					try{
						for(PendGriev pg:list){
					
				%>
			<tr>
				<td><%=pg.getGid() %></td>
				<td><%=pg.getSerno() %></td>
				<td><%=pg.getProb() %></td>
				<td><%=pg.getStatus() %></td>
			</tr>
			<%}}catch(Exception e){e.getStackTrace();} %>
		</tbody>
	</table>    <br>
<input type="submit" name="submit" value="Resolve all"/>
</form>
</center>	

</div>
</div>

        </div>
        </fieldset>    
    
    
    
        
    
    
    
    </div>

  
    
  <footer> 
    
    <div class="footer-top">
      <div class="container">
        <div class="row">
       
          <div class="col-sm-8 col-xs-20 coppyright">© 2019 Automobile Services. All Rights Reserved. </div>
              <div class="col-xs-12 col-sm-4" >
            <div > 
                    <a href="Payment.html" ><img src="./payment-1.png" alt="" > </a>
                   <a href="Payment.html" > <img src="./payment-2.png" alt=""> </a>
                   <a href="Payment.html" > <img src="./payment-3.png" alt=""> </a>
                    <a href="Payment.html" ><img src="./payment-4.png" alt=""></a>
                  </div>
          </div>
        </div>
      </div>
    </div>
  </footer>
 </div>


<div id="fade" style="display: none;"></div>
<script type="text/javascript" src="./jquery.min.js.download"></script> 
<script type="text/javascript" src="./bootstrap.min.js.download"></script> 
<script src="./bootstrap-slider.min.js.download"></script> 
<script src="./bootstrap-select.min.js.download"></script> 
<script type="text/javascript" src="./parallax.js.download"></script> 
<script type="text/javascript" src="./revslider.js.download"></script> 
<script type="text/javascript" src="./common.js.download"></script> 
<script type="text/javascript" src="./jquery.bxslider.min.js.download"></script> 
<script type="text/javascript" src="./owl.carousel.min.js.download"></script> 
<script type="text/javascript" src="./jquery.mobile-menu.min.js.download"></script> 
<script src="./countdown.js.download"></script> 

<a href="http://themesground.com/motocart-demo/V1/#" id="toTop" style="display: block;"><span id="toTopHover"></span></a></body></html>