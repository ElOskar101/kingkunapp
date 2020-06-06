package ElOskar101.kingkuna.Models;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("$id")
    private String ID;
    @SerializedName("UserID")
    private String userID;
    @SerializedName("Name")
    private String name;
    @SerializedName("Username")
    private String username;
    @SerializedName("Pwd")
    private String pdw;
    @SerializedName("Image")
    private String image;
    @SerializedName("Token")
    private String token;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPdw() {
        return pdw;
    }

    public void setPdw(String pdw) {
        this.pdw = pdw;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
