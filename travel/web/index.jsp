<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/22
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>游迹</title>

  <!-- Bootstrap core CSS -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <script src="jquery/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>

  <link href="css/styles.css" rel="stylesheet" />

</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
  <div class="container">
    <a class="navbar-brand" href="index.html">游迹</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      Menu
      <i class="fas fa-bars"></i>
    </button>
    <div class=" collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="index.html">首页</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="contact.html">攻略</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="editor.html">分享</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="login1.html">登录</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="about.html">关于</a>
        </li>
      </ul>
    </div>
  </div>
</nav>


<header>  <!--header:页眉   -->
  <div id="carousel-example-generic" class="carousel slide " data-ride="carousel" data-interview="2000">
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <div class="carousel-inner" >

      <div class="carousel-item active" >
        <img src="img/home/carousel/1.jpg" class="d-block w-100" height="500" alt="First slide">
      </div>
      <div class="carousel-item ">
        <img src="img/home/carousel/2.jpg" class="d-block w-100" height="500"  alt="Second slide">
      </div>
      <div class="carousel-item">
        <img src="img/home/carousel/3.jpg" class="d-block w-100" height="500" alt="Third slide">
      </div>
    </div>
    <a class="carousel-control-prev" href="#carousel-example-generic" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carousel-example-generic" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

</header>

<hr/>
<!--景点介绍-->
<section class="page-section bg-light" id="portfolio">
  <div class="container">

    <div class="row">

      <div class="col-lg-4 col-sm-6 mb-4">
        <div class="portfolio-item">
          <div class="portfolio-link" data-toggle="modal" href="introduction.html">
            <!--                        <div class="portfolio-hover">-->
            <!--                            <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>-->
            <!--                        </div>-->
            <a href="introduction.html"><img class="img-fluid" src="img/home/Gird/gugong1.jpg" alt="" /></a>
          </div>
          <div class="portfolio-caption">
            <div class="portfolio-caption-heading">故宫</div>
            <div class="portfolio-caption-subheading text-muted">门票：</div>
          </div>
        </div>
      </div>

      <div class="col-lg-4 col-sm-6 mb-4">
        <div class="portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#portfolioModal2">
            <div class="portfolio-hover">
              <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
            </div>
            <img class="img-fluid" src="img/home/Gird/huangshan1.jpg"  alt=""  />
          </a>
          <div class="portfolio-caption">
            <div class="portfolio-caption-heading">黄山</div>
            <div class="portfolio-caption-subheading text-muted">门票：</div>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 mb-4">
        <div class="portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#portfolioModal3">
            <div class="portfolio-hover">
              <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
            </div>
            <img class="img-fluid" src="img/home/Gird/jiuzhaigou1.jpg" alt="" />
          </a>
          <div class="portfolio-caption">
            <div class="portfolio-caption-heading">九寨沟</div>
            <div class="portfolio-caption-subheading text-muted">门票：</div>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 mb-4 mb-lg-0">
        <div class="portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#portfolioModal4">
            <div class="portfolio-hover">
              <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
            </div>
            <img class="img-fluid" src="img/home/Gird/zhangjiajie1.jpg" alt="" />
          </a>
          <div class="portfolio-caption">
            <div class="portfolio-caption-heading">张家界</div>
            <div class="portfolio-caption-subheading text-muted">门票：</div>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 mb-4 mb-sm-0">
        <div class="portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#portfolioModal5">
            <div class="portfolio-hover">
              <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
            </div>
            <img class="img-fluid" src="img/home/Gird/changcheng1.jpg" alt="" />
          </a>
          <div class="portfolio-caption">
            <div class="portfolio-caption-heading">八达岭长城</div>
            <div class="portfolio-caption-subheading text-muted">门票：</div>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6">
        <div class="portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#portfolioModal6">
            <div class="portfolio-hover">
              <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
            </div>
            <img class="img-fluid" src="img/home/Gird/guangzhouchanglong1.jpg" alt="" />
          </a>
          <div class="portfolio-caption">
            <div class="portfolio-caption-heading">广州长隆</div>
            <div class="portfolio-caption-subheading text-muted">门票：</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<hr/>
<div class="text-center"><p class="copyright text-muted">Copyright &copy; Your Website 2020</p></div>



</body>
</html>
