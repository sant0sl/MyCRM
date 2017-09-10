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

import br.edu.facear.model.Servico;
import br.edu.facear.service.service_Servico;

/**
 * Servlet implementation class gerenciarServicos
 */
@WebServlet("/gerenciarServicos")
public class gerenciarServicos extends redirecionamento {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gerenciarServicos() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setar na sessão lista de serviços cadastrados e redirecionar a pagina para /listarServicos.jsp
		try {
			service_Servico ss = new service_Servico();
			List<Servico> listadeservicos = new ArrayList<>();
			listadeservicos = ss.listarServico();
			request.setAttribute("listaservicos", listadeservicos);
			
			String nextpage = "/listarServicos.jsp";
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
		//pegar os id e name dos campos para cadastrar servico, cadastrar o servico
		String nome = request.getParameter("nome");
		
		try {
			service_Servico ss = new service_Servico();
			Servico serv = new Servico(new Integer(0), nome);
			ss.cadastrarServico(serv);
			
			PaginaPrincipal(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
