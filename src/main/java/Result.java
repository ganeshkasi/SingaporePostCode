import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("SEARCHVAL")
    public String getSEARCHVAL() {
        return this.sEARCHVAL;
    }

    public void setSEARCHVAL(String sEARCHVAL) {
        this.sEARCHVAL = sEARCHVAL;
    }

    String sEARCHVAL;

    @JsonProperty("BLK_NO")
    public String getBLK_NO() {
        return this.bLK_NO;
    }

    public void setBLK_NO(String bLK_NO) {
        this.bLK_NO = bLK_NO;
    }

    String bLK_NO;

    @JsonProperty("ROAD_NAME")
    public String getROAD_NAME() {
        return this.rOAD_NAME;
    }

    public void setROAD_NAME(String rOAD_NAME) {
        this.rOAD_NAME = rOAD_NAME;
    }

    String rOAD_NAME;

    @JsonProperty("BUILDING")
    public String getBUILDING() {
        return this.bUILDING;
    }

    public void setBUILDING(String bUILDING) {
        this.bUILDING = bUILDING;
    }

    String bUILDING;

    @JsonProperty("ADDRESS")
    public String getADDRESS() {
        return this.aDDRESS;
    }

    public void setADDRESS(String aDDRESS) {
        this.aDDRESS = aDDRESS;
    }

    String aDDRESS;

    @JsonProperty("POSTAL")
    public String getPOSTAL() {
        return this.pOSTAL;
    }

    public void setPOSTAL(String pOSTAL) {
        this.pOSTAL = pOSTAL;
    }

    String pOSTAL;


}