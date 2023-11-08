import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizFindSlangPage extends JFrame implements ActionListener {
    private JButton res1, res2, res3, res4;
    private JButton backButton, againButton;
    private JLabel question;
    public static  int resOfQuestion;
    public QuizFindSlangPage(){
        setTitle("SLANG WORD");
        setSize(560, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    public JPanel createAndShowGUI(){
        Color color = new Color(255,0,0);
        JLabel title = new JLabel("Quiz Game - Slang Word", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setForeground(color);
        title.setBounds(50, 50, 500, 30);
        add(title);

        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 1;
        gbc.gridy = 0;
        question = new JLabel();
        //String x = createSlang(slangSet);
        question.setText("What is the meaning of " + 1 + "?");
        question.setBackground(Color.WHITE);

        content.add(question, gbc);

        res1 = new JButton("asssssssssssssssssssssssssssssssss");
        res1.setPreferredSize(new Dimension(200, 100));
        res2 = new JButton("asssssssssssssssssssssssssssssssss");
        res3 = new JButton("asssssssssssssssssssssssssssssssss");
        res4 = new JButton("asssssssssssssssssssssssssssssssss");


        JPanel panel = new JPanel();
        int panelWidth = 800;
        int panelHeight = 800;
        int panelX = (getWidth() - panelWidth) / 2; // Center the panel horizontally.
        int panelY = title.getY() + title.getHeight() + 25; // Position the panel below the label.
        panel.setBounds(panelX, panelY, panelWidth, panelHeight);

        JPanel quiz = new JPanel();
        quiz.setLayout(new GridLayout(4, 1));
        quiz.add(res1);
        quiz.add(res2);
        quiz.add(res3);
        quiz.add(res4);
        gbc.gridx = 1;
        gbc.gridy = 1;
        content.add(quiz, gbc);

        backButton = new JButton("Back");
        gbc.gridx = 1;
        gbc.gridx = 2;
        quiz.add(backButton);

        againButton = new JButton("Play Again");
        gbc.gridx = 0;
        gbc.gridx = 2;
        quiz.add(againButton);

        panel.add(content);
        return panel;
    }

    public static void main(String[] args) {
        new QuizFindSlangPage();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
