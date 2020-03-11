<!DOCTYPE html>
<html lang="es">
    <head>
    
      <meta charset="utf-8">
  	  <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Taller1 - GRUPO 11</title>
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
            <h2>Taller 1 - Recomendador de canciones y artistas</h2>
            <a class="btn btn-warning btn-lg" href="/sr" role="button">VOLVER</a>
        </div>
		<br/>
		<div class="container">
            <a class="btn btn-info btn-lg" href="t1_add_user_rating" role="button">Agregar usuarios y ratings</a>
        </div>
		<div class="container">
		  <form name="t1_rc_artistas_canciones" action="t1_rc_artistas_canciones" method="POST">
		    <div class="form-row">
		        
		        <div class="col-md-4 mb-3">
				  <label for="tipoRecomendador">Tipo Recomendador</label>
			      <select name="tipoRecomendador" id="tipoRecomendador" class="custom-select" value="${tipoRecomendador}" required>
			        <option value="">Tipo Recomendador ...</option>
			      	<option value="track_model" <#if tipoRecomendador?? && tipoRecomendador=="track_model" > selected </#if> >Canciones</option>
				    <option value="artist_model"<#if tipoRecomendador?? && tipoRecomendador=="artist_model" > selected </#if> >Artistas</option>
				  </select>
		        </div>

		        <div class="col-md-4 mb-3">
                  <label for="algoritmo">Algoritmo</label>
                  <select name="algoritmo" id="algoritmo" class="custom-select" value="${algoritmo}" required>
                    <option value="">Algoritmo ...</option>
                    <option value="jaccard" <#if algoritmo?? && algoritmo=="jaccard" > selected </#if> >Jaccard</option>
                    <option value="cosine" <#if algoritmo?? && algoritmo=="cosine" > selected </#if> >Cosine</option>
                    <option value="pearson" <#if algoritmo?? && algoritmo=="pearson" > selected </#if> >Pearson</option>
                  </select>
                </div>

                <div class="col-md-4 mb-3">
                  <label for="tipo_algoritmo">Tipo Algoritmo</label>
                  <select name="tipo_algoritmo" id="tipo_algoritmo" class="custom-select" value="${tipo_algoritmo}" required>
                    <option value="">Tipo algoritmo ...</option>
                    <option value="item-item" <#if tipo_algoritmo?? && tipo_algoritmo=="item-item" > selected </#if> >item-item</option>
                    <option value="user-user" <#if tipo_algoritmo?? && tipo_algoritmo=="user-user" > selected </#if> >user-user</option>
                  </select>
                 </div>
		    

				<div class="col-md-4 mb-3">
				   <label for="user">User</label>
				   <input type="text" class="form-control" name="user" id="user" placeholder="User" value="${user}" required>
				</div>

				<div class="col-md-4 mb-3">
                   <label for="resultados">Resultados</label>
                   <input type="number" class="form-control" name="resultados" id="resultados" placeholder="resultados" value="${resultados}" required>
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
                    <th scope="col">Item</th>
                    <th scope="col">Rating</th>
                  </tr>
                </thead>
                <tbody>
                 <#list recommendations as recommendation>
                  <tr class="success">
                    <td>${recommendation.item}</td>
                    <td>${recommendation.rating}</td>
                  </tr>
                  </#list>
                </tbody>
              </table>
            </div>
        </#if>

    </body>
</html>