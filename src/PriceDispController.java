import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.Price;

import java.util.*;
import java.sql.*;

public class PriceDispController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PriceDAO pdao = new PriceDAO();
		try {
			List<Price> list = pdao.getAllPrice();
			RequestDispatcher rd = request.getRequestDispatcher("pricelist.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}