<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-2">
    <a class="btn btn-info" href="/departments/add"><span class="glyphicon glyphicon-plus"></span> Add Department</a>
    <br/>
    <br/>
    <p><strong>Choose Department:</strong></p>
    <ul class="departments-menu">
        <li class="<c:choose><c:when test="${departParam == null}">active</c:when></c:choose>"><a href="/"><b>All Departments Staff</b></a></li>
        <c:forEach var="dep" items="${requestScope.department}">
            <li class="<c:choose><c:when test="${dep.id == departParam}">active</c:when></c:choose>"><a id="<c:out value="${dep.id}"/>" href="/?department=<c:out value="${dep.id}"/>"><c:out value="${dep.name}"/></a></li>
        </c:forEach>
    </ul>



</div>
