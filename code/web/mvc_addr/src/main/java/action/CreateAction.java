package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddrDAO;
import model.AddrDTO;

public class CreateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		AddrDAO dao = new AddrDAO();
		AddrDTO dto = new AddrDTO();
		
		dto.setName(request.getParameter("name"));
		dto.setHandphone(request.getParameter("handphone"));
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setAddress(request.getParameter("address"));
		dto.setAddress2(request.getParameter("address2"));
		
		boolean flag = dao.create(dto);
		
		request.setAttribute("flag", flag);
		
		return "/view/createForm.jsp";
	}

}
