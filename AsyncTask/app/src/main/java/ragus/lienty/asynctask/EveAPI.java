package ragus.lienty.asynctask;

/**
 * Created by Slivo on 04/03/2017.
 */

public class EveAPI {

    protected String keyId;
    protected String vCode;

    public EveAPI(){
        this.keyId = "";
        this.vCode = "";
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

}
