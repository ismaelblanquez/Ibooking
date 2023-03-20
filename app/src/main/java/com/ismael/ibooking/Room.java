package com.ismael.ibooking;

public class Room {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("hotelId")
    @Expose
    private Integer hotelId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("pricePerNight")
    @Expose
    private Double pricePerNight;
    @SerializedName("photo")
    @Expose
    private String photo;

    public Room(Integer id, Integer hotelId, String type, String description, Double pricePerNight, String photo) {
        this.id = id;
        this.hotelId = hotelId;
        this.type = type;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
