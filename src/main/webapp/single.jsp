<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<header class="bg-secondary-subtle text-center py-5">
    <span class="fw-bold fs-1">TechBlog</span>
</header>
<jsp:include page="./nav.jsp"/>
<main>
    <div class="container-fluid">
        <div class="row">
            <jsp:include page="./sidenav.jsp"/>
            <div class="col-lg-10">
                <div class="d-flex flex-column gap-3 my-4">
                    <div class="card">
                        <div class="card-body d-flex flex-column gap-4">
                            <h1>${post.title}</h1>
                            <img class="w-100" src="/techblog/uploads/${post.thumbnail}" alt="">
                            <p>${post.content}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>
</html>