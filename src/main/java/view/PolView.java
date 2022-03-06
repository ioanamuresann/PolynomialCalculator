package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
public class PolView extends JFrame {

    //trei fielduri
    public JTextField firstPoli = new JTextField(15);
    public JTextField secondPoli = new JTextField(15);
    public JTextArea resultText = new JTextArea(5,15);
    //trei etichete
    private JLabel Label1 = new JLabel("Polinom 1=");
    private JLabel Label2 = new JLabel("Polinom 2=");
    private JLabel Label3 = new JLabel("Rezultat:");
    //butoanele necesare
    private JButton multiplicationButton = new JButton("Inmultire");
    private JButton substractionButton = new JButton("Scadere");
    private JButton divisionButton = new JButton("Impartire");
    private JButton addButton = new JButton("Adunare");
    private JButton derivateButton = new JButton("Derivare");
    private JButton integrationButton = new JButton("Integrare");

  public  PolView()
{

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(600, 400);
    this.setTitle("POLYNOMIAL CALCULATOR");

    //un panel separat pentru primul polinom
    JPanel panel1 = new JPanel();
    panel1.setBackground(Color.LIGHT_GRAY);
    panel1.add(Label1);
    panel1.add(firstPoli);

    //un panel separat pentru al doilea polinom
    JPanel panel2 = new JPanel();
    panel2.setBackground(Color.GRAY);
    panel2.add(Label2);
    panel2.add(secondPoli);

    //un panel separat pentru rezultat
    JPanel panel3 =new JPanel();
    panel3.setBackground(Color.LIGHT_GRAY);
    panel3.add(Label3);
    panel3.add(resultText);


    //un panel separat pentru butoane
    JPanel polynomialCalculator = new JPanel();
    this.add(polynomialCalculator);
    polynomialCalculator.add(panel1);
    polynomialCalculator.add(panel2);
    polynomialCalculator.add(panel3);
    polynomialCalculator.add(multiplicationButton);
    polynomialCalculator.add(substractionButton);
    polynomialCalculator.add(divisionButton);
    polynomialCalculator.add(addButton);
    polynomialCalculator.add(derivateButton);
    polynomialCalculator.add(integrationButton);

    GridLayout experimentLayout = new GridLayout(3,2);
    polynomialCalculator.setLayout(experimentLayout);
}
public String getFirstPoli()
{
    return firstPoli.getText();
}
public String getSecondPoli() {
    return secondPoli.getText();
}
    public void addButton(ActionListener action) {
        addButton.addActionListener(action);
    }

    public void substractionButton(ActionListener action) {
        substractionButton.addActionListener(action);
    }

    public void multiplicationButton(ActionListener action) {
        multiplicationButton.addActionListener(action);
    }

    public void divisionButton(ActionListener action) {
        divisionButton.addActionListener(action);
    }

    public void derivateButton(ActionListener action) {
        derivateButton.addActionListener(action);
    }

    public void integrationButton(ActionListener action) {
        integrationButton.addActionListener(action);
    }
}
