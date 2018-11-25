package com.compubase.mhmd.alosboiya;


public class SallesCommentItems {
    private String scommentdate , scommentuser , scommenttext;

    public SallesCommentItems(String scommentdate, String scommentuser, String scommenttext) {
        this.scommentdate = scommentdate;
        this.scommentuser = scommentuser;
        this.scommenttext = scommenttext;
    }

    public String getScommentdate() {
        return scommentdate;
    }

    public void setScommentdate(String scommentdate) {
        this.scommentdate = scommentdate;
    }

    public String getScommentuser() {
        return scommentuser;
    }

    public void setScommentuser(String scommentuser) {
        this.scommentuser = scommentuser;
    }

    public String getScommenttext() {
        return scommenttext;
    }

    public void setScommenttext(String scommenttext) {
        this.scommenttext = scommenttext;
    }
}
