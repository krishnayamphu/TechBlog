<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <style>
        @media (min-width: 576px) {
            .modal-dialog {
                max-width: 60%;
            }
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="../sidebar.jsp"/>
        <div class="col-lg-10">
            <main>
                <h3 class="text-center mb-4">New Post</h3>
                <form method="post" action="add-post">
                    <c:if test="${err!=null}">
                        <span class="d-block text-center text-danger mb-2">${err}</span>
                    </c:if>
                    <div class="mb-3">
                        <input type="text" class="form-control" name="title" placeholder="Post title" required>
                    </div>
                    <div class="mb-3">
                        <input type="text" class="form-control" name="slug" placeholder="Slug" required>
                    </div>
                    <div class="mb-3">
                        <textarea rows="4" class="form-control" name="content" placeholder="Content"></textarea>
                    </div>
                    <div class="mb-3">
                        <select class="form-select" name="category_id" required>
                            <option selected>Select category</option>
                            <c:forEach items="${categories}" var="category">
                                <option value="${category.id}">${category.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label>Post Thumbnail</label>
                        <div class="input-group mb-3 mt-1">
                            <button class="btn btn-outline-secondary" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">Browse</button>
                            <input type="text" id="postImage" class="form-control" name="thumbnail" placeholder="default.jpg" value="default.jpg" readonly>
                        </div>
                    </div>

                    <div class="mb-3">
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" role="switch" name="active" value="1" id="switchCheckDefault">
                            <label class="form-check-label" for="switchCheckDefault">Is Active</label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Add</button>
                </form>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="row row-cols-6">
                                    <c:forEach items="${files}" var="file">
                                        <div class="col mb-4">
                                            <div class="card">
                                                <img style="width: 100%; height: 110px; object-fit: cover"
                                                     src="/techblog/uploads/${file}" class="card-img-top" alt="" onclick="setPostThumb('${file}')" data-bs-dismiss="modal">
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
<script>
    function setPostThumb(name){
        document.getElementById("postImage").value=name;
    }
</script>
</body>
</html>