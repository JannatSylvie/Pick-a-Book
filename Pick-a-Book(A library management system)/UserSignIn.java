import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserSignIn extends JFrame implements MouseListener,ActionListener
{
	private JLabel user,studentid,password,newtopickabook;
	private JTextField id;
	private JPasswordField pass;
	private JButton home,signup,signin,back;
	private JPanel panel;
	private boolean flag;
	
	public UserSignIn(){
		
		super("Pick-a-Book User Sign In");
		this.setSize(1000,700);
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
		
		
		user = new JLabel("SIGN IN as User");
		user.setBounds(230 , 170 , 400 , 30);
		user.setFont(new Font("Bradley Hand ITC",Font.BOLD,26));
		user.setForeground(Color.WHITE);
		panel.add(user);
		
		studentid = new JLabel("Student ID");
		studentid.setBounds(350 , 220 , 250 , 30);
		studentid.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		studentid.setForeground(Color.DARK_GRAY);
		panel.add(studentid);
		
		id =  new JTextField();
		id.setBounds(350 , 245 , 300 , 30 );
		id.setFont(new Font("Calibri Light",0,20));
		panel.add(id);
		
		password = new JLabel("Password");
		password.setBounds(350 , 300 , 250 , 30);
		password.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		password.setForeground(Color.DARK_GRAY);
		panel.add(password);
		
		pass =  new JPasswordField();
		pass.setBounds(350 , 325 , 300 , 30 );
		pass.setEchoChar('*');
		panel.add(pass);
		
		newtopickabook = new JLabel("New to Pick-a-Book?");
		newtopickabook.setBounds(350 , 355 , 200 , 30);
		newtopickabook.setFont(new Font("Gabriola",Font.BOLD,20));
		newtopickabook.setForeground(Color.magenta);
		panel.add(newtopickabook);
		
		signup = new JButton("sign up");
		signup.setBounds(500 , 358 , 87 , 20);
		signup.setFont(new Font("Gabriola",Font.BOLD,20));
		signup.setBackground(Color.GRAY);
		signup.setForeground(Color.WHITE);
		signup.addMouseListener(this);
		signup.addActionListener(this);
		panel.add(signup);
		
		signin = new JButton("SIGN IN");
		signin.setBounds(800 , 550 , 130 , 35);
		signin.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		signin.setBackground(Color.GRAY);
		signin.setForeground(Color.WHITE);
		signin.addMouseListener(this);
		signin.addActionListener(this);
		panel.add(signin);
		
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
		else if(btn == signup)
		{
		signup.setBackground(Color.WHITE);
		signup.setForeground(Color.DARK_GRAY);
	    }
		else if(btn == signin)
		{
		signin.setBackground(Color.WHITE);
		signin.setForeground(Color.DARK_GRAY);
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
		else if(btn == signup)
		{
		signup.setBackground(Color.GRAY);
		signup.setForeground(Color.WHITE);	
		}	
		else if(btn == signin)
		{
		signin.setBackground(Color.GRAY);
		signin.setForeground(Color.WHITE);
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
		
		
		if(s.equals("sign up"))
		{
			SignUp su = new SignUp();
	    	su.setVisible(true);			
	        this.setVisible(false);
			
		}
		else if(s.equals("SIGN IN"))
		{
			System.out.println("hello");
			flag=true;
			check();
		}
		else if(s.equals("BACK"))
		{
			SignIn si = new SignIn();
		    si.setVisible(true);
			this.setVisible(false);
		}
	
	}
	
    public void check()
	{
		String query = "SELECT * FROM `user_info`";
		Connection con = null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;
        try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
					
			while(rs.next())
			{
                String StudentId = rs.getString("StudentId");
                String Password = rs.getString("Password");
				
				
				if(StudentId.equals(id.getText()))
				{
					flag=false;
					if(Password.equals(pass.getText()))
					{
						Books b = new Books();
			            b.setVisible(true);
			            this.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Invalid Password"); 
					}
				}			
			}
			if(flag){JOptionPane.showMessageDialog(this,"Invalid ID"); }
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
    }
	
	
}