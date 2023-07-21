package edu.global.board;

import java.util.Scanner;

public class MainBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BoardDao dao = new BoardDao();

        while(true) { // 게시판 작동 되는 while문
            dao.getBoardList(); // 게시판리스트 불러오기
            int answer = Integer.parseInt(scanner.nextLine()); // 입력값 받기
            int select;

            if(answer == 1) { // 1. 목록
                dao.boardCont();
            } else if(answer == 2) { // 2. 등록
                dao.boardNewCont();
            } else if(answer == 3) { // 3. 내용
                System.out.println("----------------------------------");
                dao.boardCont(); // 작성된 글 불러오기
                System.out.println("----------------------------------");
                System.out.print("확인할 글 번호 입력하세요. "); // 내용 확인할 글 번호 입력받기
                select = Integer.parseInt(scanner.nextLine());
                dao.boardContList(select); // 입력된 글 내용 확인하기
            } else if(answer == 4) { // 4. 삭제
                System.out.println("----------------------------------");
                dao.boardCont(); // 작성된 글 불러오기
                System.out.println("----------------------------------");
                System.out.print("삭제할 글 번호 입력하세요. "); // 삭제할 글 번호 입력받기
                select = Integer.parseInt(scanner.nextLine());
                dao.boardDelete(select); // 입력된 글 삭제하기
            } else if(answer == 0) { // 종료하기
                break; // break로 while문 빠저나가기
            } else { // 다른 값 입력시 출력
                System.out.println("잘못 입력하셨습니다.");
            }
        }
        System.out.println("----------------------------------");
        System.out.println("게시판을 종료합니다.");
    }
}

