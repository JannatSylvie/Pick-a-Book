import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class IssuedBooks extends JFrame implements MouseListener,ActionListener
{
	private JLabel issuedbooks;
	private JButton home,back,signout;
	private JPanel panel;
	private JFrame frame;
	
	public IssuedBooks(){
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
		home.addActionListener(this);
		panel.add(home);
		
	
	    issuedbooks = new JLabel(">>Issued Books");
		issuedbooks.setBounds(25, 25 , 500 , 30);
		issuedbooks.setFont(new Font("Bradley Hand ITC",Font.BOLD,35));
		issuedbooks.setForeground(Color.WHITE);
		panel.add(issuedbooks);
	
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
		
		Connection con = null;
         Statement st = null;
         ResultSet rs = null;
         String s;
 
   try{
       con = DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
       st = con.createStatement();
       s = "select * from issued_books";
       rs = st.executeQuery(s); 
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
        frame.setSize(400,200);
        JTable table = new JTable(data,column);
        table.setBounds(220,250,400,200);
        panel.add(table);
   
        st.close();
        rs.close();
        con.close();        
               
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, "ERROR");
   }
}
}
