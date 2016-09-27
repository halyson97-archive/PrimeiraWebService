/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import com.google.gson.Gson;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Usuario;

/**
 * REST Web Service
 *
 * @author halyson
 */
@Path("fazenda")
public class FazendaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FazendaWS
     */
    public FazendaWS() {
    }

    /**
     * Retrieves representation of an instance of WebService.FazendaWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        return "Meu primeiro WebService RESTFULL";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/get/{login}")
    public String getUsuario(@PathParam("login") String login){
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        
        UsuarioDAO dao = new UsuarioDAO();
        usuario = dao.buscar(usuario);
        
        //converter objeto para json
        Gson gson = new Gson();
        return gson.toJson(usuario);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/list")
    public String listaUsuarios(){
        List<Usuario> lista;
        
        
        UsuarioDAO dao = new UsuarioDAO();
        lista = dao.listar();
        
        //converter objeto para json
        Gson gson = new Gson();
        return gson.toJson(lista);
    }

    /**
     * PUT method for updating or creating an instance of FazendaWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
