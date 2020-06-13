import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Review;
public class ReviewController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO rdao = new ReviewDAO();
		try {
			List<Review> list = rdao.getAllReviews();
			RequestDispatcher rd = request.getRequestDispatcher("reviews.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}