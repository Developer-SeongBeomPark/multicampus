package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddrDAO;
import model.AddrDTO;

public class ReadAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int addressnum = Integer.parseInt(request.getParameter("addressnum"));
		AddrDAO dao = new AddrDAO();
		AddrDTO dto = dao.read(addressnum);
		
		request.setAttribute("dto", dto);
		request.setAttribute("addressnum", addressnum);
		
		return "/view/read.jsp";
	}

}
