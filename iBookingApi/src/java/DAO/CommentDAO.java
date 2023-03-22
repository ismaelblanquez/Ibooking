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
import model.Hotel;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Ismael
 */
public class CommentDAO
        implements IDAO<Comment, Integer> {

    private final String BBDD_CLASS_NAME = "comment";
    private final String BBDD_CLASS_PARAM_1 = "comment_id";
    private final String BBDD_CLASS_PARAM_2 = "user_id";
    private final String BBDD_CLASS_PARAM_3 = "hotel_id";
    private final String BBDD_CLASS_PARAM_4 = "comment_text";
    private final String BBDD_CLASS_PARAM_5 = "rating";

    private final String SQL_FINDALL
            = "SELECT * FROM  `" + BBDD_CLASS_NAME + "` WHERE 1=1 ";

    private final String SQL_ADD
            = "INSERT INTO `" + BBDD_CLASS_NAME + "` (`" + BBDD_CLASS_PARAM_2 + "`, `" + BBDD_CLASS_PARAM_3 + "`, `" + BBDD_CLASS_PARAM_4 + "`, `" + BBDD_CLASS_PARAM_5 + "`) VALUES ";

    private final String SQL_DELETE = "DELETE FROM `" + BBDD_CLASS_NAME + "` WHERE " + BBDD_CLASS_PARAM_1 + "=";

    private final String SQL_UPDATE = "UPDATE `" + BBDD_CLASS_NAME + "` SET ";

    private MotorSQL motorSql;

    public CommentDAO() {
        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public ArrayList<Comment> findAll(Comment bean) {
        ArrayList<Comment> comments = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getId() != 0) {
                    sql += "AND " + BBDD_CLASS_PARAM_1 + "='" + bean.getId() + "'";
                }

                if (bean.getUserId() != 0) {
                    sql += "AND " + BBDD_CLASS_PARAM_2 + "='" + bean.getUserId() + "'";
                }
                if (bean.getHotelId() != 0) {
                    sql += "AND " + BBDD_CLASS_PARAM_3 + "='" + bean.getHotelId() + "'";
                }

                if (bean.getComment() != null) {
                    sql += "AND " + BBDD_CLASS_PARAM_4 + " LIKE('%" + bean.getComment() + "%')";
                }
                if (bean.getRating() != 0) {
                    sql += "AND " + BBDD_CLASS_PARAM_5 + "='" + bean.getRating() + "'";
                }

            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Comment comment = new Comment();

                comment.setId(rs.getInt(1));
                comment.setUserId(rs.getInt(2));
                comment.setHotelId(rs.getInt(3));
                comment.setComment(rs.getString(4));
                comment.setRating(rs.getInt(5));

                comments.add(comment);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return comments;
    }

    @Override
    public int add(Comment bean) {
        int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "('"
                    + bean.getUserId() + "', '"
                    + bean.getHotelId() + "', '"
                    + bean.getComment() + "', '"
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
    public int update(Comment bean) {
        int resp = 0;
        String sql;
        try {
            motorSql.connect();

            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {

                sql = SQL_UPDATE;
                if (bean.getUserId() != 0) {
                    sql += "" + BBDD_CLASS_PARAM_2 + "='" + bean.getUserId() + "'";
                }

                if (bean.getHotelId() != 0) {
                    sql += "" + BBDD_CLASS_PARAM_3 + "='" + bean.getHotelId() + "'";
                }

                if (bean.getComment() != null) {
                    sql += "" + BBDD_CLASS_PARAM_4 + "='" + bean.getComment() + "'";
                }

                if (bean.getRating() != 0) {
                    sql += "" + BBDD_CLASS_PARAM_5 + "='" + bean.getRating() + "', ";
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
        CommentDAO comment = new CommentDAO();

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
