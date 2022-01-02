import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;


public class ListOfBooks extends JFrame implements MouseListener,ActionListener
{
	private JLabel book;
	private JTextField text;
	private JButton home,search,back,signout;
	private JPanel panel;
	private JFrame frame;    
	
	public ListOfBooks(){
		
		super("Pick-a-Book List of Books");
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
		
		book = new JLabel(">>Books");
		book.setBounds(25, 25 , 500 , 30);
		book.setFont(new Font("Bradley Hand ITC",Font.BOLD,35));
		book.setForeground(Color.WHITE);
		panel.add(book);
		
		text =  new JTextField();
		text.setBounds(625 , 120 , 250 , 25 );
		text.setFont(new Font("Calibri Light",0,20));
		panel.add(text);
		
		
		search = new JButton("Search");
		search.setBounds(875 , 122 , 90 , 20);
		search.setFont(new Font("Bradley Hand ITC",0,20));
		search.setBackground(Color.GRAY);
		search.setForeground(Color.WHITE);
		search.addMouseListener(this);
		search.addActionListener(this);
		panel.add(search);
		
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
	
	tableFromDB();
    
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
		else if(btn == search)
		{
		search.setBackground(Color.WHITE);
		search.setForeground(Color.DARK_GRAY);
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
		else if(btn == search)
		{
		search.setBackground(Color.GRAY);
		search.setForeground(Color.WHITE);
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
		else if(s.equals("Search"))
		{
			searchFromDB();
			
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
	
  
    public void tableFromDB()
	{
		
      try {
         Class.forName("com.mysql.jdbc.Driver");
      } catch(ClassNotFoundException e) {
         System.out.println("Class not found "+ e);
      }
      try {
         Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost/library","root","");
         
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM list_of_books");
         System.out.println("id  name    job");
         
         while (rs.next()) {
            String name = rs.getString("BookName");
            String job = rs.getString("AuthorName");
            int id = rs.getString("BookId");
            int job = rs.getInt("NumberOfCopies");
            System.out.println(id+"   "+name+"    "+job);
         }
      } catch(SQLException e) {
         System.out.println("SQL exception occured" + e);
      } 
    /*
	Connection con = null;
         Statement st = null;
         ResultSet rs = null;
         String s;
 
 
	try{
       con = DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
       st = con.createStatement();
       s = "select * from list_of_books";
       rs = st.executeQuery(s); 
       ResultSetMetaData rsmt = rs.getMetaData();
       int c = rsmt.getColumnCount();
	   
       Vector column = new Vector(c);
	   
       for(int i = 0; i <= c; i++)
       {
		   if(i==0){
		   String column[] = {"Book Name","Author Name","ID","Number of Copies"};
		   }
		   else{
           column.add(rsmt.getColumnName(i));
		   }  
	   }
       Vector data = new Vector();
       Vector row = new Vector();
       while(rs.next())
       {
           row = new Vector(c);
           for(int i = 1; i <= c; i++){
               row.add(rs.getString(i));
           }
           data.add(row);
       }
        frame = new JFrame();
        frame.setSize(500,200);
        JTable table = new JTable(data,column);
        table.setBounds(220,250,500,200);
        panel.add(table);
   
        st.close();
        rs.close();
        con.close();        
               
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, "ERROR");
   }*/
	}
	/*public void searchFromDB()
	{
		String query = "SELECT * FROM `list_of_books` WHERE `BookName` LIKE '%"+text.getText()+"%';";
		System.out.println(query);
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String s;
 
   try{
	   Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
       st = con.createStatement();
       rs = st.executeQuery(query); 
       ResultSetMetaData rsmt = rs.getMetaData();
       int c = rsmt.getColumnCount();
	   
       Vector column = new Vector(c);
	   
       for(int i = 1; i <= c; i++)
       {
           column.add(rsmt.getColumnName(i));
       }
       Vector data = new Vector();
       Vector row = new Vector();
       while(rs.next())
       {
           row = new Vector(c);
           for(int i = 1; i <= c; i++){
               row.add(rs.getString(i));
           }
           data.add(row);
       }
        frame = new JFrame();
        frame.setSize(500,200);
        JTable table = new JTable(data,column);
        table.setBounds(220,250,500,200);
        panel.add(table);
   
        st.close();
        rs.close();
        con.close();  
        stm.execute(query);
		stm.close();
		con.close();
						
               
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, "ERROR");
   }
    }
	*/
	
	
}