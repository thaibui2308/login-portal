import java.util.LinkedList;
import java.util.List;

public abstract class AbstractActivity {
    protected String type;
    protected int start;
    protected int end;

    //Constructor
    public AbstractActivity(){
        type=null;
        start=0;
        end=0;
    }
    public AbstractActivity(String type, int start,int end){
        this.type=type;
        this.start=start;
        this.end=end;
    }


    //Getter and Setter method
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }

    //Abstract Methods
    
    public abstract String HowLong();
}
