<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="/elements/head.jsp" />
  <body>
    <jsp:include page="/elements/header.jsp" />
    <div class="container">
    <div class="row">
        <jsp:include page="/elements/departments"/>
        <div class="col-md-10">
            <h4>

                <c:choose>
                    <c:when test="${departmentId != null}">
                        <c:out value="${depart.name}"/>
                    </c:when>
                    <c:otherwise>
                        All Departments Staff
                    </c:otherwise>
                </c:choose>
            </h4>
            <span class="empcount"><c:out value="${fn:length(requestScope.employee)}"/> employee(-s)</span>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Birthday</th>
                        <th>Passport</th>
                        <th>Position</th>
                        <th>Salary</th>
                        <th colspan="2">Actions</th>
                    </tr>
                </thead>
                <c:forEach var="employee" items="${requestScope.employee}">
                    <tr>
                        <td><a id="<c:out value="${employee.id}"/>" href="/employee/?id=<c:out value="${employee.id}"/>"><c:out value="${employee.name}"/></a></td>
                        <td><c:out value="${employee.birthday}"/></td>
                        <td><c:out value="${employee.passportNumber}"/></td>
                        <td><c:out value="${employee.position.name}"/></td>
                        <td>$<c:out value="${employee.salary}"/></td>
                        <td><a title="Edit" href="#" class="glyphicon glyphicon-pencil"></a></td>
                        <td><a title="Delete" href="/employees/deleteemployee?id=<c:out value="${employee.id}"/>" class="glyphicon glyphicon-remove"></a></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
    </div>
<jsp:include page="/elements/footer.jsp" />