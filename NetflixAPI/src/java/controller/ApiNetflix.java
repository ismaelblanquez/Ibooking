package controller;

import DAO.PeliculaDAO;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Pelicula;

@Path("peliculas")
public class ApiNetflix {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public JsonArray listarPeliculas(){
        PeliculaDAO peliculaDao = new PeliculaDAO();
        ArrayList<Pelicula> peliculas = peliculaDao.findAll(null);
        String resp = Pelicula.toArrayJSon(peliculas);
        JsonParser parser = new JsonParser();
       JsonElement tradeElement = parser.parse(resp);
       JsonArray trade = tradeElement.getAsJsonArray();
       return trade;
        //return null;
    }
}
