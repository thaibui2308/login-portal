import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderCalculator extends JFrame {
    private JPanel Order;
    private JPanel Operation;
    private JButton Calculate;
    private JButton Exit;
    private GreetingPanel welcome;
    private BreakfastPanel breakfast;
    private ToppingPanel topping;
    private CoffeePanel Coffee;
    private final int WIDTH=400;
    private final int HEIGHT=230;
    public OrderCalculator(){
        setTitle("Order Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //
        welcome=new GreetingPanel() ;
        breakfast=new BreakfastPanel();
        topping=new ToppingPanel();
        Coffee=new CoffeePanel();
        //
        buildPanel();
        add(welcome,BorderLayout.NORTH);
        add(breakfast,BorderLayout.WEST);
        add(topping,BorderLayout.CENTER);
        add(Coffee,BorderLayout.EAST);
        add(Operation,BorderLayout.SOUTH);

        pack();
        setVisible(true);

    }
    public void buildPanel(){

        Operation=new JPanel();
        Operation.setLayout(new FlowLayout(FlowLayout.CENTER));
        Calculate=new JButton("Tổng Cộng");
        Calculate.addActionListener(new OperationListener());
        Exit=new JButton("Hủy");
        Exit.addActionListener(new OperationListener());
        Operation.add(Calculate);
        Operation.add(Exit);

    }
    private class OperationListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==Calculate){
                int total;
                total=breakfast.calculateCost()+topping.ToppingCost()+Coffee.CoffeeCost();
                JOptionPane.showMessageDialog(null,"Tổng Cộng: "+total+" nghìn!"+
                        "\nCảm ơn quý khách!");
            }
            else if (e.getSource()==Exit){
                System.exit(0);
            }
        }
    }
    public static void main(String[] args){
        new OrderCalculator();
    }
}
