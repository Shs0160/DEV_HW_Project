package board.post;

import java.util.ArrayList;

public class Board {

    //흐아 어렵다

    //게시글을 한꺼번에 관리할 List 필요! -> 각각의 게시글은 번호를 가짐

    //작성(Create), 조회(Reda), 수정(Update), 삭제(Delete)의 기능이 필요

    private ArrayList<Post> post = new ArrayList<>();
    private int postId = 1;

    public void writePost(String title, String content) {
        post.add(new Post(postId, title, content));
        System.out.println("게시물이 작성이 완료되었습니다!");
    }

    public void readPost(int postId) {
        for(Post post : post) {
            if(post.id == postId){
                System.out.println("제목: " + post.title);
                System.out.println("내용: " + post.content);
                return;
            }
        }
        System.out.println("게시물이 존재하지 않습니다.");
    }

}
