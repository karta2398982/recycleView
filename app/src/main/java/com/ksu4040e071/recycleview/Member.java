package com.ksu4040e071.recycleview;

/**
 * Created by nick on 2016/12/3.
 */

public class Member { // VO- Value Object
    private int id;
    private int image;
    private String name;
    private String content;

    public Member() {
        super();
    }

    public Member(int id, int image, String name, String content) {
        super();
        this.id = id;
        this.image = image;
        this.name = name;
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
}
