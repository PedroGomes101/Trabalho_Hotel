package model;

public class Reserva {
    private int id;
    private int hospede_id;
    private String quarto;
    private String data_checkin;
    private String data_checkout;
    private String status;
    
    public Reserva(){}

    public Reserva(int hospede_id, String quarto, String data_checkin, String data_checkout, String status) {
        this.hospede_id = hospede_id;
        this.quarto = quarto;
        this.data_checkin = data_checkin;
        this.data_checkout = data_checkout;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHospede_id() {
        return hospede_id;
    }

    public void setHospede_id(int hospede_id) {
        this.hospede_id = hospede_id;
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public String getData_checkin() {
        return data_checkin;
    }

    public void setData_checkin(String data_checkin) {
        this.data_checkin = data_checkin;
    }

    public String getData_checkout() {
        return data_checkout;
    }

    public void setData_checkout(String data_checkout) {
        this.data_checkout = data_checkout;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
