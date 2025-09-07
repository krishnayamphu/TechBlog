<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<header class="bg-secondary-subtle text-center py-5">
    <span class="fw-bold fs-1">TechBlog</span>
</header>
<nav class="navbar navbar-expand-lg  bg-dark" data-bs-theme="dark">
    <div class="container">
        <a class="navbar-brand" href="#"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/techblog">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="python">Python</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="java">Java</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="c">C</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Web Technology
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">HTML Tutorial</a></li>
                        <li><a class="dropdown-item" href="#">HTML Tutorial</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">HTML Tutorial</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link">Contact</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<main>
    <div class="container-fluid">
        <div class="row">
            <jsp:include page="./sidenav.jsp"/>
            <div class="col-lg-10">

                <div class="d-flex flex-column gap-3 my-4">
                    <c:forEach items="${posts}" var="post">
                        <div class="card">
                            <div class="card-body">
                                <h2>
                                    <a href="post?slug=${post.slug}">${post.title}</a>
                                </h2>
                                <p>${post.content}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>