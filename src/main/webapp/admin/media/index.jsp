<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Media Files</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <jsp:include page="../sidebar.jsp"/>
        <div class="col-lg-10">
            <main>
                <a class="btn btn-primary my-3" href="/techblog/admin/media-upload">Upload</a>
                <div class="row row-cols-6">
                    <c:forEach items="${files}" var="file">
                        <div class="col mb-4">
                            <div class="card">
                                <a href="uploads/${file}" target="_blank">
                                    <img style="width: 100%; height: 150px; object-fit: cover"
                                         src="/techblog/uploads/${file}" class="card-img-top" alt="">
                                </a>
                                <div class="card-body">
                                    <form action="media" method="post">
                                        <input type="hidden" name="pic" value="${file}">
                                        <button type="submit" class="btn btn-danger">Delete</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </main>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
        crossorigin="anonymous"></script>
</body>
</html>
