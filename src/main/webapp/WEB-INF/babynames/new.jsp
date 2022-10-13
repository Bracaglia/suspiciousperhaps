<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <title>Document</title>
</head>
<body>
<div class="container">
    <h1  class="align-content-center">New Baby Name</h1>
    <div class="row">
        <div class="col">
            <div class="form-group">
                <form:form action="/babyNames" method="post" modelAttribute="babyName">
                   <form:hidden path="user" value="${babyName.setUser(user)}"></form:hidden>
                    <div class="form-group">
                        <form:label path="name">name</form:label>
                        <form:input  class="form-control" path="name"/>
                        <form:errors path="name"/>
                    </div>
                    <div class="form-group">
                        <form:label path="gender">Typical Gender</form:label>
                        <form:select path="gender">
                                <form:option value="Neautral" label="Neautral"/>
                                <form:option value="Female" label="Female"/>
                                <form:option value="Male" label="Male"/>
                        </form:select>
                    </div>
                    <div>
                        <form:label path="origin">origin</form:label>
                        <form:input  class="form-control" path="origin"/>
                        <form:errors path="origin"/>
                    </div>
                    <div>
                        <form:label path="meaning">meaning</form:label>
                        <form:input type="textarea"  class="form-control" path="meaning"/>
                        <form:errors path="meaning"/>
                    </div>
                    <input type="submit" value="add Name">
                </form:form>
            </div>
        </div>
        <a class="float-end" href="/babyNames">Cancel</a>
    </div>
</div>
</body>
</html>