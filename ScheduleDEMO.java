import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ScheduleDEMO {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String name, day;
        int start;
        int end;
        List<Activity> ToDO=new LinkedList<>();
        String Continue = "Y";
        System.out.println("Today is: ");
        day = scnr.nextLine();
        Daily today = new Daily(day);
        int count=0;
        while (Continue.compareTo("Y") == 0||Continue.compareTo("Yes") == 0||Continue.compareTo("y") == 0) {
            count+=1;
            scnr.nextLine();
            System.out.println("Activity");
            name = scnr.nextLine();
            System.out.println("Start time: ");
            start = scnr.nextInt();
            if (start%100>60||start/100>24){
                System.out.println("Start Time is invalid!");
                continue;
            }
            System.out.println("End time: ");
            end = scnr.nextInt();
            if (end%100>60||end/100>24||end<start){
                System.out.println("End Time is invalid!");
                continue;
            }
            Activity activity = new Activity(name, start, end);
            today.setTask(activity);
            if (!today.isConflict(activity)) {
                today.AddToSchedule(activity);
                today.Generate(activity);
                System.out.println("Continue?");
                Continue = scnr.next();
            }
            else {
                System.out.println("Time conflict! You still want to continue?");
                System.out.println("Continue?");
                Continue = scnr.next();
            }
        }
        ToDO=today.getTodaySchedule();
        showSchedule(ToDO);
    }
    public static void showSchedule(List<Activity> list){
        Display show;
        for (Activity action: list){
            show= new Display(action);
            show.displayGap();
            show.printActivity();
            show.displayTime();
        }
    }
}
