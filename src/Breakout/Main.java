package Breakout;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        GamePlay gamePlay = new GamePlay();
        frame.setBounds(10, 10, 700, 600);
        frame.setTitle("Our Breakout");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePlay);
    }

}
