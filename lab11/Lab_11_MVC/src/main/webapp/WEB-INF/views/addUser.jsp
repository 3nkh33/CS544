<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Adding new user</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>System users</h1>
            <p>Add a new one
            <p>
        </div>
    </div>
</section>
<section class="container"><form:form
        modelAttribute="newUser" class="form-horizontal">
    <fieldset>
        <legend>Add new user</legend>
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>
        <div class="form-group">
            <label class="control-label col-lg-2" for="firstName">First
                Name</label>
            <div class="col-lg-10">
                <form:input id="firstName" path="firstName" type="text"
                            class="form:input-large"/>
                <form:errors path="firstName" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="lastName">Last
                Name</label>
            <div class="col-lg-10">
                <form:input id="lastName" path="lastName" type="text"
                            class="form:input-large"/>
                <form:errors path="lastName" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="email">Email</label>
            <div class="col-lg-10">
                <form:input id="email" path="email" type="email"
                            class="form:input-large"/>
                <form:errors path="email" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="userName">User
                Name</label>
            <div class="col-lg-10">
                <div class="form:input-prepend">
                    <form:input id="username" path="userCredentials.userName"
                                type="text" class="form:input-large"/>
                    <form:errors path="userCredentials.userName"
                                 cssClass="text-danger"/>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="control-label col-lg-2" for="password">Password</label>
            <div class="col-lg-10">
                <div class="form:input-prepend">
                    <form:password id="password" path="userCredentials.password"
                                   class="form:input-large"/>
                    <form:errors path="userCredentials.password"
                                 cssClass="text-danger"/>
                </div>
            </div>
        </div>


        <form:hidden path="userCredentials.enabled" value="TRUE"/>


        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <input type="submit" id="btnAdd" class="btn btn-primary"
                       value="Add"/>
            </div>
        </div>

    </fieldset>
</form:form></section>
</body>
</html>