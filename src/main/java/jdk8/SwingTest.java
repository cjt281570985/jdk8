package jdk8;

import javax.swing.*;

/**
 * Created by Administrator on 2016/12/20.
 */
public class SwingTest {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("我的窗体");
        JButton jButton = new JButton("我的按钮");
        jButton.addActionListener(abc -> {
            System.out.println(99999);
        });

        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
