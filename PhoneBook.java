package W4;
import java.util.Scanner;

//클래스 설계
class Phone
{
	private String name;
	private String tel;
	
	//생성자
	public Phone()
	{
		this("무명","비공계");
	}
	public Phone(String name,String tel)
	{
		this.name = name;
		this.tel = tel;
	}
	
	//메서드-get기능
	String getName()
	{return this.name;}
	String getTel()
	{return this.tel; }
}

public class PhoneBook 
{
	//필드
	private Phone[] pArray;
	Scanner sc;
	private int max;
	private int count;//전화번호부에 저장된 인원수
	
	//생성자
	PhoneBook()
	{
		sc = new Scanner(System.in);
		max = 10;
		pArray = new Phone[max];
		count = 0;
	}
	
	//메서드
	void input()//추가메서드
	{
		if(count>=max)
		{
			System.out.println("전화번호부가 다 찼습니다.");
			return;
		}
		System.out.println("현재 저장된 인원수는 "+count+"명 입니다. (최대 "+max+"명 입력가능)");
		
		System.out.print("이름 입력>> ");
		String name = sc.next();
		System.out.print("전화번호 입력>> ");
		String tel = sc.next();
		
		pArray[count] = new Phone(name,tel);
		count++;
		System.out.println("추가 완료!");
	}
	String search(String name)//찾기메서드
	{
		int index=-1;
		
		for(int i=0;(i<pArray.length)&&(pArray[i]!=null);i++)
		{
			if(pArray[i].getName().equals(name))
			{
				index = i;
				break;
			}
		}
		
		if(index==-1) {return "error";}
		else
		{
			return "이름: "+name+", 전화번호: "+pArray[index].getTel();
		}
	}
	void remove(String name)
	{
		int index=-1;
		
		for(int i=0;(i<pArray.length)&&(pArray[i]!=null);i++)
		{
			if(pArray[i].getName().equals(name))
			{
				index = i;
				break;
			}
		}
		
		if(index==-1)
		{
			System.out.println("저장되지않은 이름입니다.");
		}
		else
		{
			pArray[index] = pArray[count-1];
			pArray[count-1]=null;
			count--;
			System.out.println(name+" 삭제 완료.");
		}
	}
	void run()//실행메서드
	{
		//데이터입력
		while(true)
		{
			System.out.println("(1).목록, (2).추가, (3).삭제, (4)검색, (5).종료");
			System.out.print("입력>> ");
			int choice = sc.nextInt();
			
			if(choice == 5)
			{
				System.out.println("종료합니다.....");
				break;
			}
			else if(choice==1)
			{
				System.out.println("총 "+count+"명 저장중");
				for(int i = 0;(i<pArray.length)&&pArray[i]!=null;i++)
				{
					if(count==0)
						break;
					System.out.println("이름: "+pArray[i].getName()+", 전화번호: "+pArray[i].getTel());
				}
			}
			else if(choice == 2)
			{
				input();
			}
			else if(choice ==3)
			{
				if(count<=0)
				{
					System.out.println("전화번호부가 비었습니다.");
				}
				else
				{
					System.out.print("삭제할 사람의 이름을 입력>>");
					String name = sc.next();
					
					remove(name);
				}
			}
			else if(choice==4)
			{
				System.out.print("검색할 사람의 이름을 입력>>");
				String name = sc.next();
				
				String result = search(name);
				if(result.equals("error")) {System.out.println("없는 이름입니다.");}
				else
				{
					System.out.println(result);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		new PhoneBook().run();
	}
}
