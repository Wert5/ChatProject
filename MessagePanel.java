import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MessagePanel extends JPanel {
	private JTextArea msg= new JTextArea("Help");
	private File imgFile=null;
	private JLabel imgLabel=new JLabel();
	private JButton playBut= new JButton("Play Sound");
	private JScrollPane scroll= new JScrollPane(msg);
	private JButton exitBut= new JButton("Exit");
	private Box b=Box.createVerticalBox();
	public MessagePanel(MainChat listen){
		super();
		msg.setEditable(false);
		this.add(b);
		
		//scroll.add(msg);
		b.add(scroll);
		b.add(imgLabel);
		b.add(playBut);
		b.add(exitBut);
		exitBut.addActionListener(listen);
		playBut.addActionListener(listen);
	}
	
	public void setMsg(String txt){
		msg.setText(txt);
		repaint();
	}
	
	public void setImg(File f){
		imgFile=f;
		BufferedImage img = null; 
		try {
		    img = ImageIO.read(f);
		    ImageIcon icon = new ImageIcon(img);
		    icon=new ImageIcon(icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
		    imgLabel.setIcon(icon);
		} catch (IOException e) { }

		repaint();
	}
}
