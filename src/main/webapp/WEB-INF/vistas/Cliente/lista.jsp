<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo CLiente</title>

</head>
<body>
<div class="container">
        <div class="row">
            
        </div>
        <div class="row">
            <div class="col-md-12">
                <h3>Listado de Clientes</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
              <a href="/Cliente/create"><button class="btn btn-lg btn-primary" Type="button">Agregar Cliente</button></a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 clientes">
                <c:if test="${empty records}">
                    <div class="alert alert-danger">No tiene clientes agregados aun</div>
                </c:if>

                <c:if test="${not empty records}">
                    <div class="table-responsive">
                        <table class="table table-striped borderless">
                            <thead>
                            <tr>
                                <th class="col-md-4">#</th>
                                <th class="col-md-4">Nombre</th>
                                <th class="col-md-4">Apellido</th>
                                <th class="col-md-44">Company</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="cliente" items="${records}">
                                <tr>
                                    <td><c:out value="${cliente.id}"/></td>
                                    <td><c:out value="${cliente.nombre}"/></td>
                                    <td><c:out value="${cliente.apellido}"/></td>
                                    <td><c:out value="${cliente.company}"/></td>
                                    <td><a href="#"><button type="button" class="btn btn-success"><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                                    <td><a href="#"><button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
 
</body>
</html>



