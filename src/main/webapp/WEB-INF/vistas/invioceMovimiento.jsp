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
                    
                    <h5>${movimiento.tipomovimiento.descipcion}: ${movimiento.puntoventa} - ${movimiento.numero}</h5> 
                    <br /><strong>CUIT : </strong> 30-71482650-2
                    <br> Inicio de act.: 21/04/2011
                    <br> Fecha : ${movimiento.fecha}
                   if(${moviemiento.tipomovimiento.id} == 2) {
                   
                       <br> Fecha Vencimiento : ${movimiento.fecha_vencimiento}
                   }
                </div>
            </div>
            <hr/>
            <!--  CLIENT SIDE -->
            <div class="row">
                <div class="col-lg-7 col-md-7 col-sm-7">
                    <h4>Datos del Cliente : </h4>
                    <strong>${movimiento.usuario.apellido }, ${movimiento.usuario.nombre } </strong> 
                    <br />DNI: ${movimiento.usuario.dni }
                    <br />Direccion: ${movimiento.usuario.direccion }
                </div>
                <div class="col-lg-5 col-md-5 col-sm-5">
                    <h4>Datos de Contacto :</h4>
                    email: ${movimiento.usuario.email}
                    <br> teléfono: ${movimiento.usuario.telefono }
                </div>
            </div>
            <hr />
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <h4>Descripcion del servicio:</h4>
                    Fecha del servicio: ${movimiento.viaje.fecha }
                    <br> Hora: ${movimiento.viaje.hora }
                    <br> Tipo de vehiculo: ${movimiento.viaje.tipoVehiculo.descripcion }
                    
                </div>
                
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <br> Direccion de origen: ${movimiento.viaje.origen }
                    <br> Direccion de destino: ${movimiento.viaje.destino }
                    <br> Kilometros Recorridos: ${movimiento.viaje.kilometros }
                    
                    
                    
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
                                    <td>Servicio de Mudanza ${movimiento.viaje.tipoVehiculo.descripcion}</td>
                                    <td>${movimiento.viaje.kilometros }</td>
                                    <td>$ ${movimiento.viaje.tipoVehiculo.precio }</td>
                                    <td>0</td>
                                    <td>$ ${movimiento.viaje.precio }</td>
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
                        <h3>  Total : $ ${ movimiento.viaje.precio }  </h3>
                    </div>
                    <hr />
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <strong> Observaciones: </strong>
                    <p>${ movimiento.observaciones }</p>
                </div>
            </div>
            <hr />
           <hr>
            <div class="row">
                
                
            </div>
        </div>
    </div>
</div>

<%@include file='../../templates/Footer.jsp' %>