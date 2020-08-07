import java.util.LinkedList;
import java.util.List;

public class Activity extends AbstractActivity {
    private int duration;

    //Constructor
    public Activity(){
        super();
    }
    public Activity(String Active,int Start, int End){
        super(Active,Start,End);
        duration=(End%100)+(60-(Start%100));
    }
    public Activity(Activity tmp){
        type=tmp.getType();
        start=tmp.getStart();
        end=tmp.getEnd();
        duration=tmp.getDuration();
    }

    //Getter of duration variable
    public int getDuration(){return duration;}

    public String HowLong(){
        int hour=duration/60;
        String str=hour+" hour(s), "+(duration-hour*60)+" minute(s).";
        return str;
    }

    public void add(List<Integer> list, List<Integer> List){
           list.add(start);
           List.add(end);
    }

}
