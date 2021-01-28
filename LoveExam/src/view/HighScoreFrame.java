package view;

import util.BaseFrame;

import javax.swing.*;
import java.awt.*;

public class HighScoreFrame extends BaseFrame {
    private int score;
    public HighScoreFrame(){}
    public HighScoreFrame(String title,int score){
        super(title);
        this.score = score;
        this.init();
    }
    private JPanel mainPanel = new JPanel();
    private JLabel scoreLable = new JLabel();
    ImageIcon imageIcon = new ImageIcon("src\\images\\high");
    private JLabel highImageLable = new JLabel(imageIcon);
    ImageIcon hua1Icon = new ImageIcon("src\\images\\highhuaban1");
    private JLabel hua1ImageLable = new JLabel(hua1Icon);
    ImageIcon hua2Icon = new ImageIcon("src\\images\\highhuaban2");
    private JLabel hua2ImageLable = new JLabel(hua2Icon);

    private ScoreActionThread scoreActionThread = new ScoreActionThread();
    private HuaActionThread huaActionThread = new HuaActionThread();

    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);
        highImageLable.setBounds(0,0,1100,760);
        scoreLable.setBounds(500,300,1100,51);
        scoreLable.setFont(new Font("楷体",Font.BOLD,50));
        scoreLable.setForeground(Color.PINK);
        scoreLable.setText("爱死你了!你得了"+score+"分");
        hua1ImageLable.setBounds(0,-760,1100,760);
        hua2ImageLable.setBounds(0,-1520,1100,760);
    }

    protected void addElement() {
        mainPanel.add(hua1ImageLable);
        mainPanel.add(hua2ImageLable);
        mainPanel.add(scoreLable);
        mainPanel.add(highImageLable);
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
        huaActionThread.start();
    }

    private class HuaActionThread extends Thread{
        public void run(){
            int hua1Y = -760;
            int hua2Y = -1520;
            while(true) {
                if(hua1Y >= 760){
                    hua1Y = -760;
                }
                if(hua2Y >= 760){
                    hua2Y = -760;
                }
                hua1ImageLable.setBounds(0, hua1Y, 1100, 760);
                hua2ImageLable.setBounds(0, hua2Y, 1100, 760);
                hua1Y++;
                hua2Y++;
                try{
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private class ScoreActionThread extends Thread{
        public void run(){
            int scoreY = 300;
            int scorechange = -1;
            while(true){
                scoreY += scorechange;
                if(scoreY>=320){
                    scorechange = -1;
                }
                if(scoreY<=260){
                    scorechange = 1;
                }
                scoreLable.setBounds(500,scoreY,1150,51);
                try{
                    Thread.sleep(30);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
