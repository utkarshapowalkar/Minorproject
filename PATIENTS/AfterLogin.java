package PATIENTS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AfterLogin extends JFrame implements ActionListener,Runnable
{
	private JButton bregister;
	private JButton bshowall;
	private JButton bsearch;
	private JButton bdelete;
	private JButton bupdate;
	private JButton bclose;
	private JButton bnotepad;
	private JButton bcalc;
	private JButton bcmd;
	
	JMenuItem addmenuitemobj;
	JMenuItem delmenuitemobj;
	JMenuItem updatemenuitemobj;
	JMenuItem searchmenuitemobj;
	JMenuItem viewallmenuitemobj;
	JMenuItem notepadmenuitemobj;
	JMenuItem calcmenuitemobj;
	JMenuItem cmdmenuitemobj;
	JMenuItem exitmenuitemobj;
	
	String clock="";
	JLabel lclock;
	
	public AfterLogin()
	{
		super("AFTER LOGIN FRAME");
		setLayout(null);
		
		// CREATE MENUBAR
		JMenuBar mbrobj = new JMenuBar();
				
		// CREATE MENU
		JMenu ummenuobj = new JMenu("USER MANAGEMENT");
		JMenu viewmenuobj = new JMenu("VIEW USER");
		JMenu osappmenuobj = new JMenu("OS APP");
		JMenu closemenuobj = new JMenu("CLOSE APPLICATION");
				
		//CREATE MENU ITEM
		addmenuitemobj = new JMenuItem("ADD USER");
		addmenuitemobj.addActionListener(this);
		
		delmenuitemobj = new JMenuItem("DELETE USER");
		delmenuitemobj.addActionListener(this);
		
		updatemenuitemobj = new JMenuItem("UPDATE USER");
		updatemenuitemobj.addActionListener(this);
		
		//1. ADD MENUITEM INTO MENU
		ummenuobj.add(addmenuitemobj);
		ummenuobj.add(delmenuitemobj);
		ummenuobj.add(updatemenuitemobj);
		
		//CREATE MENU ITEM
		searchmenuitemobj = new JMenuItem("SEARCH USER");
		searchmenuitemobj.addActionListener(this);
		
		viewallmenuitemobj = new JMenuItem("VIEW ALL USER");
		viewallmenuitemobj.addActionListener(this);
		
		notepadmenuitemobj = new JMenuItem("NOTEPAD");
		notepadmenuitemobj.addActionListener(this);
		
		calcmenuitemobj = new JMenuItem("CALCULATOR");
		calcmenuitemobj.addActionListener(this);
		
		cmdmenuitemobj = new JMenuItem("COMMAND PROMPT");
		cmdmenuitemobj.addActionListener(this);
		
		exitmenuitemobj = new JMenuItem("EXIT");
		exitmenuitemobj.addActionListener(this);
		
		//1. ADD MENUITEM INTO MENU
		viewmenuobj.add(searchmenuitemobj);
		viewmenuobj.add(viewallmenuitemobj);
		
		osappmenuobj.add(notepadmenuitemobj);
		osappmenuobj.add(calcmenuitemobj);
		osappmenuobj.add(cmdmenuitemobj);
		
		closemenuobj.add(exitmenuitemobj);
		
		//2. ADD MENU TO MENUBAR
		mbrobj.add(ummenuobj);
		mbrobj.add(viewmenuobj);
		mbrobj.add(osappmenuobj);
		mbrobj.add(closemenuobj);
		
		//3. SET MENU BAR
		setJMenuBar(mbrobj);
		
		JLabel lhead = new JLabel("CMS SYSTEM");
		lhead.setBounds(200,10,200,30);
		Font fobj1 = new Font("Times New Roman",Font.BOLD,30);
		lhead.setFont(fobj1);
		lhead.setForeground(Color.BLUE);
		
		bregister = new JButton("REGISTER");
		bregister.setBounds(100,60,100,40);
		bregister.addActionListener(this);
		bregister.setForeground(Color.RED);
				
		bsearch = new JButton("SEARCH");
		bsearch.setBounds(250,60,100,40);
		bsearch.addActionListener(this);
		bsearch.setForeground(Color.RED);
		
		bshowall = new JButton("SHOW ALL");
		bshowall.setBounds(400,60,100,40);
		bshowall.addActionListener(this);
		bshowall.setForeground(Color.RED);
		
		bdelete = new JButton("DELETE");
		bdelete.setBounds(100,140,100,40);
		bdelete.addActionListener(this);
		bdelete.setForeground(Color.RED);
		
		bupdate = new JButton("UPDATE");
		bupdate.setBounds(250,140,100,40);
		bupdate.addActionListener(this);
		bupdate.setForeground(Color.RED);
		
		bclose = new JButton("CLOSE");
		bclose.setBounds(400,140,100,40);
		bclose.addActionListener(this);
		bclose.setForeground(Color.RED);
		
		bnotepad = new JButton("NOTEPAD");
		bnotepad.setBounds(100,220,100,40);
		bnotepad.addActionListener(this);
		bnotepad.setForeground(Color.RED);
		
		bcalc = new JButton("CALC");
		bcalc.setBounds(250,220,100,40);
		bcalc.addActionListener(this);
		bcalc.setForeground(Color.RED);
		
		bcmd = new JButton("CMD");
		bcmd.setBounds(400,220,100,40);
		bcmd.addActionListener(this);
		bcmd.setForeground(Color.RED);
		
		lclock = new JLabel(clock);
		lclock.setBounds(250,275,100,30);
		Font fobj2 = new Font("Times New Roman",Font.BOLD,20);
		lclock.setFont(fobj2);
		lclock.setForeground(Color.RED);
		
		add(lhead);
		add(bregister); add(bsearch); add(bshowall);
		add(bdelete); add(bupdate); add(bclose);
		add(bnotepad); add(bcalc); add(bcmd);
		add(lclock);
		
		Thread clockthread = new Thread(this);
		clockthread.start();
				
		setSize(630, 380);
		setLocation(500,250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
/*
	public static void main(String[] args) {
		new AfterLogin();
	}
*/
	@Override
	public void actionPerformed(ActionEvent e) 
	{
    	 if((e.getSource() == bregister) || (e.getSource() == addmenuitemobj))
		 {
			 new RegistrationFrame();
		 }
		 else if ((e.getSource() == bsearch) || (e.getSource() == searchmenuitemobj))
		 {
			 new SearchUser();
		 }
		else if ((e.getSource() == bshowall) || (e.getSource() == viewallmenuitemobj))
		{
			 new ShowAllUser();
		}
		else if ((e.getSource() == bdelete) ||  (e.getSource() == delmenuitemobj))
		{
			 new DeleteUser();
	    }
		else if ((e.getSource() == bupdate) ||  (e.getSource() == updatemenuitemobj))
		{
			 new UpdateUser();
	    }
		else if ((e.getSource() == bclose) ||  (e.getSource() == exitmenuitemobj))
		{
			 System.exit(0);
		}
		else if ((e.getSource() == bnotepad) ||  (e.getSource() == notepadmenuitemobj))
		{
			Runtime rs = Runtime.getRuntime();
			try {
				rs.exec("notepad");
			}catch (IOException e1) {System.out.println(e1);}
		}
		else if ((e.getSource() == bcalc) ||  (e.getSource() == calcmenuitemobj) )
		{
			Runtime rs = Runtime.getRuntime();
			try {
				rs.exec("calc");
			}catch (IOException e1) {System.out.println(e1);}
	    }
		else if ((e.getSource() == bcmd) ||  (e.getSource() == cmdmenuitemobj)  )
		{
			System.out.println("hi");
			Runtime rs = Runtime.getRuntime();
			try {
				rs.exec(new String[] {"cmd", "/C", "Start"});
			}catch (IOException e1) {System.out.println(e1);}
	    }
		
	}
	
	public void run()
	{
	  try
	  {
		while(true)
		{
		  Calendar cal = Calendar.getInstance();
		  String chr = ""+cal.get(Calendar.HOUR_OF_DAY);
		  String cmin = ""+cal.get(Calendar.MINUTE);
		  String csec =""+cal.get(Calendar.SECOND);
		  clock = chr+":"+cmin+":"+csec;
		  lclock.setText(clock);
		 // System.out.println(clock);
		  Thread.sleep(1000);
		}
	  }catch(Exception e){}
	}
}
