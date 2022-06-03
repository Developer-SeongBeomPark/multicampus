package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int memono = Integer.parseInt(request.getParameter("memono"));
		
		request.setAttribute("memono", memono);
		
		return "/view/deleteForm.jsp";
	}

}
