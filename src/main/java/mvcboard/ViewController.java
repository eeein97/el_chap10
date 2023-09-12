package mvcboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvcboard/view.do")
public class ViewController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//게시물 불러오기
		MVCboardDAO dao = new MVCboardDAO();
		//요청파라미터 값 반환
		String idx = req.getParameter("idx");
		//조회수 업데이트
		dao.updateVisitcount(idx);
		//게시물 조회하기
		MVCboardDTO dto = dao.selectView(idx);
		//선연결끊기
		dao.close();
		req.setAttribute("dto", dto);
		//뷰 포워드 (요청을 한번 더함)
		req.getRequestDispatcher("/View.jsp").forward(req, resp);
	}
}
