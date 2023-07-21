package edu.global.board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardDao {
    Scanner scanner = new Scanner(System.in);
    List<BoardDto> boardDtoList = new ArrayList<>(); // 게시판 내용 저장

    public void getBoardList(){ // 게시판 기능들
        System.out.println("==================================");
        System.out.println("번호      제목      작성자      작성일");
        System.out.println("----------------------------------");
        System.out.print("1.목록  2.등록  3.내용  4.삭제  0.종료 ");
    }

    public void boardCont() { // 1. 목록
        if(boardDtoList.isEmpty()) { // 게시글이 아무것도 없다면
            System.out.println("----------------------------------");
            System.out.println("내용이 없습니다.");
            return;
        }
        for(int i = 0; i < boardDtoList.size(); i++){
            BoardDto boardDto = boardDtoList.get(i);
            int boardNo = i + 1;
            System.out.print(boardNo + ". " + boardDto.getTitle() + "  ");
            System.out.print(boardDto.getWriter() + "  ");
            System.out.println(boardDto.getNowDate());
        }
    }

    public void boardNewCont() { // 2. 등록 - 게시판 글 작성하기
        BoardDto boardDto = new BoardDto();

        System.out.println("----------------------------------");

        System.out.print("제목 : "); // 제목
        String title = scanner.nextLine();

        System.out.print("내용 : "); // 내용
        String text = scanner.nextLine();

        System.out.print("작성자 : "); // 작성자
        String writer = scanner.nextLine();

        boardDto.setNum(boardDtoList.indexOf(boardDto)); // 인텍스를 객체 번호에 저장
        boardDto.setTitle(title); // 제목 저장
        boardDto.setText(text); // 내용 저장
        boardDto.setWriter(writer); // 작성자 저장

        // 자바에서 현재 날짜 가져오기
        SimpleDateFormat txtDate = new SimpleDateFormat("MM-dd',' yyyy ',' HH:mm:ss");
        String nowDate = txtDate.format(new Date());
        boardDto.setNowDate(nowDate);

        boardDtoList.add(boardDto); // List 에 작성된 글 저장
        System.out.println("----------------------------------");
        System.out.println("글이 정상적으로 추가 되었습니다.");
    }

    public void boardContList(int select) { //3. 내용 - 게시판 글 내용 확인하기
        System.out.println("----------------------------------");
        BoardDto boardDto = boardDtoList.get(select - 1);
        System.out.println("글 번호: " + select);
        System.out.println("제목 : " + boardDto.getTitle());
        System.out.println("내용 : " + boardDto.getText());
        System.out.println("작성자 : " + boardDto.getWriter());
        System.out.println("날짜 : " + boardDto.getNowDate());
    }

    public void boardDelete(int select) { // 4. 삭제
        if(boardDtoList.isEmpty()) { // 게시글이 아무것도 없다면
            System.out.println("내용이 없습니다.");
            return;
        }

        BoardDto boardDto = new BoardDto();
        boardDto = boardDtoList.get(select - 1); // 선택한 번호의 객체
        boardDtoList.remove(boardDtoList.indexOf(boardDto)); // 해당 인덱스에 있는 객체 삭제
        System.out.println(select + "번 글이 삭제되었습니다");
    }

}
