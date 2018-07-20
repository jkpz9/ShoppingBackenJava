<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping | ${title}</title>
    
    <script>
    	<!-- Setting some variable -->
     	window.menu = '${title}';
     	window.contextRoot = '${contextRoot}';
     
    </script>

    <!-- Bootstrap core CSS -->
    <!-- <link href="${css}/bootstrap.min.css" rel="stylesheet"> -->
    <link href="${css}/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">
    
    <!-- Datatable Bootstrap -->
    <link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

  </head>

  <body>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
      <div class="container">
      	<div class="navbar-header">
        <a class="navbar-brand" href="${contextRoot}/home">Electronic && Wearable</a>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="content" style="margin:30px auto;">
    	<div class="container">
    		<div class="row">
    			<div class="col-xs-12 col-lg-12 col-md-12 col-sm-12">
    				<div class="jumbotron">
    					<h1>${errorTitle}</h1>
    					<hr />
    					<blockquote style="word-wrap:break-word;">
    						${errorDescription}
    					</blockquote>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    
    
    
    <!-- /.container -->

    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
    
    <!--  DATA TABLE PLUGIN -->
    <script src="${js}/jquery.dataTables.js"></script>
    
    <!-- Datatable Bootstrap -->
    <script src="${js}/dataTables.bootstrap4.js"></script>
    
    <!-- SELF CODED JS -->
    <script src="${js}/myapp.js"></script>
  </body>

</html>


