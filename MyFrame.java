package W4;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame
{
	private MyPanel panel = new MyPanel();
	
	public MyFrame()
	{
		setTitle("전화번호부");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,250);
		setVisible(true);
		
		setContentPane(panel);
	}
	
	class MyPanel extends JPanel
	{
		private String[] lines = new String[20]; // 한 화면에 표시할 최대 줄 수
	    private int lineCount = 0;
	
		public void setOutput(String[] newLines) 
		{
		    // 이번에 보여줄 것만 저장
		    lineCount = 0;
		    for (String s : newLines) 
		    {
		        lines[lineCount++] = s;
		    }
		    repaint(); // 다시 그리기 → paintComponent 호출됨
		}
		
		 
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
            int y = 30;
            for (int i = 0; i < lineCount; i++) 
            {
                g.drawString(lines[i], 30, y);
                y += 20; // 줄 간격
            }
		}
		
	}
	
	public void setOutput(String[] newLines) 
	{
        panel.setOutput(newLines);
    }
}
