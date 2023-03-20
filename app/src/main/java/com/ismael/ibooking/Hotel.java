package com.ismael.ibooking;

public class Hotel {
    private int id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
    private double precio;
    private double puntuacion;
    private int imagen;

    public Hotel(int id, String nombre, String direccion, String ciudad, String pais, double precio, double puntuacion, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.precio = precio;
        this.puntuacion = puntuacion;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public double getPrecio() {
        return precio;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public int getImagen() {
        return imagen;
    }
}
