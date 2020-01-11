package com.mercury;

import java.awt.*;
import javax.swing.*;

public class Graphics extends JFrame{
    Graphics() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        try{
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        } catch (Exception e){
            e.printStackTrace();
        }

        /* frame settings */
        setTitle("Calculator");
        setSize(500, 500);
        setLayout(null);        //no layout manager
        setVisible(true);       //now frame will be visible, by default not visible
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /* Constructor for class will be used to create all needed components */
        /* First all components to be placed on the frame will be created */
        /* TextFields to display all the input in */
        TextField display = new TextField();

        // This means all numeric and operator buttons with their ActionListeners
        // creating operator buttons operator buttons
        char[] operators = new char[]{'/', '*', '-', '+', '='};
        Button[] operatorButtons = new Button[operators.length];

        for (int i = 0; i < operators.length; i++) {
            String label = String.valueOf(operators[i]);
            operatorButtons[i] = new Button(label);

            // This actionlistener enables each button to add a symbol to the screen
            // TO-DO move the lambda expression to its own method and call it from there
            operatorButtons[i].addActionListener(e -> {
                String input = e.getActionCommand();
                String onScreen = display.getText();
                Character lastCharOnScreen = onScreen.charAt(onScreen.length() - 1);
                char inputChar = input.charAt(0);

                if(inputChar == '='){
                    display.setText( String.valueOf(Calculations.main(onScreen)) );
                }
                else {
                    if( lastCharOnScreen.equals('/')|lastCharOnScreen.equals('*')|lastCharOnScreen.equals('-')|lastCharOnScreen.equals('+')){
                        display.setText( onScreen.substring(0, onScreen.length() - 1) + inputChar );
                    }
                    else{
                        display.setText(onScreen.concat(input));
                    }
                    System.out.println(input);
                }
            });
        }

        // creating numeric buttons
        // TO-DO moving the creation of numeric buttons to a different method
        String numLabel;
        Integer buttonCount;
        Button[] numButtons = new Button[10];

        for(buttonCount = 0; buttonCount < numButtons.length ; buttonCount++ ) {
            numLabel = buttonCount.toString();
            numButtons[buttonCount] = new Button( numLabel );
            numButtons[buttonCount].addActionListener(e -> {
                String input = e.getActionCommand();
                String onScreen = display.getText();

                display.setText(onScreen.concat(input));
                System.out.println(input);
            });
        }

        // ELEMENT PLACEMENT
        // TO-DO replace this "manual" placement with a grid
        // initializing element placements variables */
        int buttonXCoordinate = 30, buttonYCoordinate = 100, buttonWidth = 80, buttonHeight = 30;

        // add all fields to frame*/
        add(display);
        display.setBounds(buttonXCoordinate, buttonYCoordinate, 3*(buttonWidth), buttonHeight);

        /* adding all num buttons to frame */
        buttonXCoordinate = 30;
        buttonYCoordinate += buttonHeight;

        for(int i = 0 ; i < numButtons.length ; i++) {
            add(numButtons[i]);
            numButtons[i].setBounds(buttonXCoordinate,buttonYCoordinate,buttonWidth,buttonHeight);
            buttonXCoordinate += buttonWidth;

            /* using modulo to create a new row every 3 buttons */
            if( i % 3 == 0){
                buttonXCoordinate = 30;
                buttonYCoordinate += buttonHeight;
            }
        }

        /* adding all operator buttons to separate sector of the frame */
        buttonYCoordinate = 100;
        buttonXCoordinate = 30 + (3 + 1) * buttonWidth;

        for (Button operatorButton : operatorButtons) {
            add(operatorButton);
            operatorButton.setBounds(buttonXCoordinate, buttonYCoordinate, buttonWidth, buttonHeight);
            buttonYCoordinate += buttonHeight;
        }

    }
}

