import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddBook extends JFrame implements MouseListener,ActionListener
{
	private JLabel addbook,bookname,authorname,bookid,copies;
	private JTextField book,author,id,textcopies;
	private JButton home,add,back,signout;
	private JPanel panel;

	
	public AddBook(){
		super("Pick-a-Book Add Book");
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
			
		addbook = new JLabel(">>Add Book");
		addbook.setBounds(25, 25 , 500 , 30);
		addbook.setFont(new Font("Bradley Hand ITC",Font.BOLD,35));
		addbook.setForeground(Color.WHITE);
		panel.add(addbook);
	
		bookname = new JLabel("Book Name");
		bookname.setBounds(350 , 150 , 200 , 30);
		bookname.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		bookname.setForeground(Color.DARK_GRAY);
		panel.add(bookname);
		
		book =  new JTextField();
		book.setBounds(350 , 175 , 300 , 30 );
		book.setFont(new Font("Calibri Light",0,20));
		panel.add(book);
		
		authorname = new JLabel("Author Name");
		authorname.setBounds(350 , 230 , 250 , 30);
		authorname.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		authorname.setForeground(Color.DARK_GRAY);
		panel.add(authorname);
		
		author =  new JTextField();
		author.setBounds(350 , 255 , 300 , 30 );
		author.setFont(new Font("Calibri Light",0,20));
		panel.add(author);
		
		bookid = new JLabel("Book ID");
		bookid.setBounds(350 , 310 , 250 , 30);
		bookid.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		bookid.setForeground(Color.DARK_GRAY);
		panel.add(bookid);
		
		id =  new JTextField();
		id.setBounds(350 , 335 , 300 , 30 );
		id.setFont(new Font("Calibri Light",0,20));
		panel.add(id);
	
		copies = new JLabel("Number of Copies");
		copies.setBounds(350 , 390 , 250 , 30);
		copies.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		copies.setForeground(Color.DARK_GRAY);
		panel.add(copies);
		
		textcopies =  new JTextField();
		textcopies.setBounds(350 , 415 , 300 , 30 );
		textcopies.setFont(new Font("Calibri Light",0,20));
		panel.add(textcopies);
	
		add = new JButton("Add");
		add.setBounds(568 , 447 , 80 , 25);
		add.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		add.setBackground(Color.GRAY);
		add.setForeground(Color.WHITE);
		add.addMouseListener(this);
		add.addActionListener(this);
		panel.add(add);
		
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
		else if(btn == add)
		{
		    add.setBackground(Color.WHITE);
     		add.setForeground(Color.DARK_GRAY);
		
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
		else if(btn == add)
		{
		    add.setBackground(Color.GRAY);
		    add.setForeground(Color.WHITE);
		
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
		
		else if(s.equals("Add"))
		{
			insertIntoDB();
			JOptionPane.showMessageDialog(this,"Added Successfully");
	        AddBook ab = new AddBook();
		    ab.setVisible(true);			
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
	
	public void insertIntoDB()
	{
		String query = "INSERT INTO list_of_books VALUES ('"+book.getText()+"','"+author.getText()+"','"+id.getText()+"',"+textcopies.getText()+");";
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




































