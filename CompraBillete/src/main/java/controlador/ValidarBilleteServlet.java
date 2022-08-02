package controlador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Billete;

/**
 * Servlet implementation class ValidarBilleteServlet
 */
@WebServlet("/procesarBillete")

public class ValidarBilleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ValidarBilleteServlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Billete b=new Billete();
		boolean error=false;
		
		String nombre=request.getParameter("nombre");
		if (nombre==null||nombre.isBlank()) {
			session.setAttribute("errorNombre","Debe introducir el nombre.");
			error=true;
		}else b.setNombre(nombre);
		
		try {
			int edad=Integer.parseInt(request.getParameter("edad"));
			b.setEdad(edad);
			int billete= Integer.parseInt(request.getParameter("billete"));
			b.setBillete(billete);
			if(billete==2 && edad>26) {
				session.setAttribute("errorBillete", "Debe tener menos de 26 para usar Billete Joven");
				error=true;
			}else if(billete==3 && edad<65) {
				session.setAttribute("errorBillete", "Debe tener mas de 65 para usar Billete 3ª Edad");
				error=true;
			}
		}catch(NumberFormatException e) {
			session.setAttribute("errorEdad","Debe introducir una valor numerico.");
			error=true;
		}

		String dni=request.getParameter("dni");
		b.setDni(dni);
		try {
			int pasajeros= Integer.parseInt(request.getParameter("pasajeros"));
			b.setPasajeros(pasajeros);
		}catch(NumberFormatException e) {
			session.setAttribute("errorPasajeros","Debe introducir un numero valido de pasajeros.");
			error=true;
		}
		
		String tipo=request.getParameter("tipo");
		if("ida".equals(tipo)) {
			b.setIdayVuelta(false);
		}else {
			b.setIdayVuelta(true);
		}
		session.setAttribute("billete", b);
		
		if (error) {
		    	response.sendRedirect("Billete.jsp");
		}else {
			response.sendRedirect("detalles.jsp");
		}
		
	}

}
