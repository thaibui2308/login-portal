import javax.swing.*;
import java.awt.*;

public class CoffeePanel extends JPanel {
    private JRadioButton None;
    private JRadioButton Regular;
    private JRadioButton Decaf;
    private JRadioButton Cappuccino;
    private ButtonGroup CafeGroup;
    private final int NonePrice=0;
    private final int RegularPrice=16;
    private final int DecafPrice=14;
    private final int CappuccinoPrice=17;

    public CoffeePanel(){
        setLayout(new GridLayout(4,1));
        None=new JRadioButton("Không");
        Regular=new JRadioButton("Cà Phê Đen");
        Decaf=new JRadioButton("Decaf");
        Cappuccino=new JRadioButton("Cappuccino");
        CafeGroup=new ButtonGroup();
        CafeGroup.add(None);
        CafeGroup.add(Regular);
        CafeGroup.add(Decaf);
        CafeGroup.add(Cappuccino);
        setBorder(BorderFactory.createTitledBorder("Cà Phê"));
        add(None);
        add(Regular);
        add(Decaf);
        add(Cappuccino);
    }
    public int CoffeeCost(){
        int cost=0;
        if (None.isSelected())
            cost+=NonePrice;
        else if (Regular.isSelected())
            cost+=RegularPrice;
        else if (Decaf.isSelected())
            cost+=DecafPrice;
        else if (Cappuccino.isSelected())
            cost+=CappuccinoPrice;
        return cost;
    }
}
