/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Hotel;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Ismael
 */
public class HotelDAO
        implements IDAO<Hotel, Integer> {

    private final String SQL_FINDALL
            = "SELECT * FROM `hotel` WHERE 1=1 ";

    private final String SQL_ADD
            = "INSERT INTO `hotel` (`name`, `description`, `location_id`, `rating`) VALUES ";

    private final String SQL_DELETE = "DELETE FROM `pelicula` WHERE hotel_id=";

    private final String SQL_UPDATE = "UPDATE `hotel` SET ";

    private MotorSQL motorSql;

    public HotelDAO() {
        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public ArrayList<Hotel> findAll(Hotel bean) {
        ArrayList<Hotel> hotels = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getHotel_id() != 0) {
                    sql += "AND hotel_id='" + bean.getHotel_id() + "'";
                }
                if (bean.getName() != null) {
                    sql += "AND name LIKE('%" + bean.getName() + "%')";
                }

                if (bean.getDescription() != null) {
                    sql += "AND description LIKE('%" + bean.getDescription() + "%')";
                }
                if (bean.getLocation() != 0) {
                    sql += "AND location_id='" + bean.getLocation() + "'";
                }

                if (bean.getRating() != 0) {
                    sql += "AND rating='" + bean.getRating() + "'";
                }

            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Hotel hotel = new Hotel();

                hotel.setHotel_id(rs.getInt(1));
                hotel.setName(rs.getString(2));
                hotel.setDescription(rs.getString(3));
                hotel.setLocation(rs.getInt(4));
                hotel.setRating(rs.getInt(5));
                

                hotels.add(hotel);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return hotels;
    }

    @Override
    public int add(Hotel bean) {
        int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "('"
                    + bean.getName() + "', '"
                    + bean.getDescription() + "', '"
                    + bean.getLocation() + "', '"
                    + bean.getRating() + "');";

//                    + bean.getsPuntuacion() + "',"
//                    + "CURRENT_DATE)";
            resp = motorSql.execute(sql);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Hotel insertado con éxito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer id) {
        int resp = 0;
        motorSql.connect();
        try {
            String sql = SQL_DELETE + id;
            //desactivo la restriccion de claves foráneas para borrado
            motorSql.execute("SET FOREIGN_KEY_CHECKS=0;");
            resp = motorSql.execute(sql);
            //vuelvo a activar la restricción de claves foráneas
            motorSql.execute("SET FOREIGN_KEY_CHECKS=1;");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Borrado con exito.");
        } else {
            System.out.println("No se pudo borrar.");
        }
        return resp;
    }

    @Override
    public int update(Hotel bean) {
        int resp = 0;
        String sql;
        try {
            motorSql.connect();

            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {

                sql = SQL_UPDATE;
                if (bean.getName()!= null) {
                    sql += "name='" + bean.getName()+ "'";
                }

                if (bean.getDescription()!= null) {
                    sql += "description='" + bean.getDescription()+ "'";
                }

                if (bean.getLocation() != 0) {
                    sql += "location_id='" + bean.getLocation()+ "'";
                }

                if (bean.getRating()!= 0) {
                    sql += "rating='" + bean.getRating()+ "', ";
                }


                sql += " WHERE `hotel_id`=" + bean.getHotel_id()+ ";";
                System.out.println(sql);
                resp = motorSql.execute(sql);
            }

        } catch (Exception e) {

        } finally {
            motorSql.disconnect();
        }

        if (resp > 0) {
            System.out.println("Pelicula actualizada con éxito.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
        return resp;
    }

    public static void main(String[] args) {
        /*PRUEBAS UNITARIAS - TEST*/
        HotelDAO hotel = new HotelDAO();

        //Findall - filtra segun campos que no son null o 0
//        ArrayList lstPeliculas
//                = peliculaDAO.findAll(new Pelicula("Interstellar", null, null, null, 0, 500, 0, 0, null, null));
//        System.out.println(lstPeliculas.toString());
//
//        Pelicula peliprueba = new Pelicula("Joshua y los teleñecos", "www", "abc", "2015", 90, 5, 6, 9, 5.3, null);
//        //Add de registro
        // peliculaDAO.add(peliprueba);
//        //Update del registro con id pelicula 1
        //     peliculaDAO.update(new Pelicula("Titulo cambiado", null, null, null, 0, 0, 0, 1, null));
//        //Delete del registro 2
        //     peliculaDAO.delete(2);
    }

}
