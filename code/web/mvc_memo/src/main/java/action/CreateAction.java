package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "/view/createForm.jsp";
	}

}
