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
import modelDominio.Viagem;

/**
 *
 * @author murilocost4
 */
public class ViagemTableModel extends AbstractTableModel {

    private ArrayList<Viagem> listaViagens;

    // método construtor que recebe como parâmetro a lista de Bikes
    public ViagemTableModel(ArrayList<Viagem> listaViagens) {
        this.listaViagens = listaViagens;
    }

    // sobrescrita do método que diz quantas LINHAS a tabela tem
    @Override
    public int getRowCount() {
        return listaViagens.size();
    }

    // sobrescrita do método que diz quantas COLUNAS a tabela tem
    @Override
    public int getColumnCount() {
        return 4;
    }

    // sobrescrita do método que retorna o valor de cada coluna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Viagem v = listaViagens.get(rowIndex);
        String status;
        
        if (v.getStatus_viagem() == 0) {
            status = "Não Iniciado";
        } else if (v.getStatus_viagem() == 1) {
            status = "Em Andamento";
        } else {
            status = "Finalizado";
        }

        switch (columnIndex) {
            case 0:  return v.getOrigem();
            case 1:  return v.getDestino();
            case 2:  return v.getData();
            case 3:  return status;
            default: return "";
        }
    }

    // sobrescrita do método que retorna o nome de cada coluna
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:  return "Origem";
            case 1:  return "Destino";
            case 2:  return "Data";
            case 3:  return "Status";
            default: return "NoName";
        }
    }

    // método que retorna um objeto de Raça a partir da linha que o 
    // usuário selecionou.
    public Viagem getViagem(int row) {
        return listaViagens.get(row);
    }
}
