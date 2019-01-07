package org.launchcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener
{
    private JPanel panelroot;
    private JTextField textFieldHeight;
    private JTextField textFieldWeight;
    private JTextField score;
    private JLabel labelHeight;
    private JLabel labelWeight;
    private JLabel labelScore;
    private JButton calculate;
    private JPanel panelBootom;
    private JRadioButton woman;
    private JRadioButton man;
    private JPanel panelTop;
    private double height;
    private double weight;
    private float result = 0.0f;

    public Main()
    {
        this.setVisible(true);
        initComponent();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("BMI");
        this.setBounds(450, 250, 350, 350);
    }

    private void initComponent()
    {
        //Creating panels

        panelroot = new JPanel(new GridLayout(3, 1));
        panelBootom = new JPanel();
        panelTop = new JPanel();

        //Create text fields

        textFieldHeight = new JTextField(1);
        textFieldWeight = new JTextField(1);
        score = new JTextField(1);

        // Creating labels

        labelHeight = new JLabel("Wzrost:");
        labelWeight = new JLabel("Waga:");
        labelScore = new JLabel("BMI wynosi:");

        // Creating buttons

        calculate = new JButton("Oblicz BMI");
        woman = new JRadioButton("Kobieta");
        woman.setActionCommand("Kobieta");

        man = new JRadioButton("Mężczyzna");
        man.setActionCommand("Mężczyzna");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(woman);
        buttonGroup.add(man);

        man.addActionListener(this);
        woman.addActionListener(this);
        calculate.addActionListener(this);

        // Adding all to panelroot

        panelroot.add(labelHeight);
        panelroot.add(textFieldHeight);
        panelroot.add(labelWeight);
        panelroot.add(textFieldWeight);
        panelroot.add(labelScore);
        panelroot.add(score);
        panelTop.add(woman);
        panelTop.add(man);
        panelBootom.add(calculate);

        this.getContentPane().add(panelroot);
        this.add(panelBootom, BorderLayout.PAGE_END);
        this.add(panelTop, BorderLayout.PAGE_START);

        // Setting the font

        Font font = new Font("Comic Sans MS", Font.BOLD, 15);

        labelHeight.setFont(font);
        labelWeight.setFont(font);
        labelScore.setFont(font);
        man.setFont(font);
        woman.setFont(font);
        calculate.setFont(font);

        // Setting borders and background

        panelroot.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panelroot.setBackground(Color.lightGray);
        calculate.setBackground(Color.cyan);
        textFieldHeight.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        textFieldWeight.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        score.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 1, Color.BLACK));
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new Main());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Creating the option chooser

        if (man.isSelected())
        {
            man.setSelected(true);
            result = 0.0f;
        }
        if (woman.isSelected())
        {
            woman.setSelected(true);
            result = 0.0f;
        }

        String heightInput = textFieldHeight.getText();
        height = heightInput == null || heightInput.isEmpty() ? 0.0 : Double.parseDouble(heightInput);

        String weightInput = textFieldWeight.getText();
        weight = weightInput == null || weightInput.isEmpty() ? 0.0 : Double.parseDouble(weightInput);

        String resultInput = score.getText();
        result = resultInput == null || resultInput.isEmpty() ? 0.0f : Float.parseFloat(resultInput);

        result = (float) ((weight / (height * height)) * 10000);
        score.setText(" " + result);

        JOptionPane jOptionPane = new JOptionPane();

        if (man.isSelected())
        {
            if (result < 16.00)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na wygłodzenie", "BMI", JOptionPane.WARNING_MESSAGE);
            }
            if (result > 16.00 && result < 16.99)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na wychudzenie", "BMI", JOptionPane.WARNING_MESSAGE);
            }
            if (result > 17.00 && result < 18.49)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na niedowagę", "BMI", JOptionPane.WARNING_MESSAGE);
            }
            if (result > 18.50 && result < 24.99)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na prwaidłową wagę", "BMI", JOptionPane.INFORMATION_MESSAGE);
            }
            if (result > 25.00 && result < 29.99)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje nadwagę", "BMI", JOptionPane.WARNING_MESSAGE);
            }
            if (result > 30.00 && result < 34.99)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na otyłość I stopnia", "BMI", JOptionPane.WARNING_MESSAGE);
            }
            if (result > 35.00 && result < 39.99)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na otyłość II stopnia", "BMI", JOptionPane.WARNING_MESSAGE);
            }
            if (result >= 40)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na otyłość III stopnia", "BMI", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (woman.isSelected())
        {
            if (result < 16.00)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na wygłodzenie", "BMI", JOptionPane.WARNING_MESSAGE);
            }
            if (result > 16.00 && result < 16.99)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na wychudzenie", "BMI", JOptionPane.WARNING_MESSAGE);
            }
            if (result > 17.00 && result < 18.49)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na niedowagę", "BMI", JOptionPane.WARNING_MESSAGE);
            }
            if (result > 18.50 && result < 24.99)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na prwaidłową wagę", "BMI", JOptionPane.INFORMATION_MESSAGE);
            }
            if (result > 25.00 && result < 29.99)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje nadwagę", "BMI", JOptionPane.WARNING_MESSAGE);
            }
            if (result > 30.00 && result < 34.99)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na otyłość I stopnia", "BMI", JOptionPane.WARNING_MESSAGE);
            }
            if (result > 35.00 && result < 39.99)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na otyłość II stopnia", "BMI", JOptionPane.WARNING_MESSAGE);
            }
            if (result >= 40)
            {
                jOptionPane.showMessageDialog(null, "Stan BMI wskazuje na otyłość III stopnia", "BMI", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}





