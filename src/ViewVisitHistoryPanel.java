import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ViewVisitHistoryPanel extends JPanel {
	private JTable table;
	private JTextField txtDoctor;
	private JTextField systolicTextField;
	private JTextField diastolicTextField;
	private MedicalFrame parent;
	private String username;
	JButton btnBack;

	/**
	 * Create the panel.
	 */
	public ViewVisitHistoryPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[208.00,grow][25.00][744.00][134.00][grow]", "[][156.00][][346.00,grow]"));
		
		JLabel lblViewVisitHistory = new JLabel("View Visit History");
		add(lblViewVisitHistory, "cell 2 0,alignx center");
		
		String[] listData = {};
		
		JLabel lblDatesOfVisits = new JLabel("Dates of Visits");
		add(lblDatesOfVisits, "cell 0 2");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 3,grow");
		
		JList list = new JList(listData);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);

		scrollPane.setViewportView(list);
		
		JPanel panel = new JPanel();
		add(panel, "cell 2 3 3 1,grow");
		panel.setLayout(new MigLayout("", "[][242.00,grow][][grow][][]", "[][][][][][][60.00][142.00][][][66.00][184.00][53.00][grow][]"));
		
		JLabel lblConsultingDoctor = new JLabel("Consulting Doctor:");
		panel.add(lblConsultingDoctor, "cell 0 0,alignx trailing");
		
		txtDoctor = new JTextField();
		txtDoctor.setEditable(false);
		txtDoctor.setText("Doctor");
		panel.add(txtDoctor, "cell 1 0,alignx left");
		txtDoctor.setColumns(10);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure:");
		panel.add(lblBloodPressure, "cell 0 2,alignx trailing");
		
		JLabel lblSystolic = new JLabel("Systolic: ");
		panel.add(lblSystolic, "flowx,cell 1 2");
		
		JLabel lblDiastolic = new JLabel("Diastolic:");
		panel.add(lblDiastolic, "flowx,cell 1 3");
		
		JLabel lblDiagnosis = new JLabel("Diagnosis:");
		panel.add(lblDiagnosis, "cell 0 7,alignx trailing");
		
		TextArea diagnosisTextArea = new TextArea();
		diagnosisTextArea.setEditable(false);
		panel.add(diagnosisTextArea, "cell 1 7");
		
		JLabel lblMedicationsPrescribed = new JLabel("Medications Prescribed:");
		panel.add(lblMedicationsPrescribed, "flowx,cell 1 13");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, "cell 1 13,alignx trailing,aligny center");
		
		String[] columnNames = {"Medicine Name", "Dosage", "Duration", "Notes"};
		Object[][] tableData = {{"Aspirin", "3 per day", "10 days", "After Every Meal"}};
		table = new JTable(tableData, columnNames);
		table.setEnabled(false);
		scrollPane_1.setLayout(new FlowLayout());
		scrollPane_1.setViewportView(table);
		
		systolicTextField = new JTextField();
		systolicTextField.setEditable(false);
		panel.add(systolicTextField, "cell 1 2");
		systolicTextField.setColumns(10);
		
		diastolicTextField = new JTextField();
		diastolicTextField.setEditable(false);
		panel.add(diastolicTextField, "cell 1 3");
		diastolicTextField.setColumns(10);
		
		btnBack = new JButton("Back");
		panel.add(btnBack, "cell 5 13");
		btnBack.addActionListener(listener);

	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnBack){
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
		}
	}

}
