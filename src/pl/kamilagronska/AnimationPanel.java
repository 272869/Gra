package pl.kamilagronska;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener {
    private Image image;
    Graphics2D buf;
    Graphics2D buf2;
    private Timer timer;
    private Player player = null;
    private int delay = 70;
    private ML mouseListener;
    private static boolean isRunning = false;

//    public static ArrayList<Point> points = new ArrayList<>();

    public static boolean isIsRunning() {
        return isRunning;
    }

    public AnimationPanel() {
//        super();
        mouseListener = new ML();
        setBackground(Color.pink);
        timer = new Timer(delay,this);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);

    }
    public void initialize(){
        image = createImage(getWidth(),getHeight());
        buf = (Graphics2D) image.getGraphics();
        buf.setBackground(Color.blue);
        buf.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        buf2 = (Graphics2D) getGraphics();
        buf2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
    //jesli starczy czasu zrobić levele
    //i zapisywanie najlepszego rekordu
    public void startGame(){
        timer.start();
        isRunning = true;

        if (player ==null){
            player = new Player(buf,delay,mouseListener);
            timer.addActionListener(player);
            new Thread(player).start();
        }
        addObcastle();
        addPoint();
//        endGame();
    }
    public void pause(){
        if (timer.isRunning()) {
            timer.stop();
            isRunning = false;
        }
    }
    private void addObcastle(){
        Thread loopThread = new Thread(() -> {
            while (isRunning) {
                Item item = new Obcastle(delay, buf, player);
                timer.addActionListener(item);
                new Thread(item).start();

                try {
                    Thread.sleep(1500); // Oczekiwanie 1,5 sekundy
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        loopThread.start();
    }


    private void addPoint(){
        Thread loopThread = new Thread(() -> {
            while (isIsRunning()) {
                Item item = new Point(delay, buf,player);
//                points.add(item);
                timer.addActionListener(item);
                new Thread(item).start();

                try {
                    Thread.sleep(2000); // Oczekiwanie 1,5 sekundy
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        loopThread.start();
    }
    public void endGame() {
        while (isRunning){
            if (Obcastle.isEndGame()) {
                timer.stop();
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buf2.drawImage(image,0,0,null);
        buf.clearRect(0, 0, getWidth(), getHeight());


    }
}
