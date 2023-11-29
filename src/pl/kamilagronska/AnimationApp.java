package pl.kamilagronska;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationApp extends JFrame{
    private JPanel contentPane;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               /* try {

                }catch () {
                }*/
                AnimationApp app = new AnimationApp();
                app.setVisible(true);
            }
        });


    }

    public AnimationApp() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screen.width-600)/2, (screen.height-600)/2, 600, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        //drugi panel kanwa

        JButton playButton = new JButton("Graj");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        playButton.setBounds(10,530,80,23);
        contentPane.add(playButton);



    }
}