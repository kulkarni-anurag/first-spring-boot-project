<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Todo Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <%@ include file="common/navbar.jspf" %>
    <div class="container">
        <h2 class="text-center mt-5">Add Todo Page</h2>
        <br />
        <div class="row justify-content-center">
            <div class="card col-md-8">
                <div class="card-body">
                    <form:form method="post" modelAttribute="todo">
                        <div class="form-group">
                            <form:hidden path="id" />
                        </div>
                        <div class="form-group">
                            <form:label path="desc">Enter Todo Description:</form:label>
                            <form:textarea path="desc" class="form-control" required="true"></form:textarea>
                        </div>
                        <div class="form-group">
                            <form:input type="text" path="targetDate" class="form-control" />
                        </div>
                        <div class="form-group">
                            <form:errors path="desc" cssClass="text-warning" />
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-success">Submit</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>