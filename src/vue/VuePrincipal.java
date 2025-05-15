package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controleur.User;

public class VuePrincipal extends JFrame {
    
    private JPanel panelMenu = new JPanel();
    private JPanel panelContenu = new JPanel();
    private User userConnecte;

    public VuePrincipal(User user) {
        this.userConnecte = user;
        
        this.setTitle("ITManageHub - Tableau de bord");
        this.setSize(900, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        // Menu
        panelMenu.setBounds(10, 10, 200, 640);
        panelMenu.setLayout(new GridLayout(5, 1, 10, 10)); // 5 boutons
        panelMenu.setBackground(Color.LIGHT_GRAY);

        JButton btnAccueil = new JButton("Accueil");
        JButton btnProfil = new JButton("Profil");
        JButton btnEquipements = new JButton("Équipements");
        JButton btnDeconnexion = new JButton("Déconnexion");

        panelMenu.add(btnAccueil);
        panelMenu.add(btnProfil);
        panelMenu.add(btnEquipements);
        panelMenu.add(btnDeconnexion);

        // Contenu
        panelContenu.setBounds(220, 10, 650, 640);
        panelContenu.setLayout(new BorderLayout());

        // Afficher par défaut l'accueil
        showPanel(new PanelPrincipal("Bienvenue sur ITManageHub !"));

        // Actions des boutons
        btnAccueil.addActionListener(e -> showPanel(new PanelPrincipal("Bienvenue sur ITManageHub !")));
        btnProfil.addActionListener(e -> showPanel(new PanelProfil(userConnecte)));
        btnEquipements.addActionListener(e -> showPanel(new PanelEquipements()));
        btnDeconnexion.addActionListener(e -> {
            dispose(); // ferme la fenetre principale
            new VueConnexion(); // relance connexion
        });

        // Ajout dans la JFrame
        this.add(panelMenu);
        this.add(panelContenu);
    }

    private void showPanel(JPanel panel) {
        panelContenu.removeAll();
        panelContenu.add(panel, BorderLayout.CENTER);
        panelContenu.revalidate();
        panelContenu.repaint();
    }
}