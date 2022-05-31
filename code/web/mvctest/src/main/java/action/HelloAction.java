package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandService;

public class HelloAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//1. model 사용
		CommandService service = new CommandService();
		StringBuffer sb = service.getHello();
		//2. 결과 request 저장
		request.setAttribute("hello", sb);
		//3. 결과 보여줄 view 선택(forward 방식)
		return "/view/hello.jsp";
	}

}
