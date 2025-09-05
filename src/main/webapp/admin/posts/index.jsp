<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="../sidebar.jsp"/>
        <div class="col-lg-10">
            <main>
                <h3 class="text-center mb-4">Posts</h3>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Post title</th>
                        <th scope="col">Slug</th>
                        <th scope="col">Active</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${posts}" var="post">
                        <tr>
                            <th scope="row">${post.id}</th>
                            <td>${post.title}</td>
                            <td>${post.slug}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${post.active}">
                                        <span class="badge text-bg-success">Active</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge text-bg-secondary">Disabled</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td class="d-flex gap-2">
                                <a class="btn btn-primary" href="edit-post?id=${post.id}">Edit</a>
                                <form action="posts" method="post">
                                    <input type="hidden" name="id" value="${post.id}">
                                    <button type="submit" class="btn btn-danger">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </main>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>
</html>