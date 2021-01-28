package dao;

import domain.Question;
import util.QuestionFileReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class QuestionDao {
    private QuestionFileReader reader = new QuestionFileReader();
    private ArrayList<Question> questionbank = new ArrayList<>(reader.getQuestionBox());

    public ArrayList<Question> getPaper(int count){
        HashSet<Question> paper = new HashSet<>();
        while(paper.size()!=count){
            Random r = new Random();
            int index = r.nextInt(questionbank.size());
            paper.add(this.questionbank.get(index));
            System.out.println(paper);
        }
        return new ArrayList<Question>(paper);
    }
}
