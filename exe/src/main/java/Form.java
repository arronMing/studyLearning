import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form {



    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel16;
    private JPanel panel17;
    private JPanel panel18;
    private JPanel panel19;
    private JPanel panel110;
    private JPanel panel11;
    private JPanel panel12;
    private JPanel panel13;
    private JPanel panel14;

    private JFrame jFrame;

    public  void init (){

        jFrame = new JFrame();
        jFrame.setSize(600,600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));


        GridBagLayout panel2Grid = new GridBagLayout();
        panel2 = new JPanel(panel2Grid);


        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0; // 0行0列
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.weighty = 0;
        button1 = new JButton("button1");
        panel2.add(button1, c);


        c.gridx = 0; // 0行0列
        c.gridy = 1;
        button2 = new JButton("button2");
        panel2.add(button2,c);


        CardLayout panel3Card = new CardLayout();
        panel3 = new JPanel(panel3Card);

        GridBagLayout panel4Grid = new GridBagLayout();
        panel4 = new JPanel(panel4Grid);

        GridBagConstraints cpanel4Grid = new GridBagConstraints();

        cpanel4Grid.gridx = 0; // 0行0列
        cpanel4Grid.gridy = 0;
        cpanel4Grid.gridwidth = 1;
        cpanel4Grid.gridheight = 1;
        cpanel4Grid.fill = GridBagConstraints.HORIZONTAL;
        cpanel4Grid.weightx = 0;
        cpanel4Grid.weighty = 0;

        panel16 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel16.add(new Label("名称"));
        JComboBox<String> panel16Jcombobox = new JComboBox<>();
        panel16Jcombobox.setMaximumRowCount(20);
        panel16Jcombobox.setPreferredSize(new Dimension(200,25));
        panel16Jcombobox.addItem("aifafaga");
        panel16Jcombobox.addItem("aifafaga22222");
        panel16.add(panel16Jcombobox);

        panel4.add(panel16,cpanel4Grid);



        panel17 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel17.add(new Label("性别"));
        JComboBox<String> panel17Jcombobox = new JComboBox<>();
        panel17Jcombobox.setPreferredSize(new Dimension(200,25));
        panel17Jcombobox.setMaximumRowCount(200);
        panel17Jcombobox.addItem("aiaiaiai");
        panel17Jcombobox.addItem("22222");
        panel17.add(panel17Jcombobox);

        cpanel4Grid.gridx = 0; // 0行0列
        cpanel4Grid.gridy = 1;
        panel4.add(panel17,cpanel4Grid);




        panel5 = new JPanel(new GridBagLayout());
        panel13 = new JPanel(new FlowLayout());
        panel13.add(new Label("xxxxxx"));
        JComboBox<String> panel13Jcombobox = new JComboBox<>();
        panel13Jcombobox.setMaximumRowCount(20);
        panel13Jcombobox.addItem("111111");
        panel13Jcombobox.addItem("222222");
        panel13.add(panel13Jcombobox);



        panel5.add(panel13);




        panel3.add(panel4,"card4");
        panel3.add(panel5,"card5");
        panel1.add(panel2);
        panel1.add(panel3);
        jFrame.add(panel1);


        setListener();

        jFrame.setVisible(true);








    }

    public void setListener() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("aaa");
            CardLayout cardLayout = (CardLayout)(panel3.getLayout());
            cardLayout.show(panel3, "card4");
            }
        });

        button2.addActionListener(e -> {
            System.out.println("bbbb");
            CardLayout cardLayout = (CardLayout)(panel3.getLayout());
            cardLayout.show(panel3, "card5");
        });


    }


    public static void main(String args []){

        Form form = new Form();
        form.init();





    }








}
