package action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BbsDAO;
import model.BbsDTO;

public class UpdateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
			
			BbsDAO dao = new BbsDAO();
			BbsDTO dto = new BbsDTO();
			dto.setWname(request.getParameter("wname"));
			dto.setTitle(request.getParameter("wname"));
			dto.setContent(request.getParameter("content"));
			dto.setPasswd(request.getParameter("passwd"));
			dto.setBbsno(Integer.parseInt(request.getParameter("bbsno")));
			
			Map map = new HashMap();
			map.put("bbsno", dto.getBbsno());
			map.put("passwd", dto.getPasswd());
			boolean pflag = dao.passCheck(map);
			boolean flag = false;
			if(pflag){
				flag = dao.update(dto);
			}
			request.setAttribute("pflag", pflag);
			request.setAttribute("flag", flag);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "/view/updateProc.jsp";
	}

}
