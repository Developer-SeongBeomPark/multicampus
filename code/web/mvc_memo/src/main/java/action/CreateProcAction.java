package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemoDAO;
import model.MemoDTO;

public class CreateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
			MemoDAO dao = new MemoDAO();
			MemoDTO dto = new MemoDTO();
			
			dto.setWname(request.getParameter("wname"));
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			dto.setPasswd(request.getParameter("passwd"));
			
			Boolean flag = dao.create(dto);
			
			request.setAttribute("flag", flag);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "/view/createProc.jsp";
	}

}
