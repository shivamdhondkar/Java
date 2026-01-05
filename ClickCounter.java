

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ClickCounter implements ActionListener {
	String count = "0";
	JButton jb = new JButton();
	JLabel jl = new JLabel();
	
	public  ClickCounter() {
		JFrame jf = new JFrame();
		jf.setSize(400, 400);
		
		
		jb.setBounds(150, 100, 100, 50);
        jb.addActionListener(this);
		jf.add(jb);
		
		
		jl.setBounds(300, 150, 100, 50);
		jf.add(jl);
		
		jf.setVisible(true);
	}
	
	public static void main(String args[]) {
		ClickCounter cc = new ClickCounter();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int cou = Integer.parseInt(count);
		cou = cou++;
		//jl.setText(cou);
	}

}
