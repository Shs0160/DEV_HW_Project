package board;

import java.util.*;

public class Request {

    /*
    경로를 저장할 path와
    파라미터를 저장할 변수가 필요
     */

    private String path;
    private Map<String, String> param = new HashMap<>();


    public Request(String url) {
        splitUrl(url);
    }

    private void splitUrl(String url) {
        param = new HashMap<>();
        String[] split = url.split("\\?");
        this.path = split[0];

        String[] query = split[1].split("&");
        for (int i = 1; i < split.length; i++) {

        }
    }

}
