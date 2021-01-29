package cdu.five.model;

import java.sql.Timestamp;

public class Post {
    private int pid;
    private int uid;
    private String title;
    private String content;
    private Timestamp time;
    private int essence;
    private int top;
    private String uname;
    private String upic;

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", essence=" + essence +
                ", top=" + top +
                ", uname='" + uname + '\'' +
                ", upic='" + upic + '\'' +
                '}';
    }

    public String getUpic() {
        return upic;
    }

    public void setUpic(String upic) {
        this.upic = upic;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getEssence() {
        return essence;
    }

    public void setEssence(int essence) {
        this.essence = essence;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
