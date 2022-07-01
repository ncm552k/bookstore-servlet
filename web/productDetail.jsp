<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />

        <title>Minics</title>


        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

        <!-- fonts style -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet"> <!-- range slider -->

        <!-- font awesome style -->
        <link href="css/font-awesome.min.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />

    </head>

    <body class="sub_page">

        <div class="hero_area">
            <!-- header section strats -->
            <header class="header_section">
                <div class="header_top">
                    <div class="container-fluid">
                        <div class="top_nav_container">
                            <div class="contact_nav">
                                <a href="">
                                    <i class="fa fa-phone" aria-hidden="true"></i>
                                    <span>
                                        Call : +01 123455678990
                                    </span>
                                </a>
                                <a href="">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                    <span>
                                        Email : demo@gmail.com
                                    </span>
                                </a>
                            </div>
                            
                            <form class="search_form" action="TimKiemSP">
                                <input type="text" name="searchBox" class="form-control" placeholder="Search here...">                               
                                <button class="" type="submit">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                </button>
                            </form>
                            
                            <div class="user_option_box">
                                <a href="ShowCart" class="cart-link">
                                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                    <span>
                                        Cart
                                    </span>

                                </a>
                                <a href="ChangeInfo" class="account-link">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                    <span>
                                        My Account
                                    </span>
                                </a>
                                </a>
                                <a href="LogoutServler" class="account-link">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                    <span>
                                        Logout
                                    </span>
                                </a>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="header_bottom">
                    <div class="container-fluid">
                        <nav class="navbar navbar-expand-lg custom_nav-container ">
                            <a class="navbar-brand" href="index.html">
                                <span>
                                    Minics
                                </span>
                            </a>

                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class=""> </span>
                            </button>

                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul class="navbar-nav ">
                                    <li class="nav-item ">
                                        <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="about.html"> About</a>
                                    </li>
                                    <li class="nav-item active">
                                        <a class="nav-link" href="product.html">Products</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="why.html">Why Us</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="testimonial.html">Testimonial</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </header>
            <!-- end header section -->
        </div>


        <!-- product section -->

        <section class="product_section layout_padding">
            <div class="container">
                <div class="heading_container heading_center">
                    <h2>
                        Our Products
                    </h2>
                </div>
                <div class="row">

                    <c:if test="${check == 1}">
                    <div class="col-sm-6 col-lg-4">
                        <div class="box">
                            <div class="img-box">
                                <img src="${bookDAO.viewBook(bookItem.getBookID()).getImg()}" alt="">
                                <a href="AddToCart?ID=${bookItem.getID()}&type=book" class="add_cart_btn">
                                        <span>
                                            Add To Cart
                                        </span>                                   
                                    </a>                              
                            </div>
                            <div class="detail-box">
                                <h5>
                                    Title: ${bookDAO.viewBook(bookItem.getBookID()).getTitle()}
                                </h5> 
                                <h5>
                                    Barcode: ${bookItem.barcode}
                                </h5>
                                <h5>
                                    discount ${bookItem.discount}
                                </h5>
                                <h5>
                                    ISBN: ${bookDAO.viewBook(bookItem.getBookID()).getISBN()}
                                </h5>
                                <h5>
                                    Summary: ${bookDAO.viewBook(bookItem.getBookID()).getSummary()}
                                </h5>
                                <h5>
                                    Number Of Page: ${bookDAO.viewBook(bookItem.getBookID()).getNumberOfPage()}
                                </h5>
                                <h5>
                                    Language: ${bookDAO.viewBook(bookItem.getBookID()).getLanguage()}
                                </h5>
                                <h5>
                                    Name Publisher: ${bookDAO.viewBook(bookItem.getBookID()).getPublisher().getName()}
                                </h5>
                                <h5>
                                    Address Publisher: ${bookDAO.viewBook(bookItem.getBookID()).getPublisher().getAddress()}
                                </h5>
                                <h5>
                                    Name Author: ${bookDAO.viewBook(bookItem.getBookID()).getAuthor().getName()}
                                </h5>
                                <h5>
                                    Biography: ${bookDAO.viewBook(bookItem.getBookID()).getAuthor().getBiography()}
                                </h5>
                                <div class="product_info">
                                    <h5>
                                        <span>Price: </span> ${bookItem.price} VND
                                    </h5>
                                    <div class="star_container">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:if> 
                    
                    <c:if test="${check == 2}">
                    <!-- show clothes -->                
                    <div class="col-sm-6 col-lg-4">
                        <div class="box">
                            <div class="img-box">
                                <img src="${clothesDAO.viewClothes(clothesItem.getClothesID()).getImg()}" alt="">
                                <a href="AddToCart?ID=${clothesItem.getID()}&type=clothes" class="add_cart_btn">
                                    <span>
                                        Add To Cart
                                    </span>                                   
                                </a>                              
                            </div>
                            <div class="detail-box">
                                <h5>                                  
                                    Ten sp: ${clothesDAO.viewClothes(clothesItem.getClothesID()).getName()}
                                </h5>                                
                                <h5>                                  
                                    Discount: ${clothesItem.getDiscount()}
                                </h5> 
                                <h5>                                  
                                    Barcode: ${clothesItem.getBarcode()}
                                </h5> 
                                <h5>                                  
                                    Type: ${clothesDAO.viewClothes(clothesItem.getClothesID()).getType()}
                                </h5> 
                                <h5>                                  
                                    Material: ${clothesDAO.viewClothes(clothesItem.getClothesID()).getMaterial()}
                                </h5>
                                <h5>                                  
                                    Gender: ${clothesDAO.viewClothes(clothesItem.getClothesID()).getGender()}
                                </h5> 
                         
                                <h5>                                  
                                    Brand: ${clothesDAO.viewClothes(clothesItem.getClothesID()).getBrand()}
                                </h5>
                                <h5>                                  
                                    Color: ${clothesDAO.viewClothes(clothesItem.getClothesID()).getColor()}
                                </h5>
                                <h5>                                  
                                    Size: ${clothesDAO.viewClothes(clothesItem.getClothesID()).getSize()}
                                </h5>                               
                                <div class="product_info">
                                    <h5>
                                        <span>Price: </span> ${clothesItem.price} VND
                                    </h5>
                                    <div class="star_container">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:if>                     


                </div>
        </section>

        <!-- end product section -->


        <!-- info section -->
        <section class="info_section ">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <div class="info_contact">
                            <h5>
                                <a href="" class="navbar-brand">
                                    <span>
                                        Minics
                                    </span>
                                </a>
                            </h5>
                            <p>
                                <i class="fa fa-map-marker" aria-hidden="true"></i>
                                Address
                            </p>
                            <p>
                                <i class="fa fa-phone" aria-hidden="true"></i>
                                +01 1234567890
                            </p>
                            <p>
                                <i class="fa fa-envelope" aria-hidden="true"></i>
                                demo@gmail.com
                            </p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="info_info">
                            <h5>
                                Information
                            </h5>
                            <p>
                                Eligendi sunt, provident, debitis nemo, facilis cupiditate velit libero dolorum aperiam enim nulla iste maxime corrupti ad illo libero minus.
                            </p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="info_links">
                            <h5>
                                Useful Link
                            </h5>
                            <ul>
                                <li>
                                    <a href="index.html">
                                        Home
                                    </a>
                                </li>
                                <li>
                                    <a href="about.html">
                                        About
                                    </a>
                                </li>
                                <li>
                                    <a href="product.html">
                                        Products
                                    </a>
                                </li>
                                <li>
                                    <a href="why.html">
                                        Why Us
                                    </a>
                                </li>
                                <li>
                                    <a href="testimonial.html">
                                        Testimonial
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="info_form ">
                            <h5>
                                Newsletter
                            </h5>
                            <form action="">
                                <input type="email" placeholder="Enter your email">
                                <button>
                                    Subscribe
                                </button>
                            </form>
                            <div class="social_box">
                                <a href="">
                                    <i class="fa fa-facebook" aria-hidden="true"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-twitter" aria-hidden="true"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-instagram" aria-hidden="true"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-youtube" aria-hidden="true"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- end info_section -->


        <!-- footer section -->
        <footer class="footer_section">
            <div class="container">
                <p>
                    &copy; <span id="displayYear"></span> All Rights Reserved By
                    <a href="https://html.design/">Free Html Templates</a>
                </p>
            </div>
        </footer>
        <!-- footer section -->

        <!-- jQery -->
        <script src="js/jquery-3.4.1.min.js"></script>
        <!-- bootstrap js -->
        <script src="js/bootstrap.js"></script>
        <!-- custom js -->
        <script src="js/custom.js"></script>


    </body>

</html>