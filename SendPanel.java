import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class SendPanel extends JPanel implements ActionListener{
	private MainChat wind= null;
	private JTextArea mesBox= new JTextArea();
	private JTextField nameBox= new JTextField();
	private JButton sendBut=new JButton("Send");
	public SendPanel(MainChat listen){
		super();
		wind=listen;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("Message:"));
		this.add(mesBox);
		this.add(new JLabel("Name:"));
		this.add(nameBox);
		this.add(sendBut);
		sendBut.addActionListener(wind);
		nameBox.addActionListener(wind);
	}
	
	public void clear(){
		mesBox.setText("");
	}
	public String getMessageText(){
		return mesBox.getText();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
