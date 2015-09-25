import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MainChat extends JFrame implements ActionListener{
	private String nameSender="";
	private String message="";
	private File imgFile=null;
	private File sFile=null;
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
			}else if(but.getActionCommand().equals("Choose Picture")){
				JFileChooser imgChoose= new JFileChooser();
				imgChoose.addChoosableFileFilter(new FileNameExtensionFilter("Images","jpg"));
				if(imgChoose.showDialog(this, "Choose")==JFileChooser.APPROVE_OPTION){
					imgFile=imgChoose.getSelectedFile();
					mesPan.setImg(imgFile);
				}else{
					imgFile=null;
				}
			}else if(but.getActionCommand().equals("Choose Sound")){
				JFileChooser imgChoose= new JFileChooser();
				imgChoose.addChoosableFileFilter(new FileNameExtensionFilter("Sounds","wav"));
				if(imgChoose.showDialog(this, "Choose")==JFileChooser.APPROVE_OPTION){
					sFile=imgChoose.getSelectedFile();
				}else{
					sFile=null;
				}
			}else if(but.getActionCommand().equals("Play Sound")){
				if(sFile !=null){
					EasySound es=new EasySound(sFile.getPath());
					es.play();
				}
			}
		}else{
			nameSender=((JTextField) source).getText();
			this.setTitle(nameSender+"'s Chat");
		}
	}

}

