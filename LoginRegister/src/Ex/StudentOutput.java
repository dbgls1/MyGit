package Ex;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class StudentOutput extends StudentInput{
	
	int size;//vector에 저장된 학생 수
	int sum ;
	double avg;
		
	Scanner sc = new Scanner(System.in);
	
	//원하는 학생의 정보(이름, 국어, 영어, 컴퓨터, 합계, 평균)를 출력
	public void showInfo(String name, Vector<StudentInput> vc){
		
		Iterator<StudentInput> itr = vc.iterator();
		int cnt=0;
		
		while(itr.hasNext()) {//hasNext(): 다음 요소가 있으면 true 리턴 
			//마지막 요소까지 순차적으로 순회한다.
			StudentInput si = itr.next();//next()
			if(si.getName().equals(name)) {
				sum = si.getKor()+si.getEng()+si.getCom();
				avg = (double)(sum)/3;
				System.out.println("*****************************");		
				System.out.println("이름: "+si.getName());
				System.out.println("국어: "+si.getKor());
				System.out.println("영어: "+si.getEng());
				System.out.println("컴퓨터: "+si.getCom());
				System.out.println("합계: "+sum);
				System.out.println("평균: "+avg);
				System.out.println("*****************************");
				++cnt;
				break;
			}
		}
		
		if(cnt!=1) {
			System.out.println("없는 학생입니다.");
			System.out.println("*****************************");
		}
	}
}

