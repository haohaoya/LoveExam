package view;

import util.BaseFrame;

import javax.swing.*;
import java.awt.*;

public class LowScoreFrame extends BaseFrame {
    private int score;
    public LowScoreFrame(){}
    public LowScoreFrame(String title,int score){
        super(title);
        this.score = score;
        this.init();
    }
    private JPanel mainPanel = new JPanel();
    private JLabel scoreLable = new JLabel();
    ImageIcon low1Icon = new ImageIcon("src\\images\\low1");
    private JLabel low1ImageLable = new JLabel(low1Icon);
    ImageIcon low2Icon = new ImageIcon("src\\images\\low2");
    private JLabel low2ImageLable = new JLabel(low2Icon);
    ImageIcon low3Icon = new ImageIcon("src\\images\\low3");
    private JLabel low3ImageLable = new JLabel(low3Icon);

    private ScoreActionThread scoreActionThread = new ScoreActionThread();
    private LowActionThread lowActionThread = new LowActionThread();
    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);
        low1ImageLable.setBounds(0,0,1100,760);
        low2ImageLable.setBounds(0,0,1100,760);
        low3ImageLable.setBounds(0,0,1100,760);

        scoreLable.setBounds(250,300,1100,51);
        scoreLable.setFont(new Font("楷体",Font.BOLD,40));
        scoreLable.setForeground(Color.black);
        scoreLable.setText("你不爱我了!(小声bb)你得了"+score+"分");
        low2ImageLable.setVisible(false);
        low3ImageLable.setVisible(false);
    }

    protected void addElement() {
        mainPanel.add(scoreLable);
        mainPanel.add(low1ImageLable);
        mainPanel.add(low2ImageLable);
        mainPanel.add(low3ImageLable);
        this.add(mainPanel);
    }

    protected void addListener() {

    }

    protected void setFrameSelf() {
        //设置窗口位置和大小
        this.setBounds(380,110,1100,790);
        //设置点击关闭退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体大小不可拖拽
        this.setResizable(false);
        //设置窗体显示状态
        this.setVisible(true);
        scoreActionThread.start();
        lowActionThread.start();
    }

    private class LowActionThread extends Thread{
        public void run(){
            int state = 1;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(true) {
                if (state == 1) {
                    low2ImageLable.setVisible(true);
                    low1ImageLable.setVisible(false);
                    state = 2;
                }else if(state == 2){
                    low3ImageLable.setVisible(true);
                    low2ImageLable.setVisible(false);
                    state = 3;
                }else{
                    low1ImageLable.setVisible(true);
                    low3ImageLable.setVisible(false);
                    state = 1;
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class ScoreActionThread extends Thread{
        public void run(){
            int scoreY = 3;
            while(true){
                if(scoreY==3){
                    scoreY = 700;
                }else{
                    scoreY = 3;
                }
                scoreLable.setBounds(250,scoreY,1150,51);
                try{
                    Thread.sleep(80);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
