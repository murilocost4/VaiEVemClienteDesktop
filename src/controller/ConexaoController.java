/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Usuario;
import modelDominio.Viagem;

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
    
    
    // método que comunica com o Servidor e envia o
    // comando "ViagemLista" e recebe uma listagem de 
    // Viagens
    public ArrayList<Viagem> getViagemLista(){
        try {
            // enviar o comando "ViagemLista"
            out.writeObject("ViagemLista");
            // recebendo listagem de Viagens
            return (ArrayList<Viagem>) in.readObject(); 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // inserir Viagem
    public boolean viagemInserir(Viagem v){
        try {
            // enviando comando
            out.writeObject("ViagemInserir");
            in.readObject();//lendo o "ok"
            // enviando a Viagem
            out.writeObject(v);
            // receber o boolean (deu certo ou não)
            // recebe resposta, converte boolean, devolve o boolean
            return( (boolean) in.readObject());
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean viagemAlterar(Viagem v){
        try {
            // enviando comando
            out.writeObject("ViagemAlterar");
            in.readObject();//lendo o "ok"
            // enviando a Viagem
            out.writeObject(v);
            // receber o boolean (deu certo ou não)
            // recebe resposta, converte boolean, devolve o boolean
            return( (boolean) in.readObject());
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean viagemExcluir(Viagem v){
        try {
            // enviando comando
            out.writeObject("ViagemExcluir");
            in.readObject();//lendo o "ok"
            // enviando a Viagem
            out.writeObject(v);
            // receber o boolean (deu certo ou não)
            // recebe resposta, converte boolean, devolve o boolean
            return( (boolean) in.readObject());
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Usuario> usuarioLista(){
        String msg;
        try{
            out.writeObject("UsuarioLista");
            msg = (String) in.readObject(); // lendo ok
            ArrayList<Usuario> listausr = (ArrayList<Usuario>) in.readObject(); 
            return listausr;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
     //=========================== FIM ==================
     public void fim(){
         String msg;
        try{
            out.writeObject("fim");
            in.close();
            out.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
     }
}
