/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.ingest;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JMenuItem;
import org.openide.util.Lookup;
import org.sleuthkit.autopsy.corecomponentinterfaces.BlackboardResultViewer;
import org.sleuthkit.autopsy.ingest.IngestMessagePanel.IngestMessageGroup;
import org.sleuthkit.datamodel.BlackboardArtifact;

/**
 * Details panel within IngestMessagePanel
 */
class IngestMessageDetailsPanel extends javax.swing.JPanel {

    private IngestMessageMainPanel mainPanel;

    /** Creates new form IngestMessageDetailsPanel */
    IngestMessageDetailsPanel(IngestMessageMainPanel mainPanel) {
        this.mainPanel = mainPanel;
        initComponents();
        customizeComponents();
    }

    private void customizeComponents() {
        messageDetailsPane.setContentType("text/html");
        viewArtifactButton.setEnabled(false);
        viewContentButton.setEnabled(false);
        BlackboardResultViewer v = Lookup.getDefault().lookup(BlackboardResultViewer.class);
        v.addOnFinishedListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals(BlackboardResultViewer.FINISHED_DISPLAY_EVT)) {
                   // SwingUtilities.invokeLater(new Runnable() {
                     //   @Override
                       // public void run() {
                            artifactViewerFinished();
                        //}
                        
                   
                    //});
                }
            }
            
        });
        
        
        //right click
        messageDetailsPane.setComponentPopupMenu(rightClickMenu);
        ActionListener actList = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JMenuItem jmi = (JMenuItem) e.getSource();
                if(jmi.equals(copyMenuItem))
                    messageDetailsPane.copy();
                else if(jmi.equals(selectAllMenuItem))
                    messageDetailsPane.selectAll();
            }
        };
        copyMenuItem.addActionListener(actList);
        selectAllMenuItem.addActionListener(actList);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rightClickMenu = new javax.swing.JPopupMenu();
        copyMenuItem = new javax.swing.JMenuItem();
        selectAllMenuItem = new javax.swing.JMenuItem();
        backButton = new javax.swing.JButton();
        viewContentButton = new javax.swing.JButton();
        viewArtifactButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageDetailsPane = new javax.swing.JTextPane();

        copyMenuItem.setText(org.openide.util.NbBundle.getMessage(IngestMessageDetailsPanel.class, "IngestMessageDetailsPanel.copyMenuItem.text")); // NOI18N
        rightClickMenu.add(copyMenuItem);

        selectAllMenuItem.setText(org.openide.util.NbBundle.getMessage(IngestMessageDetailsPanel.class, "IngestMessageDetailsPanel.selectAllMenuItem.text")); // NOI18N
        rightClickMenu.add(selectAllMenuItem);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/ingest/btn_step_back.png"))); // NOI18N
        backButton.setText(org.openide.util.NbBundle.getMessage(IngestMessageDetailsPanel.class, "IngestMessageDetailsPanel.backButton.text")); // NOI18N
        backButton.setAlignmentY(0.0F);
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        backButton.setMaximumSize(new java.awt.Dimension(23, 23));
        backButton.setMinimumSize(new java.awt.Dimension(23, 23));
        backButton.setPreferredSize(new java.awt.Dimension(23, 23));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        viewContentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/ingest/goto_dir.png"))); // NOI18N
        viewContentButton.setText(org.openide.util.NbBundle.getMessage(IngestMessageDetailsPanel.class, "IngestMessageDetailsPanel.viewContentButton.text")); // NOI18N
        viewContentButton.setAlignmentY(0.0F);
        viewContentButton.setBorder(null);
        viewContentButton.setIconTextGap(2);
        viewContentButton.setMargin(new java.awt.Insets(0, 2, 0, 2));
        viewContentButton.setPreferredSize(new java.awt.Dimension(111, 23));
        viewContentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewContentButtonActionPerformed(evt);
            }
        });

        viewArtifactButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/ingest/goto_res.png"))); // NOI18N
        viewArtifactButton.setText(org.openide.util.NbBundle.getMessage(IngestMessageDetailsPanel.class, "IngestMessageDetailsPanel.viewArtifactButton.text")); // NOI18N
        viewArtifactButton.setAlignmentY(0.0F);
        viewArtifactButton.setBorder(null);
        viewArtifactButton.setIconTextGap(2);
        viewArtifactButton.setMargin(new java.awt.Insets(0, 2, 0, 2));
        viewArtifactButton.setPreferredSize(new java.awt.Dimension(93, 23));
        viewArtifactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewArtifactButtonActionPerformed(evt);
            }
        });

        messageDetailsPane.setBackground(new java.awt.Color(221, 221, 235));
        messageDetailsPane.setBorder(null);
        messageDetailsPane.setContentType(org.openide.util.NbBundle.getMessage(IngestMessageDetailsPanel.class, "IngestMessageDetailsPanel.messageDetailsPane.contentType")); // NOI18N
        messageDetailsPane.setFont(new java.awt.Font("Tahoma", 0, 10));
        messageDetailsPane.setToolTipText(org.openide.util.NbBundle.getMessage(IngestMessageDetailsPanel.class, "IngestMessageDetailsPanel.messageDetailsPane.toolTipText")); // NOI18N
        jScrollPane1.setViewportView(messageDetailsPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(viewArtifactButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewContentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(viewContentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewArtifactButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewContentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewContentButtonActionPerformed
        viewContent(evt);
    }//GEN-LAST:event_viewContentButtonActionPerformed

    private void viewArtifactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewArtifactButtonActionPerformed
        viewArtifact(evt);
    }//GEN-LAST:event_viewArtifactButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        mainPanel.showMessages();
    }//GEN-LAST:event_backButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane messageDetailsPane;
    private javax.swing.JPopupMenu rightClickMenu;
    private javax.swing.JMenuItem selectAllMenuItem;
    private javax.swing.JButton viewArtifactButton;
    private javax.swing.JButton viewContentButton;
    // End of variables declaration//GEN-END:variables

    private void viewArtifact(java.awt.event.ActionEvent evt) {
        artifactViewerInvoked();
        
        final IngestMessageGroup messageGroup = mainPanel.getMessagePanel().getSelectedMessage();
        if (messageGroup != null) {
            BlackboardArtifact art = messageGroup.getData();
            if (art != null) {
                BlackboardResultViewer v = Lookup.getDefault().lookup(BlackboardResultViewer.class);
                v.viewArtifact(art);
            }
        }

    }

    private void viewContent(java.awt.event.ActionEvent evt) {
        artifactViewerInvoked();
        
        final IngestMessageGroup messageGroup = mainPanel.getMessagePanel().getSelectedMessage();
        if (messageGroup != null) {
            BlackboardArtifact art = messageGroup.getData();
            if (art != null) {
                BlackboardResultViewer v = Lookup.getDefault().lookup(BlackboardResultViewer.class);
                v.viewArtifactContent(art);
            }
        }
    }
    
    private void artifactViewerInvoked() {
        //viewArtifactButton.setEnabled(false);
        //viewContentButton.setEnabled(false);
        messageDetailsPane.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
   
    }
    
    private void artifactViewerFinished() {
        //viewArtifactButton.setEnabled(true);
        //viewContentButton.setEnabled(true);
        messageDetailsPane.setCursor(null);
    }

    void showDetails(int rowNumber) {
        final IngestMessageGroup messageGroup = mainPanel.getMessagePanel().getMessageGroup(rowNumber);
        if (messageGroup != null) {
            String details = messageGroup.getDetails();
            if (details != null) {
                StringBuilder b = new StringBuilder();
                b.append("<html>");
                b.append("<head>");
                b.append("<style type='text/css'>");
                b.append("table {table-layout:fixed;}");
                b.append("td {font-family:Arial;font-size:10pt;white-space:pre-wrap;overflow:hidden;}");
                b.append("th {font-family:Arial;font-size:10pt;font-weight:bold;}");
                b.append("p {font-family:Arial;font-size:10pt;}");
                b.append("</style>");
                b.append("</head>");
                b.append(details).append("</html>");
                this.messageDetailsPane.setText(b.toString());
            } else {
                this.messageDetailsPane.setText("");
            }
            //show artifact/content only for a message group with a single message
            if (messageGroup.getData() != null && messageGroup.getCount() == 1) {
                viewArtifactButton.setEnabled(true);
                viewContentButton.setEnabled(true);
            } else {
                viewArtifactButton.setEnabled(false);
                viewContentButton.setEnabled(false);
            }
        } else {
            viewArtifactButton.setEnabled(false);
            viewContentButton.setEnabled(false);
            messageDetailsPane.setText("");
        }
    }
}
