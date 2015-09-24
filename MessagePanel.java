import java.awt.*;

import javax.swing.*;

public class MessagePanel extends JPanel {
	private JTextArea msg= new JTextArea("Help");
	private JScrollPane scroll= new JScrollPane(msg);
	private JButton exitBut= new JButton("Exit");
	private Box b=Box.createVerticalBox();
	public MessagePanel(MainChat listen){
		super();
		msg.setEditable(false);
		this.add(b);
		
		//scroll.add(msg);
		b.add(scroll);
		b.add(exitBut);
		exitBut.addActionListener(listen);
	}
	
	public void setMsg(String txt){
		msg.setText(txt);
		repaint();
	}
}
