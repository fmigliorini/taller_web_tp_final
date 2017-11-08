<%@include file='../../templates/Header.jsp' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="row color-invoice">
        <div class="col-md-12">
            
            <div class="row">
                <div class="col-lg-7 col-md-7 col-sm-7">
                    <h1>Mudanzas Pepe</h1>
                    <br />
                    <br />
                    
                    <strong>Email : </strong> info@mudanzapepe.com
                    <br />
                    <strong>WEB : </strong> www.mudanzapepe.com.ar
                    <br />
                    <strong>Telefono : </strong>011 4480-8900
                    <br />
                    <strong>Direccion : </strong>Florencio Varela 1903, B1754JEC San Justo, Buenos Aires
                </div>
                <div class="col-lg-5 col-md-5 col-sm-5">
                    
                    <h5>Presupuesto: ${presupuesto.id}</h5> 
                    <br /><strong>CUIT : </strong> 30-71482650-2
                    <br> Inicio de act.: 21/04/2011
                    <br> Fecha : 02/11/2017
                    
                </div>
            </div>
            <hr />
            <!--  CLIENT SIDE -->
            <div class="row">
                <div class="col-lg-7 col-md-7 col-sm-7">
                    <h4>Datos del Cliente : </h4>
                    <strong>${presupuesto.usuario.apellido }, ${presupuesto.usuario.nombre } </strong> 
                    <br />DNI: ${presupuesto.usuario.dni }
                    <br />Direccion: ${presupuesto.usuario.direccion }
                </div>
                <div class="col-lg-5 col-md-5 col-sm-5">
                    <h4>Datos de Contacto :</h4>
                    email: ${presupuesto.usuario.email }
                    <br> tel�fono: ${presupuesto.usuario.telefono }
                </div>
            </div>
            <hr />
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <h4>Descripcion del servicio:</h4>
                    Fecha del servicio: 01/12/2017
                    <br> Hora: 16:00 hs.
                    <br> Tipo de vehiculo: ${presupuesto.tipoVehiculo.descripcion }
                    
                </div>
                
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <br> Direccion de origen: ${presupuesto.origen }
                    <br> Direccion de destino: ${presupuesto.destino }
                    <br> Kilometros Recorridos: ${presupuesto.kilometros }
                    
                    
                    
                </div>
                
            </div>
            <hr />
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <strong>Detalle:</strong>
                </div>
            </div>
            <hr />
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>Descripcion</th>
                                    <th>Cant.</th>
                                    <th>$ Uni.</th>
                                    <th>%Desc.</th>
                                    <th>Sub Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Servicio de Mudanza con camion , recorrido 15,3</td>
                                    <td>${presupuesto.kilometros }</td>
                                    <td>$ ${presupuesto.tipoVehiculo.precio }</td>
                                    <td>0</td>
                                    <td>$ ${presupuesto.precio }</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <hr>
                    <div>
                        <h4>  Impuestos : $ 0  </h4>
                    </div>
                    <hr>
                    <div>
                        <h3>  Total : $ ${ presupuesto.precio }  </h3>
                    </div>
                    <hr />
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <strong> Observaciones: </strong>
                    <p>${ presupuesto.descripcion }</p>
                </div>
            </div>
            <hr />
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <a href="#" class="btn btn-success btn-sm">Aceptar Presupuesto</a>
                    <a href="#" class="btn btn-danger btn-sm">Rechazar Presupuesto</a>
                </div>
            </div>
            
            <hr>
            <div class="row">
                
                
            </div>
        </div>
    </div>
</div>

<%@include file='../../templates/Footer.jsp' %>
