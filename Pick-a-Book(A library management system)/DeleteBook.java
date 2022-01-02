import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteBook extends JFrame implements MouseListener,ActionListener
{
	private JLabel deletebook,id;
	private JTextField textid;
	private JButton home,delete,back,signout;
	private JPanel panel;
	
	public DeleteBook(){
		super("Pick-a-Book Delete Book");
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
	
	    deletebook = new JLabel(">>Delete Book");
		deletebook.setBounds(25, 25 , 500 , 30);
		deletebook.setFont(new Font("Bradley Hand ITC",Font.BOLD,35));
		deletebook.setForeground(Color.WHITE);
		panel.add(deletebook);
	
	    id = new JLabel("Book ID");
		id.setBounds(350 , 227 , 250 , 30);
		id.setFont(new Font("Bradley Hand ITC",Font.BOLD,25));
		id.setForeground(Color.DARK_GRAY);
		panel.add(id);
		
		textid =  new JTextField();
		textid.setBounds(350 , 255 , 300 , 30 );
		textid.setFont(new Font("Calibri Light",0,20));
		panel.add(textid);
	
		delete = new JButton("Delete");
		delete.setBounds(554 , 287 , 94 , 25);
		delete.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		delete.setBackground(Color.GRAY);
		delete.setForeground(Color.WHITE);
		delete.addMouseListener(this);
		delete.addActionListener(this);
		panel.add(delete);
		
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
		else if(btn == delete)
		{
		    delete.setBackground(Color.WHITE);
     		delete.setForeground(Color.DARK_GRAY);
		
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
		else if(btn == delete)
		{
		    delete.setBackground(Color.GRAY);
		    delete.setForeground(Color.WHITE);
		
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
		else if(s.equals("Delete"))
		{
			deleteFromDB();
			JOptionPane.showMessageDialog(this,"Deleted Successfully");
			DeleteBook db = new DeleteBook();
            db.setVisible(true);			
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
		String query = "DELETE from list_of_books where BookId="+textid.getText()+";";
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
