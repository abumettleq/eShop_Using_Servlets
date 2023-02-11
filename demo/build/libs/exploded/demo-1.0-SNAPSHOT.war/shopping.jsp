<%--
  Created by IntelliJ IDEA.
  User: MesKaNoVa
  Date: 2/11/2023
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>eShop Shopping</title>
</head>
<body>
<form method="post" action="cartAdd-servlet">
    <input name="product-name" value="Logitech G102 Mouse" hidden="hidden"> Logitech G102 - <input name="product-price" value="35" hidden="hidden"> $35 -> <input name="product-amount" type="number" min="1" max="10" required> - <input type="submit" value="Buy">
</form>
<br>
<form method="post" action="cartAdd-servlet">
    <input name="product-name" value="Razer Kraken" hidden="hidden"> Razer Kraken - <input name="product-price" value="85" hidden="hidden"> $85 -> <input name="product-amount" type="number" min="1" max="10" required> - <input type="submit" value="Buy">
</form>
<br>
<form method="post" action="cartAdd-servlet">
    <input name="product-name" value="Asus 144hz Monitor" hidden="hidden"> Asus 144hz Monitor - <input name="product-price" value="175" hidden="hidden"> $175 -> <input name="product-amount" type="number" min="1" max="10" required> - <input type="submit" value="Buy">
</form>
<br>
<br>
<a href="cart-servlet">Taq me to me kart!</a>
</body>
</html>s