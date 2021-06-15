package main.calculator.set;

import main.calculator.decimal.CalcEngine;
import main.calculator.decimal.UserInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserInterfaceSet extends UserInterface {


    private JTextField inputA;
    private JTextField inputB;
    private JTextField output;

    private JButton union;
    private JButton intersection;
    private JButton subtraction;
    private JButton clear;
    private JButton pushA;
    private JButton pushB;
    private JButton lengthA;
    private JButton lengthB;




    /**
     * Create a user interface.
     *
     * @param engine The calculator engine.
     */
    public UserInterfaceSet(CalcEngine engine) {
        super(engine);
    }

    protected void makeFrame() {
        frame = new JFrame(calc.getTitle());
        frame.setMinimumSize(new Dimension(500,320));

        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new GridLayout(6,1));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));



        inputA = new JTextField();
        contentPane.add(inputA);

        inputB = new JTextField();
        contentPane.add(inputB);

        contentPane.add(Box.createVerticalStrut(1));


        JPanel buttonPanel = new JPanel(new GridLayout(2, 4));
        union = addButton(buttonPanel, "Union");
        subtraction = addButton(buttonPanel,"Subtraction");
        intersection = addButton(buttonPanel, "Intersection");
        clear = addButton(buttonPanel,"Clear");
        pushA = addButton(buttonPanel,"Push A");
        pushB = addButton(buttonPanel, "Push B");
        lengthA = addButton(buttonPanel, "Length Set A");
        lengthB = addButton(buttonPanel, "Length Set B");
        contentPane.add(buttonPanel);

        contentPane.add(Box.createVerticalStrut(1));

        output = new JTextField();
        contentPane.add(output);

    }

}
