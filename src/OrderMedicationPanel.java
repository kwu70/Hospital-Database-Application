import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JList;

import Backend.Doctor;
import Backend.Prescription;
import Backend.Visit;
import java.awt.Font;


public class OrderMedicationPanel extends JPanel {
	private JTextField medNameTextField;
	private JTextField consultingDoctorTextField;

	private MedicalFrame parent;
	private String username;
	
	private JButton btnAddToCart, btnCheckout, btnBack;
	private JComboBox dateOfVisitcomboBox;
	
	public ArrayList<Prescription> cart;
	
	private ArrayList<Visit> visits;
	private ArrayList<String> dates;
	private ArrayList<Prescription> prescs;
	private Visit currVisit;
	
	private JButton btnSelectDate;
	private JButton btnSelect;
	
	private JList medList;
	private JList cartList;
	
	private DefaultListModel model;
	private DefaultListModel model2;
	String[] dosage = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	String[] durationMonths = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	String[] durationDays = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	
	String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
		"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	
	String[] year = {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
	private JTextField dosageTextField;
	private JTextField monthsTextField;
	private JTextField daysTextField;
	
	/**
	 * Create the panel.
	 */
	public OrderMedicationPanel(MedicalFrame parent, String username) {
		
		cart = new ArrayList<Prescription>();
		
		setBackground(SystemColor.textHighlight);
		this.setBounds(100, 100, 1000, 600);
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(189, 49, 784, 32);
		panel.setBackground(SystemColor.textHighlight);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblOrderMedication = new JLabel("Order Medication");
		lblOrderMedication.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblOrderMedication.setBackground(SystemColor.desktop);
		lblOrderMedication.setForeground(SystemColor.menuText);
		lblOrderMedication.setBounds(211, 6, 296, 26);
		panel.add(lblOrderMedication);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(105, 158, 784, 291);
		panel_1.setBackground(SystemColor.textHighlight);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMedicineName = new JLabel("Medicine Name");
		lblMedicineName.setBounds(158, 93, 96, 16);
		panel_1.add(lblMedicineName);
		
		medNameTextField = new JTextField();
		medNameTextField.setBounds(287, 87, 275, 28);
		panel_1.add(medNameTextField);
		medNameTextField.setColumns(10);
		
		JLabel lblDosage = new JLabel("Dosage");
		lblDosage.setBounds(158, 144, 47, 16);
		panel_1.add(lblDosage);
		
		JLabel lblPerDay = new JLabel("Per Day");
		lblPerDay.setBounds(363, 144, 47, 16);
		panel_1.add(lblPerDay);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(158, 197, 55, 16);
		panel_1.add(lblDuration);
		
		JLabel lblMonths = new JLabel("Months");
		lblMonths.setBounds(363, 197, 47, 16);
		panel_1.add(lblMonths);
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setBounds(569, 197, 31, 16);
		panel_1.add(lblDays);
		
		JLabel lblConsultingDoctor = new JLabel("Consulting Doctor");
		lblConsultingDoctor.setBounds(158, 251, 116, 16);
		panel_1.add(lblConsultingDoctor);
		
		consultingDoctorTextField = new JTextField();
		consultingDoctorTextField.setBounds(287, 245, 275, 28);
		panel_1.add(consultingDoctorTextField);
		consultingDoctorTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 54, 125, 188);
		panel_1.add(scrollPane);

		btnSelect = new JButton("Select");
		btnSelect.setBounds(6, 245, 117, 29);
		panel_1.add(btnSelect);
		btnSelect.addActionListener(listener);
		
		JLabel lblMediccations = new JLabel("Medications");
		lblMediccations.setBounds(24, 35, 99, 16);
		panel_1.add(lblMediccations);
		
		JLabel lblDateOfVisit = new JLabel("Date Of Visit");
		lblDateOfVisit.setBounds(193, 24, 99, 16);
		panel_1.add(lblDateOfVisit);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(612, 76, 152, 166);
		panel_1.add(scrollPane_1);
		
		JLabel lblCart = new JLabel("Cart");
		lblCart.setBounds(669, 53, 31, 16);
		panel_1.add(lblCart);

		btnSelectDate = new JButton("Select Date");
		btnSelectDate.setBounds(461, 19, 117, 29);
		panel_1.add(btnSelectDate);
		btnSelectDate.addActionListener(listener);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(105, 499, 784, 61);
		panel_2.setBackground(SystemColor.textHighlight);
		add(panel_2);
		panel_2.setLayout(null);
		
		btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.setBounds(254, 16, 116, 29);
		panel_2.add(btnAddToCart);
		btnAddToCart.addActionListener(listener);
		
		btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(378, 16, 104, 29);
		panel_2.add(btnCheckout);
		btnCheckout.addActionListener(listener);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(490, 16, 75, 29);
		panel_2.add(btnBack);
		btnBack.addActionListener(listener);

		//Get all visits
		visits = parent.getHandler().getPatientVisits(username);
		//Fill String of dates
		dates = new ArrayList<String>();
		for(Visit v : visits) {
			dates.add(v.getDateOfVisit());
		}
		
		ArrayList<Prescription> prescs = new ArrayList<Prescription>();

		dateOfVisitcomboBox = new JComboBox(dates.toArray());
		dateOfVisitcomboBox.setBounds(284, 20, 165, 27);
		panel_1.add(dateOfVisitcomboBox);

		model = new DefaultListModel();
		model2 = new DefaultListModel();
		
		cartList = new JList(model2);
		scrollPane_1.setViewportView(cartList);
		
		medList = new JList(model);
		scrollPane.setViewportView(medList);	
		
		dosageTextField = new JTextField();
		dosageTextField.setBounds(217, 138, 134, 28);
		panel_1.add(dosageTextField);
		dosageTextField.setColumns(10);
		
		monthsTextField = new JTextField();
		monthsTextField.setBounds(225, 191, 134, 28);
		panel_1.add(monthsTextField);
		monthsTextField.setColumns(10);
		
		daysTextField = new JTextField();
		daysTextField.setBounds(428, 191, 134, 28);
		panel_1.add(daysTextField);
		daysTextField.setColumns(10);
		prescs = new ArrayList<Prescription>();
		currVisit = new Visit();
		
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnSelectDate){
				int index = dateOfVisitcomboBox.getSelectedIndex();
				currVisit = visits.get(index);
				prescs = parent.getHandler().getVisitPrescriptions(visits.get(index).getPatUsername(), visits.get(index).getDocUsername(),
						visits.get(index).getDateOfVisit());
				model.removeAllElements();
				for(Prescription p : prescs) {
					model.addElement(p.getMedicineName());
				}
				
			}
			else if(e.getSource() == btnSelect){
				//Populate fields based off the selected date
				String medName = (String) medList.getSelectedValue();
				Prescription pres = new Prescription();
				for(Prescription p : prescs) {
					if(p.getMedicineName().equals(medName)) {
						pres = p;
						break;
					}
				}
				int duration = pres.getDuration();
				Integer monthsD = duration/30;
				Integer daysD = duration%30;
				Integer dosage = pres.getDosage();
				medNameTextField.setText(medName);
				dosageTextField.setText(dosage.toString());
				monthsTextField.setText(monthsD.toString());
				daysTextField.setText(daysD.toString());
				Doctor doc = parent.getHandler().getDoctor(currVisit.getDocUsername());
				String name = "Dr. " + doc.getfName() + " " + doc.getlName();
				consultingDoctorTextField.setText(name);

			}
			else if (e.getSource() == btnAddToCart) {
			
				int durationz = Integer.parseInt(monthsTextField.getText()) * 30 + Integer.parseInt(daysTextField.getText());
				Prescription prescription = new Prescription(username, consultingDoctorTextField.getText(), (String)dateOfVisitcomboBox.getSelectedItem() , medNameTextField.getText(), Integer.parseInt(dosageTextField.getText()), durationz, "", "No");
				cart.add(prescription);
				model2.addElement(prescription.getMedicineName());
			
			} 
			else if (e.getSource() == btnCheckout) {
				if(!cart.isEmpty()) {
					PaymentInfoPanel pip = new PaymentInfoPanel(parent, username, cart);
					parent.getContentPane().add(pip);
					CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
					cl.next(parent.getContentPane());
				} else {
					JOptionPane.showMessageDialog(null, "Cart is Empty.");
				}
			}
			else if(e.getSource() == btnBack){
				//Go Back
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
		}
	}
}
