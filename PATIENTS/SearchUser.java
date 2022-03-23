package PATIENTS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SearchUser extends JFrame implements ActionListener
{
	private JTextField tf1;
	
	public SearchUser()
	{
		super("SEARCH FRAME");
		setLayout(null);
		
		Font f1 = new Font("Arial", Font.BOLD, 15);
		
		JLabel lheading = new JLabel("SEARCH");
		lheading.setBounds(150, 40, 200, 30);
		Font f2 = new Font("Arial", Font.BOLD, 25);
		lheading.setFont(f2);
		Color c1 = new Color(150,100,220);
		lheading.setForeground(c1);
		
		JLabel l1 = new JLabel("NAME");
		l1.setBounds(70, 90, 100, 20);
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);
		
		tf1 = new JTextField();
		tf1.setBounds(170, 90, 200, 20);
		tf1.setFont(f1);
				
		JButton bsearch = new JButton("SEARCH");
		bsearch.setBounds(150, 125, 120, 25);
		bsearch.addActionListener(this);
		
		add(lheading);
		add(l1); add(tf1);
		add(bsearch);
				
		setSize(450, 250);
		setLocation(500,250);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
/*
	public static void main(String[] args) 
	{
		new SearchUser();

	}
*/
	ArrayList<UserModel> userlist = new ArrayList<UserModel>();
	ArrayList<UserModel> searchlist = new ArrayList<UserModel>();
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			//FETCH ARRAYLIST WITH ALL OBJECT FROM FILE 
			FileInputStream fin = new FileInputStream("D:\\user.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);
			userlist = (ArrayList<UserModel>)oin.readObject();
		
			String name = tf1.getText();
			
			for(UserModel uobj : userlist)
			{
				if(name.equalsIgnoreCase(uobj.getName()))
				{
					searchlist.add(uobj);
				}
			}
			
			if (searchlist.size() > 0)
			{
				new SearchOutputDisplay(searchlist);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "INVALID NAME");
				tf1.setText("");
			}
			
		
		}catch (FileNotFoundException e1) 
		 {
			JOptionPane.showMessageDialog(null, "NO RECORD FOUND");
			//e1.printStackTrace();
		 }
		 catch (IOException e1) {e1.printStackTrace();}
		 catch(Exception e1){e1.printStackTrace();}
		
	}
}
