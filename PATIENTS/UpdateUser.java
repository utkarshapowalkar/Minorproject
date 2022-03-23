package PATIENTS;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UpdateUser extends JFrame implements ActionListener 
{
	private JTextField temail;
	private JTextField tname;
	private JTextField tmobile;
	private JTextArea taddr;
	private JButton bsearch;
	private JButton bupdate;
	UserModel tempobj = null;
	
	public UpdateUser()
	{
		super("UPDATE USER FRAME");
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(6,2));
		
		Font fobj1 = new Font("Chiller",Font.BOLD,27);
		JLabel ltitle = new JLabel("UPDATE");
		ltitle.setFont(fobj1);
		ltitle.setForeground(Color.BLUE);
		
		Font fobj2 = new Font("comic sans ms",Font.BOLD,15);
		JLabel lemail = new JLabel("Email");
		lemail.setForeground(Color.RED);
		lemail.setFont(fobj2);
		temail = new JTextField();
				
		JLabel lname = new JLabel("NAME");
		lname.setForeground(Color.RED);
		lname.setFont(fobj2);
		tname = new JTextField();
				
		JLabel lmobile = new JLabel("MOBILE");
		lmobile.setForeground(Color.RED);
		lmobile.setFont(fobj2);
		tmobile = new JTextField();
		
		JLabel laddr = new JLabel("ADDRESS");
		laddr.setForeground(Color.RED);
		laddr.setFont(fobj2);
		taddr = new JTextArea(5,20);
		JScrollPane tapan=new JScrollPane(taddr);
		
		bsearch = new JButton("SEARCH");
		bsearch.addActionListener(this);
		
		bupdate = new JButton("UPDATE");
		bupdate.addActionListener(this);
		
		c.add(ltitle);c.add(new JLabel("  "));
		c.add(lemail);c.add(temail);
		c.add(lname);c.add(tname);
		c.add(lmobile);c.add(tmobile);
		c.add(laddr);c.add(tapan);
		c.add(bsearch);c.add(bupdate);
				
		setSize(450, 250);
		setLocation(500,250);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
/*
	public static void main(String[] args) 
	{
		new UpdateUser();

	}
*/
	ArrayList<UserModel> userlist = new ArrayList<UserModel>();
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		int index=0;
		if(e.getSource() == bsearch)
		{
		  try
		  {
			//FETCH ARRAYLIST WITH ALL OBJECT FROM FILE 
			FileInputStream fin = new FileInputStream("D:\\user.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);
			userlist = (ArrayList<UserModel>)oin.readObject();
		
			String email = temail.getText();
					 
			for(UserModel uobj : userlist)
			{
				if(email.equalsIgnoreCase(uobj.getEmail()))
				{
					tempobj = uobj;
					break;
				}
				index++;
			}
			
			if(tempobj == null)
			{
				JOptionPane.showMessageDialog(null, "INVALID EMAIL ID");
			}
			else
			{
				//DISPLAY ON THE SCREEN
				tname.setText(tempobj.getName());
				tmobile.setText(tempobj.getMobile());
				taddr.setText(tempobj.getAddress());
				temail.setEditable(false);
			}
		}catch (FileNotFoundException e1) 
		 {
			JOptionPane.showMessageDialog(null, "NO RECORD FOUND");
			//e1.printStackTrace();
		 }
		 catch (IOException e1) {e1.printStackTrace();}
		 catch(Exception e1){e1.printStackTrace();}
	  }
	  else if(e.getSource() == bupdate)
	  {
		 //UPDATE TEMP OBJCET WITH NEW/UPDATED VALUE
		 tempobj.setMobile(tmobile.getText());
		 tempobj.setName(tname.getText());
		 tempobj.setAddress(taddr.getText());
			
		 //UPDATE ARRAYLIST
		 userlist.set(index, tempobj);
		  
		 //FILE UPDATE
		//WRITING ARRAYLIST INTO FILE
			try	
			{
			   FileOutputStream fout = new FileOutputStream("D:\\user.txt");
			   ObjectOutputStream oout = new ObjectOutputStream(fout);
			   oout.writeObject(userlist);
			   
			   JOptionPane.showMessageDialog(null, "INFORMATION UPDATED");
			}catch (FileNotFoundException e1) {e1.printStackTrace();}
			 catch (IOException e1) {e1.printStackTrace();}
			 catch(Exception e1){e1.printStackTrace();}
			
			dispose();
	   }
	}

}
