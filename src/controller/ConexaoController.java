/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Usuario;

/**
 *
 * @author murilocost4
 */
public class ConexaoController {
    private ObjectInputStream in;
    private ObjectOutputStream out;
    // usuário que está logado no sistema
    private Usuario usuarioLogado;

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    

    public ConexaoController(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    // aqui teremos zilhoes de métodos que se comunicarão com o servidor
    
    public Usuario efetuarLogin(Usuario user){
        try {
            // enviando o comando UsuarioEfetuarLogin para o servidor
            out.writeObject("UsuarioEfetuarLogin");
            in.readObject(); // recebendo o "ok" do servidor
            // enviar o usuário que está tentando fazer login
            out.writeObject(user);
            // recebendo o usuário do servidor
            Usuario userLogin = (Usuario) in.readObject();
            return userLogin; 
        } catch (Exception e) {
            e.printStackTrace();
            // se acontecer erro retornaremos null
            return null;
        }
    } 
}
