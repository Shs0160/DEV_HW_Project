package board.post;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        while(true) {
            System.out.print("명령어 > ");
            String input = scanner.nextLine().trim();

            if(input.equals("종료")) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            }else if(input.equals("작성")){
                System.out.println("제목을 작성해 주세요!");
                System.out.print("제목: ");
                String title = scanner.nextLine().trim();
                System.out.println("내용을 작성해 주세요!");
                System.out.print("내용: ");
                String content = scanner.nextLine().trim();
                board.writePost(title, content);
            }else if(input.equals("조회")){
                System.out.print("어떤 게시물을 조회할까요?");
                int postId = scanner.nextInt();
                scanner.nextLine();
                board.readPost(postId);
            }else if(input.equals("삭제")){
                System.out.print("어떤 게시물을 삭제할까요?");
                int postId = scanner.nextInt();
                scanner.nextLine();
                board.deletePost(postId);
            }else if(input.equals("수정")){
                System.out.print("어떤 게시물을 수정할까요?");
                int postId = scanner.nextInt();
                scanner.nextLine();

                System.out.println(postId + "번 게시물을 수정합니다.");
                System.out.println("제목을 작성해 주세요!");
                System.out.print("제목: ");
                String title = scanner.nextLine().trim();

                System.out.println("내용을 작성해 주세요!");
                System.out.print("내용: ");
                String content = scanner.nextLine().trim();
                board.updatePost(postId, title, content);
            }else if(input.equals("목록")){
                board.listPost();
            }
        }
        scanner.close();
    }
}
