
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class week7 {
    public static void main(String[] args) {

        Myframe mf = new Myframe();
    }
}

class Myframe extends JFrame implements ListSelectionListener {
    
    final JList<String> list = new JList<String>();
    int selections[];
    JList l=new JList<>();
    private JTextArea jt = new JTextArea("選取上方列表之地點以查看該地代表名山", 5 ,10);

    public Myframe(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 20, 400, 300);
        setLayout(null);
        JPanel p1 = new JPanel();
        setContentPane(p1);
        p1.setLayout(new BorderLayout());
        
        JLabel labelCity = new JLabel("點擊右方以選擇地點 :");
        
      
        JPanel p2 = new JPanel();
        //p1.setBackground(Color.BLUE);
        p2.setLayout(new FlowLayout());
        String[] city = {"高雄", "嘉義", "南投" , "台北"};
        JList<String> list = new JList<>(city);

        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        //list.setListData(new String[]{"高雄", "嘉義", "南投" , "台北"});
        list.setVisibleRowCount(4);
        list.addListSelectionListener(this);
        
        JScrollPane p3 = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
        p2.add(labelCity);
        p2.add(p3);
        
        p1.add(p2, BorderLayout.NORTH);
        p1.add(jt, BorderLayout.CENTER);

        setVisible(true);
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        String text="";
        boolean adjust = e.getValueIsAdjusting();
        String[] mountains ={"壽山", "阿里山" , "玉山" ,"陽明山"};

            if (!adjust) {
                l= (JList) e.getSource();
                
                selections = l.getSelectedIndices();
                
                //Object selectedValues[] = list.getSelectedValues();
                java.util.List selectedValues = l.getSelectedValuesList();
                for (int i = 0; i< selections.length; i++) {
                    text+=selectedValues.get(i) + ": " + mountains[selections[i]] + "\n";
                }
            }

            jt.setText(text);
        }        
}