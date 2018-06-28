package br.uefs.ecomp.view;

import br.uefs.ecomp.controller.ClienteController;
import br.uefs.ecomp.model.Produto;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Carrinho extends javax.swing.JDialog {
    private ClienteController c;
    private LinkedList<Produto> itens;
    private String nomeLoja;
    
    public Carrinho(java.awt.Frame parent, boolean modal, ClienteController c, LinkedList<Produto> itens, String nomeLoja) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/icons/car.png")).getImage());
        this.c = c;
        this.itens = itens;
        this.nomeLoja = nomeLoja;
        
        if (this.itens.isEmpty()) {
            disableButtons(false);
        }else{
            listarItens();
        }
    }
    
    public Carrinho(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        remover = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JTable();
        aviso = new javax.swing.JLabel();
        custoTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Meu Carrinho");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/icons/carrinho.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Itens no Carrinho");

        remover.setBackground(new java.awt.Color(255, 0, 0));
        remover.setForeground(new java.awt.Color(255, 255, 255));
        remover.setText("Remover Produto");
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        finalizar.setBackground(new java.awt.Color(0, 153, 0));
        finalizar.setForeground(new java.awt.Color(255, 255, 255));
        finalizar.setText("Finalizar Compra");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        lista.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(lista);
        if (lista.getColumnModel().getColumnCount() > 0) {
            lista.getColumnModel().getColumn(0).setResizable(false);
            lista.getColumnModel().getColumn(1).setResizable(false);
            lista.getColumnModel().getColumn(1).setPreferredWidth(20);
            lista.getColumnModel().getColumn(2).setResizable(false);
            lista.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        aviso.setForeground(new java.awt.Color(255, 0, 0));
        aviso.setText("Você não possui nenhum produto no carrinho");

        custoTotal.setText("Total R$: 0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(remover)
                                .addGap(18, 18, 18)
                                .addComponent(finalizar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(aviso))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(custoTotal)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aviso)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(custoTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(remover)
                    .addComponent(finalizar, javax.swing.GroupLayout.Alignment.TRAILING))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        if (lista.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Porfavor, selecione um produto!", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }else{
            int remove = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o produto " + lista.getValueAt(lista.getSelectedRow(), 0) + " do carrinho?",
                    "Confirmação de remoção", JOptionPane.YES_NO_CANCEL_OPTION);
            
            if (remove == JOptionPane.YES_OPTION) {
                Produto p = getItem(lista.getValueAt(lista.getSelectedRow(), 0).toString());

                Iterator itr = itens.iterator();
                while (itr.hasNext()) {
                    Produto prd = (Produto) itr.next();
                    if (prd.getNome().equals(p.getNome())) {
                        itens.remove(prd);
                        break;
                    }
                }
                listarItens();
            }
        }
    }//GEN-LAST:event_removerActionPerformed

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        LinkedList<Produto> naoComprados = new LinkedList<>();
        LinkedList<Produto> comprados = new LinkedList<>();
        
        int result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja comprar os seguintes itens: " + listaProdutos(itens),
                "Confirmação de compra",JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (result == JOptionPane.YES_OPTION) {
            Iterator itr = itens.iterator();

            while (itr.hasNext()) {
                Produto p = (Produto) itr.next();
                boolean compra = c.comprarItem(nomeLoja, p.getSerial());

                if (compra) {
                    comprados.add(p);
                }else{
                    naoComprados.add(p);
                }
            }
            itens.clear();

            if (!naoComprados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Esse(s) produto(s) não foram comprados pois não estão mais disponiveis:" + listaProdutos(naoComprados),
                        "Atenção", JOptionPane.ERROR_MESSAGE);
            }
            if (!comprados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Itens comprados: " + listaProdutos(comprados),
                        "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            }
            listarItens();
        }else{
            JOptionPane.showMessageDialog(null, "Compra Cancelada! \nProdutos permanecem no carrinho de compras!", 
                    "Compra Cancelada", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_finalizarActionPerformed

    public void listarItens(){
        DefaultTableModel tabela = (DefaultTableModel) lista.getModel();
        tabela.setRowCount(0);
        float valorTotal = 0;
        
        Iterator itr = itens.iterator();
        while (itr.hasNext()) {
            Produto p = (Produto) itr.next();
            valorTotal += p.getValor();
            tabela.addRow(p.info());
        }
        
        custoTotal.setText("Total R$: "+valorTotal);
        if (this.itens.size() == 0) {
            disableButtons(false);
        }else{
            disableButtons(true);
        }
    }
    
    private Produto getItem(String s){
        Iterator itr = itens.iterator();
        while (itr.hasNext()) {
            Produto p = (Produto) itr.next();
            if (p.getNome().equals(s)) {
                return p;
            }
        }
        return null;
    }
    
    private String listaProdutos(LinkedList<Produto> produtos){
        String pdts = "";
        Iterator itr = produtos.iterator();
        
        while (itr.hasNext()) {
            Produto p = (Produto) itr.next();
            pdts = pdts+"\n"+p.getNome();
        }
        return pdts;
    }
    
    public void disableButtons(boolean key){
        aviso.setVisible(!key);
        remover.setEnabled(key);
        finalizar.setEnabled(key);
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
            java.util.logging.Logger.getLogger(Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Carrinho dialog = new Carrinho(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aviso;
    private javax.swing.JLabel custoTotal;
    private javax.swing.JButton finalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lista;
    private javax.swing.JButton remover;
    // End of variables declaration//GEN-END:variables
}
