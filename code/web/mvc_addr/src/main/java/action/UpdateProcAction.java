package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddrDAO;
import model.AddrDTO;

public class UpdateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			AddrDAO dao = new AddrDAO();
			AddrDTO dto = new AddrDTO();
			dto.setAddressnum(Integer.parseInt(request.getParameter("addressnum")));
			dto.setName(request.getParameter("name"));
			dto.setHandphone(request.getParameter("handphone"));
			dto.setZipcode(request.getParameter("zipcode"));
			dto.setAddress(request.getParameter("address"));
			dto.setAddress2(request.getParameter("address2"));
			
			boolean flag = dao.update(dto);
			
			request.setAttribute("flag", flag);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/view/updateProc.jsp";
	}

}
