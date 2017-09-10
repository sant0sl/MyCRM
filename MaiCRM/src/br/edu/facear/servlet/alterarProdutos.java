package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Produto;
import br.edu.facear.service.service_Produto;

/**
 * Servlet implementation class alterarProdutos
 */
@WebServlet("/alterarProdutos")
public class alterarProdutos extends redirecionamento {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterarProdutos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nextpage = "/alterarProdutos.jsp";
		
		try {
			Integer x = new Integer(Integer.parseInt(id));
			service_Produto sp = new service_Produto();
			Produto prod = sp.ConsultaPorID(x);
			request.setAttribute("produtoObjeto", prod);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
			rd.forward(request, response);			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		
		try {
			service_Produto sp = new service_Produto();
			Produto prod = new Produto(Integer.parseInt(id), nome);
			sp.alterarProduto(prod);
			
			PaginaPrincipal(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
