import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ReturnBook extends JFrame implements MouseListener,ActionListener
{
	private JLabel returnbook,studentid,bookid;
	private JTextField sid,bid;
	private JButton home,returns,back,signout;
	private JPanel panel;
	
	public ReturnBook(){
		super("Pick-a-Book Issue Book");
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
		home.addActionListener(this);
		panel.add(home);
		
		returnbook = new JLabel(">>Return Book");
		returnbook.setBounds(25, 25 , 500 , 30);
		returnbook.setFont(new Font("Bradley Hand ITC",Font.BOLD,35));
		returnbook.setForeground(Color.WHITE);
		panel.add(returnbook);
		
		studentid = new JLabel("Student ID");
		studentid.setBounds(350 , 230 , 250 , 30);
		studentid.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		studentid.setForeground(Color.DARK_GRAY);
		panel.add(studentid);
		
		sid =  new JTextField();
		sid.setBounds(350 , 255 , 300 , 30 );
		sid.setFont(new Font("Calibri Light",0,20));
		panel.add(sid);
		
		bookid = new JLabel("Book ID");
		bookid.setBounds(350 , 310 , 250 , 30);
		bookid.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		bookid.setForeground(Color.DARK_GRAY);
		panel.add(bookid);
		
		bid =  new JTextField();
		bid.setBounds(350 , 335 , 300 , 30 );
		bid.setFont(new Font("Calibri Light",0,20));
		panel.add(bid);
	
		
		returns = new JButton("Return");
		returns.setBounds(540 , 367 , 107 , 25);
		returns.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		returns.setBackground(Color.GRAY);
		returns.setForeground(Color.WHITE);
		returns.addMouseListener(this);
		returns.addActionListener(this);
		panel.add(returns);
		
		back = new JButton("BACK");
		back.setBounds(50 , 550 , 100 , 35);
		back.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		back.setBackground(Color.GRAY);
		back.setForeground(Color.WHITE);
		back.addMouseListener(this);
		back.addActionListener(this);
		panel.add(back);
		
		signout = new JButton("SIGN OUT");
		signout.setBounds(783 , 550 , 147 , 35);
		signout.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		signout.setBackground(Color.GRAY);
		signout.setForeground(Color.WHITE);
		signout.addMouseListener(this);
		signout.addActionListener(this);
		panel.add(signout);
	
	
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
		else if(btn == returns)
		{
		returns.setBackground(Color.WHITE);
		returns.setForeground(Color.DARK_GRAY);
		}
		else if(btn == back)
		{
		back.setBackground(Color.WHITE);
		back.setForeground(Color.DARK_GRAY);
		}
		else if(btn == signout)
		{
		signout.setBackground(Color.WHITE);
		signout.setForeground(Color.DARK_GRAY);
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
		else if(btn == returns)
		{
		returns.setBackground(Color.GRAY);
		returns.setForeground(Color.WHITE);
		}
		else if(btn == back)
		{
		back.setBackground(Color.GRAY);
		back.setForeground(Color.WHITE);
		}
		else if(btn == signout)
		{
		signout.setBackground(Color.GRAY);
		signout.setForeground(Color.WHITE);
	    }
		else{}
		
		
		
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String s = a.getActionCommand();
		
		
		if(s.equals("Pick-a-Book"))
		{
			AdminHomePage asp = new AdminHomePage();
			asp.setVisible(true);
			this.setVisible(false);
			
		}
		else if(s.equals("Return"))
		{
			deleteFromDB();
			JOptionPane.showMessageDialog(this,"Returned Successfully");
			ReturnBook rb = new ReturnBook();
            rb.setVisible(true);			
	        this.setVisible(false);
			
		}
		else if(s.equals("BACK"))
		{
			AdminHomePage asp = new AdminHomePage();
			asp.setVisible(true);
			this.setVisible(false);
			
		}
		
		else if(s.equals("SIGN OUT"))
		{
			AdministratorSignIn asi = new AdministratorSignIn();
		    asi.setVisible(true);
          	this.setVisible(false);
		}
	
	}
	
	public void deleteFromDB()
	{
		String query = "DELETE from issued_books where BookId="+bid.getText()+" and StudentId="+sid.getText()+";";
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




































