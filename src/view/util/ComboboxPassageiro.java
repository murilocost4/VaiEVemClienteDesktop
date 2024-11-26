/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelDominio.Condutor;
import modelDominio.Passageiro;

/**
 * @author murilocost4
 */
//Referência: http://www.guj.com.br/t/jcombobox-tem-id/50938/10

public class ComboboxPassageiro {
 
    //Atributos privados do ComboBox
    private String value; // String que aparece para o usuário
    private int key;      // Código da String (Chave primaria da tabela Marca)

    // Método construtor
    public ComboboxPassageiro(int key, String value) {
        this.key = key;
        this.value = value;
    }
 
    // sobrescrevendo o método padrão toString que facilita para imprimir valores na tela,
    // sem esse método são impressos os endereços da memória onde o objeto foi declarado.
    @Override
    public String toString() {
        return value;
    }

    // método get a chave primária
    public int getKey() {
        return key;
    }
    
    // Este método retorna o código (chave primária) da opção que está selecionada pelo usuário
    public static int getSelectedIndex(JComboBox combo){
        Object obj = combo.getSelectedItem();
        if (obj == null)
            return -1; // se nenhum item estiver selecionado devolve -1
        else
            return ((ComboboxPassageiro) obj).getKey();// devolve o código da chave selecionada
    }
    
    // Método que preenche o comboBox com os nomes dos Condutores.
    // selCodigo --> parâmetro para já selecionar um código 
    // combo     --> ComboBox a ser preenchida
    // lista     --> Lista de Raças
    public static void preencheComboBoxPassageiro(int SelCodigo, JComboBox combo, ArrayList<Passageiro> lista){
        Vector vlista= new Vector();
        int x = 0;  // se quiser inserir um vazio então tem que jogar esse número para 1
        int selecionarCodigo = -1; // guarda a posicao se tiver código selecionado
        
        /* inserindo vazio*/
        // só habilite a linha abaixo se você quiser uma Marca vazia, exemplo:
        // cadastrar sem Marca.
        
        vlista.add(new ComboboxPassageiro(0,"Sem Passageiro"));
            
        // percorre toda a lista de Raças e armazena as informações no Vector vlista;
        for (Passageiro p: lista){ 
            // criando um ComboBoxMarca
            ComboboxPassageiro cmb = new ComboboxPassageiro(p.getCodUsuario(),p.getNomeUsuario());
            // armazenando esse comboBoc no Vector
            vlista.add(cmb);
            // Se o código atual for igual ao código que já se deseja pré-selecionar
            // guarda-se a informação em selecionarCodigo
            if (cmb.getKey() == SelCodigo)
                selecionarCodigo = x;
            x++;// incrementa a variável x que guarda o índice que é diferente do código da tabela
        }
        
        // Criando um modelo com o vetor
        DefaultComboBoxModel modelocliente = new DefaultComboBoxModel(vlista);
        // setando o modelo no ComboBox
        combo.setModel(modelocliente);
        // Selecionando o índice que o usuário selecionou como padrão.
        if (selecionarCodigo >= 0)
            combo.setSelectedIndex(selecionarCodigo);
    }

}
