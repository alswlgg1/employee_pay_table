package employeePay;

import java.util.Scanner;

/*1. 입력 자료 수는main(String[] args) 이용하여 입력 받는다.
2. 사원번호, 이름을 입력
3. 사원의 근무유형은 관리직(1), 정규직(2), 임시직(3)으로 구분한다.
사원번호가 잘 못 입력되면 “근무유형 오류 재입력….”을 출력하고 다시 입력을 받는다.
4. 관리자 - 직책과 임금을 입력
정규직 - 부서, 업무, 임금을 입력
임시직 - 부서, 월 근무시간수
5. 직무 유형에 따라 수당
관리자 : 20만원 정규직 : 10만원을 더해서 급여액을 더하여 출력한다.
임시직 : 시간당 3만원으로 정하고 시간 수에 월급여액을 구해서 출력한다.
*/

public class TestEmployee {
	
	public static void main(String[] args) {
  TempEmployee tp;
  RegEmployee re;
	// 필드선언시 클래스타입, 임시직, 정규직 
	
		
	// 필드선언시 기본타입변수,String no,name
	String no = null ,name = null;
	
	// main 메서드 매개변수인 args 를 배열 선언한다.
	int n = Integer.parseInt(args[0]);
			Scanner scan = new Scanner(System.in);
	// 부모의 클래스를 입력하는 개수로 배열을 만든다. 
			
			System.out.print("입력 자료 수 :");
			int n1 = scan.nextInt();
			Employee []emp = new Employee[n1];
			
			// 1. 입력 자료 수 만큼 반복문 for
			for(int i = 0; i < n1; i++) {
				//2. System.out.print ("사원번호 , 이름..");
				System.out.print("사원번호, 이름... ");
				//3. no, name 에 사원번호와 이름을 넣는다. 
				no = scan.next ();
                name = scan.next();             
			
			
			//4.  System.out.print("사원의 근무유형 : (1:CEO, 2:정규직, 3:임시직)..."

				System.out.print("사원의 근무유형 : (1:CEO, 2:정규직, 3: 임시직)...");
				
				int eno = scan.nextInt ();
				if (eno < 1  || eno >3) {
					System.out.println("근무유형 오류 재입력...");
			       i--;
					continue; 
				}
				
		
			
			switch (eno) {
			case 1 : 
              System.out.print("직책, 월 임금...");
              String title = scan.next();
              Long pay = scan.nextLong();
              Staff sa = new Staff (name,no,title);
              sa.setStaffpay(pay);
              emp[i] = sa;
              break;
              
			case 2 : 
				System.out.print("부서, 업무, 월 임금...");
				String regtitle = scan.next();
				String dept = scan.next();
				long regpay = scan.nextLong();
				
				re = new RegEmployee (name, no, dept,regpay,regtitle);
				emp[i] = re;
                break;
                
				
				
			case 3 : 
				System.out.print("부서,월 근무시간 ...");
				String hdept = scan.next();
				long temphour = scan.nextLong();
				tp = new TempEmployee(name, no, hdept, temphour);
				emp[i] = tp;
				break;
				
			default:
				
			}
			}
			
			
				System.out.println("\n 급여보고서");
				
				for(Employee g : emp ) {
					System.out.println (g + " 급여액" + g.earnings() + "만원");
						
					}

	}

}