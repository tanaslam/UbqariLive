
package org.ubqari.android.ubqarilive.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArchivedAudio {

    @Expose @SerializedName("id")
    private String id;

    @Expose @SerializedName("sphCatId")
    private String sphCatId;

    @Expose @SerializedName("nSphId")
    private String nSphId;

    @Expose @SerializedName("strTitle")
    private String strTitle;

    @Expose @SerializedName("strTitleEng")
    private String strTitleEng;

    @Expose @SerializedName("strDate")
    private String strDate;
    @Expose @SerializedName("strFileName")
    private String strFileName;
    @Expose @SerializedName("strFormatedDate")
    private String strFormatedDate;

    private boolean isPlaying;

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        this.isPlaying = playing;
    }

    public String getId() {
        return id;
    }

    public void setNId(String nId) {
        this.id = nId;
    }

    public ArchivedAudio withNId(String nId) {
        this.id = nId;
        return this;
    }

    public String getSphCatId() {
        return sphCatId;
    }

    public void setNSphcatId(String nSphcatId) {
        this.sphCatId = nSphcatId;
    }

    public ArchivedAudio withNSphcatId(String sphCatId) {
        this.sphCatId = sphCatId;
        return this;
    }

    public String getNSphId() {
        return nSphId;
    }

    public void setNSphId(String nSphId) {
        this.nSphId = nSphId;
    }

    public ArchivedAudio withNSphId(String nSphId) {
        this.nSphId = nSphId;
        return this;
    }

    public String getStrTitle() {
        return strTitle;
    }

    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public ArchivedAudio withStrTitle(String strTitle) {
        this.strTitle = strTitle;
        return this;
    }

    public String getStrTitleEng() {
        return strTitleEng;
    }

    public void setStrTitleEng(String strTitleEng) {
        this.strTitleEng = strTitleEng;
    }

    public ArchivedAudio withStrTitleEng(String strTitleEng) {
        this.strTitleEng = strTitleEng;
        return this;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public ArchivedAudio withStrDate(String strDate) {
        this.strDate = strDate;
        return this;
    }

    public String getStrFileName() {
        return strFileName;
    }

    public void setStrFileName(String strFileName) {
        this.strFileName = strFileName;
    }

    public ArchivedAudio withStrFileName(String strFileName) {
        this.strFileName = strFileName;
        return this;
    }

    public String getStrFormatedDate() {
        return strFormatedDate;
    }

    public void setStrFormatedDate(String strFormatedDate) {
        this.strFormatedDate = strFormatedDate;
    }

    public ArchivedAudio withStrFormatedDate(String strFormatedDate) {
        this.strFormatedDate = strFormatedDate;
        return this;
    }

}
