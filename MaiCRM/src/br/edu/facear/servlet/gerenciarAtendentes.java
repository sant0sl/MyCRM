package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Atendente;
import br.edu.facear.service.service_Atendente;

/**
 * Servlet implementation class gerenciarAtendentes
 */
@WebServlet("/gerenciarAtendentes")
public class gerenciarAtendentes extends redirecionamento {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gerenciarAtendentes() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setar na sessão lista de atendentes cadastrados e redirecionar a pagina para /listarAtendentes.jsp
		try {
			service_Atendente sa = new service_Atendente();
			List<Atendente> listadeatendentes = new ArrayList<>();
			listadeatendentes = sa.listarAtendente();
			request.setAttribute("listaatendentes", listadeatendentes);
			
			String nextpage = "/listarAtendentes.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pegar os id e name dos campos para cadastrar atendente, cadastrar o(a) atendente, 
		//jogar na sessão a lista de clientes e redirecionar pra /principal.jsp
				
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		String supervisor = request.getParameter("supervisor");
		
		try {
			service_Atendente sa = new service_Atendente();
			Atendente at = new Atendente(new Integer(0), nome, cpf, senha, Integer.parseInt(supervisor));
			sa.cadastrarAtendente(at);
			
			PaginaPrincipal(request, response);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
