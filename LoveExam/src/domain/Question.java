package domain;

public class Question {
    private String title;
    private String answer;

    public Question(){}
    public Question(String title,String answer){
        this.title = title;
        this.answer = answer;
    }

    public int hashCode() {
        String thisTitle = this.title.substring(0,this.title.indexOf("？"));
        return thisTitle.hashCode();
    }

    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof Question){
            Question anQuestion = (Question)obj;
            String thisTitle = this.title.substring(0,this.title.indexOf("？"));
            String anotherTitle = anQuestion.title.substring(0,anQuestion.title.indexOf("？"));
            if(thisTitle.equals(anotherTitle)){
                return true;
            }
        }
        return false;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getTitle() {
        return title;
    }
    public String getAnswer() {
        return answer;
    }
}
