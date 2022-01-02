import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminHomePage extends JFrame implements MouseListener,ActionListener
{
	private JLabel admin;
	private JButton home,booklist,addbook,deletebook,issuedbooks,issuebook,returnbook,userlist,signout;
    private JPanel panel;	
	

    public AdminHomePage(){
		super("Pick-a-Book Administrator Home Page");
		this.setSize(1000 , 700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setLayout(null);
		
		admin = new JLabel(">>HOME");
		admin.setBounds(25, 25 , 500 , 30);
		admin.setFont(new Font("Bradley Hand ITC",Font.BOLD,35));
		admin.setForeground(Color.WHITE);
		panel.add(admin);
		
		home = new JButton("Pick-a-Book");
		home.setBounds(800, 25 , 140 , 25);
		home.setFont(new Font("Monotype Corsiva",Font.BOLD,20));
		home.setBackground(Color.WHITE);
		home.setForeground(Color.magenta);
		home.addMouseListener(this);
		panel.add(home);
		
		
		booklist = new JButton("BOOKS");
		booklist.setBounds(390 , 100 , 220 , 40);
		booklist.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		booklist.setBackground(Color.GRAY);
		booklist.setForeground(Color.WHITE);
		booklist.addMouseListener(this);
		booklist.addActionListener(this);
		panel.add(booklist);

		addbook = new JButton("ADD a BOOK");
		addbook.setBounds(390 , 160 , 220 , 40);
		addbook.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		addbook.setBackground(Color.GRAY);
		addbook.setForeground(Color.WHITE);
		addbook.addMouseListener(this);
		addbook.addActionListener(this);
		panel.add(addbook);
		
		deletebook = new JButton("DELETE a BOOK");
		deletebook.setBounds(390 , 220 , 220 , 40);
		deletebook.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		deletebook.setBackground(Color.GRAY);
		deletebook.setForeground(Color.WHITE);
		deletebook.addMouseListener(this);
		deletebook.addActionListener(this);
		panel.add(deletebook);		
		
		issuedbooks = new JButton("ISSUED BOOKS");
		issuedbooks.setBounds(390 , 280 , 220 , 40);
		issuedbooks.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		issuedbooks.setBackground(Color.GRAY);
		issuedbooks.setForeground(Color.WHITE);
		issuedbooks.addMouseListener(this);
		issuedbooks.addActionListener(this);
		panel.add(issuedbooks);
		
      	issuebook = new JButton("ISSUE BOOK");
		issuebook.setBounds(390 , 340 , 220 , 40);
		issuebook.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		issuebook.setBackground(Color.GRAY);
		issuebook.setForeground(Color.WHITE);
		issuebook.addMouseListener(this);
		issuebook.addActionListener(this);
		panel.add(issuebook);
        
		returnbook = new JButton("RETURN BOOK");
		returnbook.setBounds(390 , 400 , 220 , 40);
		returnbook.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		returnbook.setBackground(Color.GRAY);
		returnbook.setForeground(Color.WHITE);
		returnbook.addMouseListener(this);
		returnbook.addActionListener(this);
		panel.add(returnbook);
		
		userlist = new JButton("USERS");
		userlist.setBounds(390 , 460 , 220 , 40);
		userlist.setFont(new Font("Bradley Hand ITC",Font.BOLD,22));
		userlist.setBackground(Color.GRAY);
		userlist.setForeground(Color.WHITE);
		userlist.addMouseListener(this);
		userlist.addActionListener(this);
		panel.add(userlist);
		
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
		else if(btn == booklist)
		{
		    booklist.setBackground(Color.WHITE);
	    	booklist.setForeground(Color.DARK_GRAY);
		}
		else if(btn == addbook)
		{
		    addbook.setBackground(Color.WHITE);
		    addbook.setForeground(Color.DARK_GRAY);
		}
		else if(btn == deletebook)
		{
	        deletebook.setBackground(Color.WHITE);
		    deletebook.setForeground(Color.DARK_GRAY);
		
		}
		else if(btn == issuedbooks)
		{
		    issuedbooks.setBackground(Color.WHITE);
		    issuedbooks.setForeground(Color.DARK_GRAY);
		}
		else if(btn == issuebook)
		{
		    issuebook.setBackground(Color.WHITE);
		    issuebook.setForeground(Color.DARK_GRAY);
		
		}
		else if(btn == returnbook)
		{
		    returnbook.setBackground(Color.WHITE);
		    returnbook.setForeground(Color.DARK_GRAY);
		
		}
		else if(btn == userlist)
		{
	    	userlist.setBackground(Color.WHITE);
	    	userlist.setForeground(Color.DARK_GRAY);
	
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
		else if(btn == booklist)
		{
		    booklist.setBackground(Color.GRAY);
		    booklist.setForeground(Color.WHITE);
		
		}
		else if(btn == addbook)
		{
		    addbook.setBackground(Color.GRAY);	
	    	addbook.setForeground(Color.WHITE);
		}
		else if(btn == deletebook)
		{
	        deletebook.setBackground(Color.GRAY);
		    deletebook.setForeground(Color.WHITE);
		
		}
		else if(btn == issuedbooks)
		{
		    issuedbooks.setBackground(Color.GRAY);
		    issuedbooks.setForeground(Color.WHITE);
		
		}
		else if(btn == issuebook)
		{
		    issuebook.setBackground(Color.GRAY);
		    issuebook.setForeground(Color.WHITE);
		
		}
		
		else if(btn == returnbook)
		{
		    returnbook.setBackground(Color.GRAY);
		    returnbook.setForeground(Color.WHITE);
		
		}
		else if(btn == userlist)
		{
	    	userlist.setBackground(Color.GRAY);	
		    userlist.setForeground(Color.WHITE);
		
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
		
		if(s.equals("BOOKS"))
		{
			ListOfBooks lob = new ListOfBooks();
     		lob.setVisible(true);
	    	this.setVisible(false);
			
		}
		else if(s.equals("ADD a BOOK"))
		{
			AddBook ab = new AddBook();
		    ab.setVisible(true);			
	        this.setVisible(false);
			
		}
		else if(s.equals("DELETE a BOOK"))
		{
		    DeleteBook db = new DeleteBook();
            db.setVisible(true);			
	        this.setVisible(false);
			
		}
		else if(s.equals("ISSUED BOOKS"))
		{
			IssuedBooks ibs = new IssuedBooks();
            ibs.setVisible(true);			
	        this.setVisible(false);
			
		}
		else if(s.equals("ISSUE BOOK"))
		{
			IssueBook ib = new IssueBook();
            ib.setVisible(true);			
	        this.setVisible(false);
			
		}
		else if(s.equals("RETURN BOOK"))
		{
			ReturnBook rb = new ReturnBook();
            rb.setVisible(true);			
	        this.setVisible(false);
			
		}
		else if(s.equals("USERS"))
		{
			Users us = new Users();
            us.setVisible(true);			
	        this.setVisible(false);
			
		}
		else if(s.equals("SIGN OUT"))
		{
			AdministratorSignIn asi = new AdministratorSignIn();
		    asi.setVisible(true);
          	this.setVisible(false);
		}
	
	}
	
	
}