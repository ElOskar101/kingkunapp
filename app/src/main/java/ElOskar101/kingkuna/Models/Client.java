package ElOskar101.kingkuna.Models;

import com.google.gson.annotations.SerializedName;

public class Client {

    @SerializedName("ClientID")
    private int clientID;
    @SerializedName("Name")
    private String name;
    @SerializedName("CreateAt")
    private String createAt;
    @SerializedName("HireDate")
    private String hireDate;
    @SerializedName("CancelDate")
    private String cancelDate;
    @SerializedName("DemoDays")
    private String demoDays;
    @SerializedName("Phone")
    private String phone;
    @SerializedName("Status")
    private int status;
    @SerializedName("Amount")
    private float amount;

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getDemoDays() {
        return demoDays;
    }

    public void setDemoDays(String demoDays) {
        this.demoDays = demoDays;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
