<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="length" required="false" type="java.lang.Integer" %>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%-- length : 5

===== logging =====

--%>


<%-- length 속성이 없을경우 length 기본값 20으로 표현  --%>

<c:set var = "length" value="${length == null ? 20 : lang }"/>

<font color="${color}" >
	<c:forEach begin="1" end="${length }">=</c:forEach>
	logging
	<c:forEach begin="1" end="${length }">=</c:forEach>
	<br>
</font>
