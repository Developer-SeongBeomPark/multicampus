package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddrDAO;

public class DeleteProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int addressnum = Integer.parseInt(request.getParameter("addressnum"));
		
		AddrDAO dao = new AddrDAO();
		
		boolean flag = dao.delete(addressnum);
		
		request.setAttribute("flag", flag);
		
		return "/view/deleteProc.jsp";
	}

}
