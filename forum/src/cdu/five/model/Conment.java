package cdu.five.model;

import java.sql.Timestamp;

public class Conment {
    private int cid;
    private int pid;
    private int uid;
    private String content;
    private Timestamp ctime;
    private String uname;

    @Override
    public String toString() {
        return "Conment{" +
                "cid=" + cid +
                ", pid=" + pid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", ctime=" + ctime +
                ", uname='" + uname + '\'' +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

}
