package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int addressnum = Integer.parseInt(request.getParameter("addressnum"));
		
		
		request.setAttribute("addressnum", addressnum);
		
		return "/view/deleteForm.jsp";
	}

}
