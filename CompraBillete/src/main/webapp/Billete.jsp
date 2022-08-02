<%@page import="modelo.Billete"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <%  Billete b=(Billete)session.getAttribute("billete"); 
    if(b==null){
    	b=new Billete();
    }
    %>
    
    <h1>Compra de Billete</h1>
    


    <form action="procesarBillete"method="post">

        <div>
            <label for="nombre">Nombre<sub>*</sub> :</label>
            <input type="text" name="nombre" id="nombre"  value="<%= b.getNombre()%>" required>
        </div>

        <div>
            <label for="edad">Edad<sub>*</sub> : </label>
            <input type="text" name="edad" id="edad"  value="<%= b.getEdad()%>" required>
        </div>

        <div>
            <label for="billete">Billete</label>
            <select name="billete" id="billete">
                <option value="1"<%if(b.getBillete()==1) out.print(" selected");%>>Normal</option>
                <option value="2"<%if(b.getBillete()==2) out.print(" selected");%>>Joven</option>
                <option value="3"<%if(b.getBillete()==3) out.print(" selected");%>>3ª Edad</option>
            </select>
        </div>

        <div>
            <label for="dni">DNI:<sub>*</sub>: </label>
            <input type="text" name="dni" id="dni" pattern="[0-9]{1,8}[A-Za-z]{1}"  value="<%= b.getDni()%>"required>
        </div>

        <div>
            <label for="pasajeros">Núm. Pasajeros: </label>
            <input type="text" name="pasajeros" id="pasajeros" step="1" value="<%= b.getPasajeros()%>"required>
        </div>

        <div>
            <label for="tipo">Tipo: </label>
            
            <input type="radio" name="tipo" id="ida" value="ida" <%if(!b.isIdayVuelta()) out.print(" checked");%>>
            <label for="ida">Ida </label>
          
            <input type="radio" name="tipo" id="ida_vuelta" value="ida_vuelta" <%if(b.isIdayVuelta()) out.print(" checked");%>>
            <label for="ida_vuelta">Ida y Vuelta</label>
        </div>
       
        <div>
            <input type="submit" value="Comprar">
          
        </div>
    </form>

</body>
</html>