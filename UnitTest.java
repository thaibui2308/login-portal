import java.util.LinkedList;
import java.util.List;

public class UnitTest {
    public static void main(String[] args) {
        ConflictTest();
        SizeTest();
        SortTest();
        SearchTest();
    }
    public static void ConflictTest(){
        Daily today=new Daily("Monday");
        Activity activity= new Activity("Fishing",0250,0350);
        today.setTask(activity);
        today.AddToSchedule(activity);
        today.Generate(activity);
        activity=new Activity("Go to Target",0120,0255);
        today.setTask(activity);
        if (!today.isConflict(activity))
            System.out.println("ConflictTest: FAILED!");
        else
            System.out.println("ConflictTest: PASSED!");
        today.todaySchedule=new LinkedList<>();

    }
    public static void SortTest(){
        Daily today=new Daily("Tuesday");
        Activity tmp=new Activity("Workout",0650,0730);
        today.setTask(tmp);
        today.AddToSchedule(tmp);
        today.Generate(tmp);
        tmp =new Activity("Movie with mom",1930,2115);
        today.setTask(tmp);
        if (!today.isConflict(tmp)) {
            today.AddToSchedule(tmp);
            today.Generate(tmp);
        }
        tmp= new Activity("Breakfast",6,630);
        today.setTask(tmp);
        if (!today.isConflict(tmp)) {
            today.AddToSchedule(tmp);
            today.Generate(tmp);
        }
        List<Activity> TuesdaySchedule=today.getTodaySchedule();
        if (TuesdaySchedule.get(1).getStart()==0650&&TuesdaySchedule.get(2).getType().compareTo("Movie with mom")==0&&TuesdaySchedule.get(0).getEnd()==630)
            System.out.println("Sorting Test: INSERTION SORT PASSED!");
        else
            System.out.println("Sorting Test: INSERTION SORT FAILED!");
        today.todaySchedule=new LinkedList<>();
    }
    public static void SizeTest(){
        Daily today=new Daily("Wednesday");
        Activity tmp=new Activity("School",1100,1530);
        today.setTask(tmp);
        today.AddToSchedule(tmp);
        today.Generate(tmp);
        tmp =new Activity("Library",2240,2330);
        today.setTask(tmp);
        if (!today.isConflict(tmp)) {
            today.AddToSchedule(tmp);
            today.Generate(tmp);
        }

        List<Activity> WednesdaySchedule=today.getTodaySchedule();
        if (WednesdaySchedule.size()==2)
            System.out.println("Size Test: PASSED!");
        else
            System.out.println("Size Test: FAILED!");

        today.todaySchedule=new LinkedList<>();
    }
    public static void SearchTest(){
        Daily today=new Daily();
        Activity tmp=new Activity("Go Skating",1545,1700);
        today.setTask(tmp);
        today.AddToSchedule(tmp);
        today.Generate(tmp);
        tmp =new Activity("Haircut",1230,1305);
        today.setTask(tmp);
        if (!today.isConflict(tmp)) {
            today.AddToSchedule(tmp);
            today.Generate(tmp);
        }
        tmp= new Activity("Dinner",1815,1900);
        today.setTask(tmp);
        if (!today.isConflict(tmp)) {
            today.AddToSchedule(tmp);
            today.Generate(tmp);
        }
        tmp= new Activity("Hit the Gym",815,930);
        today.setTask(tmp);
        if (!today.isConflict(tmp)) {
            today.AddToSchedule(tmp);
            today.Generate(tmp);
        }
        tmp= new Activity("Breakfast at Rubio's",945,1005);
        today.setTask(tmp);
        if (!today.isConflict(tmp)) {
            today.AddToSchedule(tmp);
            today.Generate(tmp);
        }
        List<Activity> toDO=new LinkedList<>(today.getTodaySchedule());
        int position=today.binarySearch(0,toDO.size()-1,1545);

        if (toDO.get(position).getType().compareTo("Go Skating")==0)
            System.out.println("Searching Test: BINARY SEARCH PASSED!");
        else System.out.println("Searching Test: BINARY SEARCH FAILED!");
        //today.todaySchedule=new LinkedList<>();
    }
}

