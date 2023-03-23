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
import model.Location;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Ismael
 */
public class LocationDAO
        implements IDAO<Location, Integer> {

    private final String BBDD_CLASS_NAME = "location";
    private final String BBDD_CLASS_PARAM_1 = "location_id";
    private final String BBDD_CLASS_PARAM_2 = "city";
    private final String BBDD_CLASS_PARAM_3 = "country";

    private final String SQL_FINDALL
            = "SELECT * FROM  `" + BBDD_CLASS_NAME + "` WHERE 1=1 ";

    private final String SQL_ADD
            = "INSERT INTO `" + BBDD_CLASS_NAME + "` (`" + BBDD_CLASS_PARAM_2 + "`, `" + BBDD_CLASS_PARAM_3 + "`) VALUES ";

    private final String SQL_DELETE = "DELETE FROM `" + BBDD_CLASS_NAME + "` WHERE " + BBDD_CLASS_PARAM_1 + "=";

    private final String SQL_UPDATE = "UPDATE `" + BBDD_CLASS_NAME + "` SET ";

    private MotorSQL motorSql;

    public LocationDAO() {
        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public ArrayList<Location> findAll(Location bean) {
        ArrayList<Location> locations = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getId() != 0) {
                    sql += "AND " + BBDD_CLASS_PARAM_1 + "='" + bean.getId() + "'";
                }
                if (bean.getCity() != null) {
                    sql += "AND " + BBDD_CLASS_PARAM_2 + " LIKE('%" + bean.getCity() + "%')";
                }
                if (bean.getCountry() != null) {
                    sql += "AND " + BBDD_CLASS_PARAM_3 + " LIKE('%" + bean.getCountry() + "%')";
                }

            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Location location = new Location();

                location.setId(rs.getInt(1));
                location.setCity(rs.getString(2));
                location.setCountry(rs.getString(3));
                locations.add(location);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return locations;
    }

    @Override
    public int add(Location bean) {
        int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "('"
                    + bean.getCity() + "', '"
                    + bean.getCountry() + "');";

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
    public int update(Location bean) {
        int resp = 0;
        String sql;
        try {
            motorSql.connect();

            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {

                sql = SQL_UPDATE;
                if (bean.getCity() != null) {
                    sql += "" + BBDD_CLASS_PARAM_2 + "='" + bean.getCity() + "'";
                }

                if (bean.getCountry() != null) {
                    sql += "" + BBDD_CLASS_PARAM_3 + "='" + bean.getCountry() + "'";
                }

                sql += " WHERE `" + BBDD_CLASS_PARAM_1 + "`=" + bean.getId() + ";";
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
        LocationDAO location = new LocationDAO();

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
