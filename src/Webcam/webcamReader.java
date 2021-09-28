package Webcam;

import Player.Player;
import Poker.Game;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


public class webcamReader extends JFrame implements Runnable, ThreadFactory
{

    private int num;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private String last;
    private WebcamPanel panel = null;
    private Game game;

    public Game getGame() {
        return game;
    }

    public webcamReader(ArrayList<Player> players , int num){
        super();
        this.num = num;
        last = "";
        game = new Game(players,25,50);


        setLayout(new FlowLayout());
        setTitle("Webcam Reader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width,screenSize.height);


        Dimension dim = new Dimension(640,480);
        webcam = Webcam.getWebcams().get(num);
        webcam.setViewSize(dim);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(screenSize);
        panel.setFPSDisplayed(true);

        add(panel);
        pack();
        setVisible(true);
        executor.execute(this);

    }

    @Override
    public void run() {
        while (true){
            getCard();
        }

    }


    public void getCard(){

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Error with thread sleep");
        }
        Result result = null;
        BufferedImage image = null;

        if (webcam.isOpen()){
           image = webcam.getImage();
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                System.out.println("Error with result");
            }


            if (result != null && !last.equals(result.getText())){
                last = result.getText();
                System.out.println("card: " + last);
            }
        }

    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,"thread");
        t.setDaemon(true);
        return t;
    }
}

