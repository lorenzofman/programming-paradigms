import javax.swing.JTextArea;

/**
 *
 * @author andrea
 */
class ThreadDemoSwing extends javax.swing.JFrame implements AppendableView {
  
  private ThreadController controller = null;
  
  /** Creates new form ThreadDemo */
  public ThreadDemoSwing() {
    initComponents();
    controller = new ThreadController(this);
  }
  
  /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    
    jScrollPane1 = new javax.swing.JScrollPane();
    textArea0 = new javax.swing.JTextArea();
    jScrollPane2 = new javax.swing.JScrollPane();
    textArea1 = new javax.swing.JTextArea();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    buttonRun1 = new javax.swing.JButton();
    buttonStop1 = new javax.swing.JButton();
    buttonStop0 = new javax.swing.JButton();
    buttonRun0 = new javax.swing.JButton();
    
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    
    textArea0.setColumns(20);
    textArea0.setEditable(false);
    textArea0.setRows(5);
    jScrollPane1.setViewportView(textArea0);
    
    textArea1.setColumns(20);
    textArea1.setEditable(false);
    textArea1.setRows(5);
    jScrollPane2.setViewportView(textArea1);
    
    jLabel1.setText("Thread1");
    
    jLabel2.setText("Thread0");
    
    buttonRun1.setText("Run");
    buttonRun1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonRun1ActionPerformed(evt);
      }
    });
    
    buttonStop1.setText("Stop");
    buttonStop1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonStop1ActionPerformed(evt);
      }
    });
    
    buttonStop0.setText("Stop");
    buttonStop0.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonStop0ActionPerformed(evt);
      }
    });
    
    buttonRun0.setText("Run");
    buttonRun0.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonRun0ActionPerformed(evt);
      }
    });
    
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
                              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(buttonRun0)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(buttonStop0)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(buttonRun1)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(buttonStop1)))
                                            .addGap(12, 12, 12))
                             );
    
    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonRun1, buttonStop1});
    
    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                      .addComponent(jLabel2)
                                                      .addComponent(jLabel1))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                      .addComponent(jScrollPane2)
                                                      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                  .addComponent(buttonStop0)
                                                                  .addComponent(buttonRun0))
                                                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                  .addComponent(buttonStop1)
                                                                  .addComponent(buttonRun1)))
                                          .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                           );
    
    pack();
  }// </editor-fold>//GEN-END:initComponents
  
  private void buttonStop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStop1ActionPerformed
    controller.stopThread(1);
    
  }//GEN-LAST:event_buttonStop1ActionPerformed
  
  private void buttonStop0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStop0ActionPerformed
    controller.stopThread(0);
    
  }//GEN-LAST:event_buttonStop0ActionPerformed
  
  private void buttonRun0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRun0ActionPerformed
    controller.runThread(0);
  }//GEN-LAST:event_buttonRun0ActionPerformed
  
  private void buttonRun1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRun1ActionPerformed
    controller.runThread(1);
  }//GEN-LAST:event_buttonRun1ActionPerformed
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      
      public void run() {
        new ThreadDemoSwing().setVisible(true);
        
        
      }
    });
    
    
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonRun0;
  private javax.swing.JButton buttonRun1;
  private javax.swing.JButton buttonStop0;
  private javax.swing.JButton buttonStop1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextArea textArea0;
  private javax.swing.JTextArea textArea1;
  // End of variables declaration//GEN-END:variables
  
  
  public SwingAppendableText getTextArea(int threadId) {
    if (threadId == 0) {
      return new SwingAppendableText(textArea0);
    }
    if (threadId == 1) {
      return new SwingAppendableText(textArea1);
    }
    return null;
  }
  
  public void setRunning(int threadId) {
    if (threadId == 0) {
      textArea0.setText("");
      buttonRun0.setEnabled(false);
      buttonStop0.setEnabled(true);
    }
    if (threadId == 1) {
      textArea1.setText("");
      buttonRun1.setEnabled(false);
      buttonStop1.setEnabled(true);
    }
  }
  
  public void setStopped(int threadId) {
    if (threadId == 0) {
      buttonRun0.setEnabled(true);
      buttonStop0.setEnabled(false);
    }
    if (threadId == 1) {
      buttonRun1.setEnabled(true);
      buttonStop1.setEnabled(false);
    }
  }
  
}

class SwingAppendableText implements AppendableText {
  private JTextArea textArea;
  
  public SwingAppendableText(JTextArea textArea) {
    this.textArea = textArea;
  }
  
  @Override
  public void append(final String s) {
    textArea.append(s);
  }
  
}