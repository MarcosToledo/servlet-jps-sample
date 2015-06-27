import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Home")
public class MainServlet extends HttpServlet{
	private static final long serialVersionUID = -5111152333462774884L;
	
	private List<String> nomes;
	
	public MainServlet() {
		nomes = new ArrayList<String>();
		nomes.add("Nicolas");
		nomes.add("Marcos");
		nomes.add("MaurcioViado");
	} 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Passou aqui");
		req.setAttribute("nomes", nomes);
	}
	public List<String> getNomes() {
		return nomes;
	}
	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}
}
