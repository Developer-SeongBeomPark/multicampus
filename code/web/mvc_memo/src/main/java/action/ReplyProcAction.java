package action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemoDAO;
import model.MemoDTO;

public class ReplyProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
			
			MemoDAO dao = new MemoDAO();
			MemoDTO dto = new MemoDTO();
			
			dto.setMemono(Integer.parseInt(request.getParameter("memono")));
			dto.setWname(request.getParameter("wname"));
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			dto.setPasswd(request.getParameter("passwd"));
			dto.setGrpno(Integer.parseInt(request.getParameter("grpno")));
			dto.setIndent(Integer.parseInt(request.getParameter("indent")));
			dto.setAnsnum(Integer.parseInt(request.getParameter("ansnum")));
			
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
