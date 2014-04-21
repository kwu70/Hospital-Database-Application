import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import Backend.Prescription;

public class NewVisitPanel extends JPanel {
	
	private JTextField dateOfVisitTextField;
	private JTextField patientNameTextField;
	private JTextField systolicTextField;
	private JTextField diastolicTextField;
	private JTextField drugNameTextField;
	
	private MedicalFrame parent;
	private String username;
	
	private JButton btnRecordVisit;
	private JButton btnAddPrescription;
	private JButton btnBack;
	
	private JComboBox dosageComboBox;
	private JComboBox durationMonthsComboBox;
	private JComboBox durationDaysComboBox;
	
	private JTextPane textPane;
	
	private String visitID;
	
	private ArrayList<Prescription> prescriptionList;
	
	public NewVisitPanel(MedicalFrame parent, String username) {
		
		this.visitID = generateVisitID();
		
		this.parent = parent;
		this.username = username;
		
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		dateOfVisitTextField = new JTextField();
		dateOfVisitTextField.setBounds(381, 97, 134, 28);
		add(dateOfVisitTextField);
		dateOfVisitTextField.setColumns(10);
		
		JLabel lblDateOfVisit = new JLabel("Date of Visit :");
		lblDateOfVisit.setBounds(275, 103, 115, 16);
		add(lblDateOfVisit);
		
		JLabel lblPatientName = new JLabel("Patient Name : ");
		lblPatientName.setBounds(275, 143, 115, 16);
		add(lblPatientName);
		
		patientNameTextField = new JTextField();
		patientNameTextField.setBounds(381, 137, 134, 28);
		add(patientNameTextField);
		patientNameTextField.setColumns(10);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure: ");
		lblBloodPressure.setBounds(194, 183, 115, 16);
		add(lblBloodPressure);
		
		JLabel lblSystolic = new JLabel("Systolic : ");
		lblSystolic.setBounds(303, 183, 90, 16);
		add(lblSystolic);
		
		JLabel lblDiastolic = new JLabel("Diastolic :");
		lblDiastolic.setBounds(527, 183, 79, 16);
		add(lblDiastolic);
		
		systolicTextField = new JTextField();
		systolicTextField.setBounds(381, 177, 134, 28);
		add(systolicTextField);
		systolicTextField.setColumns(10);
		
		diastolicTextField = new JTextField();
		diastolicTextField.setBounds(601, 177, 134, 28);
		add(diastolicTextField);
		diastolicTextField.setColumns(10);
		
		JLabel lblPrescribeMedication = new JLabel("Prescribe Medication");
		lblPrescribeMedication.setBounds(414, 247, 193, 16);
		add(lblPrescribeMedication);
		
		JLabel lblDrugName = new JLabel("Drug Name : ");
		lblDrugName.setBounds(142, 281, 90, 16);
		add(lblDrugName);
		
		drugNameTextField = new JTextField();
		drugNameTextField.setBounds(232, 275, 134, 28);
		add(drugNameTextField);
		drugNameTextField.setColumns(10);
		
		JLabel lblDosage = new JLabel("Dosage : ");
		lblDosage.setBounds(166, 313, 61, 16);
		add(lblDosage);

		JLabel lblPerDay = new JLabel("per day");
		lblPerDay.setBounds(305, 313, 61, 16);
		add(lblPerDay);
		
		JLabel lblDuration = new JLabel("Duration : ");
		lblDuration.setBounds(153, 352, 79, 16);
		add(lblDuration);
		
		durationMonthsComboBox = new JComboBox();
		durationMonthsComboBox.setBounds(232, 348, 52, 27);
		add(durationMonthsComboBox);
		
		dosageComboBox = new JComboBox();
		dosageComboBox.setBounds(232, 309, 52, 27);
		add(dosageComboBox);
		
		durationDaysComboBox = new JComboBox();
		durationDaysComboBox.setBounds(363, 348, 52, 27);
		add(durationDaysComboBox);
		
		JLabel lblMonths = new JLabel("Months");
		lblMonths.setBounds(290, 352, 61, 16);
		add(lblMonths);
	
		JLabel lblDays = new JLabel("Days");
		lblDays.setBounds(430, 352, 61, 16);
		add(lblDays);
		
		JLabel lblNotes = new JLabel("Notes : ");
		lblNotes.setBounds(159, 387, 61, 16);
		add(lblNotes);
		
		JLabel lblAddNewVisit = new JLabel("Add New Visit");
		lblAddNewVisit.setBounds(434, 19, 179, 16);
		add(lblAddNewVisit);
		
		//Buttons
		btnAddPrescription = new JButton("Add Prescription");
		btnAddPrescription.setBounds(381, 479, 148, 29);
		add(btnAddPrescription);
		
		btnRecordVisit = new JButton("Record Visit");
		btnRecordVisit.setBounds(862, 553, 117, 29);
		add(btnRecordVisit);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 565, 97, 29);
		add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(228, 383, 324, 84);
		add(scrollPane);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

	}
	
	/**
	 * We need to generate a unique visitID
	 * 
	 * @return
	 */
	private String generateVisitID() {
		return "";
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnBack) {
				
				//Go back
				
			} else if (e.getSource() == btnAddPrescription) {
				
				//add prescription to the list for adding to the visit
				
				String drugName = drugNameTextField.getText();
				int dosage = (Integer) dosageComboBox.getSelectedItem();
				int durationDays = (Integer) durationDaysComboBox.getSelectedItem();
				int durationMonths = (Integer) durationMonthsComboBox.getSelectedItem();
				String notes = textPane.getText();
				prescriptionList.add(new Prescription(visitID, drugName, dosage, durationDays, durationMonths, notes, "No"));
				
			} else if (e.getSource() == btnRecordVisit) {
				String dateOfVisit = dateOfVisitTextField.getText();
				String patientName = patientNameTextField.getText();
				String systolic = systolicTextField.getText();
				String diastolic = diastolicTextField.getText();
				String notes = textPane.getText();
				
				//ADD VISIT TO DATABASE
				
				if (!prescriptionList.isEmpty()) {
					//There are no prescriptions
				} else {
					//There are one or more prescriptions
				}
				
				
			}
			
		}
		
	}
}