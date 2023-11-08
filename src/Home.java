import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchDefButton;
    private javax.swing.JButton historyButton;
    private javax.swing.JButton addButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton randomButton;
    private javax.swing.JButton quizButton;
    private javax.swing.JButton quizDefButton;

    public Home() {
        setTitle("Slang word");
        setSize(600, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLayout(null); // Set the layout manager of the MainFrame to null.
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI() {
        Color color = new Color(255,0,0);
        JLabel title = new JLabel("SLANG WORD", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setForeground(color);
        title.setBounds(50, 50, 500, 30);
        add(title);
        searchButton = new JButton("Search");
        searchDefButton = new JButton("Search by definition");
        historyButton = new JButton("History");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        resetButton = new JButton("Reset");
        randomButton = new JButton("Random");
        quizButton = new JButton("Quiz - Slang Word");
        quizDefButton = new JButton("Quiz - Definition");
        JPanel panel = new JPanel();
        int panelWidth = 360;
        int panelHeight = 540;
        int panelX = (getWidth() - panelWidth) / 2; // Center the panel horizontally.
        int panelY = title.getY() + title.getHeight() + 25; // Position the panel below the label.
        panel.setBounds(panelX, panelY, panelWidth, panelHeight);

        panel.setLayout(new GridLayout(10, 1));
        panel.add(searchButton);panel.add(searchDefButton);panel.add(historyButton);
        panel.add(addButton);panel.add(updateButton);panel.add(deleteButton);panel.add(resetButton);
        panel.add(randomButton);panel.add(quizButton);panel.add(quizDefButton);
        searchButton.addActionListener(this);
        searchDefButton.addActionListener(this);
        historyButton.addActionListener(this);
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        resetButton.addActionListener(this);
        deleteButton.addActionListener(this);
        return panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(searchButton)) {
            searchPage page = new searchPage();
            page.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource().equals(searchDefButton)) {
            searchDefPage page = new searchDefPage();
            page.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource().equals(historyButton)) {
            historyPage page = new historyPage();
            page.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource().equals(addButton)) {
            addPage page = new addPage();
            page.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource().equals(updateButton)) {
            editPage page = new editPage();
            page.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource().equals(deleteButton)) {
            deletePage page = new deletePage();
            page.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource().equals(resetButton)) {
            FileManager.resetDictionary();
        }
    }
}