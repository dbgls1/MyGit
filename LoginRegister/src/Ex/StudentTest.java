package Ex;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class StudentTest extends Login {
	public static boolean check;  
	
	public static void main(String[] args) {
		
		Vector<StudentInput> vc= new Vector<>();
		
		//StudentInput si = new StudentInput();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("사용자 확인을 위해 ID를 입력하세요. (남은 기회: "+(3-loginBool)+"회)");
			String id = sc.next();
			System.out.println("PassWord를 입력하세요.");
			String pw = sc.next();
			//입력한 pw를 콘솔창에서 안보이게 할 수 있나..??
			 
			check=loginCheck(id, pw);
			
			while(check) {
				System.out.println("1~3번 중에 원하는 메뉴 번호를 선택하세요.");
				System.out.println("1: 학생정보 입력");
				System.out.println("2: 학생정보 출력");
				System.out.println("3: 프로그램 종료");
				
				int num = 0;
				
				//정수 아닌 값을 입력시, 정수 입력할 때까지 반복. 
				while(true) {
					try {
						num = sc.nextInt();//sc에서 받은 값이 숫자가 아닌경우 에러발생.
						break;
						
					}catch (InputMismatchException e) {
						System.out.println("잘못 입력하셨습니다. 숫자를 입력해주세요.");
						//새롭게 입력받은 값을 sc에 대입.
						sc = new Scanner(System.in);
						
					}catch (Exception e) {
						e.printStackTrace();
						
					}
					
				}
								
				switch(num) {
					case 1 :
						System.out.println("*****************************");
						System.out.println("학생 정보를 입력합니다. 다음을 입력하세요\n이름: ");
						String name1 = sc.next();
						//이름을 nextLine으로 입력받으니 에러발생.
						//국어점수 입력하고나서 에러발생. 왜???
						//이름 입력을 생략하고 국어점수부터 입력받으면 문제없음..
						//이름 대신 숫자를 입력하면 문제가 없음...
						//몇번 돌려보니, 이름을 입력할 때 커서가 안내문구 중간에 있어서 (이름 +Enter)후에 안내문구 일부가 버퍼에 남아있다가
						//다음 점수 입력때 nextInt에 입력되어서 자꾸 오류가 남...
						//System.out.flush()써도 안되네.. 그냥 커퍼 위치 옮겨서 입력하는 수밖에..
						System.out.println("국어 점수: ");
						int kor= sc.nextInt();
						System.out.println("영어 점수: ");
						int eng= sc.nextInt();
						System.out.println("컴퓨터 점수: ");
						int com= sc.nextInt();
							
						StudentInput si = new StudentInput();//객체생성
							
						si.input(name1, kor, eng, com);//메서드로 정보입력받아서 입력.
						vc.add(si);//벡터에 객체 추가.
						System.out.println(name1+"학생의 정보가 입력되었습니다.");
						System.out.println("*****************************");
						break;
						
					case 2 :	
						StudentOutput so = new StudentOutput();//객체생성
						
						so.size = vc.size();//벡터에 저장된 학생수
						if(so.size==0) {
							System.out.println("학생정보가 비어있습니다.");
							System.out.println("*****************************");
						}else {
							System.out.println("학생정보를 출력합니다. 찾는 학생의 이름을 입력하세요");
							String name2 = sc.next();
														
							so.showInfo(name2, vc);
							
						}
						break;
					
					case 3 :	System.out.println("프로그램이 종료되었습니다.");	break;
					//switch문에서 나올뿐, 작은 while문에서 벗어나지 못함..
					default :System.out.println("잘못 누르셨습니다.");
							System.out.println("*****************************");
							continue;
				}
					
				if(num==3) {//작은 while문에서 벗어나기
					break;
						
				}
				
			}
			
			//작은 while문 조건(프로그램 로그인)은 만족하였지만, 그 다음 경우 선택하기.  
			if(check) {//큰 while문에서 벗어나기
				break;
			}
			
			//작은 while문 조건(프로그램 로그인) 불만족시
			if(loginBool<3) {
				System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
				System.out.println("(3회 오류 발생시, 자동으로 종료됩니다.)");
				System.out.println("*****************************");
				continue;
				
			}else {
				System.out.println("로그인 실패가 3회 이상 발생하여 종료됩니다.");
				break;
				
			}
		}
		sc.close();
		
	}

}
