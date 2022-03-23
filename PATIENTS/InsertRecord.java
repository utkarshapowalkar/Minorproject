package PATIENTS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class InsertRecord 
{
    private ArrayList<UserModel> userlist;
	
	public InsertRecord(UserModel userobj)
	{
	// READ ALL OBJECT FROM FILE	
		try
		{
			FileInputStream fin = new FileInputStream("D:\\user.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);
			userlist = (ArrayList<UserModel>)oin.readObject();
		}catch (FileNotFoundException e) 
		 {
			userlist=new ArrayList<UserModel>();
		 }
		 catch (IOException e) {e.printStackTrace();}
		 catch(Exception e){e.printStackTrace();}
		
		//ADD NEW OBject into Arraylist
		userlist.add(userobj);
		
		//WRITING ARRAYLIST INTO FILE
		try	
		{
		   FileOutputStream fout = new FileOutputStream("D:\\user.txt");
		   ObjectOutputStream oout = new ObjectOutputStream(fout);
		   oout.writeObject(userlist);
		}catch (FileNotFoundException e) {e.printStackTrace();}
		 catch (IOException e) {e.printStackTrace();}
		 catch(Exception e){e.printStackTrace();}
	
	}
}