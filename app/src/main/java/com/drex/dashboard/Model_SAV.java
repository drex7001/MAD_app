package com.drex.dashboard;

public class Model_SAV{
    String id,title,notice;

    public Model_SAV() {
    }

    public Model_SAV(String id, String title, String notice) {
        this.id = id;
        this.title = title;
        this.notice = notice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
