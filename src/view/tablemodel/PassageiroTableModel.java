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
import modelDominio.Passageiro;
import modelDominio.Usuario;
import modelDominio.StatusPassageiro;

/**
 *
 * @author murilocost4
 */
public class PassageiroTableModel extends AbstractTableModel {

    private ArrayList<Passageiro> listaPassageiro;

    // método construtor que recebe como parâmetro a lista de Bikes
    public PassageiroTableModel(ArrayList<Passageiro> listaPassageiro) {
        this.listaPassageiro = listaPassageiro;
    }

    // sobrescrita do método que diz quantas LINHAS a tabela tem
    @Override
    public int getRowCount() {
        return listaPassageiro.size();
    }

    // sobrescrita do método que diz quantas COLUNAS a tabela tem
    @Override
    public int getColumnCount() {
        return 2;
    }

    // sobrescrita do método que retorna o valor de cada coluna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Passageiro p = listaPassageiro.get(rowIndex);

        switch (columnIndex) {
            case 0:  return p.getNomeUsuario();
            case 1:  return p.getEndereco();
            default: return "";
        }
    }

    // sobrescrita do método que retorna o nome de cada coluna
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:  return "Nome";
            case 1:  return "Endereço";
            default: return "NoName";
        }
    }

    // método que retorna um objeto de Raça a partir da linha que o 
    // usuário selecionou.
    public Passageiro getPassageiro(int row) {
        return listaPassageiro.get(row);
    }
}
