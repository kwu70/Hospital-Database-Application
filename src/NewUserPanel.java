import javax.swing.JComboBox;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.JButton;


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

	/**
	 * Create the panel.
	 */
	public NewUserPanel(MedicalFrame parent) {
		setLayout(new MigLayout("", "[1000.00,grow]", "[100.00][491.00,grow]"));
		
		JPanel panel = new JPanel();
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
		
		btnRegister = new JButton("Register");
		panel.add(btnRegister, "cell 16 11");
		
	}

}