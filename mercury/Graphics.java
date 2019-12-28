package com.mercury;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics extends Frame{
    public static void main(){

        /* When calling this graphics class the AWT library will be used to create a GUI */

        /* call button methods */
        Button[] numButtons = Graphics.generateNumButtons();
        Button[] operatorButtons = Graphics.generateOperatorButtons();

        /* call text field method */
        TextField[] textFields = Graphics.createTextFields();

        new calcFrame("Calculator", numButtons, operatorButtons, textFields);
    }

    public static class calcFrame extends Frame{
        calcFrame( String title, Button[] numButtons, Button[] operatorButtons, TextField[] textFields ){

            /* window settings */
            short frameWidth = 500;
            short frameHeight = 500;
            setTitle(title);
            setSize(frameWidth, frameHeight);
            setLayout(null);        //no layout manager
            setVisible(true);       //now frame will be visible, by default not visible

            /* initializing element placements variables */
            int buttonXCoordinate = 30, buttonYCoordinate = 100, buttonWidth = 80, buttonHeight = 30;

            /* add all fields to frame*/
            for(int i = 0; i < textFields.length; i++){
                add(textFields[i]);
                textFields[i].setBounds(buttonXCoordinate,buttonYCoordinate,buttonWidth,buttonHeight);
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

            for(int i = 0; i < operatorButtons.length ; i++){
                add(operatorButtons[i]);
                operatorButtons[i].setBounds(buttonXCoordinate,buttonYCoordinate,buttonWidth,buttonHeight);
                buttonYCoordinate += buttonHeight;
            }

        }
    }

    private static Button[] generateNumButtons(){
        String buttonLabel = "";
        Integer buttonCount;
        Button[] numButtons = new Button[10];

        for(buttonCount = 0; buttonCount < numButtons.length ; buttonCount++ ) {
            buttonLabel = buttonCount.toString();
            numButtons[buttonCount] = new Button( buttonLabel );
            numButtons[buttonCount].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = e.getActionCommand();
                    System.out.println(input);
                }
            });
        }

        return numButtons;
    }

    private static Button[] generateOperatorButtons() {
        String[] buttonLabel = new String[]{"/", "*", "-", "+", "="};
        Button[] operatorButtons = new Button[buttonLabel.length];

        for (int i = 0; i < buttonLabel.length; i++) {
            operatorButtons[i] = new Button(buttonLabel[i]);
            operatorButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = e.getActionCommand();
                    System.out.println(input);
                }
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
    }
}

