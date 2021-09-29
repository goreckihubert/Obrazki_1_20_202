public class Obrazek {

    private String code;
    private String quantity;

    public Obrazek(String code, String quantity) {
        this.code = code;
        this.quantity = quantity;
    }

    public Obrazek() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
