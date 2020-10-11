package Ex;

public class Login {
	private static final String stId = "홍길동";
	private static final String stPw ="0000";
	public static int loginBool;
	
	public String getStId() {
		return stId;
	}
	
	public String getStPw() {
		return stPw;
	}
	
	public static boolean loginCheck(String id, String pw ) {
		// == 		: 주소를 비교한다.
		// equals() : 주소 안에 들어있는 값을 비교한다. 
		if(stId.equals(id) && stPw.equals(pw)) {
			System.out.println("프로그램에 로그인 되었습니다.");
			return true;
			
		}else {
			++loginBool;
			return false;
			
		}
	}
	
}
