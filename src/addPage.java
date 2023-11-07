import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.*;
import java.util.List;
public class addPage extends JFrame implements ActionListener {
    private JButton backButton;
    private JButton addButton;
    private JTextField inputSlangField;
    private JTextField inputDefField;
    public addPage () {
        setTitle("SLANG WORD");
        setSize(640, 320);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI(){
        Color color = new Color(255,0,0);
        JLabel title = new JLabel("ADD NEW", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setForeground(color);
        title.setBounds(50, 50, 500, 30);
        add(title);

        JPanel panel = new JPanel();
        int panelWidth = 640;
        int panelHeight = 320;
        int panelX = (getWidth() - panelWidth) / 2;
        int panelY = title.getY() + title.getHeight() + 25;
        panel.setBounds(panelX, panelY, panelWidth, panelHeight);

        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel labelSlang = new JLabel("Input Slang: ");
        content.add(labelSlang, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputSlangField = new JTextField();
        inputSlangField.setPreferredSize(new Dimension(200, 25));
        content.add(inputSlangField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel labelDef = new JLabel("Input Definition: ");
        content.add(labelDef, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        inputDefField = new JTextField();
        inputDefField.setPreferredSize(new Dimension(200, 25));
        content.add(inputDefField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        content.add(backButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        content.add(addButton, gbc);

        panel.add(content);
        return panel;
    }

    public static void main(String[] args) {
        new addPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            dispose();
            new Home();
        }
        if(e.getSource() == addButton){
            String slang = inputSlangField.getText();
            String def = inputDefField.getText();
            String[] data = def.split("\\|");
            List<String> definition = new ArrayList<>();
            for(String s: data){
                definition.add(s);
            }
            ArrayList<String> result = (ArrayList<String>) Main.listOfSlang.searchSlangWord(slang);
            if(result == null){
                Main.listOfSlang.addBySlangAndDef(slang, definition);
                FileManager.saveFile();
                JOptionPane.showMessageDialog(null, "Add successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new alertScreen(slang, definition);
            }
        }
    }
}
