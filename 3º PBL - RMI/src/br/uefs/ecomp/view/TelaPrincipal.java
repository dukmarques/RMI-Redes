package br.uefs.ecomp.view;

//  @author Eduardo

import br.uefs.ecomp.controller.ClienteController;
import br.uefs.ecomp.model.Produto;
import br.uefs.ecomp.util.ManipularArquivo;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaPrincipal extends javax.swing.JFrame {
    private ClienteController c = new ClienteController();
    private LinkedList<Produto> itens = new LinkedList<>();
    private LinkedList<Produto> carro = new LinkedList<>();
    
    public TelaPrincipal() {
        initComponents();
        listarItens();
    }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JTable();
        comprar = new javax.swing.JButton();
        carrinho = new javax.swing.JButton();
        verCarrinho = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RMI");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/icons/Logo-e-commerce-good (3).png"))); // NOI18N

        lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Valor", "Serial"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lista.setSelectionBackground(new java.awt.Color(255, 153, 51));
        lista.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(lista);
        if (lista.getColumnModel().getColumnCount() > 0) {
            lista.getColumnModel().getColumn(0).setResizable(false);
            lista.getColumnModel().getColumn(0).setPreferredWidth(300);
            lista.getColumnModel().getColumn(1).setResizable(false);
            lista.getColumnModel().getColumn(2).setResizable(false);
            lista.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        comprar.setBackground(new java.awt.Color(0, 153, 0));
        comprar.setForeground(new java.awt.Color(255, 255, 255));
        comprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/icons/carCompra.png"))); // NOI18N
        comprar.setText("Comprar");
        comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarActionPerformed(evt);
            }
        });

        carrinho.setBackground(new java.awt.Color(255, 102, 0));
        carrinho.setForeground(new java.awt.Color(255, 255, 255));
        carrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/icons/car.png"))); // NOI18N
        carrinho.setText("Por no Carrinho");
        carrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carrinhoActionPerformed(evt);
            }
        });

        verCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/icons/car.png"))); // NOI18N
        verCarrinho.setText("(0)");
        verCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCarrinhoActionPerformed(evt);
            }
        });

        atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/icons/refresh.png"))); // NOI18N
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(carrinho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(verCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verCarrinho)
                    .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carrinho)
                    .addComponent(comprar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void carrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carrinhoActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) lista.getModel();
        
        if (lista.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Porfavor, selecione um produto.", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }else{
            carro.add(getItem(lista.getValueAt(lista.getSelectedRow(), 0).toString()));
            verCarrinho.setText("("+carro.size()+")");
        }
    }//GEN-LAST:event_carrinhoActionPerformed

    private void verCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCarrinhoActionPerformed
        Carrinho carro = new Carrinho(this, true, this.carro);
        carro.setVisible(true);
        verCarrinho.setText("("+this.carro.size()+")");
    }//GEN-LAST:event_verCarrinhoActionPerformed

    private void comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) lista.getModel();
        
        if (lista.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Porfavor, selecione um produto.", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Compra realizada com sucesso! \nProduto Comprado: "+lista.getValueAt(lista.getSelectedRow(), 0), "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_comprarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        listarItens();
    }//GEN-LAST:event_atualizarActionPerformed

    public void listarItens(){
        try {
            DefaultTableModel tabela  = (DefaultTableModel) lista.getModel();
            
            itens = c.getItens();
            
            if (itens == null) {
                JOptionPane.showMessageDialog(null, "Não foi possível buscar os produtos", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            tabela.setRowCount(0);
            
            Iterator itr = itens.iterator();
            while (itr.hasNext()) {
                Produto p = (Produto) itr.next();
                tabela.addRow(p.info());
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
    }
    
    public Produto getItem(String s){
        Iterator itr = itens.iterator();
        while (itr.hasNext()) {
            Produto p = (Produto) itr.next();
            if (p.getNome().equals(s)) {
                return p;
            }
        }
        verCarrinho.setText("("+carro.size()+")");
        return null;
    }
    
    public void disableButtons(boolean key){
        carrinho.setEnabled(key);
        comprar.setEnabled(key);
   }
    
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton carrinho;
    private javax.swing.JButton comprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lista;
    private javax.swing.JButton verCarrinho;
    // End of variables declaration//GEN-END:variables
}
