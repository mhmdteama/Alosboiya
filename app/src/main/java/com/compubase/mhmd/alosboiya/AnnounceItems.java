package com.compubase.mhmd.alosboiya;


public class AnnounceItems {
    private String announcename , announcetime,announcername , announcelocation;
    private int announceimage;

    public AnnounceItems(String announcename, String announcetime, String announcername, String announcelocation, int announceimage) {
        this.announcename = announcename;
        this.announcetime = announcetime;
        this.announcername = announcername;
        this.announcelocation = announcelocation;
        this.announceimage = announceimage;
    }

    public String getAnnouncename() {
        return announcename;
    }

    public void setAnnouncename(String announcename) {
        this.announcename = announcename;
    }

    public String getAnnouncetime() {
        return announcetime;
    }

    public void setAnnouncetime(String announcetime) {
        this.announcetime = announcetime;
    }

    public String getAnnouncername() {
        return announcername;
    }

    public void setAnnouncername(String announcername) {
        this.announcername = announcername;
    }

    public String getAnnouncelocation() {
        return announcelocation;
    }

    public void setAnnouncelocation(String announcelocation) {
        this.announcelocation = announcelocation;
    }

    public int getAnnounceimage() {
        return announceimage;
    }

    public void setAnnounceimage(int announceimage) {
        this.announceimage = announceimage;
    }
}
