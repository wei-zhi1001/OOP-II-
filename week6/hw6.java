


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon; 

public class hw6 {
    public static void main(String[] args) {
        frame6 mf = new frame6();
    }
}

class frame6 extends JFrame
{   
    private JPanel contentPane;
    private JLabel jl, jtext;

    private int num=0;

    public frame6(){

        contentPane=new JPanel();
        contentPane.setLayout(new BorderLayout());
        
        JButton btn1 = new JButton("back");
        JButton btn2 = new JButton("next");
        ImageIcon[] Icons  = {new ImageIcon("./image/baby1.png"),new ImageIcon("./image/baby4.png"),new ImageIcon("./image/soldier.png")};
        for(int i=0;i<3;i++){
            Image image = Icons[i].getImage(); 
            Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); 
            Icons[i] = new ImageIcon(newimg); 
        }
        
        String[] iconsName = {"baby.png","baby2.png","notbaby.png"};
        jl=new JLabel();
        jl.setIcon(Icons[0]);
        jtext=new JLabel(iconsName[0],SwingConstants.CENTER);
        contentPane.add(btn1, BorderLayout.WEST);
        contentPane.add(btn2, BorderLayout.EAST);   
        contentPane.add(jl, BorderLayout.CENTER);
        contentPane.add(jtext, BorderLayout.NORTH);

        btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(num>0){
                    num -= 1;
                    System.out.println(num);
                    jl.setIcon(Icons[num]);
                    jtext.setText(iconsName[num]);
                }else{
                    JOptionPane.showMessageDialog(getContentPane(), "it is the first one !");
                }
            }
        });
        
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              
                if(num<Icons.length-1){
                    num += 1;
                    //System.out.println(num);
                    jl.setIcon(Icons[num]);
                    jtext.setText(iconsName[num]);
                }else{
                    JOptionPane.showMessageDialog(getContentPane(), "no more pictures !");
                }
            }
        });
        
        
        

        this.setContentPane(contentPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Photo");
        this.setBounds(200,200,400,300);
        this.setVisible(true);

        
    }


}