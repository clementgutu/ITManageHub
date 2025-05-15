package vue;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.User;
import modele.Modele;

public class PanelProfil extends JPanel {

    private JTextField txtNom;
    private JTextField txtPrenom;
    private JTextField txtEmail;
    private JLabel lblRole;
    private JButton btnModifier;

    private User userConnecte;

    public PanelProfil(User user) {
        this.userConnecte = user;
        
        this.setLayout(null); // pour positionner à la main
        this.setBackground(Color.WHITE);

        JLabel lblTitre = new JLabel("Mon Profil");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitre.setBounds(250, 10, 200, 30);
        this.add(lblTitre);

        JLabel lblNom = new JLabel("Nom :");
        lblNom.setBounds(100, 80, 100, 25);
        this.add(lblNom);

        txtNom = new JTextField(user.getNom());
        txtNom.setBounds(200, 80, 200, 25);
        this.add(txtNom);

        JLabel lblPrenom = new JLabel("Prénom :");
        lblPrenom.setBounds(100, 120, 100, 25);
        this.add(lblPrenom);

        txtPrenom = new JTextField(user.getPrenom());
        txtPrenom.setBounds(200, 120, 200, 25);
        this.add(txtPrenom);

        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setBounds(100, 160, 100, 25);
        this.add(lblEmail);

        txtEmail = new JTextField(user.getEmail());
        txtEmail.setBounds(200, 160, 200, 25);
        this.add(txtEmail);

        JLabel lblRoleLabel = new JLabel("Role :");
        lblRoleLabel.setBounds(100, 200, 100, 25);
        this.add(lblRoleLabel);

        lblRole = new JLabel(user.getRole());
        lblRole.setBounds(200, 200, 200, 25);
        this.add(lblRole);

        btnModifier = new JButton("Modifier");
        btnModifier.setBounds(200, 250, 100, 30);
        this.add(btnModifier);

        // Tu pourras ici ajouter l'action pour mettre à jour si besoin plus tard
        btnModifier.addActionListener(e -> {
            String nouveauNom = txtNom.getText();
            String nouveauPrenom = txtPrenom.getText();
            String nouvelEmail = txtEmail.getText();
            
            // Appeler le modèle pour mettre à jour en BDD
            Modele.ProfilUpdate(userConnecte.getIduser(), nouveauNom, nouveauPrenom, nouvelEmail);

            // Mettre à jour l'objet utilisateur en local aussi
            userConnecte.setNom(nouveauNom);
            userConnecte.setPrenom(nouveauPrenom);
            userConnecte.setEmail(nouvelEmail);
            
            // Appeler ton modèle pour sauvegarder ces infos dans la BDD
            JOptionPane.showMessageDialog(this, "Profil mis à jour !");
        });
    }
}