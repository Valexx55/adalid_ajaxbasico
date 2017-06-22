

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dni.Dni;

/**
 * Servlet implementation class DniAjax
 */
@WebServlet("/DniAjax")
public class DniAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DniAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String dni = request.getParameter("dni");
		int dni_int = Integer.parseInt(dni);
		char letra = Dni.calculaLetra(dni_int);
		
		InfoDni info_dni = new InfoDni();
		info_dni.setLetra(letra);
		info_dni.setNumero(dni_int);
		
		Gson gson = new Gson ();
		String dni_json = gson.toJson(info_dni);
		
		PrintWriter pw = response.getWriter();
		pw.write(dni_json);
		response.setContentType("application/json");
		
		

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
