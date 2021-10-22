package ros.models;

public enum OrderStatus {
    OPEN("Acik"),
    IN_PROGRESS("Hazırlanıyor"),
    RESOLVED("Cözüldü"),
    CLOSED("Kapandi");
    private String label;
    OrderStatus(String label){
        this.label=label;
    }
}
