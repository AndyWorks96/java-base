package timer;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;
import java.util.function.Predicate;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class TimerTest {
	
	public static void main(String[] args) {
		ActionListener listener=new TimePrinter();
		Timer t=new Timer(1000, listener);
		t.start();
		//消息提示框
		JOptionPane.showMessageDialog(null, "quit Program?");
		System.exit(0);
	}
}

class TimePrinter implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("At the tone,the time is "+new Date());
		Toolkit.getDefaultToolkit().beep();
	}

}
