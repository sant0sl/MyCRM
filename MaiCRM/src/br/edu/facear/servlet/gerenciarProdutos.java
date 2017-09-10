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

import br.edu.facear.model.Produto;
import br.edu.facear.service.service_Produto;

/**
 * Servlet implementation class gerenciarProdutos
 */
@WebServlet("/gerenciarProdutos")
public class gerenciarProdutos extends redirecionamento {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gerenciarProdutos() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setar na sessão lista de produtos cadastrados e redirecionar a pagina para /listarProdutos.jsp
		try {
			service_Produto sp = new service_Produto();
			List<Produto> listadeprodutos = new ArrayList<>();
			listadeprodutos = sp.listarProduto();
			request.setAttribute("listaprodutos", listadeprodutos);
			
			String nextpage = "/listarProdutos.jsp";
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
		//pegar os id e name dos campos para cadastrar produto, cadastrar o produto
		String nome = request.getParameter("nome");
		
		try {
			service_Produto sp = new service_Produto();
			Produto prod = new Produto(new Integer(0), nome);
			sp.cadastrarProduto(prod);
			
			PaginaPrincipal(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
