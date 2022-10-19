import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class week5 extends JFrame {
    
    JPanel TextPanel = new JPanel();
  

    JPanel ButtonPanel = new JPanel(new GridLayout(4,4,10,10));
    JTextField textField;
    
    JButton jButton1 = new JButton("1");
    JButton jButton2 = new JButton("2");;
    JButton jButton3 = new JButton("3");;
    JButton jButtonAdd = new JButton("+");

    JButton jButton4 = new JButton("4");;
    JButton jButton5 = new JButton("5");;
    JButton jButton6 = new JButton("6");;
    JButton jButtonsub = new JButton("-");

    JButton jButton7 = new JButton("7");;
    JButton jButton8 = new JButton("8");;
    JButton jButton9 = new JButton("9");;
    JButton jButtonMul = new JButton("*");

    JButton jButton0 = new JButton("0");;
    JButton jButtondivide = new JButton("/");
    JButton jButtonclear = new JButton("C");
    JButton jButtonEqual = new JButton("=");
    int sum=0;
    String opString="";
	
    public ActionListener buttonListener(String text){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+text);
            }
        };
    }
   
    private void ops(){
        switch (opString) {
            case "+":
                if (textField.getText() != "") {
                    sum += Integer.parseInt(textField.getText());
                }
                else sum +=0;
                textField.setText(sum+"");
                opString="";
                break;
            case "-":
                if (textField.getText() != "") {
                    sum -= Integer.parseInt(textField.getText());
                }
                else sum -=0;
                textField.setText(sum+"");
                opString="";
                break;
            case "*":
                if (textField.getText() != "") {
                    sum *= Integer.parseInt(textField.getText());
                }
                else sum *=0;
                textField.setText(sum+"");
                opString="";
                break;
            case "/":
                if (textField.getText() != "") {
                    sum /= Integer.parseInt(textField.getText())!=0?Integer.parseInt(textField.getText()):1;
                }
                else sum /= 1;
                textField.setText(sum+"");
                opString="";
                break;
        }
    }
    public ActionListener clearButtonListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        };
    }
    public ActionListener optButtonListener(String op){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (op!="="){
                    ops();
                    opString=op;
                    if (textField.getText() != "") {
                        sum = Integer.parseInt(textField.getText());
                        textField.setText("");
                    }
                    else {
                        sum=0;
                    }
                }
                else {
                    ops();
                }
            }
        };
    }

    public week5(){
        
        textField = new JTextField(30);
        textField.setText("");
        textField.setEditable(false);
        TextPanel.add(textField);
        
        jButton1.addActionListener(buttonListener(jButton1.getText()));
        jButton2.addActionListener(buttonListener(jButton2.getText()));
        jButton3.addActionListener(buttonListener(jButton3.getText()));      
        jButtonAdd.addActionListener(optButtonListener(jButtonAdd.getText()));
        jButton4.addActionListener(buttonListener(jButton4.getText()));      
        jButton5.addActionListener(buttonListener(jButton5.getText()));
        jButton6.addActionListener(buttonListener(jButton6.getText()));       
        jButtonsub.addActionListener(optButtonListener(jButtonsub.getText()));
        jButton7.addActionListener(buttonListener(jButton7.getText()));
        jButton8.addActionListener(buttonListener(jButton8.getText()));
        jButton9.addActionListener(buttonListener(jButton9.getText()));       
        jButtonMul.addActionListener(optButtonListener(jButtonMul.getText()));
        jButton0.addActionListener(buttonListener(jButton0.getText()));     
        jButtondivide.addActionListener(optButtonListener(jButtondivide.getText()));      
        jButtonclear.addActionListener(clearButtonListener());      
        jButtonEqual.addActionListener(optButtonListener(jButtonEqual.getText()));
       
        ButtonPanel.add(jButton1);
        ButtonPanel.add(jButton2);
        ButtonPanel.add(jButton3);
        ButtonPanel.add(jButtonAdd);
        ButtonPanel.add(jButton4);
        ButtonPanel.add(jButton5);
        ButtonPanel.add(jButton6);
        ButtonPanel.add(jButtonsub);
        ButtonPanel.add(jButton7);
        ButtonPanel.add(jButton8);
        ButtonPanel.add(jButton9);
        ButtonPanel.add(jButtonMul);
        ButtonPanel.add(jButton0);
        ButtonPanel.add(jButtonclear);
        ButtonPanel.add(jButtondivide);
        ButtonPanel.add(jButtonEqual);
        this.add(TextPanel,BorderLayout.NORTH);
        this.add(ButtonPanel,BorderLayout.CENTER);
        
    }
    
    public static void main(String[] args) {
        week5 deom = new week5();
        deom.setTitle("計算器");
        deom.setLocation(200,200);
        deom.pack();
        deom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        deom.setVisible(true);
    }
}