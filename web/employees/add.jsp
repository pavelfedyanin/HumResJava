<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 25.06.14
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="/elements/head.jsp" />
<body>
<jsp:include page="/elements/header.jsp" />
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">

            <form class="form" role="form" method="post" action="<c:out value="${requestScope.actUrl}"/>">
            <div class="form-group">
                <input value="" name="id" type="hidden">
                <label for="name" class="control-label">Employee Name:</label>
                <input class="form-control" id="name" placeholder="Please input employee name" value="" name="name" required>
                <br/>
                <label for="empbirthday" class="control-label">Birthday:</label>
                <input pattern="\d{1,2}/\d{1,2}/\d{4}" type="date" class="form-control" id="empbirthday" placeholder="Birthday" value="" name="empbirthday" required>
                <br/>
                <label for="passport" class="control-label">Passport:</label>
                <input class="form-control" id="passport" placeholder="Passport data" value="" name="passport" required>
                <br/>
                <label for="departmentId" class="control-label">Select Department:</label>
                <select class="form-control"  name="departmentId" id="departmentId">
                    <c:forEach var="department" items="${requestScope.departments}">

                        <option value="<c:out value="${department.id}"/>"><c:out value="${department.name}"/></option>

                    </c:forEach>
                </select>
                <label for="positionId" class="control-label">Select Position:</label>
                <select class="form-control"  name="positionId" id="positionId">
                    <c:forEach var="position" items="${requestScope.positions}">
                        <option value="<c:out value="${position.id}"/>">
                            <c:out value="${position.name}"/>
                        </option>
                    </c:forEach>
                </select>
                <label for="salary" class="control-label">Salary:</label>
                <input class="form-control"  name="salary" id="salary" min="5000" max="10000" placeholder="Salary" value="" name="salary" pattern="\d+(\.\d{2})?" required>
                <span class="empcount">Use for input format ####.## or #####, e.g. 3000.00 or 954020, <br/>you can use only numbers and one dot.</span>

            </div>
            <button type="submit" class="btn btn-info">Save Employee</button>
            </form>

        </div>
    </div>
</div>
<jsp:include page="/elements/footer.jsp" />
