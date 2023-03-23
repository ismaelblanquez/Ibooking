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
import model.Comment;
import model.Reservation;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Ismael
 */
public class ReservationDAO
        implements IDAO<Reservation, Integer> {

    private final String BBDD_CLASS_NAME = "reservation";
    private final String BBDD_CLASS_PARAM_1 = "reservation_id";
    private final String BBDD_CLASS_PARAM_2 = "user_id";
    private final String BBDD_CLASS_PARAM_3 = "hotel_id";
    private final String BBDD_CLASS_PARAM_4 = "room_id";
    private final String BBDD_CLASS_PARAM_5 = "check_in_date";
    private final String BBDD_CLASS_PARAM_6 = "check_out_date";

    private final String SQL_FINDALL
            = "SELECT * FROM  `" + BBDD_CLASS_NAME + "` WHERE 1=1 ";

    private final String SQL_ADD
            = "INSERT INTO `" + BBDD_CLASS_NAME + "` (`" + BBDD_CLASS_PARAM_2 + "`, `" + BBDD_CLASS_PARAM_3 + "`, `" + BBDD_CLASS_PARAM_4 + "`, `" + BBDD_CLASS_PARAM_5 + "`, `" + BBDD_CLASS_PARAM_6 + "`) VALUES ";

    private final String SQL_DELETE = "DELETE FROM `" + BBDD_CLASS_NAME + "` WHERE " + BBDD_CLASS_PARAM_1 + "=";

    private final String SQL_UPDATE = "UPDATE `" + BBDD_CLASS_NAME + "` SET ";

    private MotorSQL motorSql;

    public ReservationDAO() {
        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public ArrayList<Reservation> findAll(Reservation bean) {
        ArrayList<Reservation> reservations = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getReservation_id()!= 0) {
                    sql += "AND " + BBDD_CLASS_PARAM_1 + "='" + bean.getReservation_id()+ "'";
                }

                if (bean.getUser()!= 0) {
                    sql += "AND " + BBDD_CLASS_PARAM_2 + "='" + bean.getUser()+ "'";
                }
                if (bean.getHotel()!= 0) {
                    sql += "AND " + BBDD_CLASS_PARAM_3 + "='" + bean.getHotel()+ "'";
                }

                if (bean.getRoom()!= 0) {
                    sql += "AND " + BBDD_CLASS_PARAM_4 + "='" + bean.getRoom()+ "'";
                }
                if (bean.getCheckin()!= null) {
                    sql += "AND " + BBDD_CLASS_PARAM_5 + "='" + bean.getCheckin()+ "'";
                }
                if (bean.getCheckout()!= null) {
                    sql += "AND " + BBDD_CLASS_PARAM_6 + "='" + bean.getCheckout()+ "'";
                }

            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Reservation reservation = new Reservation();

                reservation.setReservation_id(rs.getInt(1));
                reservation.setUser(rs.getInt(2));
                reservation.setHotel(rs.getInt(3));
                reservation.setRoom(rs.getInt(4));
                reservation.setCheckin(rs.getString(5));
                reservation.setCheckout(rs.getString(6));

                reservations.add(reservation);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return reservations;
    }

    @Override
    public int add(Reservation bean) {
        int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "('"
                    + bean.getUser()+ "', '"
                    + bean.getHotel()+ "', '"
                    + bean.getRoom()+ "', '"
                    + bean.getCheckin()+ "', '"
                    + bean.getCheckout()+ "');";

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
    public int update(Reservation bean) {
        int resp = 0;
        String sql;
        try {
            motorSql.connect();

            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {

                sql = SQL_UPDATE;
                if (bean.getUser()!= 0) {
                    sql += "" + BBDD_CLASS_PARAM_2 + "='" + bean.getUser()+ "'";
                }

                if (bean.getHotel()!= 0) {
                    sql += "" + BBDD_CLASS_PARAM_3 + "='" + bean.getHotel()+ "'";
                }

                if (bean.getRoom()!= 0) {
                    sql += "" + BBDD_CLASS_PARAM_4 + "='" + bean.getRoom()+ "'";
                }

                if (bean.getCheckin()!= null) {
                    sql += "" + BBDD_CLASS_PARAM_5 + "='" + bean.getCheckin()+ "', ";
                }
                if (bean.getCheckout()!= null) {
                    sql += "" + BBDD_CLASS_PARAM_6 + "='" + bean.getCheckout()+ "', ";
                }

                sql += " WHERE `" + BBDD_CLASS_PARAM_1 + "`=" + bean.getReservation_id()+ ";";
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
        ReservationDAO reservation = new ReservationDAO();

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
