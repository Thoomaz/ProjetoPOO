import javax.swing.*;
import java.awt.*;

public class LittleBoxd extends GenericWindow{
    private JButton mvsBtn;
    private JButton laterBtn;
    private JLabel titleLabel;
    private JPanel painel;
    public LittleBoxd() {
        super("LittleBoxd", 500,250);

        //Título
        titleLabel = new JLabel("LittleBoxd", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));


        //Botões
        mvsBtn = new JButton("Filmes");
        laterBtn = new JButton("Ver mais tarde");

        //Frame
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.ipadx = 20;
        c.ipady = 20;
        c.gridy = 0;
        frame.add(titleLabel, c);

        frame.add(Box.createRigidArea(new Dimension(0, 60)));

        c.ipadx = 200;
        c.gridx = 0;
        c.gridy = 1;
        frame.add(mvsBtn, c);

        c.ipadx = 200;
        c.gridx = 0;
        c.gridy = 2;
        frame.add(laterBtn, c);
    }
}

