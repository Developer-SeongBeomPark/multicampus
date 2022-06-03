package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemoDAO;
import model.MemoDTO;

public class ReadAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int memono = Integer.parseInt(request.getParameter("memono"));
		
		MemoDAO dao = new MemoDAO();
		dao.upViewcnt(memono);
		MemoDTO dto = dao.read(memono);
		dto.setMemono(memono);
		
		request.setAttribute("dto", dto);
		
		
		return "/view/read.jsp";
	}

}
