### DAY32(5/24 Tue)

---

[]()

[]()

[]()

[]()



##### 서블릿 기초 문법

\1. 서블릿이란
\- Jsp가 나오기전에 만들어진 웹페이지 생성 기술
\- 서블릿은 java의 많은 장점들을 사용 할 수 있지만 html, css, js 등과
 연동하기에 많은 단점이 있다
\- 기업에서 사용하는 프레임워크의 기초 기술로 사용된다.
\- WAS(tomcat)에서 웹페이지를 동적으로 생성하여 결과를 전송해 주는
 서버 측 프로그램이다.



(2) 서블릿의 주요 클래스
■HttpServlet
\- 서블릿을 만들기 위해서 반드시 상속해야 할 필수 클래스스
\- Servlet 인터페이스 > GenericServlet 추상클래스 > HttpServlet 상속구조
\- 위에서 제공되는 많은 메소드사용 가능
![img](http://lectureblue.pe.kr/ckstorage/images/was/jsp/07/5.jpg)

■HttpServletRequest
\- 클라이언트가 데이터를 입력하거나 클라이언트의 정보에 대한 요청 값을 가지고
 있다.
![img](http://lectureblue.pe.kr/ckstorage/images/was/jsp/07/6.jpg)

■HttpServletResponse
\- 클라이언트가 요청한 정보를 처리하고 응답을 위한 정보를 담고 있다.
![img](http://lectureblue.pe.kr/ckstorage/images/was/jsp/07/7.jpg)

■HttpSession
클라이언트가 세션정보를 저장하고, 세션 기능을 유지 하기 위해서 제공된다.
![img](http://lectureblue.pe.kr/ckstorage/images/was/jsp/07/8.jpg)

(3) 서블릿의 라이프 사이클
 ![img](http://lectureblue.pe.kr/ckstorage/images/was/jsp/07/9.jpg)

![img](http://lectureblue.pe.kr/ckstorage/images/was/jsp/07/10.jpg)