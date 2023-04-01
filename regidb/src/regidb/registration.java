package regidb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class registration {

	private JFrame frame;
	private JTextField n;
	private JTextField em;
	private JPasswordField p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration window = new registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 566, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION PAGE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(163, 11, 198, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(74, 75, 69, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		n = new JTextField();
		n.setBounds(238, 80, 147, 20);
		frame.getContentPane().add(n);
		n.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("email id");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(74, 122, 69, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		em = new JTextField();
		em.setBounds(238, 127, 147, 20);
		frame.getContentPane().add(em);
		em.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(74, 172, 69, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		p = new JPasswordField();
		p.setBounds(238, 177, 147, 20);
		frame.getContentPane().add(p);
		
		JLabel lblNewLabel_2 = new JLabel("gender");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(74, 221, 69, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JRadioButton ml = new JRadioButton("male");
		ml.setBackground(SystemColor.inactiveCaption);
		ml.setBounds(237, 222, 69, 23);
		frame.getContentPane().add(ml);
		
		JRadioButton fml = new JRadioButton("female");
		fml.setBackground(SystemColor.inactiveCaption);
		fml.setBounds(323, 222, 69, 23);
		frame.getContentPane().add(fml);
		
		JLabel pl = new JLabel(" programming language");
		pl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		pl.setBounds(74, 268, 182, 31);
		frame.getContentPane().add(pl);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(ml);
		bg.add(fml);
		
		JComboBox cb1 = new JComboBox();
		cb1.setBackground(SystemColor.scrollbar);
		cb1.setModel(new DefaultComboBoxModel(new String[] {"select", "c++", "python", "java", "c", "rust", "php", "brain fuck", "java script", "type script", "assembly"}));
		cb1.setBounds(276, 274, 85, 22);
		frame.getContentPane().add(cb1);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=n.getText();
				String email=em.getText();
				String password=p.getText();
				String pl=(String) cb1.getSelectedItem();
				String gender;
				if(fml.isSelected())
				 {
					gender ="female";
				 }
				else if(ml.isSelected())
				{
					gender="male";
				}
				else
				{
					gender="invalid";
				}
				
				try {
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","mrec");
					String q="Insert into student values('"+name+"','"+email+"','"+password+"','"+gender+"','"+pl+"')";
					Statement sta=con.createStatement();
					sta.executeLargeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "done!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(223, 372, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
