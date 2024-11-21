/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tablemodel;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelDominio.Admin;
import modelDominio.Condutor;
import modelDominio.Usuario;

/**
 *
 * @author murilocost4
 */
public class UsuarioTableModel extends AbstractTableModel {

    private ArrayList<Usuario> listaUsuarios;

    // método construtor que recebe como parâmetro a lista de Bikes
    public UsuarioTableModel(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    // sobrescrita do método que diz quantas LINHAS a tabela tem
    @Override
    public int getRowCount() {
        return listaUsuarios.size();
    }

    // sobrescrita do método que diz quantas COLUNAS a tabela tem
    @Override
    public int getColumnCount() {
        return 2;
    }

    // sobrescrita do método que retorna o valor de cada coluna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usr = listaUsuarios.get(rowIndex);
        String tipo;
        
        if (usr instanceof Admin) {
            tipo = "Admin";
        } else if (usr instanceof Condutor) {
            tipo = "Condutor";
        } else {
            tipo = "Passageiro";
        }

        switch (columnIndex) {
            case 0:  return usr.getNomeUsuario();
            case 1:  return tipo;
            default: return "";
        }
    }

    // sobrescrita do método que retorna o nome de cada coluna
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:  return "Nome";
            case 1:  return "Tipo";
            default: return "NoName";
        }
    }

    // método que retorna um objeto de Raça a partir da linha que o 
    // usuário selecionou.
    public Usuario getUsuario(int row) {
        return listaUsuarios.get(row);
    }
}
