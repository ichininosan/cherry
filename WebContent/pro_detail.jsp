<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
<s:property value="pro_detail.product_name"/>の詳細ページ


</title>
</head>
<body>

<s:form action="PutProductIntoCartAction">
<s:hidden name="productId" value='<s:property value="pro_detail.product_id"/>'/>
<s:property value="pro_detail.product_id"/>

<s:hidden name="productNameKana" value="%{pro_detail.product_name_kana}"/>
<s:property value="pro_detail.product_name_kana"/>

<s:hidden name="productName" value="%{pro_detail.product_name}"/>
<s:property value="pro_detail.product_name"/>

<s:hidden name="productDescription" value="%{pro_detail.product_description}"/>
<s:property value="pro_detail.product_description"/>

<s:hidden name="price" value="%{pro_detail.price}"/>
<s:property value="pro_detail.price"/>

<s:hidden name="imageFileName" value="%{pro_detail.image_file_name}"/>
<img src='<s:property value="pro_detail.image_file_name"/>'/>

<s:hidden name="releaseCompany" value="%{pro_detail.release_company}"/>
<s:property value="pro_detail.release_company"/>
<s:submit value="カートに追加"/>
</s:form>

</body>
</html>