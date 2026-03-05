package dao;

import model.Employeur;
import model.Employe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeurDAO {

    public void ajouterEmployeur(Employeur e) {
        // SQL correspond à tes colonnes : raisonSociale, secteurActivite
        String sql = "INSERT INTO employeurs (raisonSociale, secteurActivite) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getRaisonSociale());
            ps.setString(2, e.getSecteurActivite());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Employeur> consulterListeDesEmployeurs() {
        List<Employeur> liste = new ArrayList<>();
        String sql = "SELECT * FROM employeurs";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Employeur emp = new Employeur(
                        rs.getInt("id"),
                        rs.getString("raisonSociale"),
                        rs.getString("secteurActivite")
                );
                liste.add(emp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return liste;
    }

    public Employeur consulterEmployeur(int id) {
        String sql = "SELECT * FROM employeurs WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Employeur(
                        rs.getInt("id"),
                        rs.getString("raisonSociale"),
                        rs.getString("secteurActivite")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void associerEmployes(Employeur employeur) {
        String sql = "SELECT * FROM employes WHERE employeur_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, employeur.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employe e = new Employe();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setSalaireMensuel(rs.getDouble("salaireMensuel"));

                employeur.getEmployes().add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}