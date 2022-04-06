/*

make it work for doubles, check for dividing by zero

 */


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener  {

    public static void main(String arg[]) {
        new Calculator();
    }
    
    JButton addition, subtraction, multiplication, division, equals, clear;
    JButton b[] = new JButton[10];
    int i, r, firstNumber, secondNumber;
    JTextField result;
    char op;
    
    public Calculator() {
        super("Nirayka's Calulator");
        setLayout(new BorderLayout());
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(4,4));
        for(int i=0;i<=9;i++)
        {
            b[i]=new JButton(i+"");
            p.add(b[i]);
            b[i].addActionListener(this);
        }
        addition = new JButton("+");
        p.add(addition);
        addition.addActionListener(this);

        subtraction = new JButton("-");
        p.add(subtraction);
        subtraction.addActionListener(this);

        multiplication = new JButton("*");
        p.add(multiplication);
        multiplication.addActionListener(this);

        division=new JButton("/");
        p.add(division);
        division.addActionListener(this);

        equals = new JButton("=");
        p.add(equals);
        equals.addActionListener(this);

        clear = new JButton("C");
        p.add(clear);
        clear.addActionListener(this);

        result = new JTextField(10);
        add(p,BorderLayout.CENTER);
        add(result,BorderLayout.NORTH);
        setVisible(true);
        setSize(200,200);
    }
    
    public void actionPerformed(ActionEvent ae) {
        JButton pb=(JButton)ae.getSource();
        if (pb==clear) {
            r=firstNumber=secondNumber=0;
            result.setText("");
        }
        else if (pb==equals) {
            secondNumber=Integer.parseInt(result.getText());
            eval();
            result.setText(""+r);
        }
        else {
            boolean opf=false;
            if (pb == addition) {
                op='+';
                opf=true;
            }
            if (pb == subtraction) {
                op='-';opf=true;
            }
            if (pb == multiplication) {
                op='*';opf=true;
            }
            if (pb == division) {
                op='/';opf=true;
            }
            if (opf == false) {
                for(i=0; i<10; i++) {
                    if (pb==b[i]) {
                        String t = result.getText();
                        t+=i;
                        result.setText(t);
                    }
                }
            } else {
                firstNumber = Integer.parseInt(result.getText());
                result.setText("");
            }
        }
    }
    int eval() {
        switch(op) {
            case '+': r = firstNumber + secondNumber; break;
            case '-': r = firstNumber - secondNumber; break;
            case '*': r = firstNumber * secondNumber; break;
            case '/': r = firstNumber / secondNumber; break;

        }
        return 0;
    }


}