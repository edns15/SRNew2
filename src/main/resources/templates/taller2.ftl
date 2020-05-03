<!DOCTYPE html>
<html lang="es">
    <head>

      <meta charset="utf-8">
  	  <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Taller2 - GRUPO 11</title>
      <link rel="stylesheet" href="/sr/webjars/bootstrap/4.0.0/css/bootstrap.min.css" />
      <script src="/sr/webjars/jquery/3.1.1/jquery.min.js"></script>
	  <script src="/sr/webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    </head>

    <body>
    	<#if errorMessage??>
	      <div style="color:red;font-style:italic;">
	         ${errorMessage}
	      </div>
	    </#if>
	    <div class="container">
            <h2>Taller 2 - Recomendador de restaurantes</h2>
            <a class="btn btn-warning btn-lg" href="/sr" role="button">Volver</a>
        </div>
		<br/>

		<div class="container">
		  <form name="t2_restaurantes_recomendacion" action="t2_restaurantes_recomendacion" method="POST">
		    <div class="form-row">

		        <div class="col-md-4 mb-3">
                    <label for="user">User</label>
                    <input type="text" class="form-control" name="user" id="user" value="${user}" placeholder="User" required>
                </div>

                <div class="col-md-4 mb-3">
                    <label for="Estado">Estado</label>
                    <select name="Estado" id="Estado" class="custom-select" required>
                        <option value="OH" <#if Estado?? && Estado=="OH">selected</#if>> Ohio </option>
                        <option value="NC" <#if Estado?? && Estado=="NC">selected</#if>> Carolina del Norte </option>
                        <option value="PA" <#if Estado?? && Estado=="PA">selected</#if>> Pensilvania </option>
                        <option value="QC" <#if Estado?? && Estado=="QC">selected</#if>> Quebec </option>
                        <option value="AB" <#if Estado?? && Estado=="AB">selected</#if>> Alabama </option>
                        <option value="WI" <#if Estado?? && Estado=="WI">selected</#if>> Wisconsin </option>
                    </select>
                </div>

                <div class="col-md-4 mb-3">
                <label for="tipo_visita">Tipo de visita</label>
                <select name="tipo_visita" id="tipo_visita" class="custom-select">
                    <option value="" <#if tipo_visita?? && tipo_visita=="">selected</#if>></option>
                    <option value="weekday" <#if tipo_visita?? && tipo_visita=="weekday">selected</#if>> Entre semana </option>
                    <option value="weekend" <#if tipo_visita?? && tipo_visita=="weekend">selected</#if>> Fin de semana </option>
                  </select>
                </div>

			</div>

			<button class="btn btn-primary" type="submit">Recomendar</button>

		  </form>
		</div>

		<#if recommendations ??>
            <div class="container">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">Restaurante</th>
                    <th scope="col">Dirección</th>
                    <th scope="col">Ciudad</th>
                    <th scope="col">Estado</th>
                  </tr>
                </thead>
                <tbody>
                 <#list recommendations as recommendation>
                  <tr class="success">
                    <td>${recommendation.name}</td>
                    <td>${recommendation.address}</td>
                    <td>${recommendation.city}</td>
                  </tr>
                  </#list>
                </tbody>
              </table>
            </div>
        </#if>

    </body>
</html>