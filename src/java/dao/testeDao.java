/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Usuario;

/**
 *
 * @author halyson
 */
public class testeDao {
    
    public static void main(String[] args) {
	Usuario usuario = new Usuario();
        usuario.setEmail("hall@hall.com");
        usuario.setLogin("halyson");
        usuario.setPerfil("Admin");
        usuario.setSenha("123");
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.inserir(usuario);
               
}
    
}
