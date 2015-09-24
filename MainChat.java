import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MainChat extends JFrame implements ActionListener{
	private String name="";
	private String message="";
	private SendPanel send = new SendPanel(this);
	private MessagePanel mesPan = new MessagePanel(this);
	
	public MainChat(){
		super();
		this.getContentPane().add(send);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainChat screen= new MainChat();
		screen.setVisible(true);
		screen.setSize(500, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source=e.getSource();
		if(source.getClass().getName().equals("javax.swing.JButton")){
			JButton but= (JButton)source;
			if(but.getActionCommand().equals("Send")){
				
			}
		}else{
			name=((JTextField) source).getText();
			this.setTitle(name+"'s Chat");
		}
	}

}
