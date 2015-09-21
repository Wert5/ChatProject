import javax.swing.JFrame;


public class MainChat extends JFrame {
	private String name="";
	private String message="";
	
	public MainChat(){
		super();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainChat screen= new MainChat();
		screen.setVisible(true);
		screen.setSize(500, 500);
	}

}
