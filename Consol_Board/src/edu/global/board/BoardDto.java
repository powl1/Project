package edu.global.board;

public class BoardDto { // 게시판 객체 저장 Getter/Setter 이용
    private int num;
    private String title;
    private String text;
    private String writer;
    private String nowDate;

    public int getNum() { return num; }

    public void setNum(int num) { this.num = num; }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getNowDate() {
        return nowDate;
    }

    public void setNowDate(String nowDate) {
        this.nowDate = nowDate;
    }
}