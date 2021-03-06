<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
<%
ArrayList<ArrayList<String>>aryTable=(ArrayList<ArrayList<String>>) request.getAttribute("MSL");
System.out.println(aryTable.get(0));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>ここにキーワードを含むページのタイトルを記入</title>
<meta name="Description" content="ここにキーワードを含むページの説明文を記入" />
<meta name="Keywords" content="キーワード,キーワード,キーワード" />
<link rel="icon" href="http://saetl.net/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" type="img/x-icon" href="http://saetl.net/favicon.ico" />
<link rel="stylesheet" href="css/style.css">
<link href='https://fonts.googleapis.com/css?family=Berkshire+Swash|Lobster' rel='stylesheet' type='text/css'><!--googlewebフォント-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"><!--アイコンwebフォント-->
<link rel="stylesheet" href="css/vertical-responsive-menu.css" /><!--レスポンシブメニュー-->
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>
<noscript>
<p>※このページはJavaScriptを使用しています。JavaScript設定を有効にしてご覧ください。</p>
</noscript>

<!--ヘッダー-->
<header class="header clearfix">
  <button type="button" id="toggleMenu" class="toggle_menu"> <i class="fa fa-bars"></i> </button>

  <!--ロゴ（ページ左上のサイト名）-->
  <h1><a href="index.html" title="ここにキーワードを含むページの見出しを記入">まさる堂</a></h1>

  <!--ページ右上の表示-->
  <div class="user info"><a href="user.html">
    <ul>
      <li><i class="fa fa-user fa-2x"></i></li>
      <li>会員情報</li>
    </ul>
    </a></div>
  <div class="login info"><a href="login.html">
    <ul>
      <li><i class="fa fa-sign-in fa-2x"></i> </li>
      <li>登録・ログイン</li>
    </ul>
    </a></div>
    <div class="cart info"><a href="cart.html">
      <ul>
        <li><i class="fa fa-shopping-cart fa-2x"></i></li>
        <li>カート</li>
      </ul>
      </a></div>
    <div class="help info"><a href="help.html">
      <ul>
        <li><i class="fa fa-question-circle fa-2x"></i> </li>
        <li>ヘルプ</li>
      </ul>
      </a></div>
      <div class="terms info"><a href="terms.html">
        <ul>
          <li><i class="fa fa-info-circle fa-2x"></i></li>
          <li>利用規約</li>
        </ul>
        </a></div>
      <div class="contact info"><a href="contact.html">
        <ul>
          <li><i class="fa fa-envelope-o fa-2x"></i> </li>
          <li>お問い合わせ</li>
        </ul>
      </div>
</header>
<!--ナビゲーションメニューー-->
<nav class="vertical_nav">
  <ul id="js-menu" class="menu">
    <li class="menu--item"> <a href="news.html" class="menu--link" title="NEWS"> <i class="menu--icon  fa fa-fw fa-pencil-square"></i> <span class="menu--label">NEWS</span> </a> </li>
    <li class="menu--item"> <a href="Blog.html" class="menu--link" title="BLOG"><i class="menu--icon fa fa-fw fa-comments"></i> <span class="menu--label">BLOG</span> </a> </li>
    <li class="menu--item  menu--item__has_sub_menu">
      <label class="menu--link"> <i class="menu--icon fa fa-fw fa-music"></i> <span class="menu--label">PRODUCT</span> </label>
      <ul class="sub_menu">
        <li class="sub_menu--item"> <a href="ArtistSearch.html" class="sub_menu--link">アーティスト検索</a> </li>
        <li class="sub_menu--item"> <a href="Ranking.html" class="sub_menu--link">ランキング</a> </li>
      </ul>
    </li>
    <li class="menu--item  menu--item__has_sub_menu">
    <label class="menu--link"> <i class="menu--icon  fa fa-fw fa-building"></i> <span class="menu--label">まさる堂</span> </label>
    <ul class="sub_menu">
      <li class="sub_menu--item"> <a href="Gallery.html" class="sub_menu--link">Gallery</a></li>
      <li class="sub_menu--item"> <a href="FloorMap.html" class="sub_menu--link">FloorMap</a></li>
      <li class="sub_menu--item"> <a href="Schedule.html" class="sub_menu--link">Schedule</a></li>
      <li class="sub_menu--item"> <a href="Access.html" class="sub_menu--link">Access</a></li>
    </ul>
  </ul>
  <button id="collapse_menu" class="collapse_menu"> <i class="collapse_menu--icon  fa fa-fw"></i> <span class="collapse_menu--label">Recolher menu</span> </button>

  <!--ページ左下の表示-->
  <p class="copyright">Copyright(C) 2015<br>
    サイト名 All Rights Reserved.</p>
</nav>
<div class="wrapper">
  <div class="content">

    <!--ページのメイン部分-->
    <article>
      <h2>Cart</h2>
      <hr>
<center>
<table border=1>
<tr>
	<td>アルバム番号</td>
	<td>アルバム名</td>
	<td>アルバムカウント</td>
	<td>曲名</td>
	<td>価格</td>
	<td>リリース年</td>
</tr>
<%for(ArrayList<String>rec:aryTable){ %>
<tr>
	<%for(String date:rec){ %>
	<td><%=date %></td>
	<%} %>
</tr>
<%} %>
</table>
            <form action="./MusicPurchaseServlet" method="get" enctype="multipart/form-data">
            <input type="submit" value="購入する" class="btn_submit">
            </form>
</center>
    </article>
    <!-- / .content -->
  </div>
  <!-- / .wrapper -->
</div>

<!--javascript設定-->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script> <!--googleのCDN（ネットワーク経由でコンテンツを提供するサービス）よりjqueryをロード-->
<script src="js/vertical-responsive-menu.min.js" ></script> <!--レスポンシブメニュー-->
<script src="js/scrolltopcontrol.js"></script> <!--スクロールしながらページのトップに戻る-->

</body>
</html>
