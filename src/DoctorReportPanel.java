
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class DoctorReportPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	private MedicalFrame parent;
	private String username;
	
	public DoctorReportPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][449.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[200.00][600.00,grow][200.00]", "[][329.00,grow][91.00]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 1 1,grow");
		
		String[] colNames = {"Specialty", "Average Rating", "Number of Surgeries Performed"};
		Object[][] data = {};
		table = new JTable(data, colNames);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[904.00][]", "[]"));
		
		JButton btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 1 0");

	}

}