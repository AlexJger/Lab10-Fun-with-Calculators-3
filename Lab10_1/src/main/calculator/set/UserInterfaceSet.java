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
    private JButton powerA;
    private JButton powerB;
    private JButton clearA;
    private JButton clearB;


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
        frame.setMinimumSize(new Dimension(250, 200));

        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setLayout(new BorderLayout(2, 2));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        
        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        inputA = new JTextField();
        textPanel.add(inputA);

        inputB = new JTextField();
        textPanel.add(inputB);
        contentPane.add(textPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new GridLayout(3, 4));
        union = addButton(buttonPanel, "Union");
        subtraction = addButton(buttonPanel, "Subtraction");
        intersection = addButton(buttonPanel, "Intersection");
        clear = addButton(buttonPanel, "Clear All");
        pushA = addButton(buttonPanel, "Push A");
        lengthA = addButton(buttonPanel, "Length Set A");
        powerA = addButton(buttonPanel, "Power Set A");
        clearA = addButton(buttonPanel, "Clear A");
        pushB = addButton(buttonPanel, "Push B");
        lengthB = addButton(buttonPanel, "Length Set B");
        powerB = addButton(buttonPanel, "Power Set B");
        clearB = addButton(buttonPanel, "Clear B");
        contentPane.add(buttonPanel);
       
        output = new JTextField();
        contentPane.add(output, BorderLayout.SOUTH);
        
        frame.pack();
    }
    
    public void preAction() {
    	calcSet.clear("setResult");
    	calcSet.setSet(inputA.getText(), "setA");
        calcSet.setSet(inputB.getText(), "setB");
    }
    
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        
        switch (command) {
            case "Union" -> {
            	preAction();
                output.setText(calcSet.union().toString());
            }
            case "Intersection" -> {
                calcSet.setSet(inputA.getText(), "setA");
                preAction();
                output.setText(calcSet.intersection().toString());
            }
            case "Subtraction" -> {
            	preAction();
                output.setText(calcSet.subtraction().toString());
            }
            case "Push A" -> {
                if(output != null){
                	calcSet.clear("setA");
                    calcSet.setSet(calcSet.removeSpacebars(calcSet.removeFirstAndLast(calcSet.getSet("setResult").toString())), "setA");
                }
            }
            case "Push B" -> {
               if(output != null){
            	   calcSet.clear("setB");
                   calcSet.setSet(calcSet.removeSpacebars(calcSet.removeFirstAndLast(calcSet.getSet("setResult").toString())), "setB");
                }
            }
            case "Length Set A" ->  {
            	calcSet.clear("setResult");
            	calcSet.setSet(inputA.getText(), "setA");
                calcSet.setSet((""+calcSet.sizeOfSet("setA")), "setResult");
            }
            case "Length Set B" -> {
            	calcSet.clear("setResult");
            	calcSet.setSet(inputB.getText(), "setB");
                calcSet.setSet((""+calcSet.sizeOfSet("setB")), "setResult");
            }
            case "Clear All" -> {
                calcSet.clear("all");

            }
            case "Clear A" -> {
                calcSet.clear("setA");

            }
            case "Clear B" -> {
                calcSet.clear("setB");

            }
            case "Power Set A" -> {
            	calcSet.setSet(inputA.getText(), "setA");
            	calcSet.clear("setResult");
            	calcSet.powerSet("setA");
            }
            case "Power Set B" -> {
            	calcSet.setSet(inputB.getText(), "setB");
            	calcSet.clear("setResult");
            	calcSet.powerSet("setB");
            }

        } 
        redisplay();
    }
    
    public void redisplay(){
        inputA.setText("" + calcSet.removeFirstAndLast(calcSet.removeSpacebars(calcSet.getSet("setA").toString())));
        inputB.setText("" + calcSet.removeFirstAndLast(calcSet.removeSpacebars(calcSet.getSet("setB").toString())));
        output.setText("" + calcSet.removeSpacebars(calcSet.getSet("setResult").toString()));
    }
}

