package board.post;

import java.util.ArrayList;

public class Board {

    //흐아 어렵다

    //게시글을 한꺼번에 관리할 List 필요! -> 각각의 게시글은 번호를 가짐

    //작성(Create), 조회(Reda), 수정(Update), 삭제(Delete)의 기능이 필요
    //작업을 수행할 번호 확인을 위해 따로 입력을 받을 필요가 있음
    //Board 클래스에서 메서드마다 받는것보단 main 에서 받는게 좋을듯

    private ArrayList<Post> post = new ArrayList<>();
    private int postId = 1;

    //작성
    public void writePost(String title, String content) {
        post.add(new Post(postId, title, content));
        System.out.println("게시물이 작성이 완료되었습니다!");
    }

    //조회
    public void readPost(int postId) {
        for(Post post : post) {
            if(post.id == postId){
                System.out.println("제목: " + post.title);
                System.out.println("내용: " + post.content);
                return;
            }
        }

        System.out.println(postId + "게시글이 존재하지 않습니다.");
    }

    //전체 게시글 목록 출력
    public void listPost() {
        if(post.isEmpty()) {
            System.out.println("게시물이 존재하지 않습니다.");
        }
        System.out.println("총 게시글은 " + postId + "개 작성되었습니다.");
        for(Post post : post) {
            System.out.println(post.id + "번 게시글");
            System.out.println("제목: " + post.title);
            System.out.println("내용: " + post.content);
        }
    }

    //삭제

    public void deletePost(int postId) {
        if(post.isEmpty()) {
            System.out.println("게시글이 비어있어 삭제가 불가능 합니다.");
        }
        for(Post posts : post) {
            if(posts.id == postId) {
                post.remove(posts);
                System.out.println(posts.id + "번 게시물이 성공적으로 삭제되었습니다!");
            }
        }
    }

    //수정
    public void updatePost(int postId, String title, String content) {
        for(Post posts : post) {
            if(posts.id == postId) {
                posts.title = title;
                posts.content = content;
                System.out.println(postId + "번 게시글이 수정되었습니다.");
                return;
            }
        }
    }



}
