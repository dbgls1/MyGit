package Ex;


public class StudentInput {
	
	private String name;
	private int kor;
	private int eng;
	private int com;
			
	//생성자 초기화.
	/*public StudentInput(String name, int kor, int eng, int com){
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.com=com;
	}*/
	
	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getCom() {
		return com;
	}
	
	//메소드: 이름, 국어, 영어 ,컴퓨터 정보를 입력받아 저장.
	public void input(String name, int kor, int eng, int com) {
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.com=com;
	}
	
}

