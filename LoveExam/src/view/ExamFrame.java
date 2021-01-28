package view;

import domain.Question;
import service.QuestionService;
import util.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ExamFrame extends BaseFrame {
    private QuestionService service = new QuestionService();
    private ArrayList<Question> paper = service.getpaper(5);
    private String[] answers = new String[paper.size()];
    private int nowNum = 1;
    private int totalCount = paper.size();
    private int answerCount = 0;
    private int unanswerCount = totalCount;

    public ExamFrame(){}
    public ExamFrame(String title){
        super(title);
        this.init();
    }
    //三个panel
    private JPanel mainPanel = new JPanel();
    private JPanel messagePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    //主组件
    private JTextArea examArea = new JTextArea();
    private JLabel areaPictureLable = new JLabel();
    //右侧组件
    private JLabel pictureLable = new JLabel();
    private JLabel nowNumLable = new JLabel("当前题号：");
    private JLabel totalCountLable = new JLabel("题目总数：");
    private JLabel answerLable = new JLabel("已答题数：");
    private JLabel unanswerLable = new JLabel("未答题数：");
    private JTextField nowNumField = new JTextField();
    private JTextField totalCountField = new JTextField();
    private JTextField answerField = new JTextField();
    private JTextField unanswerField = new JTextField();
    private JLabel timeLebel = new JLabel("剩余答题时间");
    private JLabel realTime = new JLabel("00:00:00");

    private TimeControlThread timeControlThread = new TimeControlThread();

    //下方组件
    private JButton aButton = new JButton("A");
    private JButton bButton = new JButton("B");
    private JButton cButton = new JButton("C");
    private JButton dButton = new JButton("D");
    private JButton prevButton = new JButton("上一题");
    private JButton nextButton = new JButton("下一题");
    private JButton submitButton = new JButton("提交试卷");

    protected void setFontAndSoOn() {
        //清空panel布局
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.PINK);
        //设置message区域位置
        messagePanel.setLayout(null);
        messagePanel.setBounds(680,10,300,600);
        messagePanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        //设置button区域位置
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(16,470,650,140);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        //设置每个组件的位置 字体 背景 颜色
        examArea.setBounds(16,10,650,450);
        examArea.setFont(new Font("楷体",Font.BOLD,30));
        examArea.setEnabled(false);
        examArea.setOpaque(false);
        examArea.setDisabledTextColor(Color.PINK);
        ImageIcon areaImageIcon = new ImageIcon("src\\images\\area");
        areaPictureLable.setIcon(areaImageIcon);   //展示图片信息
        areaPictureLable.setBounds(16,10,650,450);

        //设置message区域中每个组件
        pictureLable.setBounds(10,10,280,230);
        pictureLable.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        ImageIcon imageIcon = new ImageIcon("src\\images\\exam");
        pictureLable.setIcon(imageIcon);   //展示图片信息
        //当前题号
        nowNumLable.setBounds(40,270,100,30);   //左边字
        nowNumLable.setFont(new Font("楷体",Font.PLAIN,20));
        nowNumField.setBounds(150,270,100,30);  //右边框
        nowNumField.setFont(new Font("黑体",Font.BOLD,20));
        nowNumField.setBorder(BorderFactory.createLineBorder((Color.ORANGE)));
        nowNumField.setEnabled(false);
        nowNumField.setHorizontalAlignment(JTextField.CENTER);
        nowNumField.setDisabledTextColor(Color.BLACK);
        //题目总数
        totalCountLable.setBounds(40,310,100,30);   //左边字
        totalCountLable.setFont(new Font("楷体",Font.PLAIN,20));
        totalCountField.setBounds(150,310,100,30);  //右边框
        totalCountField.setFont(new Font("黑体",Font.BOLD,20));
        totalCountField.setBorder(BorderFactory.createLineBorder((Color.ORANGE)));
        totalCountField.setEnabled(false);
        totalCountField.setHorizontalAlignment(JTextField.CENTER);
        totalCountField.setDisabledTextColor(Color.BLACK);
        //已答题数
        answerLable.setBounds(40,350,100,30);   //左边字
        answerLable.setFont(new Font("楷体",Font.PLAIN,20));
        answerField.setBounds(150,350,100,30);  //右边框
        answerField.setFont(new Font("黑体",Font.BOLD,20));
        answerField.setBorder(BorderFactory.createLineBorder((Color.ORANGE)));
        answerField.setEnabled(false);
        answerField.setHorizontalAlignment(JTextField.CENTER);
        answerField.setDisabledTextColor(Color.BLACK);
        //未答题数
        unanswerLable.setBounds(40,390,100,30);   //左边字
        unanswerLable.setFont(new Font("楷体",Font.PLAIN,20));
        unanswerField.setBounds(150,390,100,30);  //右边框
        unanswerField.setFont(new Font("黑体",Font.BOLD,20));
        unanswerField.setBorder(BorderFactory.createLineBorder((Color.ORANGE)));
        unanswerField.setEnabled(false);
        unanswerField.setHorizontalAlignment(JTextField.CENTER);
        unanswerField.setDisabledTextColor(Color.BLACK);
        //时间提示
        timeLebel.setBounds(85,460,150,40);
        timeLebel.setFont(new Font("楷体",Font.PLAIN,25));
        timeLebel.setForeground(Color.GREEN);
        realTime.setBounds(103,500,150,40);
        realTime.setFont(new Font("楷体",Font.BOLD,25));
        realTime.setForeground(Color.GREEN);

        //设置button区域
        aButton.setBounds(40,20,120,35);
        bButton.setBounds(190,20,120,35);
        cButton.setBounds(340,20,120,35);
        dButton.setBounds(490,20,120,35);
        prevButton.setBounds(40,80,100,36);
        prevButton.setEnabled(false);
        nextButton.setBounds(510,80,100,36);
        submitButton.setBounds(256,78,140,40);
        submitButton.setForeground(Color.BLUE);
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //重新设置右侧message中的组件值 用变量控制
        nowNumField.setText(nowNum+"");
        totalCountField.setText(totalCount+"");
        answerField.setText(answerCount+"");
        unanswerField.setText(unanswerCount+"");

        this.showQuestion();
    }

    private void showQuestion(){
        Question question = paper.get(nowNum-1);
        examArea.setText(question.getTitle());
    }

    protected void addElement() {
        messagePanel.add(pictureLable);
        messagePanel.add(nowNumLable);
        messagePanel.add(nowNumField);
        messagePanel.add(totalCountLable);
        messagePanel.add(totalCountField);
        messagePanel.add(answerLable);
        messagePanel.add(answerField);
        messagePanel.add(unanswerLable);
        messagePanel.add(unanswerField);
        messagePanel.add(timeLebel);
        messagePanel.add(realTime);
        buttonPanel.add(aButton);
        buttonPanel.add(bButton);
        buttonPanel.add(cButton);
        buttonPanel.add(dButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(submitButton);
        mainPanel.add(examArea);
        mainPanel.add(messagePanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(areaPictureLable);
        this.add(mainPanel);
    }

    private void clearOptionButtonColor(){
        aButton.setBackground(null);
        bButton.setBackground(null);
        cButton.setBackground(null);
        dButton.setBackground(null);
    }
    protected void addListener() {
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = JOptionPane.showConfirmDialog(ExamFrame.this,"是否确认提交试卷?");
                if(value==0) {
                    int score = 100;
                    int size = paper.size();
                    for (int i = 0; i < size; i++) {
                        Question question = paper.get(i);
                        String realAnswer = question.getAnswer();
                        if (!realAnswer.equals(answers[i])) {
                            score -= (100 / size);
                        }
                    }
                    ExamFrame.this.setVisible(false);
                    if (score == 100 || score == 80) {
                        new HighScoreFrame("你的分数是"+score+"分",score);
                    } else if (score == 60 || score == 40) {
                        new MiddleScoreFrame("你的分数是"+score+"分",score);
                    } else {
                        new LowScoreFrame("你的分数是"+score+"分",score);
                    }
                }
            }
        });

        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //清空之前的按钮颜色
                ExamFrame.this.clearOptionButtonColor();
                nowNum--;
                if(nowNum==4){
                    nextButton.setEnabled(true);
                }else if(nowNum==1){
                    prevButton.setEnabled(false);
                }
                nowNumField.setText(nowNum+"");
                ExamFrame.this.showQuestion();
                if(answers[nowNum-1]!=null){
                    switch(answers[nowNum-1]){
                        case "A":
                            aButton.setBackground(Color.PINK);break;
                        case "B":
                            bButton.setBackground(Color.PINK);break;
                        case "C":
                            cButton.setBackground(Color.PINK);break;
                        case "D":
                            dButton.setBackground(Color.PINK);break;
                    }
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //清空之前的按钮颜色
                ExamFrame.this.clearOptionButtonColor();
                nowNum++;
                if(nowNum==2){
                    prevButton.setEnabled(true);
                }else if(nowNum==totalCount){
                    nextButton.setEnabled(false);
                }
                nowNumField.setText(nowNum+"");
                ExamFrame.this.showQuestion();
                if(answers[nowNum-1]!=null){
                    switch(answers[nowNum-1]){
                        case "A":
                            aButton.setBackground(Color.PINK);break;
                        case "B":
                            bButton.setBackground(Color.PINK);break;
                        case "C":
                            cButton.setBackground(Color.PINK);break;
                        case "D":
                            dButton.setBackground(Color.PINK);break;
                    }
                }
            }
        });

        //创建监听器对象 用于四个选项按钮
        ActionListener optionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                //清空前面的颜色
                ExamFrame.this.clearOptionButtonColor();
                //设置选中的按钮颜色
                button.setBackground(Color.PINK);
                //将当前选中的选项存储在answers数组中
                answers[nowNum-1] = button.getText();
                int un = 0;
                for(String an:answers){
                    if(an==null){
                        un++;
                    }
                }
                unanswerCount = un;
                answerCount = totalCount-un;
                answerField.setText(answerCount+"");
                unanswerField.setText(unanswerCount+"");
            }
        };
        //绑定在四个选项按钮身上
        aButton.addActionListener(optionListener);
        bButton.addActionListener(optionListener);
        cButton.addActionListener(optionListener);
        dButton.addActionListener(optionListener);
    }

    protected void setFrameSelf() {
        //设置窗口位置和大小
        this.setBounds(430,160,1000,660);
        //设置点击关闭退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体大小不可拖拽
        this.setResizable(false);
        //设置窗体显示状态
        this.setVisible(true);
        timeControlThread.start();
    }

    private class TimeControlThread extends Thread{
        public void run(){
            int minute = 1;
            int second = 0;
            while(true){
                StringBuilder timeString = new StringBuilder("00:0");
                timeString.append(minute);
                timeString.append(":");
                if(second>=0&&second<=9){
                    timeString.append("0");
                }
                timeString.append(second);
                realTime.setText(timeString.toString());
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                if(second>0){
                    second--;
                }else{
                    if(minute>0){
                        minute--;
                        second = 59;
                    }else{
                        realTime.setForeground(Color.RED);
                        aButton.setEnabled(false);
                        bButton.setEnabled(false);
                        cButton.setEnabled(false);
                        dButton.setEnabled(false);
                        prevButton.setEnabled(false);
                        nextButton.setEnabled(false);
                        break;
                    }
                }
            }
        }
    }
}
