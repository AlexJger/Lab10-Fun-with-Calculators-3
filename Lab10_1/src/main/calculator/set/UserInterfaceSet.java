package main.calculator.set;

import main.calculator.decimal.CalcEngine;
import main.calculator.decimal.UserInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Set;

public class UserInterfaceSet extends UserInterface {

    CalcEngineSet calcSet;
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
    public UserInterfaceSet(CalcEngineSet engine) {
        super(engine);
        calcSet = engine;
    }

    protected void makeFrame() {
        frame = new JFrame(calc.getTitle());
        frame.setMinimumSize(new Dimension(500, 320));

        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setLayout(new GridLayout(6, 1));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));


        inputA = new JTextField();
        contentPane.add(inputA);

        inputB = new JTextField();
        contentPane.add(inputB);

        contentPane.add(Box.createVerticalStrut(1));


        JPanel buttonPanel = new JPanel(new GridLayout(2, 4));
        union = addButton(buttonPanel, "Union");
        subtraction = addButton(buttonPanel, "Subtraction");
        intersection = addButton(buttonPanel, "Intersection");
        clear = addButton(buttonPanel, "Clear");
        pushA = addButton(buttonPanel, "Push A");
        pushB = addButton(buttonPanel, "Push B");
        lengthA = addButton(buttonPanel, "Length Set A");
        lengthB = addButton(buttonPanel, "Length Set B");
        contentPane.add(buttonPanel);

        contentPane.add(Box.createVerticalStrut(1));

        output = new JTextField();
        contentPane.add(output);

    }

    public void redisplay(){
        inputA.setText("" + calcSet.removeFirstAndLast(calcSet.removeSpacebars(calcSet.getSet("setA").toString())));
        inputB.setText("" + calcSet.removeFirstAndLast(calcSet.removeSpacebars(calcSet.getSet("setB").toString())));
        // output.setText("" + calcSet.removeFirstAndLast(calcSet.getSet("setResult").toString()));
    }
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        switch (command) {
            case "Union" -> {
                calcSet.setSet(inputA.getText(), "setA");
                calcSet.setSet(inputB.getText(), "setB");
                output.setText(calcSet.union().toString());
            }
            case "Intersection" -> {
                calcSet.setSet(inputA.getText(), "setA");
                calcSet.setSet(inputB.getText(), "setB");
                output.setText(calcSet.intersection().toString());
            }
            case "Subtraction" -> {
                calcSet.setSet(inputA.getText(), "setA");
                calcSet.setSet(inputB.getText(), "setB");
                output.setText(calcSet.subtraction().toString());
            }
            case "Push A" -> {
                if(output != null){
                    inputA.setText(calcSet.removeSpacebars(calcSet.removeFirstAndLast(output.getText())));
                    calcSet.setSet(inputA.getText(), "setA");
                }
            }
            case "Push B" -> {
               if(output != null){
                    inputB.setText(calcSet.removeSpacebars(calcSet.removeFirstAndLast(output.getText())));
                    calcSet.setSet(inputB.getText(), "setB");
                   System.out.println(inputB.getText());
                }
            }
            case "Length Set A" ->  {
                calcSet.setSet(inputA.getText(), "setA");
                output.setText("" + (calcSet.parseStringToSet(inputA.getText()).size()));
            }
            case "Length Set B" -> {
                calcSet.setSet(inputB.getText(), "setB");

                output.setText("" + (calcSet.parseStringToSet(inputB.getText()).size()));
            }
            case "Clear" -> {
                calcSet.clear();

            }

        } redisplay();
    }
}

