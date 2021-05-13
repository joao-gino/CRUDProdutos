import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//João Vitor Gino CB3005488
//Douglas William Feu CB3005348
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String nome=request.getParameter("nome");
		String descricao=request.getParameter("descricao");
		String sunidadeCompra=request.getParameter("unidadeCompra");
		int unidadeCompra=Integer.parseInt(sunidadeCompra);
		String sqtdPrevistoMes=request.getParameter("qtdPrevistoMes");
		float qtdPrevistoMes=Float.parseFloat(sqtdPrevistoMes);
		String sprecoMaxComprado=request.getParameter("precoMaxComprado");
		float precoMaxComprado=Float.parseFloat(sprecoMaxComprado);

		Prod e=new Prod();
		e.setNome(nome);
		e.setDescricao(descricao);
		e.setUnidadeCompra(unidadeCompra);
		e.setQtdPrevistoMes(qtdPrevistoMes);
		e.setPrecoMaxComprado(precoMaxComprado);

		int status=ProdDao.save(e);
		
		if(status>0){
			out.print("<p>Produto salvo com sucesso!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
				
		}else{
			out.println("Desculpe! Não foi possível salvar");
		}

		out.close();
	}
	
}
