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
	public MyFrame frame;
	
	//생성자
	PhoneBook()
	{
		sc = new Scanner(System.in);
		max = 10;
		pArray = new Phone[max];
		count = 0;
		frame = new MyFrame();
	}
	
	//메서드
	void input()//추가메서드
	{
		String line = "";
		if(count>=max)
		{
			System.out.println("전화번호부가 다 찼습니다.");
			String[] out = new String[1];
			out[0] = "전화번호부가 다 찼습니다.";
			
			frame.setOutput(out);
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
		
		String[] out = new String[2];
		out[0] = "이름: "+name+", 전화번호: "+tel;
		out[1] = "추가 완료!";
		
		frame.setOutput(out);
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
			String[] out = new String[1];
			out[0] = "저장되지않은 이름입니다.";
			
			frame.setOutput(out);
		}
		else
		{
			pArray[index] = pArray[count-1];
			pArray[count-1]=null;
			count--;
			System.out.println(name+" 삭제 완료.");
			
			String[] out = new String[1];
			out[0] = name+" 삭제 완료.";
			frame.setOutput(out);
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
				String[] out = {"종료합니다....."};
				frame.setOutput(out);
				break;
			}
			else if(choice==1)
			{
				System.out.println("총 "+count+"명 저장중");
				String[] out = new String[count+1];
				out[0] = "총"+count+"명 저장중";
				for(int i = 0;(i<pArray.length)&&pArray[i]!=null;i++)
				{
					if(count==0)
						break;
					System.out.println("이름: "+pArray[i].getName()+", 전화번호: "+pArray[i].getTel());
					out[i+1] = "이름: "+pArray[i].getName()+", 전화번호: "+pArray[i].getTel();
				}
				
				frame.setOutput(out);
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
					String[] out = new String[1];
					out[0] = "전화번호부가 비었습니다.";
					
					frame.setOutput(out);
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
				
				String[] out = new String[1];
				String result = search(name);
				if(result.equals("error")) 
				{
					System.out.println("없는 이름입니다.");
					out[0] = name+"은(는) 없는 이름입니다.";
					frame.setOutput(out);
				}
				else
				{
					System.out.println(result);
					out[0] = result;
					frame.setOutput(out);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		new PhoneBook().run();
	}
}
