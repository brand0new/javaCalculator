package com.mercury;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics extends Frame{
    Graphics(){
        /* Constructor for class will be used to create all needed components */
        /* First all components to be placed on the frame will be created */
        /* TextFields to display all the input in */
        TextField display = new TextField("display");

        // This means all numeric and operator buttons with their ActionListeners
        // operator buttons
        String[] buttonLabel = new String[]{"/", "*", "-", "+", "="};
        Button[] operatorButtons = new Button[buttonLabel.length];

        for (int i = 0; i < buttonLabel.length; i++) {
            operatorButtons[i] = new Button(buttonLabel[i]);
            operatorButtons[i].addActionListener(e -> {
                String input = e.getActionCommand();
                if(input == "="){
                    display.setText( String.valueOf(Calculations.main(input)) );
                }
                else {
                    display.getText().concat(input);
                }
            });
        }

        // numeric buttons
        String numLabel;
        Integer buttonCount;
        Button[] numButtons = new Button[10];

        for(buttonCount = 0; buttonCount < numButtons.length ; buttonCount++ ) {
            numLabel = buttonCount.toString();
            numButtons[buttonCount] = new Button( numLabel );
            numButtons[buttonCount].addActionListener(e -> {
                String input = e.getActionCommand();
                display.getText().concat(input);
            });
        }
    }

    public static void main(){
        /* When calling this graphics class the AWT library will be used to create a GUI */
        calcFrame Main = new calcFrame();
    }

    public static class calcFrame extends Frame{
        calcFrame( Button[] numButtons, Button[] operatorButtons, TextField[] textFields ){

            /* frame settings */
            setTitle("Calculator");
            setSize(500, 500);
            setLayout(null);        //no layout manager
            setVisible(true);       //now frame will be visible, by default not visible

            /* ELEMENT PLACEMENT */
            /* initializing element placements variables */
            int buttonXCoordinate = 30, buttonYCoordinate = 100, buttonWidth = 80, buttonHeight = 30;

            /* add all fields to frame*/
            for (TextField textField : textFields) {
                add(textField);
                textField.setBounds(buttonXCoordinate, buttonYCoordinate, buttonWidth, buttonHeight);
                buttonXCoordinate += buttonWidth;
            }

            buttonXCoordinate = 30;
            buttonYCoordinate += buttonHeight;

            /* adding all num buttons to frame */
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

    /* private static Button[] generateNumButtons(){
        String buttonLabel;
        Integer buttonCount;
        Button[] numButtons = new Button[10];

        for(buttonCount = 0; buttonCount < numButtons.length ; buttonCount++ ) {
            buttonLabel = buttonCount.toString();
            numButtons[buttonCount] = new Button( buttonLabel );
            numButtons[buttonCount].addActionListener(e -> {
                String input = e.getActionCommand();
            });
        }

        return numButtons;
    }

    private static Button[] generateOperatorButtons() {
        String[] buttonLabel = new String[]{"/", "*", "-", "+", "="};
        Button[] operatorButtons = new Button[buttonLabel.length];

        for (int i = 0; i < buttonLabel.length; i++) {
            operatorButtons[i] = new Button(buttonLabel[i]);
            operatorButtons[i].addActionListener(e -> {
                    String input = e.getActionCommand();
                    TextField[]  ;
            });
        }

        return operatorButtons;
    }

    private static TextField[] createTextFields(){
        String[] fieldLabels = new String[]{"var1","var2","operator","result"};
        TextField[] fieldList = new TextField[fieldLabels.length];

        for(int i = 0; i < fieldLabels.length; i++ ){
            fieldList[i] = new TextField(fieldLabels[i]);
        }

        return fieldList;
    }*/
}

