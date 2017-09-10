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

import br.edu.facear.model.Manutencao;
import br.edu.facear.model.ManutencaoBusca;
import br.edu.facear.model.Produto;
import br.edu.facear.model.Servico;
import br.edu.facear.service.service_Manutencao;
import br.edu.facear.service.service_ManutencaoBusca;
import br.edu.facear.service.service_Produto;
import br.edu.facear.service.service_Servico;

/**
 * Servlet implementation class cadastrarManutencao
 */
@WebServlet("/cadastrarManutencao")
public class cadastrarManutencao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarManutencao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service_Produto sp = new service_Produto();
		service_Servico ss = new service_Servico();
		List<Produto> listadeproduto = new ArrayList<>();
		List<Servico> listadeservico = new ArrayList<>();
		try {
			listadeproduto = sp.listarProduto();
			listadeservico = ss.listarServico();
			request.setAttribute("produto", listadeproduto);
			request.setAttribute("servico", listadeservico);
			
			String nextpage = "/cadastrarManutencao.jsp";
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
		String nextpage = "/principal.jsp";
		
		String produto_id = request.getParameter("produto_id");//int
		String servico_id = request.getParameter("servico_id");//int
		String status = request.getParameter("status");//int
		String atendente_cpf = request.getParameter("atendente_cpf");
		String cliente_cpf = request.getParameter("cliente_cpf");
		String data = request.getParameter("data");
		
		try {
			service_Manutencao sm = new service_Manutencao();
			Manutencao manutencao = new Manutencao(new Integer(0), Integer.parseInt(produto_id), Integer.parseInt(servico_id), Integer.parseInt(status), atendente_cpf, cliente_cpf, data);
			sm.cadastrarManutencao(manutencao);
			service_ManutencaoBusca smb = new service_ManutencaoBusca();
			List<ManutencaoBusca> lista = new ArrayList<>();
			lista = smb.listarManutencao();
			request.setAttribute("listamanutencao", lista);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
			rd.forward(request, response);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
