import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;


public class NewUserPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JLabel lblTypeOfUser;
	private JButton btnRegister;
	MedicalFrame parent;
	private JButton btnBack;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public NewUserPanel(MedicalFrame parent) {
		setBackground(SystemColor.textHighlight);
		setLayout(new MigLayout("", "[1000.00,grow]", "[100.00][491.00,grow]"));
		ButtonListener listener = new ButtonListener();
		this.parent = parent;
		this.setBounds(100, 100, 1000, 600);
		
		lblNewLabel = new JLabel("New User Creation");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		add(lblNewLabel, "cell 0 0,alignx center");
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[199.00][][][grow][][][][][][][][23.00][][][][][grow]", "[][][][][][][][][][][142.00][36.00]"));
		
		lblUsername = new JLabel("Username");
		panel.add(lblUsername, "cell 1 3");
		
		textField = new JTextField();
		panel.add(textField, "cell 3 3 10 1,growx");
		textField.setColumns(10);
		
		lblPassword = new JLabel("Password");
		panel.add(lblPassword, "cell 1 5");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 3 5 10 1,growx");
		textField_1.setColumns(10);
		
		lblConfirmPassword = new JLabel("Confirm Password");
		panel.add(lblConfirmPassword, "cell 1 7");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "cell 3 7 10 1,growx");
		textField_2.setColumns(10);
		
		String[] user_option = {"Patient", "Doctor", "Admin"};
		
		lblTypeOfUser = new JLabel("Type of User");
		panel.add(lblTypeOfUser, "cell 1 9");
		comboBox = new JComboBox(user_option);
		panel.add(comboBox, "cell 3 9 10 1,growx");
		
		btnBack = new JButton("Back");
		panel.add(btnBack, "cell 0 11");
		btnBack.addActionListener(listener);
		
		btnRegister = new JButton("Register");
		panel.add(btnRegister, "cell 16 11");
		btnRegister.addActionListener(listener);
	}

	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnRegister){
				if (comboBox.getSelectedItem().equals("Patient")) {
					if (textField_1.getText().equals(textField_2.getText()))	{
						NewPatientProfilePanel nup = new NewPatientProfilePanel(parent, textField.getText(), textField_1.getText());
						parent.getContentPane().add(nup);
						CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
						cl.next(parent.getContentPane());
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect value, please try again.");
					}
				}
				else if (comboBox.getSelectedItem().equals("Doctor")) {
					if (textField_1.getText().equals(textField_2.getText()))	{
						NewDoctorProfilePanel ndp = new NewDoctorProfilePanel(parent, textField.getText(), textField_1.getText());
						parent.getContentPane().add(ndp);
						CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
						cl.next(parent.getContentPane());
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect value, please try again.");
					}
				}
				else {
					if (textField_1.getText().equals(textField_2.getText()))	{
						if(parent.getHandler().addNewUser(textField.getText(), textField_1.getText())) {
							AdminHomePanel ahp = new AdminHomePanel(parent, textField.getText());
							parent.getContentPane().add(ahp);
							CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
							cl.next(parent.getContentPane());
						}
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect value, please try again.");
					}					
				}
			} else if (e.getSource() == btnBack) {
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.first(parent.getContentPane());
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
			}
		}
	}
}
