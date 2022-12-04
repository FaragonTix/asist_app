package assistapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class aframe extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfSName;
	private JTextField tfLang;
	private JTextField BDday;
	private JTextField BDmonth;
	private JTextField BDYear;
	private JTextField searchfield;
	private JTextField tfGender;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//aframe frame = new aframe();
					//frame.setVisible(true);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
			//}
		//});
	//}

	/**
	 * Create the frame.
	 */
	public aframe() {
		setTitle("Assistent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Create\\Modify");
		btnNewButton.setBackground(new Color(255, 250, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///
				try {
				manager.Refetch();
				if (manager.IsInData(manager.currobj)==true)
				{remover.RemoveFromXml(Integer.toString(manager.currobj)); manager.Refetch();}
				Person person = new Person(tfName.getText(), tfSName.getText(), tfLang.getText(), tfGender.getText(), Integer.parseInt(BDday.getText()), Integer.parseInt(BDmonth.getText()),Integer.parseInt(BDYear.getText()), manager.currobj);
				settler.SetToXml(person);
				ClearFields();
				manager.currobj=manager.UniqID();}
				catch (Exception d) {mainq.ShowError();}
			}
		});
		btnNewButton.setBounds(34, 305, 117, 39);
		contentPane.add(btnNewButton);
		
		tfName = new JTextField();
		tfName.setBounds(81, 29, 237, 28);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 36, 45, 13);
		contentPane.add(lblNewLabel);
		
		tfSName = new JTextField();
		tfSName.setBounds(81, 72, 237, 28);
		contentPane.add(tfSName);
		tfSName.setColumns(10);
		
		tfLang = new JTextField();
		tfLang.setBounds(81, 114, 237, 28);
		contentPane.add(tfLang);
		tfLang.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Surename");
		lblNewLabel_1.setBounds(10, 75, 61, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Language");
		lblNewLabel_2.setBounds(10, 121, 71, 13);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 294, 361, 13);
		contentPane.add(separator);
		
		BDday = new JTextField();
		BDday.setBounds(52, 264, 50, 20);
		contentPane.add(BDday);
		BDday.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Birth date");
		lblNewLabel_3.setBounds(78, 213, 72, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("day(DD)");
		lblNewLabel_4.setBounds(52, 241, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("month (MM)");
		lblNewLabel_5.setBounds(109, 241, 72, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("year(YYYY)");
		lblNewLabel_6.setBounds(191, 241, 66, 13);
		contentPane.add(lblNewLabel_6);
		
		BDmonth = new JTextField();
		BDmonth.setBounds(113, 264, 55, 20);
		contentPane.add(BDmonth);
		BDmonth.setColumns(10);
		
		BDYear = new JTextField();
		BDYear.setBounds(185, 264, 72, 20);
		contentPane.add(BDYear);
		BDYear.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(426, 29, -12, 284);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(382, 29, 1, 260);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(386, 10, 30, 346);
		contentPane.add(separator_3);
		
		searchfield = new JTextField();
		searchfield.setBounds(451, 276, 243, 28);
		contentPane.add(searchfield);
		searchfield.setColumns(10);
		
		
		
		tfGender = new JTextField();
		tfGender.setBounds(161, 158, 117, 28);
		contentPane.add(tfGender);
		tfGender.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("gender");
		lblNewLabel_7.setBounds(105, 165, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		JButton btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiveInfo(1);
			}
		});
		btn1.setBackground(new Color(240, 248, 255));
		btn1.setBounds(405, 32, 330, 21);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiveInfo(2);
			}
		});
		btn2.setBackground(new Color(240, 248, 255));
		btn2.setBounds(405, 63, 330, 21);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiveInfo(3);
			}
		});
		btn3.setBackground(new Color(240, 248, 255));
		btn3.setBounds(405, 94, 330, 21);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiveInfo(4);
			}
		});
		btn4.setBackground(new Color(240, 248, 255));
		btn4.setBounds(405, 125, 330, 21);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiveInfo(5);
			}
		});
		btn5.setBackground(new Color(240, 248, 255));
		btn5.setBounds(405, 158, 330, 21);
		contentPane.add(btn5);
		JLabel pageslabel = new JLabel("0/0");
		pageslabel.setHorizontalAlignment(SwingConstants.CENTER);
		pageslabel.setBounds(609, 213, 50, 13);
		contentPane.add(pageslabel);
		JButton reloadbtn = new JButton("Refresh");
		reloadbtn.setBackground(new Color(255, 250, 250));
		reloadbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.Refetch();
					if (manager.persons.size()>0) {
					btn1.setText(manager.persons.get(0).getFullname());}
					if (manager.persons.size()>1) {
					btn2.setText(manager.persons.get(1).getFullname());}
			if (manager.persons.size()>2) {
				btn3.setText(manager.persons.get(2).getFullname());}
			if (manager.persons.size()>3) {
				btn4.setText(manager.persons.get(3).getFullname());}
				if (manager.persons.size()>4) {
					btn5.setText(manager.persons.get(4).getFullname());}
				String labelep=Integer.toString(manager.currpage)+"/"+Integer.toString(manager.pages);
				pageslabel.setText(labelep);
			}
		});
		reloadbtn.setBounds(405, 189, 85, 21);
		contentPane.add(reloadbtn);
		
		JButton btnNewButton_2 = new JButton(">");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.currpage+1<=manager.pages){
				manager.currpage+=1;
				String labelep=Integer.toString(manager.currpage)+"/"+Integer.toString(manager.pages);
				pageslabel.setText(labelep);
				btn1.setText("");
				btn2.setText("");
				btn3.setText("");
				btn4.setText("");
				btn5.setText("");
				if (manager.exp.size()> manager.currpage*5-5) {
				btn1.setText(manager.exp.get(manager.currpage*5-5).getFullname());}
				if (manager.exp.size()> manager.currpage*5-4) {
					btn2.setText(manager.exp.get(manager.currpage*5-4).getFullname());}
				if (manager.exp.size()> manager.currpage*5-3) {
					btn3.setText(manager.exp.get(manager.currpage*5-3).getFullname());}
				if (manager.exp.size()> manager.currpage*5-2) {
					btn4.setText(manager.exp.get(manager.currpage*5-2).getFullname());}
				if (manager.exp.size()> manager.currpage*5-1) {
					btn5.setText(manager.exp.get(manager.currpage*5-1).getFullname());}
				}
				
				
			}
		});
		btnNewButton_2.setBackground(new Color(248, 248, 255));
		btnNewButton_2.setBounds(662, 209, 61, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("<");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.currpage-1!=0) {
				manager.currpage-=1;
				String labelep=Integer.toString(manager.currpage)+"/"+Integer.toString(manager.pages);
				pageslabel.setText(labelep);
				btn1.setText("");
				btn2.setText("");
				btn3.setText("");
				btn4.setText("");
				btn5.setText("");
				if (manager.exp.size()> manager.currpage*5-5) {
					btn1.setText(manager.exp.get(manager.currpage*5-5).getFullname());}
					if (manager.exp.size()> manager.currpage*5-4) {
						btn2.setText(manager.exp.get(manager.currpage*5-4).getFullname());}
					if (manager.exp.size()> manager.currpage*5-3) {
						btn3.setText(manager.exp.get(manager.currpage*5-3).getFullname());}
					if (manager.exp.size()> manager.currpage*5-2) {
						btn4.setText(manager.exp.get(manager.currpage*5-2).getFullname());}
					if (manager.exp.size()> manager.currpage*5-1) {
						btn5.setText(manager.exp.get(manager.currpage*5-1).getFullname());}
				}
				
			}
		});
		btnNewButton_2_1.setBackground(new Color(248, 248, 255));
		btnNewButton_2_1.setBounds(543, 209, 61, 21);
		contentPane.add(btnNewButton_2_1);
		
		
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remover.RemoveFromXml(Integer.toString(manager.currobj));
				ConfirmDetele();
			}
		});
		btnNewButton_3.setBackground(new Color(255, 250, 250));
		btnNewButton_3.setBounds(201, 305, 117, 39);
		contentPane.add(btnNewButton_3);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(4, 0, 61, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Create");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Profile");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearFields();
				manager.currobj=manager.UniqID();
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setText("");
				btn2.setText("");
				btn3.setText("");
				btn4.setText("");
				btn5.setText("");
				manager.SearchF(searchfield.getText());
				if (manager.exp.size()>0) {
					btn1.setText(manager.exp.get(0).getFullname());}
					if (manager.exp.size()>1) {
					btn2.setText(manager.exp.get(1).getFullname());}
			if (manager.exp.size()>2) {
				btn3.setText(manager.exp.get(2).getFullname());}
			if (manager.exp.size()>3) {
				btn4.setText(manager.exp.get(3).getFullname());}
				if (manager.exp.size()>4) {
					btn5.setText(manager.exp.get(4).getFullname());}
				String labelep=Integer.toString(manager.currpage)+"/"+Integer.toString(manager.pages);
				pageslabel.setText(labelep);
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 250, 250));
		btnNewButton_1.setBounds(521, 309, 104, 30);
		contentPane.add(btnNewButton_1);
	}
	public void GiveInfo(int i) {
		int a = 6-i;
		if (manager.currpage!=0){
		int b=manager.currpage*5-a;
		int c = manager.exp.size()-1;
		if (c>=b) {
		//System.out.println(manager.exp.size());
		tfName.setText(manager.exp.get(manager.currpage*5-a).name);
		tfSName.setText(manager.exp.get(manager.currpage*5-a).sname);
		tfGender.setText(manager.exp.get(manager.currpage*5-a).gender);
		tfLang.setText(manager.exp.get(manager.currpage*5-a).lang);
		BDday.setText(Integer.toString(manager.exp.get(manager.currpage*5-a).birthday));
		BDmonth.setText(Integer.toString(manager.exp.get(manager.currpage*5-a).birthmonth));
		BDYear.setText(Integer.toString(manager.exp.get(manager.currpage*5-a).birthyear));
		manager.currobj= manager.exp.get(manager.currpage*5-a).id;
		}}
	}
	public void ClearFields() {
		tfName.setText("");
		tfSName.setText("");
		tfGender.setText("");
		tfLang.setText("");
		BDday.setText("");
		BDYear.setText("");
		BDmonth.setText("");
	}
	public void ConfirmDetele() {
	    
	    int res = JOptionPane.showConfirmDialog(null, "Do you really want to delete this profile?", "Confirm",
	    JOptionPane.YES_NO_OPTION);
	    if(res == 0) {
	       System.out.println("Pressed YES");
	       manager.Refetch();
	       if (manager.IsInData(manager.currobj)==true)
	       {remover.RemoveFromXml(Integer.toString(manager.currobj)); 
	       manager.Refetch(); 
	       ClearFields(); 
	       manager.currobj=manager.UniqID();}
	    } else if (res == 1) {
	       System.out.println("Pressed NO");
	    } else {
	       System.out.println("Pressed CANCEL");
	    }
	 }
}
