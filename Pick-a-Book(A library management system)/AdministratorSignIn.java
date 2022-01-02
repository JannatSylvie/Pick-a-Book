import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdministratorSignIn extends JFrame implements MouseListener,ActionListener
{
	private JLabel administrator,adminid,password;
	private JTextField id;
	private JPasswordField pass;
	private JButton home,signin,back;
	private JPanel panel;
	private boolean flag;
	
	public AdministratorSignIn(){
		
		super("Pick-a-Book Administrator Sign In");
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
		home.addActionListener(this);
		panel.add(home);
		
		administrator = new JLabel("SIGN IN as Administrator");
		administrator.setBounds(150 , 170 , 400 , 30);
		administrator.setFont(new Font("Bradley Hand ITC",Font.BOLD,26));
		administrator.setForeground(Color.WHITE);
		panel.add(administrator);
		
		adminid = new JLabel("Administrator ID");
		adminid.setBounds(350 , 220 , 250 , 30);
		adminid.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		adminid.setForeground(Color.DARK_GRAY);
		panel.add(adminid);
		
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
		
		if(s.equals("SIGN IN"))
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
		String query = "SELECT * FROM `admin_info`";
		Connection con=null;//for connection
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
                String AdminId = rs.getString("AdminId");
                String Password = rs.getString("Password");
				
				
				if(AdminId.equals(id.getText()))
				{
					flag=false;
					if(Password.equals(pass.getText()))
					{
						AdminHomePage asp = new AdminHomePage();
			            asp.setVisible(true);
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
