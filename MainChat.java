import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MainChat extends JFrame implements ActionListener{
	private String nameSender="";
	private String message="";
	private SendPanel send = new SendPanel(this);
	private MessagePanel mesPan = new MessagePanel(this);
	
	public MainChat(){
		super();
		this.setTitle("Your Chat");
		this.getContentPane().add(send);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainChat screen= new MainChat();
		screen.setVisible(true);
		screen.setSize(500, 500);
	}

	public String getNameSender() {
		return nameSender;
	}

	public void setNameSender(String name) {
		this.nameSender = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source=e.getSource();
		if(source.getClass().getName().equals("javax.swing.JButton")){
			JButton but= (JButton)source;
			if(but.getActionCommand().equals("Send")){
				message=send.getMessageText();
				this.setTitle("Messsage from "+nameSender);
				mesPan.setMsg(message);
				mesPan.setVisible(true);
				this.getContentPane().removeAll();
				this.getContentPane().add(mesPan);
				this.getContentPane().repaint();
				this.getContentPane().revalidate();
			}else if(but.getActionCommand().equals("Exit")){
				message="";
				send.clear();
				this.setTitle(nameSender+"'s Chat");
				this.getContentPane().removeAll();
				this.getContentPane().add(send);
				this.getContentPane().repaint();
				this.getContentPane().revalidate();
			}else if(but.getActionCommand().equals("Send Picture")){
				JFileChooser imgChoose= new JFileChooser();
				imgChoose.addChoosableFileFilter(new FileNameExtensionFilter("Images","jpg"));
				imgChoose.showDialog(this, "Choose");
			}
		}else{
			nameSender=((JTextField) source).getText();
			this.setTitle(nameSender+"'s Chat");
		}
	}

}
