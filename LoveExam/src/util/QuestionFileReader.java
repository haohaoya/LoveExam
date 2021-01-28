package util;

import domain.Question;

import java.util.HashSet;

public class QuestionFileReader {
    private HashSet<Question> questionBox = new HashSet<Question>();
    public  HashSet<Question> getQuestionBox(){
        return questionBox;
    }

    {
        //读文件
        questionBox.add(new Question(
                "你知道浩浩是谁吗？\n\n\tA.没听说\n\n\tB.听过，但不认识\n\n\tC.不认识\n\n\tD.知道",
                "D"));
        questionBox.add(new Question(
                "你知道浩浩是谁吗？\n\n\tA.知道\n\n\tB.听过，但不认识\n\n\tC.不认识\n\n\tD.没听说",
                "A"));
        questionBox.add(new Question(
                "你知道浩浩是谁吗？\n\n\tA.没听说\n\n\tB.知道\n\n\tC.不认识\n\n\tD.听过，但不认识",
                "B"));
        questionBox.add(new Question(
                "你知道浩浩是谁吗？\n\n\tA.没听说\n\n\tB.听过，但不认识\n\n\tC.知道\n\n\tD.不认识",
                "C"));

        questionBox.add(new Question(
                "浩浩认为什么样的人才是优秀的？\n\n\tA.自律\n\n\tB.努力\n\n\tC.认真\n\n\tD.善良",
                "D"));
        questionBox.add(new Question(
                "浩浩认为什么样的人才是优秀的？\n\n\tA.自律\n\n\tB.努力\n\n\tC.善良\n\n\tD.认真",
                "C"));
        questionBox.add(new Question(
                "浩浩认为什么样的人才是优秀的？\n\n\tA.善良\n\n\tB.自律\n\n\tC.认真\n\n\tD.努力",
                "A"));
        questionBox.add(new Question(
                "浩浩认为什么样的人才是优秀的？\n\n\tA.努力\n\n\tB.善良\n\n\tC.自律\n\n\tD.认真",
                "B"));

        questionBox.add(new Question(
                "编程使人快乐吗？\n\n\tA.快乐\n\n\tB.不快乐\n\n\tC.很快乐\n\n\tD.无感",
                "A"));
        questionBox.add(new Question(
                "编程使人快乐吗？\n\n\tA.不快乐\n\n\tB.无感\n\n\tC.很快乐\n\n\tD.快乐",
                "D"));

        questionBox.add(new Question(
                "编程世界里程序员是什么？\n\n\tA.上帝\n\n\tB.打工仔\n\n\tC.普通人\n\n\tD.无感",
                "A"));
        questionBox.add(new Question(
                "编程世界里程序员是什么？\n\n\tA.普通人\n\n\tB.无感\n\n\tC.打工仔\n\n\tD.上帝",
                "D"));
        questionBox.add(new Question(
                "玩游戏快乐吗？\n\n\tA.快乐\n\n\tB.不快乐\n\n\tC.难受\n\n\tD.无感",
                "A"));
        questionBox.add(new Question(
                "玩游戏快乐吗？\n\n\tA.难受\n\n\tB.无感\n\n\tC.快乐\n\n\tD.不快乐",
                "C"));

    }

}
