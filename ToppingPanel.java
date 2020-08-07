import javax.swing.*;
import java.awt.*;

public class ToppingPanel extends JPanel {
    private JCheckBox CreamCheese;
    private JCheckBox butter;
    private JCheckBox PeachJelly;
    private JCheckBox Caramel;
    private final int CreamPrice=5;
    private final int ButterPrice=3;
    private final int PeachPrice=6;
    private final int CaramelPrice=7;

    public ToppingPanel(){
        setBorder(BorderFactory.createTitledBorder("Topping"));
        setLayout(new GridLayout(4,1));
        CreamCheese=new JCheckBox("Cream Cheese");
        butter=new JCheckBox("Butter Foam");
        PeachJelly=new JCheckBox("Peach Jelly");
        Caramel=new JCheckBox("Caramel");
        add(CreamCheese);
        add(butter);
        add(PeachJelly);
        add(Caramel);
    }
    public int ToppingCost(){
        int cost=0;
        if (CreamCheese.isSelected())
            cost+=CreamPrice;
        if (butter.isSelected())
            cost+=ButterPrice;
        if (PeachJelly.isSelected())
            cost+=PeachPrice;
        if (Caramel.isSelected())
            cost+=CaramelPrice;
        return cost;
    }
}
