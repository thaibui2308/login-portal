import java.util.LinkedList;
import java.util.List;

public class Daily implements Schedule {
    private String day;
    private Activity task=new Activity();
    public static List<Integer> BeginAt = new LinkedList<>();
    public static List<Integer> EndAt= new LinkedList<>();
    public static List<Activity> todaySchedule=new LinkedList<>();


    //Constructor
    public Daily(){
        day=null;
        task=new Activity();
    }
    public Daily(String Day, Activity activ){
        day=Day;
        task=new Activity(activ);
    }
    public Daily(String Day){
        day=Day;
        task=null;
    }

    //getter and setter
    public String getDay() {
        return day;
    }
    public Activity getTask() {
        return task;
    }
    public void setTask(Activity New) {
        task =new Activity(New);
    }
    public List<Activity> getTodaySchedule(){
        return todaySchedule;
    }
    public List<Integer> getEndAt(){
        return EndAt;
    }
    //Check if conflict with any other tasks that already in the schedule
    public boolean isConflict(Activity tmp){
        if (BeginAt.size()==0)
            return false;
        for (int i=0;i<BeginAt.size();i++)
            if (tmp.getStart()==BeginAt.get(i)||tmp.getEnd()==EndAt.get(i))
                return true;
            else if (tmp.getStart()<EndAt.get(i)&&tmp.getStart()>BeginAt.get(i))
                return true;
            else if (tmp.getEnd()>BeginAt.get(i)&&tmp.getEnd()<EndAt.get(i))
                return true;
        return false;
    }
    //add to schedule
    public void AddToSchedule(Activity tmp){
        todaySchedule.add(tmp);
        if (todaySchedule.size()>1)
            InsertionSort(todaySchedule);

    }
    public static void InsertionSort(List<Activity> list) {

        int len = list.size();
        for (int l = 1; l < len; ++l) {
            Activity tmp=list.get(l);
            int key = tmp.getStart();
            int j = l - 1;
            while (j >= 0 && list.get(j).getStart() > key) {
                list.set(j+1,list.get(j));
                j = j - 1;
            }
            list.set(j+1,tmp);
        }
    }
    //This method returns the position of the activity based on its Start time
    public static int binarySearch(int initial, int len, int x) {
        if (len >= initial) {
            int between = initial + (len - initial) / 2;
            if (todaySchedule.get(between).getStart()== x)
                return between;
            else if (todaySchedule.get(between).getStart()> x)
                return binarySearch(initial, between - 1, x);
            else
                return binarySearch(between + 1, len, x);
        }
        return -1;
    }
    /**
     * If a task doesn't conflict with any other tasks in the schedule, add its start and end time to
     * two lists BeginAt and EndAt so the next task can be checked
     */
    public void Generate(Activity tmp){
        //if a task does not conflict with any other task in term of time, add it to the schedule
        if (!isConflict(tmp))
            tmp.add(BeginAt, EndAt);
    }
}
