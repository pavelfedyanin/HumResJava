<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 25.06.14
  Time: 3:25
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="/elements/head.jsp" />
<body>
<jsp:include page="/elements/header.jsp" />
<div class="container">
    <div class="row">
        <jsp:include page="/elements/departments"/>
        <div class="col-md-9">
            <c:choose>
                <c:when test="${param.departmentId != null}">

                </c:when>

                <c:otherwise>
                    <h4>Add New Department:</h4>
                </c:otherwise>
            </c:choose>
        <div class="row">
            <div class="col-md-8">
                <form class="form" role="form" method="post" action="<c:out value="${param.actURL}"/>">
                    <div class="form-group">
                        <input value="<c:out value="${param.departmentId}"/>" name="id" type="hidden">
                        <label for="departmentName" class="control-label">Name:</label>
                        <input class="form-control" id="departmentName" placeholder="Please input department name" value="<c:out value="${param.departmentName}"/>" name="departmentName" required>

                    </div>
                    <button type="submit" class="btn btn-info">Save Department</button>
                </form>
            </div>
        </div>
        </div>
    </div>
</div>
<jsp:include page="/elements/footer.jsp" />
