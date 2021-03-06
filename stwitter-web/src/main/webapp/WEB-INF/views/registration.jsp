<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stwitter</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/resources/css/home.css">
    <link rel="stylesheet" href="/resources/css/registration.css">
    <link rel="stylesheet" href="/resources/css/main.css">
    <%----%>

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav id="menu" class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <img id="logo" src="/resources/images/logo.png" width="70 px" data-toggle="tooltip"
                             title="Stwitter"/>
                    </div>
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="/home">Home
                                <span class="glyphicon glyphicon-home"></span>
                            </a>
                        </li>
                        <li><a href="/not-ready">My profile</a></li>
                        <li><a href="/not-ready">My stwits</a></li>
                        <li><a href="/not-ready">Search people <span class="glyphicon glyphicon-search"></span></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="/registration"><span class="glyphicon glyphicon-user"></span>
                            Register</a></li>
                        <li><a href="/not-ready"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3">

        </div>


        <div id="main-content" class="col-md-6">
            <form id="registration-form" role="form" action="registration/addUser" method="post">
                <h3> Please, fill this registration form to be able to add posts on this site.</h3>
                <div class="form-group">
                    <label for="firstName">*First Name:</label>
                    <input type="text" class="required form-control" name="firstName" id="firstName"/>
                </div>
                <div class="form-group">
                    <label for="lastName">*Last Name:</label>
                    <input type="text" class="form-control" name="lastName" id="lastName"/>
                </div>
                <div class="form-group">
                    <label for="nickname">*Nickname/Login:</label>
                    <input type="text" class="form-control" name="nickName" id="nickName"/>
                </div>
                <div class="form-group">
                    <label for="email">*Email address:</label>
                    <input type="email" class="form-control" name="email" id="email"/>
                </div>
                <div class="form-group">
                    <label for="pwd">*Password:</label>
                    <input type="password" class="form-control" name="pwd" id="pwd"/>
                </div>
                <div class="form-group">
                    <label for="hobbies">Your hobby: </label>
                    <div id="hobbies" class="form-group">
                        <c:forEach var="postDto" items="${hobbies}">
                            <label class="checkbox-inline" title="${postDto.description}">
                                <input type="checkbox" value=${postDto.id} path="hobby"/>
                                    ${postDto.title}
                            </label>
                        </c:forEach>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="date">*Your birthday date:</label>
                    <input class="form-control" id="date" name="date" placeholder="MM/DD/YYY"
                           type="text"/>
                </div>
                <button type="submit" class="btn btn-default center-block">Submit</button>
            </form>
        </div>
        <div class="col-md-3">

        </div>
    </div>
</div>
<%----%>

<div class="row">

</div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<%--for validation form--%>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript" src="/resources/js/registration.js"></script>
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

</body>
</html>