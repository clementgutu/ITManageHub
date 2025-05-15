package vue;
import javax.swing.*;
import java.awt.event.*;
import modele.Modele;
import controleur.User;

public class VueConnexion extends JFrame {
    private JTextField txtEmail = new JTextField();
    private JPasswordField txtMdp = new JPasswordField();
    private JButton btnConnexion = new JButton("Connexion");

    public VueConnexion() {
        this.setTitle("Connexion");
        this.setSize(300, 200);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création des labels et champs de saisie
        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setBounds(20, 30, 80, 20);
        txtEmail.setBounds(100, 30, 150, 20);

        JLabel lblMdp = new JLabel("Mot de passe :");
        lblMdp.setBounds(20, 60, 100, 20);
        txtMdp.setBounds(120, 60, 130, 20);

        btnConnexion.setBounds(100, 100, 100, 30);

        // Ajout des éléments à la fenêtre
        this.add(lblEmail);
        this.add(txtEmail);
        this.add(lblMdp);
        this.add(txtMdp);
        this.add(btnConnexion);

        this.setVisible(true);

        // Action du bouton "Connexion"
        btnConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Récupération des valeurs saisies par l'utilisateur
                String email = txtEmail.getText();
                String mdp = new String(txtMdp.getPassword());

                // Vérification dans la BDD via le modèle
                User user = Modele.VerifConnexion(email, mdp);

                if (user != null) {
                    // Si l'utilisateur existe, message de bienvenue
                    JOptionPane.showMessageDialog(null, "Bienvenue " + user.getNom() + "  " +user.getPrenom());
                    dispose(); // ferme la fenêtre de connexion
                    new VuePrincipal(user).setVisible(true); // ouvre la vue principale
                    // TODO : ici tu peux lancer une autre vue (menu, tableau de bord, etc.)
                } else {
                    // Sinon, message d'erreur
                    JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrect");
                }
            }
        });
    }
}