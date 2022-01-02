import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp extends JFrame implements MouseListener,ActionListener
{
	private JLabel account,fullname,studentid,password;
	private JTextField name,id;
	private JPasswordField pass;
	private JButton home,termsandconditions,signup,back;
	private JCheckBox read;
	private JPanel panel;
	
	public SignUp(){
		super("Pick-a-Book User Sign Up");
		this.setSize(1000 , 700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setLayout(null);
		
		account = new JLabel("CREATE A NEW ACCOUNT");
		account.setBounds(275, 50 , 500 , 30);
		account.setFont(new Font("Bradley Hand ITC",Font.BOLD,35));
		account.setForeground(Color.DARK_GRAY);
		panel.add(account);
		
		home = new JButton("Pick-a-Book");
		home.setBounds(800, 25 , 140 , 25);
		home.setFont(new Font("Monotype Corsiva",Font.BOLD,20));
		home.setBackground(Color.WHITE);
		home.setForeground(Color.magenta);
		home.addMouseListener(this);
		panel.add(home);
		
		
		fullname = new JLabel("Full Name");
		fullname.setBounds(350 , 150 , 200 , 30);
		fullname.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		fullname.setForeground(Color.DARK_GRAY);
		panel.add(fullname);
		
		name =  new JTextField();
		name.setBounds(350 , 175 , 300 , 30 );
		name.setFont(new Font("Calibri Light",0,20));
		panel.add(name);
		
		studentid = new JLabel("Student ID");
		studentid.setBounds(350 , 230 , 250 , 30);
		studentid.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		studentid.setForeground(Color.DARK_GRAY);
		panel.add(studentid);
		
		id =  new JTextField();
		id.setBounds(350 , 255 , 300 , 30 );
		id.setFont(new Font("Calibri Light",0,20));
		panel.add(id);
		
		password = new JLabel("Password");
		password.setBounds(350 , 310 , 250 , 30);
		password.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		password.setForeground(Color.DARK_GRAY);
		panel.add(password);
		
		pass =  new JPasswordField();
		pass.setBounds(350 , 335 , 300 , 30 );
		pass.setEchoChar('*');
		panel.add(pass);
	
	    read = new JCheckBox("By clicking it you are accepting the");
		read.setBounds(355, 365, 300,30);
		read.setFont(new Font("Centaur",Font.BOLD,18));
		read.setBackground(Color.PINK);
		read.setForeground(Color.WHITE);
		panel.add(read);
	
		termsandconditions = new JButton("terms & conditions");
		termsandconditions.setBounds(360, 393, 175,20);
		termsandconditions.setFont(new Font("Centaur",Font.BOLD,18));
		termsandconditions.setBackground(Color.magenta);
		termsandconditions.setForeground(Color.WHITE);
		termsandconditions.addMouseListener(this);
		termsandconditions.addActionListener(this);
		panel.add(termsandconditions);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(800 , 550 , 130 , 35);
		signup.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		signup.setBackground(Color.GRAY);
		signup.setForeground(Color.WHITE);
		signup.addMouseListener(this);
		signup.addActionListener(this);
		panel.add(signup);
		
		back = new JButton("BACK");
		back.setBounds(50 , 550 , 100 , 35);
		back.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		back.setBackground(Color.GRAY);
		back.setForeground(Color.WHITE);
		back.addMouseListener(this);
		back.addActionListener(this);
		panel.add(back);
	
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
		else if(btn == termsandconditions)
		{
		termsandconditions.setBackground(Color.WHITE);
		termsandconditions.setForeground(Color.magenta);
		}
		else if(btn == signup)
		{
		signup.setBackground(Color.WHITE);
		signup.setForeground(Color.DARK_GRAY);
		}
		else if(btn == back)
		{
		back.setBackground(Color.WHITE);
		back.setForeground(Color.DARK_GRAY);
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
		else if(btn == termsandconditions)
		{
		termsandconditions.setBackground(Color.magenta);
		termsandconditions.setForeground(Color.WHITE);
		}
		else if(btn == signup)
		{
		signup.setBackground(Color.GRAY);
		signup.setForeground(Color.WHITE);
		}
		else if(btn == back)
		{
		back.setBackground(Color.GRAY);	
		back.setForeground(Color.WHITE);
	    }
		else{}
		
	
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String s = a.getActionCommand();
		
		if(s.equals("terms & conditions"))
		{
			TermsAndConditions tac =new TermsAndConditions();
		    tac.setVisible(true);
		    this.setVisible(false);
			
		}
		else if(s.equals("SIGN UP"))
		{
			insertIntoDB();
			UserSignIn usi = new UserSignIn();
		    usi.setVisible(true);
          	this.setVisible(false);
			
		}
		else if(s.equals("BACK"))
		{
			UserSignIn usi = new UserSignIn();
		    usi.setVisible(true);
          	this.setVisible(false);
		}
	
	}
	public void insertIntoDB()
	{
		String query = "INSERT INTO user_info VALUES ('"+name.getText()+"','"+id.getText()+"',"+pass.getText()+");";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			stm.close();
			con.close();
					
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
    }
	
	
}




































