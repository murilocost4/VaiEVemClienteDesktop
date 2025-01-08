/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelDominio.Viagem;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import modelDominio.Condutor;
import modelDominio.Passageiro;
import modelDominio.StatusPassageiro;
import view.util.ComboboxMotorista;
import view.util.ComboboxPassageiro;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import modelDominio.Usuario;
import view.tablemodel.PassageiroTableModel;
import view.tablemodel.UsuarioTableModel;


/**
 *
 * @author murilocost4
 */
public class TelaCadViagens extends javax.swing.JFrame {
    
    ArrayList<Passageiro> listaPassageiros = new ArrayList<>();
    ArrayList<StatusPassageiro> spLista = new ArrayList<>();
    private int codigo = -1;
    private PassageiroTableModel passageiroModel;
    /**
     * Creates new form TelaCadViagens
     */
    
    private void atualizaTabela() {
        passageiroModel = new PassageiroTableModel(listaPassageiros);
        jTPassageiros.setModel(passageiroModel);
    }
    
    
    
    private void preencheComboboxMotoristas() {
        // preenchendo o comboBox dos Motoristas
        ArrayList<Condutor> listaCondutor = new ArrayList<Condutor>();
        listaCondutor = Principal.ccont.getCondutorLista();
        ComboboxMotorista.preencheComboBoxMotorista(-1, jCBMotorista, listaCondutor);
    }
    
    private void preencheComboboxPassageiro() {
        ArrayList<Passageiro> listaPassageiro = new ArrayList<Passageiro>();
        listaPassageiro = Principal.ccont.getPassageiroLista();
        ComboboxPassageiro.preencheComboBoxPassageiro(-1, jCBPassageiro, listaPassageiro);
    }
    
    
    
    public TelaCadViagens() {
        
        initComponents();
        preencheComboboxMotoristas();
        preencheComboboxPassageiro();   
        this.listaPassageiros = listaPassageiros;
        this.spLista = spLista;
        atualizaTabela();
        MaskFormatter dateFormatter;
        MaskFormatter horaFormatter;
        try { 
            dateFormatter = new MaskFormatter("##/##/####");
            horaFormatter = new MaskFormatter("##:##");
            dateFormatter.setPlaceholderCharacter('_');
            horaFormatter.setPlaceholderCharacter('_');
            jTFData.setColumns(10);
            jTFData.setFormatterFactory(new DefaultFormatterFactory (dateFormatter));
            jTFSaida.setColumns(5);
            jTFSaida.setFormatterFactory(new DefaultFormatterFactory (horaFormatter));
            jTFRetorno.setColumns(5);
            jTFRetorno.setFormatterFactory(new DefaultFormatterFactory (horaFormatter));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public void setViagem(Viagem v){
            codigo = v.getTrip_id(); // salvando o código para usar depois no salvar
            jTFOrigem.setText(v.getOrigem());
            jTFDestino.setText(v.getDestino());
            jTFData.setText(v.getData());
            jTFRetorno.setText(v.getRetorno().toString());
            jTFSaida.setText(v.getSaida().toString());
            jCBStatus.setSelectedIndex(v.getStatus_viagem());
            
            int codCondutor = v.getCodCondutor(); // O ID do motorista que você quer selecionar

            for (int i = 0; i < jCBMotorista.getItemCount(); i++) {
                jCBMotorista.setSelectedIndex(i); // Temporariamente seleciona o item
                ComboboxMotorista motorista = (ComboboxMotorista) jCBMotorista.getSelectedItem(); // Obtém o item selecionado
                if (motorista.getKey() == codCondutor) { // Compara o código
                    break; // Sai do loop, pois o item foi encontrado
                }
            }




            ArrayList<StatusPassageiro> listaSP = (ArrayList<StatusPassageiro>) v.getStatusPassageiros();
            for (StatusPassageiro sp : listaSP) {
                listaPassageiros.add(sp.getPassageiro());
            }
            atualizaTabela();
    }
    
    



    
    /*private void adicionarPassageiro(Viagem viagem) {
        
        jPPassageiros.setLayout(new FlowLayout());
        
        listaPassageiros = new ArrayList<>();
        
        String passageiroSelecionado = (String) jCBPassageiro.getSelectedItem();
        if (jCBPassageiro != null && jCBPassageiro.getSelectedItem() != null) {
            int passageiroId = Integer.parseInt(passageiroSelecionado.split(" - ")[0]);
            String passageiroNome = passageiroSelecionado.split(" - ")[1];
            
            Timestamp horaAtualizacao = Timestamp.from(Instant.now());
            
            Passageiro p = new Passageiro(passageiroId);
            
            listaPassageiros.add(new StatusPassageiro(viagem,p,1, horaAtualizacao));
            
            JLabel passageiroLabel = new JLabel(passageiroNome);
            jPPassageiros.add(passageiroLabel);
            jPPassageiros.revalidate();
            jPPassageiros.repaint();
        }
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFOrigem = new javax.swing.JTextField();
        jTFDestino = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jCBMotorista = new javax.swing.JComboBox<>();
        jBCancelar = new javax.swing.JButton();
        jBVoltar = new javax.swing.JButton();
        jCBStatus = new javax.swing.JComboBox<>();
        jCBPassageiro = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jBAdicionarPassageiro = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTPassageiros = new javax.swing.JTable();
        jBExcluirP = new javax.swing.JButton();
        jTFSaida = new javax.swing.JFormattedTextField();
        jTFRetorno = new javax.swing.JFormattedTextField();
        jTFData = new javax.swing.JFormattedTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 150, 105));
        jLabel1.setText("Viagem");

        jTFOrigem.setToolTipText("");
        jTFOrigem.setSelectionColor(new java.awt.Color(5, 150, 105));

        jLabel2.setText("Origem");

        jLabel3.setText("Destino");

        jLabel4.setText("Data");

        jLabel5.setText("Motorista");

        jLabel6.setText("Saída");

        jLabel7.setText("Retorno");

        jBSalvar.setBackground(new java.awt.Color(5, 150, 105));
        jBSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jCBMotorista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBMotoristaActionPerformed(evt);
            }
        });

        jBCancelar.setBackground(new java.awt.Color(5, 150, 105));
        jBCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBVoltar.setBackground(new java.awt.Color(5, 150, 105));
        jBVoltar.setForeground(new java.awt.Color(255, 255, 255));
        jBVoltar.setIcon(new javax.swing.ImageIcon("/home/murilocost4/Downloads/arrow-left.png")); // NOI18N
        jBVoltar.setText("Voltar");
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });

        jCBStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Iniciado", "Iniciado", "Finalizado" }));

        jCBPassageiro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Passageiros");

        jBAdicionarPassageiro.setForeground(new java.awt.Color(5, 150, 105));
        jBAdicionarPassageiro.setText("Adicionar");
        jBAdicionarPassageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicionarPassageiroActionPerformed(evt);
            }
        });

        jLabel9.setText("Status da Viagem");

        jTPassageiros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTPassageiros);

        jBExcluirP.setForeground(new java.awt.Color(5, 150, 105));
        jBExcluirP.setText("Excluir");
        jBExcluirP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCBStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTFDestino, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCBMotorista, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(158, 158, 158))
                            .addComponent(jLabel5))
                        .addGap(313, 313, 313))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTFSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jTFRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTFOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jCBPassageiro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBExcluirP)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBAdicionarPassageiro))
                                .addComponent(jLabel8))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBExcluirP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCBPassageiro)
                            .addComponent(jBAdicionarPassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jTFRetorno)
                            .addComponent(jTFData))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(24, 24, 24)
                        .addComponent(jCBMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(57, 57, 57))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed

        
        if (jTFOrigem.equals("")) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo Origem");
            jTFOrigem.requestFocus();
        } else if (jTFDestino.equals("")) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo Destino");
            jTFDestino.requestFocus();
        } else if (jTFData == null) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo Data");
            jTFData.requestFocus();
        } else if (jTFSaida == null) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo Saida");
            jTFSaida.requestFocus();
        } else if (jTFRetorno == null) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo Retorno");
            jTFRetorno.requestFocus();
        } else {
            ComboboxMotorista motorista = (ComboboxMotorista) jCBMotorista.getSelectedItem();
            int codCondutor = motorista.getKey();
            System.out.println("Condutor: "+codCondutor);
            Viagem v = new Viagem(jTFOrigem.getText(), jTFDestino.getText(), jTFData.getText(), jTFSaida.getText(), jTFRetorno.getText(), jCBStatus.getSelectedIndex(), codCondutor);
            
            
            
            boolean ok = false;
            
            // Criação da viagem
            
                
            if (codigo == -1) {
                int idGerado = Principal.ccont.viagemInserir(v);
                if (idGerado != 0) {
                    ok = true;
                    for (Passageiro p : listaPassageiros) {
                        Timestamp horaAtualizacao = Timestamp.from(Instant.now());
                        StatusPassageiro statusPassageiro = new StatusPassageiro(idGerado, p, 0, horaAtualizacao);
                        Principal.ccont.statusPassageiroInserir(statusPassageiro);
                        spLista.add(statusPassageiro);
                    }
                   v.setStatusPassageiros(spLista);
                   
                   Principal.ccont.viagemAlterar(v);
                }
                
            } else {
                v.setTrip_id(codigo);
                    for (Passageiro p : listaPassageiros) {
                        Timestamp horaAtualizacao = Timestamp.from(Instant.now());
                        StatusPassageiro statusPassageiro = new StatusPassageiro(codigo, p, 0, horaAtualizacao);
                        Principal.ccont.statusPassageiroInserir(statusPassageiro);
                        spLista.add(statusPassageiro);
                    }
                   v.setStatusPassageiros(spLista);
                ok = Principal.ccont.viagemAlterar(v);
                
                
            }
            
            if (!ok) {
                JOptionPane.showMessageDialog(this,
                    "Ocorreu um  erro",
                    this.getTitle(),
                    JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Viagem salva com sucesso",
                    this.getTitle(),
                    JOptionPane.INFORMATION_MESSAGE);
                jTFOrigem.requestFocus();
                jTFOrigem.setText("");
                jTFDestino.setText("");
                jTFData.setText("");
                jTFSaida.setText("");
                jTFRetorno.setText("");
            }
            this.dispose();
            
    }
        
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jCBMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBMotoristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBMotoristaActionPerformed

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed

    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBAdicionarPassageiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdicionarPassageiroActionPerformed
        
        if (jCBPassageiro != null && jCBPassageiro.getSelectedItem() != null) {
            ComboboxPassageiro passageiroSelecionado = (ComboboxPassageiro) jCBPassageiro.getSelectedItem();
            int passageiroId = passageiroSelecionado.getKey();
            String passageiroNome = passageiroSelecionado.toString();
            Passageiro p = new Passageiro(passageiroId, passageiroNome);
            
            if (listaPassageiros.contains(p)) {
                JOptionPane.showMessageDialog(rootPane, "Erro: Passageiro já inserido nesta viagem");
                atualizaTabela();
                
            } else {
                listaPassageiros.add(p);
                atualizaTabela();
            }
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro: Selecione o Passageiro");
        }
        
        
        /*if (jCBPassageiro != null && jCBPassageiro.getSelectedItem() != null) {
        // Obtém o item selecionado do combo box
        ComboboxPassageiro passageiroSelecionado = (ComboboxPassageiro) jCBPassageiro.getSelectedItem();

        // Usa getKey() para obter o ID do passageiro
        int passageiroId = passageiroSelecionado.getKey();
        String passageiroNome = passageiroSelecionado.toString(); // toString retorna o nome


        Passageiro p = new Passageiro(passageiroId, passageiroNome);
        
        // Adiciona à lista local
        listaPassageiros.add(p);
        }*/
    }//GEN-LAST:event_jBAdicionarPassageiroActionPerformed

    private void jBExcluirPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirPActionPerformed
        if (jTPassageiros.getSelectedRow() >= 0) {
            if (JOptionPane.showConfirmDialog(this,
                "Tem certeza de que deseja excluir?",
                this.getTitle(),
                JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION) {

            Passageiro p = passageiroModel.getPassageiro(jTPassageiros.getSelectedRow());
            if (p != null) {
                listaPassageiros.remove(p);
                Timestamp horaAtualizacao = Timestamp.from(Instant.now());
                StatusPassageiro sp = new StatusPassageiro(codigo, p, 1, horaAtualizacao);
                Principal.ccont.excluirStatusPassageiro(sp);
                atualizaTabela();
            }
        }
        }
    }//GEN-LAST:event_jBExcluirPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadViagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadViagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadViagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadViagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadViagens().setVisible(true);
            }
        });
    }

    void setModal(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdicionarPassageiro;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBExcluirP;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JComboBox<String> jCBMotorista;
    private javax.swing.JComboBox<String> jCBPassageiro;
    private javax.swing.JComboBox<String> jCBStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField jTFData;
    private javax.swing.JTextField jTFDestino;
    private javax.swing.JTextField jTFOrigem;
    private javax.swing.JFormattedTextField jTFRetorno;
    private javax.swing.JFormattedTextField jTFSaida;
    private javax.swing.JTable jTPassageiros;
    // End of variables declaration//GEN-END:variables
}
