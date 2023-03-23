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
import model.Location;
import model.Room;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Ismael
 */
public class RoomDAO
        implements IDAO<Room, Integer> {

    private final String BBDD_CLASS_NAME = "room";
    private final String BBDD_CLASS_PARAM_1 = "room_id";
    private final String BBDD_CLASS_PARAM_2 = "hotel_id";
    private final String BBDD_CLASS_PARAM_3 = "room_type";
    private final String BBDD_CLASS_PARAM_4 = "price_per_night";
    private final String BBDD_CLASS_PARAM_5 = "aviability";

    private final String SQL_FINDALL
            = "SELECT * FROM  `" + BBDD_CLASS_NAME + "` WHERE 1=1 ";

    private final String SQL_ADD
            = "INSERT INTO `" + BBDD_CLASS_NAME + "` (`" + BBDD_CLASS_PARAM_2 + "`, `" + BBDD_CLASS_PARAM_3 + "`, `" + BBDD_CLASS_PARAM_4 + "`, `" + BBDD_CLASS_PARAM_5 + "`) VALUES ";

    private final String SQL_DELETE = "DELETE FROM `" + BBDD_CLASS_NAME + "` WHERE " + BBDD_CLASS_PARAM_1 + "=";

    private final String SQL_UPDATE = "UPDATE `" + BBDD_CLASS_NAME + "` SET ";

    private MotorSQL motorSql;

    public RoomDAO() {
        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public ArrayList<Room> findAll(Room bean) {
        ArrayList<Room> locations = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getRoom_id() != null) {
                    sql += "AND " + BBDD_CLASS_PARAM_1 + "='" + bean.getRoom_id() + "'";
                }
                if (bean.getHotelId() != null) {
                    sql += "AND " + BBDD_CLASS_PARAM_2 + " LIKE('%" + bean.getHotelId() + "%')";
                }
                if (bean.getRoom_type() != null) {
                    sql += "AND " + BBDD_CLASS_PARAM_3 + " LIKE('%" + bean.getRoom_type() + "%')";
                }
                if (bean.getPricePerNight()!= null) {
                    sql += "AND " + BBDD_CLASS_PARAM_4 + "='" + bean.getPricePerNight()+ "'";
                }
                if (bean.getAvailability()!= null) {
                    sql += "AND " + BBDD_CLASS_PARAM_5 + "='" + bean.getAvailability()+ "'";
                }
            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Room room = new Room();

                room.setRoom_id(rs.getInt(1));
                room.setHotelId(rs.getInt(2));
                room.setRoom_type(rs.getString(3));
                room.setPricePerNight(rs.getDouble(4));
                room.setPricePerNight(rs.getDouble(5));

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return locations;
    }

    @Override
    public int add(Room bean) {
        int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "('"
                    + bean.getHotelId()+ "', '"
                    + bean.getRoom_type()+ "', '"
                    + bean.getPricePerNight()+ "', '"
                    + bean.getAvailability()+ "');";

//                    + bean.getsPuntuacion() + "',"
//                    + "CURRENT_DATE)";
            resp = motorSql.execute(sql);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Comentario insertado con éxito.");
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
    public int update(Room bean) {
        int resp = 0;
        String sql;
        try {
            motorSql.connect();

            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {

                sql = SQL_UPDATE;
                if (bean.getHotelId()!= null) {
                    sql += "" + BBDD_CLASS_PARAM_2 + "='" + bean.getHotelId()+ "'";
                }

                if (bean.getRoom_type()!= null) {
                    sql += "" + BBDD_CLASS_PARAM_3 + "='" + bean.getRoom_type()+ "'";
                }
                if (bean.getPricePerNight()!= null) {
                    sql += "" + BBDD_CLASS_PARAM_4 + "='" + bean.getPricePerNight()+ "'";
                }
                if (bean.getAvailability()!= null) {
                    sql += "" + BBDD_CLASS_PARAM_5 + "='" + bean.getAvailability()+ "'";
                }

                sql += " WHERE `" + BBDD_CLASS_PARAM_1 + "`=" + bean.getRoom_id()+ ";";
                System.out.println(sql);
                resp = motorSql.execute(sql);
            }

        } catch (Exception e) {

        } finally {
            motorSql.disconnect();
        }

        if (resp > 0) {
            System.out.println("Habitación actualizada con éxito.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
        return resp;
    }

    public static void main(String[] args) {
        /*PRUEBAS UNITARIAS - TEST*/
        RoomDAO room = new RoomDAO();
        System.out.println(room.findAll(null).toString());

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
