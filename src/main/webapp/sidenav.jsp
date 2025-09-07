<div class="col-lg-2 bg-success-subtle min-vh-100">
    <nav class="nav flex-column">
        <a class="nav-link active" aria-current="page" href="/techblog/admin/dashboard">Dashboard</a>
        <hr>
        <a class="nav-link" href="/techblog/admin/media">Media Files</a>
        <hr>
        <a class="nav-link" href="/techblog/admin/posts">Posts</a>
        <a class="nav-link" href="/techblog/admin/add-post">Add Post</a>
        <a class="nav-link" href="/techblog/admin/category">Category</a>
        <a class="nav-link" href="/techblog/admin/add-category">Add Category</a>
    </nav>
    <hr>
    <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
            Profile
        </button>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Profile</a></li>
            <li><a class="dropdown-item" href="#">Change Password</a></li>
            <li>
                <form action="/techblog/logout" method="post">
                    <button class="btn btn-light">Logout</button>
                </form>
            </li>
        </ul>
    </div>
</div>