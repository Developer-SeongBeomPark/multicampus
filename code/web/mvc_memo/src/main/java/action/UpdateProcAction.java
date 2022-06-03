package action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemoDAO;
import model.MemoDTO;

public class UpdateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
			MemoDAO dao = new MemoDAO();
			MemoDTO dto = new MemoDTO();
			dto.setWname(request.getParameter("wname"));
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			dto.setPasswd(request.getParameter("passwd"));
			dto.setMemono(Integer.parseInt(request.getParameter("memono")));
			
			Map map = new HashMap();
			map.put("memono", dto.getMemono());
			map.put("passwd", dto.getPasswd());
			
			boolean pflag = dao.passCheck(map);
			boolean flag = false;
			
			if(pflag) {
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
