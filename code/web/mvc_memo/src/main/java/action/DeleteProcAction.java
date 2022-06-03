package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemoDAO;

public class DeleteProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int memono = Integer.parseInt(request.getParameter("memono"));
		String passwd = request.getParameter("passwd");
		
		MemoDAO dao = new MemoDAO();
		Map map = new HashMap();
		map.put("memono", memono);
		map.put("passwd", passwd);
		boolean pflag = dao.passCheck(map);
		boolean flag = false;
		
		if(pflag) {
			flag = dao.delete(map);
		}
		
		request.setAttribute("pflag", pflag);
		request.setAttribute("flag", flag);
		
		return "/view/deleteProc.jsp";
	}

}
