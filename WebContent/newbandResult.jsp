<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ErrorCheck.MemberRegist" %>

<% MemberRegist m = (MemberRegist)request.getAttribute("MEMBER"); %>
<!DOCTYPE html>
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
<nav>
  <!--ページ左下の表示-->
  <p class="copyright">Copyright(C) 2015<br>
    サイト名 All Rights Reserved.</p>
</nav>

    <!--ページのメイン部分-->
    <article>
      <h2>Contact</h2>
      <hr>
      <section>
        <div class="form">
          <p> 下記フォームを確認の上、「送信」をクリックしてください。</p>
          <dl class="clearfix">
              <dt>バンド名<span class="required"></span></dt>
              <dd>
                <%=m.getBandName() %>
              </dd>
            </dl>

            <dl class="clearfix">
              <dt>メールアドレス<span class="required"></span></dt>
              <dd>
              <%=m.getMail() %>
              </dd>
            </dl>

            <dl class="clearfix">
              <dt>パスワード<span class="required"></span></dt>
              <dd>
                <%=m.getPass() %>
              </dd>
            </dl>

            <dl class="clearfix">
              <dt>電話番号<span class="required"></span></dt>
              <dd>
              <%=m.getTelnumber() %>
              </dd>
            </dl>

             <dl class="clearfix">
              <dt>口座番号<span class="required"></span></dt>
              <dd>
              <%=m.getBankNumber() %>
              </dd>
            </dl>

			<div class="form_conf">
			<form action="./newBandRegist" method="get">
			<p class="kakunin" >
			<input type="submit" value="送信" class="btn_submit">
			</p>
			</form>

			<form action="./newBandInput" method="get">
			<input type="hidden" name="name" value="<%=m.getBandName() %>">
			<input type="hidden" name="mail" value="<%=m.getMail() %>">
			<input type="hidden" name="pass" value="<%=m.getPass() %>">
			<input type="hidden" name="telnumber" value="<%=m.getTelnumber() %>">
			<input type="hidden" name="bankNumber" value="<%=m.getBankNumber() %>">
			<input type="hidden" name="state" value="back">
			<p class="kakunin" >
			<input type="submit" value="戻る" class="btn_submit">
			</p>
			</form>
			</div>

        </div>
      </section>
    </article>

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