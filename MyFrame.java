package W4;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame
{
	private MyPanel panel = new MyPanel();
	
	public MyFrame()
	{
		setTitle("drawString 사용예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,200);
		setVisible(true);
		
		setContentPane(panel);
	}
	
	class MyPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawString("자바는 재밌다.~~", 30, 30);
			g.drawString("재미없다", 30, 60);
		}
	}
	
	public static void main(String[] args)
	{
		new MyFrame();
	}
}
