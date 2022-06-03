package controller; 
 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.util.Iterator; 
import java.util.Map; 
import java.util.Properties; 
 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletConfig; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
import action.NullAction; 
import action.Action; 
 
public class Controller extends HttpServlet { 
    private boolean usingTemplate = false; 
    private String templatePage = null; 
    
    //명령어=명령처리Action객체
    private Map map = new java.util.HashMap(); 
     
    public void init(ServletConfig config) throws ServletException { 
        String configFile = config.getInitParameter("configFile"); 
         
        Properties prop = new Properties(); 
        FileInputStream fis = null; 
        try { 
            fis = new FileInputStream(configFile);
            prop.load(fis);
        } catch (IOException e) { 
            throw new ServletException(e); 
        } finally { 
            if (fis != null) try { fis.close(); } catch(IOException ex) {} 
        } 
         
        Iterator keyIter = prop.keySet().iterator(); 
        while( keyIter.hasNext() ) { 
            String command = (String)keyIter.next(); 
            System.out.println("command: " + command); 
 
            String handlerClassName = prop.getProperty(command).trim();  
            System.out.println("handlerClassName: " + handlerClassName); 
             
            try { 
                //클래스를 JVM으로 로딩합니다. 
                Class handlerClass = Class.forName(handlerClassName);
                //forName을 사용하는 이유 : handlerClass가 일정하지 않기 때문에 generic과 비슷한 느낌의 forName을 통해 Object객체로 바꿔준다.
                 
                //읽어들인 클래스의 객체를 생성합니다. 
                Object handlerInstance = handlerClass.newInstance(); 
                 
                //MAP에 키와 각 클래스별 객체가 저장합니다. 
                map.put(command, handlerInstance); 
                
            } catch (ClassNotFoundException e) { 
                throw new ServletException(e); 
            } catch (InstantiationException e) { 
                throw new ServletException(e); 
            } catch (IllegalAccessException e) { 
                throw new ServletException(e); 
            } 
        } 
      
        templatePage = config.getInitParameter("templatePage"); 
        
        if (templatePage != null && !templatePage.equals("")) { 
            usingTemplate = true; // 템플릿 페이지 존재 
        } 
    }
    
 //1. http 요청받음
    public void doGet( 
        HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        process(request, response); 
    } 
 
    protected void doPost( 
        HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        process(request, response); 
    } 
     
    private void process( 
        HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException { 
 
    	// 2. 요청 기능 분석
        String command = request.getRequestURI(); 
        System.out.println("RequestURI: " + request.getRequestURI()); 
        
        //URI:/www_mvc/mvc/list.do
        if (command.indexOf(request.getContextPath()) == 0) { 
            command = command.substring(request.getContextPath().length()); 
            System.out.println("command: " + command); 
        } 
         
 
        Action action =  
            (Action)map.get(command);
         
        // 핸들러가 없는 경우 
        if (action == null) { 
            action = new NullAction(); 
        }
        // 2. 요청 기능 분석 완료
         
        String viewPage = null; 
        try { 
        	// 3.model 사용, 4. request에 결과 저장, 5.view 선택 
 
            viewPage = action.execute(request, response);
        } catch(Throwable e) { 
            throw new ServletException(e); 
        } 
         
        if (usingTemplate) { 
            request.setAttribute("CONTENT_PAGE", viewPage); 
        } 
        
        // forward 처리
        RequestDispatcher dispatcher = 
           request.getRequestDispatcher( 
                   usingTemplate ? templatePage : viewPage); 
        dispatcher.forward(request, response); 
    } 
} 
