package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddrDAO;
import model.AddrDTO;

public class UpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
			int addressnum = Integer.parseInt(request.getParameter("addressnum"));
			AddrDAO dao = new AddrDAO();
			AddrDTO dto = dao.read(addressnum);
			
			request.setAttribute("addressnum", addressnum);
			request.setAttribute("dto", dto);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "/view/updateForm.jsp";
	}

}
