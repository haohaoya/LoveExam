package view;

import util.BaseFrame;

import javax.swing.*;
import java.awt.*;

public class MiddleScoreFrame extends BaseFrame {
    private int score;
    public MiddleScoreFrame(){}
    public MiddleScoreFrame(String title,int score){
        super(title);
        this.score = score;
        this.init();
    }
    private JPanel mainPanel = new JPanel();
    private JLabel scoreLable = new JLabel();
    ImageIcon imageIcon = new ImageIcon("src\\images\\middle");
    private JLabel middleImageLable = new JLabel(imageIcon);
    ImageIcon xinIcon = new ImageIcon("src\\images\\xin");
    private JLabel xinImageLable = new JLabel(xinIcon);

    private ScoreActionThread scoreActionThread = new ScoreActionThread();
    private XinActionThread xinActionThread = new XinActionThread();
    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);
        middleImageLable.setBounds(0,0,1100,760);
        scoreLable.setBounds(560,180,1100,51);
        scoreLable.setFont(new Font("楷体",Font.BOLD,50));
        scoreLable.setForeground(Color.GRAY);
        scoreLable.setText("爱你呀，你得了"+score+"分");
        xinImageLable.setBounds(-1100,-760,1100,760);
    }

    protected void addElement() {
        mainPanel.add(xinImageLable);
        mainPanel.add(scoreLable);
        mainPanel.add(middleImageLable);
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
        xinActionThread.start();
    }

    private class XinActionThread extends Thread{
        public void run(){
                int xinX = -760;
                int xinY = -760;
                while(true) {
                    if(xinX>=790){
                        xinX = -760;
                        xinY = -760;
                    }
                    xinImageLable.setBounds(xinX,xinY,1100,760);
                    if(xinX<20) {
                        xinX++;
                        xinY++;
                    }else{
                        xinX++;
                        xinY--;
                    }
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    private class ScoreActionThread extends Thread{
        public void run(){
            int scoreY = 180;
            int scorechange = -1;
            while(true){
                scoreY += scorechange;
                if(scoreY>=210){
                    scorechange = -1;
                }
                if(scoreY<=170){
                    scorechange = 1;
                }
                scoreLable.setBounds(560,scoreY,1150,51);
                try{
                    Thread.sleep(30);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
