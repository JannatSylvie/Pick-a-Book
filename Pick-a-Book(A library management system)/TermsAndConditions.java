import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TermsAndConditions extends JFrame implements MouseListener,ActionListener
{
	private JLabel termsandconditions,termstext,publicuse,publicusetext,privacypolicy,privacypolicytext,information,informationtext,modifications,modificationstext;
	private JButton home,back,exit;
	private JPanel panel;

	
	public TermsAndConditions(){
		super("Pick-a-Book Issued Books");
		this.setSize(1000 , 700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setLayout(null);
	
	    home = new JButton("Pick-a-Book");
		home.setBounds(800, 25 , 140 , 25);
		home.setFont(new Font("Monotype Corsiva",Font.BOLD,20));
		home.setBackground(Color.WHITE);
		home.setForeground(Color.magenta);
		home.addMouseListener(this);
		panel.add(home);
		
	
	    termsandconditions = new JLabel(">>Terms & Conditions");
		termsandconditions.setBounds(25, 25 , 500 , 32);
		termsandconditions.setFont(new Font("Bradley Hand ITC",Font.BOLD,35));
		termsandconditions.setForeground(Color.WHITE);
		panel.add(termsandconditions);
	
	    termstext = new JLabel("All users must comply with the terms and conditions on this page.");
		termstext.setBounds(115, 125 , 875 , 25);
		termstext.setFont(new Font("Bradley Hand ITC",Font.BOLD,20));
		termstext.setForeground(Color.WHITE);
		panel.add(termstext);
	
	    publicuse = new JLabel("Public Use");
		publicuse.setBounds(115, 165 , 875 , 30);
		publicuse.setFont(new Font("Bradley Hand ITC",Font.BOLD,25));
		publicuse.setForeground(Color.DARK_GRAY);
		panel.add(publicuse);
	
	    publicusetext = new JLabel("All users should commit to ethics and values and should refrain from insult and abuse of it.");
		publicusetext.setBounds(115, 205 , 875 , 25);
		publicusetext.setFont(new Font("Bradley Hand ITC",Font.BOLD,20));
		publicusetext.setForeground(Color.WHITE);
		panel.add(publicusetext);
	
	    privacypolicy = new JLabel("Privacy Policy");
		privacypolicy.setBounds(115, 245 , 875 , 30);
		privacypolicy.setFont(new Font("Bradley Hand ITC",Font.BOLD,25));
		privacypolicy.setForeground(Color.DARK_GRAY);
		panel.add(privacypolicy);
	
	    privacypolicytext = new JLabel("All users have to read the privacy policy.");
		privacypolicytext.setBounds(115, 285 , 875 , 25);
		privacypolicytext.setFont(new Font("Bradley Hand ITC",Font.BOLD,20));
		privacypolicytext.setForeground(Color.WHITE);
		panel.add(privacypolicytext);
	
	    information = new JLabel("Information");
		information.setBounds(115, 325 , 875 , 30);
		information.setFont(new Font("Bradley Hand ITC",Font.BOLD,25));
		information.setForeground(Color.DARK_GRAY);
		panel.add(information);
	
	    informationtext = new JLabel("Pick-a-Book has the right to use the information input by users.");
		informationtext.setBounds(115, 365 , 875 , 25);
		informationtext.setFont(new Font("Bradley Hand ITC",Font.BOLD,20));
		informationtext.setForeground(Color.WHITE);
		panel.add(informationtext);
	
	    modifications = new JLabel("Modifications of Terms and Conditions");
		modifications.setBounds(115, 405 , 875 , 30);
		modifications.setFont(new Font("Bradley Hand ITC",Font.BOLD,25));
		modifications.setForeground(Color.DARK_GRAY);
		panel.add(modifications);
	
	    modificationstext = new JLabel("We have the right to modify terms and conditions if needed and whenever adequate.");
		modificationstext.setBounds(115, 445 , 875 , 25);
		modificationstext.setFont(new Font("Bradley Hand ITC",Font.BOLD,20));
		modificationstext.setForeground(Color.WHITE);
		panel.add(modificationstext);
	
	
		back = new JButton("BACK");
		back.setBounds(50 , 550 , 100 , 35);
		back.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		back.setBackground(Color.GRAY);
		back.setForeground(Color.WHITE);
		back.addMouseListener(this);
		back.addActionListener(this);
		panel.add(back);
		
		exit = new JButton("EXIT");
		exit.setBounds(783 , 550 , 100 , 35);
		exit.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		exit.setBackground(Color.GRAY);
		exit.setForeground(Color.WHITE);
		exit.addMouseListener(this);
		exit.addActionListener(this);
		panel.add(exit);
	
	
		this.add(panel);

	}	
	public void mouseClicked(MouseEvent m){}
	public void mousePressed(MouseEvent m){}
	public void mouseReleased(MouseEvent m){}
	public void mouseEntered(MouseEvent m)
	{
		
		JButton btn = (JButton)m.getComponent();
		
		if(btn == home)
		{	
	    home.setBackground(Color.pink);
		home.setForeground(Color.WHITE);
	    }
		else if(btn == back)
		{
		back.setBackground(Color.WHITE);
		back.setForeground(Color.DARK_GRAY);
		}
		else if(btn == exit)
		{
		exit.setBackground(Color.WHITE);
		exit.setForeground(Color.DARK_GRAY);
	    }
		else{}
	}
	public void mouseExited(MouseEvent m)
	{
		JButton btn = (JButton)m.getComponent();
	    
		
		if(btn == home)
		{
		    home.setBackground(Color.WHITE);
		    home.setForeground(Color.magenta);	
        }
		else if(btn == back)
		{
		    back.setBackground(Color.GRAY);	
	    	back.setForeground(Color.WHITE);
		}
		else if(btn == exit)
		{
	    	exit.setBackground(Color.GRAY);
     		exit.setForeground(Color.WHITE);
		}
		else{}
		
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String s = a.getActionCommand();
		
		
		if(s.equals("BACK"))
		{
			SignUp su = new SignUp();
	    	su.setVisible(true);
	    	this.setVisible(false);
			
		}
		
		else if(s.equals("EXIT"))
		{
			AdministratorSignIn asi = new AdministratorSignIn();
		    asi.setVisible(true);
          	this.setVisible(false);
			System.exit(0);
		}
	
	}
	
}
