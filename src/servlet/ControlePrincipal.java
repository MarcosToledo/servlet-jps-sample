package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControlePrincipal
 */
@WebServlet("/controle-principal")
public class ControlePrincipal extends HttpServlet {
	private static final long serialVersionUID = 3653951935128498777L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ControlePrincipal() {
        super();
    }

	/**
	 * Método chamada quando vem uma requisição utilizando o verbo GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		configurarResponse(response);
		response.getWriter().write("Salveeee, acabei de fazer uma requisção usando ajax com verbo GET, só pra teste"); // Escreve a mensagem de retorno do ajax 
	}

	/**
	 * Método chamada quando vem uma requisição utilizando o verbo POST para receber dados
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  configurarResponse(response);
		  
		  String nome = request.getParameter("nome");
		  String email = request.getParameter("email");
		  String telefone = request.getParameter("telefone");
		  
		  // TODO aqui vc pode cadastrar o contato no MySQL
		  
		  System.out.println("Nome: " + nome + " | Email : " + email + " | Telefone: " + telefone); // Log
		  
		  response.getWriter().write("O Contato do " + nome + " foi salvo com sucesso parça!"); // Escreve a mensagem de retorno do ajax 
	}

	public void configurarResponse(HttpServletResponse response) {
		response.setContentType("text/plain");	// Fala que o conteudo do response é do tipo text, pq vamos mandar uma mensagem
		response.setCharacterEncoding("UTF-8");	// Coloca a mensagem no encoding de UTF-8 só pra não zuar acentuação
	}
}
