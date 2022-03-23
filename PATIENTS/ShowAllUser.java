package PATIENTS;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowAllUser extends JFrame 
{
	public ShowAllUser()
	{
		super("Display All User");
		String heading[]={"Name","Email","Mobile","Address","City","Gender","Interests","Date Of Birth","Reg Date"};
		String data[][];
		ArrayList<UserModel> userlist = new ArrayList<UserModel>();
		
		try
		{
			//FETCH ARRAYLIST WITH ALL OBJECT FROM FILE 
			FileInputStream fin = new FileInputStream("D:\\user.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);
			userlist = (ArrayList<UserModel>)oin.readObject();
		
			//CREATE STRING 2D ARRAY ACCORDING TO THE NO OF OBJECT
			data = new String[userlist.size()][9];
			
			//RETRIVE OBJECT DATA & STORE IT IN THE 2D ARRAY
			int r=0;
			for(UserModel uobj : userlist)
			{
				data[r][0]=uobj.getName();
				data[r][1]=uobj.getEmail();
				data[r][2]=uobj.getMobile();
				data[r][3]=uobj.getAddress();
				data[r][4]=uobj.getCity();
				data[r][5]=uobj.getGender();
				data[r][6]=uobj.getInterests();
				data[r][7]=uobj.getDob();
				data[r][8]=uobj.getDate();
				r++;
			}
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			//CREATE TABLE AND DISPLAY DATA
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Registration Details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			
			setSize(850, 300);
			setLocation(200, 200);
			setVisible(true);
		
		}catch (FileNotFoundException e) 
		 {
			JOptionPane.showMessageDialog(null, "NO RECORD FOUND");
			//e.printStackTrace();
		 }
		 catch (IOException e) {e.printStackTrace();}
		 catch(Exception e){e.printStackTrace();}
	}

}

