import java.util.* ;
public class week2_2 
{
    public static void main(String[] args)
    {
        String [] month = {"January","February","March","April","May","June","July","August",
        "September","October","November","December"};
        var hmap = new HashMap<>();
        for(int i=0;i<12;i++)
        {
            hmap.put(i+1, month[i]);
        }
        while(true)
        {
            System.out.print("請輸入1~12？");
            Scanner sc=new Scanner(System.in);
            int inputs=sc.nextInt();
            if(inputs<1||inputs>12)
            {
                System.out.println("範圍錯誤!"); 
            }
            else
            {
                System.out.println("第"+inputs+"月的英文單字為"+hmap.get(inputs));
                break; 
            }
        }
        


    }
}
