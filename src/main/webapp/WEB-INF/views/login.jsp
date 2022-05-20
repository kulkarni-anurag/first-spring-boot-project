<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center mt-5">Login Page</h2>
        <br />
        <h5 class="error">${error_message}</h5>
        <div class="row justify-content-center">
            <div class="card col-md-8">
                <div class="card-body">
                    <form method="post" class="form" role="form">
                        <div class="form-group">
                            <label for="username">Enter Username:</label>
                            <input type="text" class="form-control" name="username" placeholder="Enter Username" />
                        </div>
                        <div class="form-group">
                            <label for="username">Enter Password:</label>
                            <input type="password" class="form-control" name="password" placeholder="Enter Password" />
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-success">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>