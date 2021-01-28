package service;

public class UserService {
    private String acount = "1";
    private String passward = "1";

    public String login(String acount,String passward){
        if(this.acount.equals(acount)){
            if(this.passward.equals(passward)){
                return "登录成功";
            }else{
                return "密码错误";
            }
        }else{
            return "无此账号";
        }

    }
}
