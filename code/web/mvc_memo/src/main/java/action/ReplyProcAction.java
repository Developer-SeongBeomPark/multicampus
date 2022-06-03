package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemoDAO;
import model.MemoDTO;

public class ReplyProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemoDAO dao = new MemoDAO();
		MemoDTO dto = new MemoDTO();
		
		dto.setWname(request.getParameter("wname"));
		dto.setTitle(request.getParameter("title"));
		
		boolean flag = dao.createReply(dto);
		
		return "/view/replyProc.jsp";
	}

}
