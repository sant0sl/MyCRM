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

import br.edu.facear.model.Cliente;
import br.edu.facear.service.service_Cliente;

/**
 * Servlet implementation class gerenciarClientes
 */
@WebServlet("/gerenciarClientes")
public class gerenciarClientes extends redirecionamento {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gerenciarClientes() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setar na sessão lista de clientes cadastrados e redirecionar a pagina para /listarClientes.jsp
		try {
			service_Cliente sc = new service_Cliente();
			List<Cliente> listadeclientes = new ArrayList<>();
			listadeclientes = sc.listarCliente();
			request.setAttribute("listaclientes", listadeclientes);
			
			String nextpage = "/listarClientes.jsp";
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
		//pegar os id e name dos campos para cadastrar cliente, cadastrar o cliente, 
		//jogar na sessão a lista de clientes e redirecionar pra /principal.jsp
		
		String nome_cliente = request.getParameter("nome");
		String cliente_cpf = request.getParameter("cpf");
		
		try {
			service_Cliente sc = new service_Cliente();
			Cliente c = new Cliente(new Integer(0), nome_cliente, cliente_cpf);
			sc.cadastrarCliente(c);
			
			PaginaPrincipal(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
