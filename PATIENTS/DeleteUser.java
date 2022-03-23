package PATIENTS;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTextField;

public class DeleteUser extends JFrame implements ActionListener
{
    private JTextField tf1;
	
	public DeleteUser()
	{
		super("DELETE USER FRAME");
		setLayout(null);
		
		Font f1 = new Font("Arial", Font.BOLD, 15);
		
		JLabel lheading = new JLabel("DELETE");
		lheading.setBounds(180, 40, 200, 30);
		Font f2 = new Font("Arial", Font.BOLD, 25);
		lheading.setFont(f2);
		Color c1 = new Color(150,100,220);
		lheading.setForeground(c1);
		
		JLabel l1 = new JLabel("EMAIL ID");
		l1.setBounds(70, 90, 100, 20);
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);
		
		tf1 = new JTextField();
		tf1.setBounds(170, 90, 200, 20);
		tf1.setFont(f1);
				
		JButton bsearch = new JButton("DELETE");
		bsearch.setBounds(180, 125, 120, 25);
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

	ArrayList<UserModel> userlist = new ArrayList<UserModel>();
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			//FETCH ARRAYLIST WITH ALL OBJECT FROM FILE 
			FileInputStream fin = new FileInputStream("D:\\user.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);
			userlist = (ArrayList<UserModel>)oin.readObject();
		
			String email = tf1.getText();
			int index = 0;
			boolean flag = false;
			for(UserModel uobj : userlist)
			{
				if(email.equalsIgnoreCase(uobj.getEmail()))
				{
					flag = true;
					break;
				}
				index++;
			}
			
			if (flag)
			{
				userlist.remove(index);
				
				//WRITE UPDATED LIST INTO FILE
				FileOutputStream fout = new FileOutputStream("D:\\user.txt");
				ObjectOutputStream oout = new ObjectOutputStream(fout);
				oout.writeObject(userlist);
				
				tf1.setText("");
				JOptionPane.showMessageDialog(null, "DELETE SUCCESS");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "INVALID EMAIL");
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
