package service;

import dao.QuestionDao;
import domain.Question;

import java.util.ArrayList;

public class QuestionService {
    private QuestionDao dao = new QuestionDao();

    public ArrayList<Question> getpaper(int count){
        ArrayList<Question> result = dao.getPaper(count);
        int i = 1;
        for(Question q :result){
            String indexTitle = "\n  "+i+"."+q.getTitle();
            q.setTitle(indexTitle);
            i++;
        }
        return result;
    }
}
