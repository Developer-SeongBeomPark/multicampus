package action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BbsDAO;
import model.BbsDTO;

public class replyProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
			BbsDTO dto = new BbsDTO();
			dto.setWname(request.getParameter("wname"));
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			dto.setPasswd(request.getParameter("passwd"));
			
			dto.setBbsno(Integer.parseInt(request.getParameter("bbsno")));
			dto.setGrpno(Integer.parseInt(request.getParameter("grpno")));
			dto.setIndent(Integer.parseInt(request.getParameter("indent")));
		    dto.setAnsnum(Integer.parseInt(request.getParameter("ansnum")));
			
		    BbsDAO dao = new BbsDAO();
		    
		    Map map = new HashMap();
			map.put("grpno", dto.getGrpno());
			map.put("ansnum", dto.getAnsnum());
			dao.upAnsnum(map);
		    
			boolean flag = dao.createReply(dto);
			
			request.setAttribute("flag", flag);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "/view/replyProc.jsp";
	}

}
