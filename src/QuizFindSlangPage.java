import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

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
        Set<Object> slangSet = createQuestion();
        gbc.gridx = 1;
        gbc.gridy = 0;
        question = new JLabel();
        String x = createSlang(slangSet);
        question.setText("What is the meaning of " + x + "?");
        question.setBackground(Color.WHITE);

        content.add(question, gbc);

        ArrayList<String> answerList = convertArrayString(slangSet);
        res1 = new JButton(answerList.get(0));
        res1.setPreferredSize(new Dimension(200, 100));
        res2 = new JButton(answerList.get(1));
        res3 = new JButton(answerList.get(2));
        res4 = new JButton(answerList.get(3));


        JPanel panel = new JPanel();
        int panelWidth = 800;
        int panelHeight = 800;
        int panelX = (getWidth() - panelWidth) / 2; // Center the panel horizontally.
        int panelY = title.getY() + title.getHeight() + 25; // Position the panel below the label.
        panel.setBounds(panelX, panelY, panelWidth, panelHeight);

        JPanel quiz = new JPanel();
        quiz.setLayout(new GridLayout(4, 1));
        res1.addActionListener(this);
        res2.addActionListener(this);
        res3.addActionListener(this);
        res4.addActionListener(this);
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
        backButton.addActionListener(this);

        againButton = new JButton("Play Again");
        gbc.gridx = 0;
        gbc.gridx = 2;
        quiz.add(againButton);
        againButton.addActionListener(this);

        panel.add(content);
        return panel;
    }

    public static void main(String[] args) {
        new QuizFindSlangPage();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            dispose();
            new Home();
        }
        if(e.getSource() == againButton) {
            dispose();
            new QuizFindSlangPage();
        }
        if(e.getSource() == res1){
            if(resOfQuestion == 0){
                JOptionPane.showMessageDialog(null, "Correct answer");
            } else {
                JOptionPane.showMessageDialog(null, "Wrong answer");
            }
            res2.setEnabled(false);
            res3.setEnabled(false);
            res4.setEnabled(false);
        } else if (e.getSource() == res2){
            if(resOfQuestion == 1){
                JOptionPane.showMessageDialog(null, "Correct answer");
            } else {
                JOptionPane.showMessageDialog(null, "Wrong answer");
            }
            res1.setEnabled(false);
            res3.setEnabled(false);
            res4.setEnabled(false);
        } else if (e.getSource() == res3){
            if(resOfQuestion == 2){
                JOptionPane.showMessageDialog(null, "Correct answer");
            } else {
                JOptionPane.showMessageDialog(null, "Wrong answer");
            }
            res1.setEnabled(false);
            res2.setEnabled(false);
            res4.setEnabled(false);
        } else if (e.getSource() == res4){
            if(resOfQuestion == 3){
                JOptionPane.showMessageDialog(null, "Correct answer");
            } else {
                JOptionPane.showMessageDialog(null, "Wrong answer");
            }
            res1.setEnabled(false);
            res2.setEnabled(false);
            res3.setEnabled(false);
        } else if (e.getSource() == againButton){
            setDefaultButton();
            setLabel();
        }
    }
    private Set<Object> createQuestion() {
        Set<Object> ansObject = new HashSet<>();
        while(ansObject.size() != 4){
            String randomAns = Main.listOfSlang.randomSlangWordString();
            ArrayList<String> A = Main.listOfSlang.getDefinition(randomAns);
            ansObject.add(A);
        }
        return ansObject;
    }

    public String createSlang(Set<Object> ansObject) {
        Iterator<Object> k = ansObject.iterator();
        Random rand = new Random();
        resOfQuestion = rand.nextInt(4);
        System.out.println(resOfQuestion);
        int count = 0;
        String slang = null;
        while (count != 4 && k.hasNext()) {
            if (resOfQuestion == count) {
                ArrayList<String> aaa = (ArrayList<String>) k.next();
                slang = Main.listOfSlang.getSlangWord(aaa);
                break;
            }
            k.next();
            ++count;
        }
        System.out.println("slang: " + slang);
        return slang;
    }

    public ArrayList<String> convertArrayString(Set<Object> ansObject){
        Iterator<Object> i = ansObject.iterator();
        ArrayList<String> ansQuestion = new ArrayList<>();
        while(i.hasNext()){
            ArrayList<String> b = (ArrayList<String>) i.next();
            ansQuestion.add(String.join(" , ", b));
        }
        return ansQuestion;
    }

    public void setDefaultButton(){
        res1.setEnabled(true);
        res2.setEnabled(true);
        res3.setEnabled(true);
        res4.setEnabled(true);
        res1.setBackground(Color.white);
        res2.setBackground(Color.white);
        res3.setBackground(Color.white);
        res4.setBackground(Color.white);
    }
    public void setLabel(){
        Set<Object> obj = createQuestion();
        ArrayList<String> listAns = convertArrayString(obj);
        String x = createSlang(obj);
        question.setText("What is the definition of slang " + x + "? ");
        res1.setText(listAns.get(0));
        res2.setText(listAns.get(1));
        res3.setText(listAns.get(2));
        res4.setText(listAns.get(3));
    }
}




