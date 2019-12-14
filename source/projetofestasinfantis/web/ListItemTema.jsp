<%-- 
    Document   : ListItemTema
    Created on : Dec 14, 2019, 1:23:36 PM
    Author     : ander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.ItemTema" %>
<%@page import="fachada.ItemTemaFacade" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de itens de tema</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <h1>Listagem de itens de tema</h1>
            <% if (request.getParameter("success") != null && request.getParameter("success").equals("1")) { %>
            <div class="alert alert-success" role="alert">
                Item de tema cadastrado com sucesso!
            </div>
            <% } %>

            <table class="table">
                <thead>
                    <tr><th>Id tema</th><th>Id item</th><th>Descrição</th></tr>
                </thead>
                <tbody>
                    <% ArrayList<ItemTema> listItemTema = (ArrayList<ItemTema>) request.getSession().getAttribute("listItemTema"); %>
                    <% for (ItemTema item : listItemTema) {%>
                    <tr>
                        <td><%= item.getIdTema()%></td>
                        <td><%= item.getIdItem()%></td>
                        <td><%= item.getDescricaoItem()%></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
                
            <a href="CadItemTemaServlet" class="btn btn-outline-dark">Cadastro dos itens de tema</a>
        </div>
    </body>
</html>
