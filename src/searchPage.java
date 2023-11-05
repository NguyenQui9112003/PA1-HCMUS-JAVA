import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
public class searchPage extends JFrame implements ActionListener {
    private JLabel searchLabel;
    private JTextField inputField;
    private JTable listTable;
    private JButton searchButton;
    private JButton backButton;
//    private JPanel panel;
    private javax.swing.JLabel title;
    public searchPage () {
        setTitle("Search Slang word");
        setSize(640, 360);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
        setLayout(null); // Set the layout manager of the MainFrame to null.
        setVisible(true);
    }
    public JPanel createAndShowGUI() {
        Color color = new Color(255,0,0);
        title = new JLabel("SLANG WORD", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setForeground(color);
        title.setBounds(50, 50, 500, 30);
        add(title);

        JPanel panel = new JPanel();
        int panelWidth = 640;
        int panelHeight = 360;
        int panelX = (getWidth() - panelWidth) / 2; // Center the panel horizontally.
        int panelY = title.getY() + title.getHeight() + 25; // Position the panel below the label.
        panel.setBounds(panelX, panelY, panelWidth, panelHeight);

        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        searchLabel = new JLabel("Search: ");
        content.add(searchLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(240, 25));
        content.add(inputField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        searchButton = new JButton("OK");
        searchButton.setMargin(new Insets(5, 10, 5, 10));
        searchButton.setPreferredSize(new Dimension(50, 25));
        content.add(searchButton, gbc);

        String[] columnNames = {"Slang", "Definition"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 15);
        model.setColumnIdentifiers(columnNames);
        listTable = new JTable(model);
        listTable.setPreferredScrollableViewportSize(new Dimension(450, 90));
        listTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(listTable);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        content.add(scrollPane, gbc);

        GridBagConstraints backButtonGBC = new GridBagConstraints();
        backButtonGBC.fill = GridBagConstraints.HORIZONTAL;
        backButtonGBC.insets = new Insets(5, 10, 5, 10);
        backButtonGBC.gridx = 0;
        backButtonGBC.gridy = 2;
        backButtonGBC.gridwidth = 2;
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        content.add(backButton, backButtonGBC);

        panel.add(content);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
