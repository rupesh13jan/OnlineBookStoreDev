<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from houzez.favethemes.com/html/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 15 May 2017 13:09:48 GMT -->
<head>
    <title>Login Page</title>
    <!--Meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="Houzez HTML5 Template">
    <meta name="description" content="Houzez HTML5 Template">
    <meta name="author" content="Favethemes">

    <link rel="apple-touch-icon" sizes="144x144" href="images/favicons/apple-touch-icon.png">
    <link rel="manifest" href="<c:url value="/resources/images/favicons/manifest.json"/>">
    <link rel="mask-icon" href="<c:url value="/resources/images/favicons/safari-pinned-tab.svg"/>">
    <meta name="theme-color" content="#ffffff">

    <link href="<c:url value="/resources/bootstrap.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/bootstrap-select.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/owl.carousel.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet" type="text/css" />
   
   
</head>

<body style=" background-attachment: fixed;" background="<c:url value="/resources/imgbook.jpg"/>">

<!--start header section header v1-->
<header id="header-section" class="header-section-4 header-main nav-left hidden-sm hidden-xs" data-sticky="1">
    <div class="container">
        <div class="header-left">
            <div class="logo">
                <a href="index-2.html">
				
                </a>
            </div>
            <nav class="navi main-nav">
               </nav>
        </div>
        <div class="header-right">
            <div class="user">
                
            </div>
        </div>
    </div>
</header>

<!--end header section header v1-->

    <!--start section page body-->
    <section id="section-body">
        <div class="container">
            <div class="page-title page-title-center breadcrumb-top">
                <div class="row">
                    <div class="col-sm-12">
                        <br><br>
                       
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div style="opacity: 1.2;" class="login-register-block login-block">
                       
                      <form  action="home" method="POST">
                      <div class="page-title-right">
                            <h2>Online Book Store</h2><br><br>
                        </div> 
                            <div class="form-group field-group">
                                <div class="input-user input-icon">
                                    <input type="text" name="username" placeholder="Username">
                                <div class="input-email input-icon">

                                </div>
                                    <input type="password" name="password"  placeholder="Password">
                                </div>
                                 
                            </div>
                            <div class="forget-block clearfix">
                                <div class="form-group pull-left">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox">
                                            Remember me
                                        </label>
                                    </div>
                                </div>
                              
                                
                            </div>
                            
<br><br> 
<input class="btn btn-primary btn-block" type="submit"
					value="Sign In" />
                           <br><br>
                              <div class="form-group pull-right">
                                    <a href="#" data-toggle="modal" data-dismiss="modal" data-target="#pop-reset-pass">Forgot Password?</a>
                                </div>
                                <div class="form-group pull-left">
                            <a href="profile" data-toggle="modal" data-dismiss="modal" data-target="#pop-reset-pass"> Register here</a>
                           
                        </div><br>
                        </form>
                         </div>
                </div>
            </div>
        </div>
    </section>
    <!--end section page body-->

    <!--start footer section-->
    <footer class="footer-v2">
       <div class="footer-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-3">
                        <div class="footer-col">
                            <p>Online Book Store - All rights reserved</p>
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-6">
                        <div class="footer-col">
                            <div class="navi">
                                <ul id="footer-menu" class="">
                                    <li><a href="privacy.html">Privacy</a></li>
                                    <li><a href="terms-and-conditions.html">Terms and Conditions</a></li>
                                    <li><a href="contact-us.html">Contact</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-3">
                        <div class="footer-col foot-social">
                            <p>
                                Follow us
                                <a target="_blank" class="btn-facebook" href="https://facebook.com/Favethemes"><i class="fa fa-facebook-square"></i></a>

                                <a target="_blank" class="btn-twitter" href="https://twitter.com/favethemes"><i class="fa fa-twitter-square"></i></a>

                                <a target="_blank" class="btn-linkedin" href="http://linkedin.com/"><i class="fa fa-linkedin-square"></i></a>

                                <a target="_blank" class="btn-google-plus" href="http://google.com/"><i class="fa fa-google-plus-square"></i></a>

                                <a target="_blank" class="btn-instagram" href="http://instagram.com/"><i class="fa fa-instagram"></i></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--end footer section-->

    
    <!--Start Scripts-->
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/modernizr.custom.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.touch-punch.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>

    <script type="text/javascript" src="<c:url value="/resources/js/slick.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/owl.carousel.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap-select.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.matchHeight-min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.nicescroll.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/custom.js"/>"></script>
</body>

<!-- Mirrored from houzez.favethemes.com/html/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 15 May 2017 13:09:48 GMT -->
</html>