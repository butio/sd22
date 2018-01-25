<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ErrorCheck.MemberRegist" %>

<% MemberRegist m = (MemberRegist)request.getAttribute("MEMBER"); %>

<%
String name = (String)session.getAttribute("USER_NAME");
String nickName = (String)session.getAttribute("USER_NICKNAME");
String mail = (String)session.getAttribute("USER_MAIL");
String pass = (String)session.getAttribute("USER_PASS");
String address = (String)session.getAttribute("USER_ADDRESS");
String telnumber = (String)session.getAttribute("USER_TELNUMBER");
String card = (String)session.getAttribute("USER_CARD");
%>

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

<nav>
<!--ページ左下の表示-->
  <p class="copyright">Copyright(C) 2015<br>
    サイト名 All Rights Reserved.</p>
</nav>

    <!--ページのメイン部分-->
    <article>
      <h2>管理画面</h2>
      <section>
        <div class="form">
          <p> 下記フォームをご入力の上、「確認画面へ」をクリックしてください。</p>
          <form action="./memberChangeOutput" method="get" >
            <dl class="clearfix">
              <dt>お名前<span class="required">【必須】</span></dt>
              <dd>
                <input name="name" type="text" class="txt" value="<%=name%>"/>
                                <span class="error"><%=m.errorName() %></span>
              </dd>
            </dl>
            <dl class="clearfix">
              <dt>ニックネーム<span class="required">【必須】</span></dt>
              <dd>
                <input name="nickname" type="text" class="txt" value="<%=nickName%>"/>
                                <span class="error"><%=m.errorNickname() %></span>
              </dd>
            </dl>
            <dl class="clearfix">
              <dt>メールアドレス<span class="required">【必須】</span></dt>
              <dd>
                <input name="mail" type="text" class="txt ina" value="<%=mail%>"/>
                                <span class="error"><%=m.errorMail() %></span>
              </dd>
            </dl>
            <dl class="clearfix">
              <dt>パスワード<span class="required">【必須】</span></dt>
              <dd>
                <input name="pass" type="text" class="txt ina" value="<%=pass%>"/>
                                <span class="error"><%=m.errorPass() %></span>
              </dd>
            </dl>
            <dl class="clearfix">
              <dt>住所<span class="required">【必須】</span></dt>
              <dd>
                <input name="address" type="text" class="txt" value="<%=address%>"/>
                                <span class="error"><%=m.errorAdoress() %></span>
              </dd>
            </dl>
            <dl class="clearfix">
              <dt>電話番号<span class="required">【必須】</span></dt>
              <dd>
                <input name="telnumber" type="text" class="txt ina" value="<%=telnumber%>"/>
                                <span class="error"><%=m.errorTelnumber() %></span>
              </dd>
            </dl>
            <dl class="clearfix">
              <dt>クレジットカード<span class="required">【必須】</span></dt>
              <dd>
                <input name="card" type="text" class="txt ina" value="<%=card%>"/>
                                <span class="error"><%=m.errorCard() %></span>
              </dd>
            </dl>
            <p class="kakunin">
 			<input type="submit" value="確認画面へ" class="btn_submit" >
            </p>
          </form>

          	<form action="./memberSearchResult.jsp" method="get">
			<p class="kakunin" >
			<input type="submit" value="戻る" class="btn_submit" >
			</p>
			</form>
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
