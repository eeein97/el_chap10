package mvcboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import fileUpload.FileUtil;

@WebServlet("/mvcboard/edit.do")
public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idx = req.getParameter("idx");
		MVCboardDAO dao = new MVCboardDAO();
		MVCboardDTO dto = dao.selectView(idx);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/Edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.파일 업로드 처리
		//업로드 디렉토리의 물리적 경로확인
		String saveDirectory = req.getServletContext().getRealPath("/uploads");
		//파일 크기 지정
		int maxPostSize = 1024*1000;
		//파일 업로드
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		//파일 업로드 외 처리
		//수정내용을 매개변수에서 얻어옴
		String idx = mr.getParameter("idx");
		String name = mr.getParameter("name");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		
		//비밀번호 session에서 가지고옴
		HttpSession session = req.getSession();
		String pass = (String) session.getAttribute("pass");
		
		//DTO에 저장하기
		MVCboardDTO dto = new MVCboardDTO();
		dto.setIdx(idx);
		dto.setName(name);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPass(pass);
		
		String fileName = mr.getFilesystemName("ofile");
		if(fileName != null) {
			//새로운 파일명 생성
			String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = now + ext;
			
			//파일명 변경하기
			File oldFile = new File(saveDirectory+File.separator+fileName);
			File newFile = new File(saveDirectory+File.separator+newFileName);
			oldFile.renameTo(newFile);
			
			//DTO에 저장
			dto.setOfile(fileName);
			dto.setSfile(newFileName);
		}
		//데이터 베이스에 update 사용
		MVCboardDAO dao = new MVCboardDAO();
		int result = dao.updatePost(dto);
		resp.sendRedirect("./view.do?idx="+idx);
	}
	
	
}
