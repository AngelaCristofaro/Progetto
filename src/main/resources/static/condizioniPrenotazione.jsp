<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <div>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:if  test = "${pageContext.request.userPrincipal.name == null}">
              <a href="home.html" id="nonFarlo">Prenotazioni</a>
 </c:if>
 <c:if  test = "${pageContext.request.userPrincipal.name != null}">
              <a href="/prenota">Prenotazioni</a>
 </c:if>
</div>