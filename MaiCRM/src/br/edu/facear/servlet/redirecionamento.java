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

import br.edu.facear.model.ManutencaoBusca;
import br.edu.facear.service.service_ManutencaoBusca;

/**
 * Servlet implementation class redirecionamento
 */
@WebServlet("/redirecionamento")
public class redirecionamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void PaginaPrincipal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nextpage = "/principal.jsp";
			service_ManutencaoBusca smb = new service_ManutencaoBusca();
			List<ManutencaoBusca> lista = new ArrayList<>();
			lista = smb.listarManutencao();
			request.setAttribute("listamanutencao", lista);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
			rd.forward(request, response);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }

}
