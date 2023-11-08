import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class deletePage extends JFrame implements ActionListener {
    private JButton backButton, deleteButton;
    private JTextField inputSlangField;
    public deletePage(){
        setTitle("SLANG WORD");
        setSize(640, 360);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI(){
        Color color = new Color(255,0,0);
        JLabel title = new JLabel("Delete Slang Word", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setForeground(color);
        title.setBounds(50, 50, 500, 30);
        add(title);

        JPanel panel = new JPanel();
        int panelWidth = 640;
        int panelHeight = 360;
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
        JLabel slangWord = new JLabel("Slang word: ");
        content.add(slangWord, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputSlangField = new JTextField();
        inputSlangField.setPreferredSize(new Dimension(240, 25));
        content.add(inputSlangField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        content.add(deleteButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        content.add(backButton, gbc);

        panel.add(content);
        return panel;
    }

    public static void main(String[] args) {
        new deletePage();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            dispose();
            new Home();
        }
        if(e.getSource() == deleteButton){
            String inputSlangString = inputSlangField.getText();
            if(inputSlangString.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter slang word to delete");
            } else {
                ArrayList<String> def = (ArrayList<String>) Main.listOfSlang.searchSlangWord(inputSlangString);
                if (def == null) {
                    JOptionPane.showMessageDialog(null, "Slang word don't exist");
                } else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Do you want delete?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION){
                        Main.listOfSlang.deleteSlangWord(inputSlangString);
                        JOptionPane.showMessageDialog(null, "Delete successfully");
                        FileManager.saveFile();
                    }
                }
            }
        }
    }
}
