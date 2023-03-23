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

import model.User;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Ismael
 */
/**
 *
 * @author Ismael
 */
public class UserDAO
        implements IDAO<User, Integer> {

    private final String SQL_FINDALL
            = "SELECT * FROM `users` WHERE 1=1 ";

    private final String SQL_ADD
            = "INSERT INTO `users` (`name`, `lastName`, `email`, `password`) VALUES ";

    private final String SQL_DELETE = "DELETE FROM `users` WHERE user_id=";

    private final String SQL_UPDATE = "UPDATE `users` SET ";

    private MotorSQL motorSql;

    public UserDAO() {
        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public ArrayList<User> findAll(User bean) {
        ArrayList<User> users = new ArrayList<>();
         String sql = SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {

                if (bean.getUser_id() != 0) {
                    sql += "AND user_id ='" + bean.getUser_id() + "'";
                }

                if (bean.getName() != null) {
                    sql += "AND name LIKE('%" + bean.getName() + "%')";
                }

                if (bean.getLastName() != null) {
                    sql += "AND lastName LIKE('%" + bean.getLastName() + "%')";
                }
                if (bean.getEmail() != null) {
                    sql += "AND email='" + bean.getEmail() + "'";
                }

                if (bean.getPassword() != null) {
                    sql += "AND password='" + bean.getPassword() + "'";
                }

            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));

                users.add(user);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return users;
    }

    @Override
    public int add(User bean) {
        int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "('"
                    + bean.getName() + "', '"
                    + bean.getLastName()+ "', '"
                    + bean.getEmail()+ "', '"
                    + bean.getPassword()+ "');";

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
    public int update(User bean) {
        int resp = 0;
        String sql;
        try {
            motorSql.connect();

            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {

                sql = SQL_UPDATE;
                if (bean.getName() != null) {
                    sql += "name='" + bean.getName() + "'";
                }

                if (bean.getLastName()!= null) {
                    sql += "lastName='" + bean.getLastName()+ "'";
                }

                if (bean.getEmail()!= null) {
                    sql += "email='" + bean.getEmail()+ "'";
                }

                if (bean.getPassword()!= null) {
                    sql += "password='" + bean.getPassword()+ "', ";
                }

                sql += " WHERE `user_id`=" + bean.getUser_id()+ ";";
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
        UserDAO user = new UserDAO();
        
        System.out.println(user.findAll(null).toString());

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
