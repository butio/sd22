<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta charset="utf-8" />
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
<link rel="stylesheet" href="css/grey.css"><!--セレクトメニューの装飾-->
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
    <div class="cart info"><a href="cart.jsp">
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
      <section>
          <p>配信楽曲/アルバム</p>
          <p class="mo"><strong>TYCOON</strong></p>
          <hr>
          <img class="a" src="images/tycoon.jpg" width="250" height="250">
          <ul>
          <li class="uver">UVERworld</li>
          <li>邦楽ロック<li>
          <li>収録曲 18曲</li>
          <li>配信日 2017/08/02</li>
          <li>xxxx円</li>
          <li>text......</li>
          </ul>
            <form action="./MusicCartServlet" method="get" enctype="multipart/form-data">
            <input type="hidden" name="album_id" value="31">
			<input type="hidden" name="album_count" value="0">
            <input type="submit" value="カートに入れる" class="btn_submit">
            </form>
        <hr>
        <div id ="music">
        <p>収録曲</p>
        <p>1 TYCOON</p><p>2 Q.E.D</p><p>3 シリウス</p><p>4 SHOUT LOVE</p><p>5 IDEAL REALITY</p>
        <p>6 LONE WOLF</p><p>7 DECIDED</p><p>8 PLAYING RUN</p><p>9 ALL ALONE</p><p>10 一滴の影響</p>
        <p>11 ほんの少し</p><p>12 僕の言葉ではない これは僕たちの言葉</p><p>13 WE ARE GO</p><p>14 Collide</p>
        <p>15 奏全域</p><p>16 I LOVE THE WORLD</p><p>17 エミュー</p><p>18 終焉</p>

        <p>※上記フォームを利用するには <a href="http://www.sophia-it.com/content/CGI" target="_blank"> CGI </a> などのプログラムが必要です。</p>
        <p> <a href="http://cgi-design.net/" target="_blank"> CGI-design </a> </p>
      </form>
    </div>
      </section>
    </article>

    <!-- / .content -->
  </div>
  <!-- / .wrapper -->
</div>

<!--javascript設定-->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script> <!--googleのCDN（ネットワーク経由でコンテンツを提供するサービス）よりjqueryをロード-->
<script src="js/vertical-responsive-menu.min.js" ></script> <!--レスポンシブメニュー-->
<script src="js/icheck.min.js"></script> <!--チェックボックスやラジオボタンの装飾-->
<script>
 $(function() {
     $('input').iCheck({
         checkboxClass: 'icheckbox_minimal-grey',
         radioClass: 'iradio_minimal-grey',
     });
 });
</script>
<script src="js/jquery.customSelect.min.js"></script> <!--セレクトメニューの装飾-->
<script>
 $(function() {
     $('.ctSelect').customSelect()
 });
</script>
<script src="js/scrolltopcontrol.js"></script> <!--スクロールしながらページのトップに戻る-->

</body>
</html>