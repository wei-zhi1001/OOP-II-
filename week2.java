import java.util.* ;
import java.lang.Math;
public class week2
{
    public static void main(String[] args)
    {
        var stree = new TreeSet<>();
        int count = 1;
        while(stree.size()<10)
        {
            int rd = (int)(Math.random()*100)+1;
            if(!stree.contains(rd))
            {
                stree.add(rd);
                System.out.println("第"+count+"個號碼："+rd);
                count++;
            } 
        }
        System.out.println("物件內元素個數為："+stree.size());
        System.out.println("物件內元素的內容："+stree);
        System.out.println("第一個元素內容："+stree.first());
        System.out.println("最後一個元素內容："+stree.last());
        System.out.println("內容介於30~70者："+stree.subSet(30, 70));
        
    }
}