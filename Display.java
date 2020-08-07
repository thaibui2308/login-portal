import java.util.LinkedList;
import java.util.List;

public class Display {
    private Activity activity=new Activity();
    private static List<Activity> schedule=new LinkedList<>();

    public Display() {
        this.activity=null;
    }
    public Display(Activity random){
        activity=new Activity(random);
        schedule.add(activity);
    }

    //method that transfers military time to normal time
    public void displayTime(){
        String Begin;
        String End;
        int start=activity.getStart();
        int sub_start;
        int end=activity.getEnd();
        int sub_end;
        if (start/100>0&&start/100<12) {
            Begin = "AM";
            sub_start=start/100;
        }
        else {
            Begin="PM";
            if (start/100==12)
                sub_start=start/100;
            else
                sub_start=start/100-12;
        }
        if (end/100>0&&end/100<12){
            End="AM";
            sub_end=end/100;
        }
        else {
            if (end/100==12)
                sub_end=end/100;
            else
                sub_end=end/100-12;
            End="PM";
        }
        System.out.print(sub_start+":"+start%100+Begin+" to "+sub_end+":"+end%100+End+"\n");
    }
    public void printActivity(){
        for (int j=1;j<=3;j++) {
            if (j==2){
                int len=activity.getType().length();
                for (int h=0;h<(20-len)/2;h++) System.out.print(" ");
                System.out.println(activity.getType().toUpperCase());
            }
            else {
                for (int i=0;i<20;i++) System.out.print("X");
                System.out.println();
            }
        }
    }
    public void displayGap(){
        int Size=schedule.size();
        if (Size==1)
            System.out.print("");
        else {
         int s=schedule.get(Size-1).getStart();
         int e=schedule.get(Size-2).getEnd();
         int time=((s/100)*60+(s%100))-((e/100)*60+(e%100));
         if (time<=60) System.out.println("You have "+time+" minute(s) "+"before your next activity!");
         else{
             System.out.println("You have "+time/60+" hour(s), "+time%60+" minute(s) "+"before your next activity!");

         }
        }

    }
}
