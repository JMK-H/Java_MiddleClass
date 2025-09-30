package W4;

class Circle
{//필드 + 메서드
	protected int radius;//생략형 -패키지단위
	String name;
	//기본생성자 - 컴파일러가 자동추가해줌
	//메서드
	
	Circle()
	{
		this.radius = 1;
		this.name = "동그라미";
	}
	
	Circle(int radius,String name)
	{
		this.radius = radius;
		this.name = name;
	}
	
	double getArea()
	{
		return radius*radius*3.14;
	}
}

public class CircleMain 
{
	public static void main(String[] args)
	{//객체생성 - 메모리할당
		Circle pizza = new Circle(); //타입형 + 레퍼런스변수이름 = new + 기본생성자
		
		double res = pizza.getArea();
		System.out.println("피자의 면적은 " +res+"입니다");
		System.out.println("피자의 이름은 "+pizza.name+"입니다.");
		
		pizza.radius = 10;
		pizza.name = "김선엽";
		
		res = pizza.getArea();
		System.out.println("피자의 면적은 " +res+"입니다");
		System.out.println("피자의 이름은 "+pizza.name+"입니다.");
		
		Circle donut = new Circle(5,"김치");
		
		System.out.println(donut.name +" " +donut.radius);
	}
}
