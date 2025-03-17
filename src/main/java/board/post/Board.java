package board.post;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

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
        System.out.println("게시글이 작성이 성공적으로 완료되었습니다!");
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
    //그냥 remove를 사용하니까 ConcurrentModificationException에러가 발생함 -> 초면
    /*ConcurrentModificationException -> Arraylist에서 반복문을 도는
    도중에 크기 변경이 일어나면 발생되는 에러
    -> Iterator를 사용하면 됨
     */
    public void deletePost(int postId) {
        Iterator<Post> iterator = post.iterator();
        while (iterator.hasNext()) {
            Post post = iterator.next();
            if (post.getId() == postId) {
                iterator.remove(); //
                System.out.println(postId + "번 게시물이 성공적으로 삭제되었습니다!");
                return;
            }
        }
        System.out.println(postId + "번 게시글을 찾을 수 없습니다.");
    }

    //수정
    public void updatePost(int postId, String title, String content) {
        for(Post posts : post) {
            if(posts.id == postId) {
                posts.title = title;
                posts.content = content;
                System.out.println(postId + "번 게시글이 성공적으로 수정되었습니다!");
                return;
            }
        }
    }



}
