import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Magic8Ball extends JFrame{
	JTextField messageLabel = new JTextField(" Ask a question and it will be answered (oooh ahhh) ");

	public Magic8Ball() {
		initGUI(); 
		setTitle(" Magic 8 Ball"); 
		setResizable(true); 
		setSize(400,100);  
		setLocationRelativeTo(null); 
		setVisible(true); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		pack();
	}
	
	private void initGUI() {
		JLabel titleLabel = new JLabel("Magic 8 Ball");
		Font titleFont = new  Font ("Times New Roman", Font.BOLD, 50);
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(Color.BLACK);
		titleLabel.setOpaque(true);
		//add label to window
		add(titleLabel, BorderLayout.PAGE_START);
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		
		//CENTER PANEL
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.BLACK);
		add(centerPanel, BorderLayout.CENTER);
		//Dimension size = new Dimension(300,200);
		 
		centerPanel.add(messageLabel, BorderLayout.CENTER); 
		
		//BUTTON PANEL
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		add(buttonPanel, BorderLayout.PAGE_END);
		
		//BUTTONS
		JButton shake = new JButton("SHAKE");
		shake.setBackground(Color.BLACK);
		shake.setForeground(Color.WHITE);
		shake.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				//String newShake = shake(); 
				shake(); 
			}
		});
		buttonPanel.add(shake);
		
	}
		private void shake() { 
			String [] shake = {" Without a doubt ", 
					" No ", " Yes ", " You may rely on it ", 
					" Very doubtful "}; 
			int random = new Random().nextInt(shake.length); 
			//return shake[random];
			messageLabel.setText(shake[random]); 
			}
		
public static void main(String[] args) {
	try {
        //UI = user interface
		String className = UIManager.getCrossPlatformLookAndFeelClassName();
        UIManager.setLookAndFeel(className);
    } catch ( Exception e) {}
    
    EventQueue.invokeLater(new Runnable (){
        @Override
        public void run() {
            new Magic8Ball();
        }   
    });
}

}

