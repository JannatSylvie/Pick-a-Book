import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignIn extends JFrame implements MouseListener,ActionListener
{
	
	private JLabel signin,tocontinue;
    private JButton home,administrator,user;
    private JPanel panel;	
	
    public SignIn(){
		super("Pick-a-Book Sign In");
		this.setSize(1000,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.PINK);
		
		panel.setLayout(null);
		
		signin = new JLabel("SIGN IN");
		signin.setBounds(340 , 50 , 400 , 30);
		signin.setFont(new Font("Bradley Hand ITC",Font.BOLD,30));
		signin.setForeground(Color.DARK_GRAY);
		panel.add(signin);
		
		tocontinue = new JLabel("to continue to Pick-a-Book");
		tocontinue.setBounds(340 , 70 , 800 , 30);
		tocontinue.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		tocontinue.setForeground(Color.DARK_GRAY);
		panel.add(tocontinue);
		
		home = new JButton("Pick-a-Book");
		home.setBounds(800, 25 , 140 , 25);
		home.setFont(new Font("Monotype Corsiva",Font.BOLD,20));
		home.setBackground(Color.WHITE);
		home.setForeground(Color.magenta);
		home.addMouseListener(this);
		home.addActionListener(this);
		panel.add(home);
		
		
		administrator = new JButton("as Administrator");
		administrator.setBounds(350 , 220 , 250 , 50);
		administrator.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		administrator.setBackground(Color.GRAY);
		administrator.setForeground(Color.WHITE);
		administrator.addMouseListener(this);
		administrator.addActionListener(this);
		panel.add(administrator);
		
		user = new JButton("as User");
		user.setBounds(350 , 300 , 250 , 50);
		user.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		user.setBackground(Color.GRAY);
		user.setForeground(Color.WHITE);
		user.addMouseListener(this);
		user.addActionListener(this);
		panel.add(user);
		
		
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
		else if(btn == administrator)
		{
		administrator.setBackground(Color.WHITE);
		administrator.setForeground(Color.DARK_GRAY);
		}
		else if(btn == user)
		{
		user.setBackground(Color.WHITE);
		user.setForeground(Color.DARK_GRAY);
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
		else if(btn == administrator)
		{
		administrator.setBackground(Color.GRAY);
		administrator.setForeground(Color.WHITE);
        }
		else if(btn == user)
		{
		user.setBackground(Color.GRAY);
		user.setForeground(Color.WHITE);
        }
		else{}
		
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String s = a.getActionCommand();
		
		
		if(s.equals("as Administrator"))
		{
			AdministratorSignIn asi = new AdministratorSignIn();
			asi.setVisible(true);
			this.setVisible(false);
			
		}
		else if(s.equals("as User"))
		{
			UserSignIn usi = new UserSignIn();
		    usi.setVisible(true);
			this.setVisible(false);
		}
	
	}
	
}