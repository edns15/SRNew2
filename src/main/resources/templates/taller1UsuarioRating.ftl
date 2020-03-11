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
<#if infoMessage??>
    <div style="color:green;font-style:italic;">
        ${infoMessage}
    </div>
</#if>
<div class="container">
    <h2>Taller 1 - Agregar usuarios y ratings</h2>
    <a class="btn btn-warning btn-lg" href="taller1" role="button">VOLVER</a>
</div>
<br/>
<div class="container">
    <form name="addUserRating" action="addUserRating" method="POST">
        <div class="form-row">

            <div class="col-md-4 mb-3">
                <label for="tipoRecomendador">Tipo Recomendador</label>
                <select name="tipoRecomendador" id="tipoRecomendador" class="custom-select" required>
                    <option value="track_model" <#if tipoRecomendador?? && tipoRecomendador=="track_model" > selected </#if> >Canciones</option>
                    <option value="artist_model" <#if tipoRecomendador?? && tipoRecomendador=="artist_model" > selected </#if> >Artistas</option>
                </select>
            </div>

            <div class="col-md-4 mb-3">
                <label for="user">User</label>
                <input type="text" class="form-control" name="user" id="user" placeholder="User" required>
            </div>

            <div class="col-md-4 mb-3">
                <label for="item">Item</label>
                <input type="text" class="form-control" name="item" id="item" placeholder="Item" required>
            </div>

            <div class="col-md-4 mb-3">
                <label for="rating">Rating</label>
                <select name="rating" id="rating" class="custom-select" required>
                    <option value="1" <#if rating?? && rating=="1" > selected </#if> >1</option>
                    <option value="2" <#if rating?? && rating=="2" > selected </#if> >2</option>
                    <option value="3" <#if rating?? && rating=="3" > selected </#if> >3</option>
                    <option value="4" <#if rating?? && rating=="4" > selected </#if> >4</option>
                    <option value="5" <#if rating?? && rating=="5" > selected </#if> >5</option>
                </select>
            </div>
        </div>
        <button class="btn btn-primary" href="addUserRating" role="button" type="submit">Agregar</button>
    </form>
</div>

<div class="container">
    <h2>Revelar usuarios</h2>
    <a class="btn btn-info btn-lg" href="show_user_list" role="button">Mostrar</a>
</div>
<div class="container">
    <h2>Revelar artistas</h2>
    <a class="btn btn-info btn-lg" href="show_artist_list" role="button">Mostrar</a>
</div>
<div class="container">
    <h2>Revelar canciones</h2>
    <a class="btn btn-info btn-lg" href="show_track_list" role="button">Mostrar</a>
</div>

<#if recommendations ??>
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Usuarios</th>
                <th scope="col">Items</th>

            </tr>
            </thead>
            <tbody>
            <#list recommendations as user>
                <tr class="success">
                    <td>${user.userId}</td>
                    <td>${user.trackId}</td>

                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</#if>

</body>
</html>
