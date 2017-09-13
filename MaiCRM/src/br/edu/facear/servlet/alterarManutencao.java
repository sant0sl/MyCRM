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
import br.edu.facear.model.Cliente;
import br.edu.facear.model.Manutencao;
import br.edu.facear.model.Produto;
import br.edu.facear.model.Servico;
import br.edu.facear.service.service_Atendente;
import br.edu.facear.service.service_Cliente;
import br.edu.facear.service.service_Manutencao;
import br.edu.facear.service.service_Produto;
import br.edu.facear.service.service_Servico;

/**
 * Servlet implementation class alterarManutencao
 */
@WebServlet("/alterarManutencao")
public class alterarManutencao extends redirecionamento {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterarManutencao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nextpage = "/alterarManutencao.jsp";
		
		service_Produto sp = new service_Produto();
		service_Servico ss = new service_Servico();
		service_Atendente sa = new service_Atendente();
		service_Cliente sc = new service_Cliente();
		List<Produto> listadeproduto = new ArrayList<>();
		List<Servico> listadeservico = new ArrayList<>();
		List<Atendente> listadeatendente = new ArrayList<>();
		List<Cliente> listadecliente = new ArrayList<>();
		
		try {
			Integer x = new Integer(Integer.parseInt(id));
			service_Manutencao sm = new service_Manutencao();
			Manutencao manutencao = sm.ConsultaPorID(x);
			System.out.println(manutencao);
			listadeproduto = sp.listarProduto();
			listadeservico = ss.listarServico();
			listadeatendente = sa.listarAtendente();
			listadecliente = sc.listarCliente();
			request.setAttribute("manutencaoObjeto", manutencao);
			request.setAttribute("produto", listadeproduto);
			request.setAttribute("servico", listadeservico);
			request.setAttribute("atendente", listadeatendente);
			request.setAttribute("cliente", listadecliente);
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
		String id = request.getParameter("id");//int
		String produto_id = request.getParameter("produto_id");//int
		String servico_id = request.getParameter("servico_id");//int
		String status = request.getParameter("status");//int
		String atendente_cpf = request.getParameter("atendente_cpf");
		String cliente_cpf = request.getParameter("cliente_cpf");
		String data = request.getParameter("data");
		
		try {
			service_Manutencao sm = new service_Manutencao();
			Manutencao manutencao = new Manutencao(Integer.parseInt(id), Integer.parseInt(produto_id), Integer.parseInt(servico_id), Integer.parseInt(status), atendente_cpf, cliente_cpf, data);
			sm.alterarManutencao(manutencao);
			
			PaginaPrincipal(request, response);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
		
	}

}
