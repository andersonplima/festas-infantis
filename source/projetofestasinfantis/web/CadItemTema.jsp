<%-- 
    Document   : CadItemTema
    Created on : Dec 14, 2019, 1:45:19 PM
    Author     : ander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de itens de tema</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <h1>Cadastro de item de tema</h1>
            <% if (request.getParameter("error") != null && request.getParameter("error").equals("1")) { %>
            <div class="alert alert-danger" role="alert">
                Erro ao cadastrar tema!
            </div>
            <% } %>
            <form action="CadItemTemaServlet" method="post">
                <input type="hidden" name="idTema" value="2" />
                <div class="form-group">                    
                    <label for="descricaoItem">Descrição</label> 
                    <input type="text" name="descricaoItem" class="form-control" placeholder="Entre com a descrição do item" />
                </div>
                <button type="submit" class="btn btn-primary">Salvar</button>
            </form>
        </div>
    </body>
</html>