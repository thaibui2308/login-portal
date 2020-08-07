import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class BreakfastPanel extends JPanel {
    private ButtonGroup BreakFastGroup;
    private JRadioButton FirstOption;
    private JRadioButton SecondOption;
    private final int FirstPrice=15;
    private final int SecondPrice=12;

    public BreakfastPanel(){
        setLayout(new GridLayout(2,1));
        setBorder(BorderFactory.createTitledBorder("Món Ăn Sáng"));
        BreakFastGroup=new ButtonGroup();
        FirstOption=new JRadioButton("Bánh Mì");
        SecondOption=new JRadioButton("Xôi Mặn");
        BreakFastGroup.add(FirstOption);
        BreakFastGroup.add(SecondOption);
        add(FirstOption);
        add(SecondOption);
    }
    public int calculateCost(){
        int BreakfastCost=0;
        if (FirstOption.isSelected())
            BreakfastCost=FirstPrice;
        else if(SecondOption.isSelected())
            BreakfastCost=SecondPrice;
        return BreakfastCost;
    }
}
