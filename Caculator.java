//simple java calculator v1.0
//by lrex93497 @ github
//release under no license

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Caculator implements ActionListener {

    JButton[] buttons = new JButton[9];
    JButton zeroButton;
    JButton dotButton;
    JButton delButton;
    JButton plusButton;
    JButton minusButton;
    JButton timesButton;
    JButton divideButton;
    JButton equalButton;
    JButton resetButton;
    JLabel answerLabel;
    JLabel functionLabel;

    public static void main(String[] args){
        new Caculator();   
    }

    Caculator(){
    
    //default font setting control all font size in this program
    Font DefaultFontSetting = new Font("Arial", Font.BOLD, 38);

    JFrame frame =new JFrame();   //new frame
    frame.setTitle("Simple Java Calculator");
    frame.setSize(600,500);
    frame.setMinimumSize(new Dimension(700, 600));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(true);
    frame.setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();

    JPanel answerPanel = new JPanel();
    gbc.insets = new Insets(10,10,10,10); //Insets(int top, int left, int bottom, int right)
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.gridwidth = 2;
    gbc.fill = gbc.BOTH;
    frame.add(answerPanel, gbc);

    JPanel functionPanel = new JPanel();
    gbc.insets = new Insets(10,10,10,10); //Insets(int top, int left, int bottom, int right)
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 1.0;
    gbc.weighty = 4.0;
    gbc.gridwidth = 1;
    gbc.fill = gbc.BOTH;
    frame.add(functionPanel, gbc);

    JPanel numberPanel = new JPanel();
    gbc.insets = new Insets(10,10,10,10); //Insets(int top, int left, int bottom, int right)
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.weightx = 3.0;
    gbc.weighty = 4.0;
    gbc.gridwidth = 1;
    gbc.fill = gbc.BOTH;
    frame.add(numberPanel, gbc);

    numberPanel.setLayout(new GridLayout(4,3,3,3));  //(int rows, int cols, int hgap, int vgap)
    //numberPanel.setBackground(Color.BLACK);
    answerPanel.setLayout(new GridBagLayout());
    answerPanel.setBackground(new Color(185,185,185));
    functionPanel.setLayout(new GridLayout(6,1,1,2));
    //functionPanel.setBackground(Color.BLACK);


    //forloop to add button
    for (int n = 0; n<9; n++){
        buttons[n] = new JButton();
        buttons[n].setText(String.valueOf(n+1));
        numberPanel.add(buttons[n]);
    }


    zeroButton = new JButton("0");
    numberPanel.add(zeroButton);
    dotButton = new JButton(".");
    numberPanel.add(dotButton);
    delButton = new JButton("del");
    numberPanel.add(delButton);

    plusButton = new JButton("+");
    functionPanel.add(plusButton);
    minusButton = new JButton("-");
    functionPanel.add(minusButton);
    timesButton = new JButton("x");
    functionPanel.add(timesButton);
    divideButton = new JButton("/");
    functionPanel.add(divideButton);
    resetButton = new JButton("RESET");
    functionPanel.add(resetButton);
    equalButton = new JButton("EXE");
    functionPanel.add(equalButton);
    

    
    JButton[] zeroDotDelbuttons = {zeroButton, dotButton, delButton};
    JButton[] functionButtons = {plusButton, minusButton, timesButton, divideButton, equalButton, resetButton};
    for (JButton button:buttons){
        button.setFont(DefaultFontSetting);
    }

    for (JButton button:zeroDotDelbuttons){
        button.setFont(DefaultFontSetting);
    }

    for (JButton button:functionButtons){
        button.setFont(DefaultFontSetting);
    }

    //add ActionListener
    for (int i = 0; i < 9; i++){
        
        buttons[i].setFont(DefaultFontSetting);
        buttons[i].addActionListener(this);

    }

    for (JButton button:zeroDotDelbuttons){
        button.setFont(DefaultFontSetting);
        button.addActionListener(this);    
    }

    for (JButton button:functionButtons){
        button.setFont(DefaultFontSetting);
        button.addActionListener(this);
        }

    //set specific action command of below 4 buttons 
    plusButton.setActionCommand("+");
    minusButton.setActionCommand("-");
    timesButton.setActionCommand("x");
    divideButton.setActionCommand("/");
    

    answerLabel = new JLabel();
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.weightx = 7.0;
    gbc.weighty = 7.0;
    gbc.gridwidth = 1;
    gbc.fill = gbc.BOTH;
    answerPanel.add(answerLabel, gbc);
    answerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    answerLabel.setFont(DefaultFontSetting);
    answerLabel.setText("");

    functionLabel = new JLabel("Mode:+");
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.gridwidth = 1;
    gbc.fill = gbc.BOTH;
    answerPanel.add(functionLabel, gbc);
    functionLabel.setHorizontalAlignment(SwingConstants.LEFT);
    //functionLabel.setBackground(new Color(225,225,225));
    //functionLabel.setOpaque(true);
    functionLabel.setFont(DefaultFontSetting);

    frame.setVisible(true);

    }   
    
    String valueShowed = "";
    String operator = "+";
    double answer = 0.0;
    String temp = "";    //for holding int input in string form 
    Boolean dotUsed = false;  //control for 1 times dot input only, reset when "=" or "del" or "RESET" pressed
    Boolean newvalue = true;  //control for input a new value or extend valueShowed, reset at "=" or "RESET" pressed


    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        //answerLabel.setText(s);

        for(int i=0;i<9;i++) {
            if(e.getSource() == buttons[i]){
                if(newvalue == true){
                    valueShowed = "";
                    newvalue = false;
                    answerLabel.setText(valueShowed);
                }
                temp = Integer.toString(i+1);
                valueShowed = valueShowed.concat(temp);
                answerLabel.setText(valueShowed);
            }
            
        }
        
        if(s == "0"){
            if(newvalue == true){
                valueShowed = "";
                newvalue = false;
                answerLabel.setText(valueShowed);
            }
            valueShowed = valueShowed.concat("0");
            answerLabel.setText(valueShowed);
        }

        if(s == "."){
            if(newvalue == true){
                valueShowed = "";
                newvalue = false;
                answerLabel.setText(valueShowed);
            }
            if(dotUsed == false){
                if(valueShowed == ""){
                    valueShowed = "0";
					newvalue = false;
                }
                valueShowed = valueShowed.concat(".");
                answerLabel.setText(valueShowed);
                dotUsed = true;
                return;
            }
            if(dotUsed == true){
                JOptionPane.showMessageDialog(null, "dot already present", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if(s == "+"){
            operator = "+";
            functionLabel.setText("Mode:+");
        }

        if(s == "-"){
            operator = "-";
            functionLabel.setText("Mode:-");
        }

        if(s == "x"){
            operator = "x";
            functionLabel.setText("Mode:x");
        }

        if(s == "/"){
            operator = "/";
            functionLabel.setText("Mode:/");
        }

        if(s == "del"){
            valueShowed = "";
            answerLabel.setText(valueShowed);
            dotUsed = false; //reset dotUsed
        }

        if(s == "RESET"){
            answer = 0.0;
            valueShowed = "";
            operator ="+";
            temp = "";    
            dotUsed = false;  
            newvalue = true;
            answerLabel.setText(valueShowed);
            functionLabel.setText("Mode:+");
        }

        if(s == "EXE"){
            if(valueShowed == ""){  //for user null input
                JOptionPane.showMessageDialog(null, "Nothing entered, please input.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
                }
            if(valueShowed.substring(valueShowed.length() - 1).equals(".")){  //for user null input
                JOptionPane.showMessageDialog(null, "Invalid, input stopped at '.' ", "Error", JOptionPane.ERROR_MESSAGE);
                return;
                }
            if(operator == "+"){
                answer = answer + Double.parseDouble(valueShowed);
                valueShowed = String.valueOf(answer);
                answerLabel.setText(valueShowed);
            }

            if(operator == "-"){   
                answer = answer - Double.parseDouble(valueShowed);
                valueShowed = String.valueOf(answer);
                answerLabel.setText(valueShowed);
            }

            if(operator == "x"){   
                answer = answer * Double.parseDouble(valueShowed);
                valueShowed = String.valueOf(answer);
                answerLabel.setText(valueShowed);
            }

            if(operator == "/"){   
                System.out.println(valueShowed);
                if(valueShowed.equals("0") | valueShowed.equals("0.0")){  //for user 0 input
                    answerLabel.setText("");
                    valueShowed = "";
                    JOptionPane.showMessageDialog(null, "cannot divide by 0", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                    }
                    answer = answer / Double.parseDouble(valueShowed);
                    valueShowed = String.valueOf(answer);
                    answerLabel.setText(valueShowed);
            }
            dotUsed = false; //reset dotUsed
            newvalue = true; //allow answerLabel input new value 
        }
        
    }
}

