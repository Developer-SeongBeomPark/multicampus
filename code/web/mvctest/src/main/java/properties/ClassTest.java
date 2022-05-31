package properties;

interface Action{
	void execute();
}

class Spring implements Action{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("따뜻한 봄입니다. - 새싹");
	}
	
}

class Summer implements Action{ 
    public void execute(){ 
        System.out.println("더운 여름입니다. - 바다"); 
    } 
} 

class Fall implements Action{ 
    public void execute(){ 
        System.out.println("시원한 가을입니다. - 등산"); 
    } 
} 

class Winter implements Action{ 
    public void execute(){ 
        System.out.println("눈이오는 겨울입니다. - X-MAS"); 
    } 
} 

public class ClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String className = args[0];
		try {
			Class object = Class.forName(className);
			Action instance = (Action)object.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
