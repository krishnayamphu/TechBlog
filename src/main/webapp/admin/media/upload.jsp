<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
</head>
<body>

<div class="row">
    <jsp:include page="../sidebar.jsp"/>
    <div class="col-lg-10">
        <main>
            <div class="row justify-content-center py-5 my-5">
                <div class="col-6">
                    <form method="POST" enctype="multipart/form-data" action="media-upload">
                        File to upload: <input type="file" name="upfile">
                        <br/>
                        <br/>
                        <button class="btn btn-primary" type="submit">Upload</button>
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</body>
</html>
