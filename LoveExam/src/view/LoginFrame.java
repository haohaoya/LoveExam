package view;

import service.UserService;
import util.BaseFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFrame extends BaseFrame {
    //创建一个面板
    private JPanel mainPanel = new JPanel();

    private ImageIcon imageIcon = new ImageIcon("src/images/bg.jpg");
    private JLabel background = new JLabel(imageIcon);

    //创建title显示标题
    private JLabel titleLabel = new JLabel("浩 浩 的 测 试 系 统");
    //创建账号和密码的标题
    private JLabel accountLable = new JLabel("账 号:");
    private JLabel passwordLable = new JLabel("密 码:");
    //创建账号和密码的文本框和密码框
    private JTextField accountField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    //创建俩个按钮
    private JButton loginButton = new JButton("登 录");
    private JButton exitButton = new JButton("退 出");

    public LoginFrame(){}
    public LoginFrame(String title){
        super(title);
        this.init();
    }

    protected void setFontAndSoOn() {
        //设置布局管理方式
        mainPanel.setLayout(null);
        //设置背景图片位置和大小
        background.setBounds(0, 0, 646,420);
        //设置标题组件的位置和大小
        titleLabel.setBounds(110,40,420,40);
        titleLabel.setFont(new Font("楷体",Font.BOLD,39));
        titleLabel.setForeground(Color.PINK);
        //设置账号label位置和字体大小
        accountLable.setBounds(160,130,100,30);
        accountLable.setFont(new Font("宋体",Font.BOLD,27));
        accountLable.setForeground(Color.white);
        //设置账号field位置和字体大小
        accountField.setBounds(260,130,200,30);
        accountField.setFont(new Font("黑体",Font.BOLD,27));

        //设置密码label位置和字体大小
        passwordLable.setBounds(160,200,100,30);
        passwordLable.setFont(new Font("宋体",Font.BOLD,27));
        passwordLable.setForeground(Color.white);
        //设置密码field位置和字体大小
        passwordField.setBounds(260,200,200,30);
        passwordField.setFont(new Font("宋体",Font.BOLD,27));
        //设置按钮 位置和字体大小
        loginButton.setBounds(180,280,110,35);
        loginButton.setFont(new Font("黑体",Font.BOLD,22));
        exitButton.setBounds(370,280,110,35);
        exitButton.setFont(new Font("黑体",Font.BOLD,22));
    }

    protected void addElement() {
        mainPanel.add(titleLabel);
        mainPanel.add(accountLable);
        mainPanel.add(accountField);
        mainPanel.add(passwordLable);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(exitButton);
        //添加背景
        mainPanel.add(background);
        this.add(mainPanel);
    }

    protected void addListener() {
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText();
                String password = new String(passwordField.getPassword());
                UserService service = new UserService();
                String result = service.login(account,password);
                if(result.equals("登录成功")){
                    //弹出考试页面
                    LoginFrame.this.setVisible(false);
                    new ExamFrame("考试中...");
                }else{
                    //弹出警告框
                    JOptionPane.showMessageDialog(LoginFrame.this,result);
                    //清空密码框
                    passwordField.setText("");
                }
            }
        };
        exitButton.addActionListener(actionListener);
        loginButton.addActionListener(listener);

    }

    protected void setFrameSelf() {
        //设置窗口位置和大小
        this.setBounds(600,280,646,420);
        //设置点击关闭退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体大小不可拖拽
        this.setResizable(false);
        //设置窗体显示状态
        this.setVisible(true);
    }
}
