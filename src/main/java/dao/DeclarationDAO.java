package dao;

import model.Declaration;
import model.Employe;
import model.Cotisation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeclarationDAO {

    public void creerDeclaration(Declaration dec) {
        String sql = "INSERT INTO declarations (annee, mois, dateDeclaration, employeur_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, dec.getAnnee());
            ps.setInt(2, dec.getMois());
            ps.setDate(3, java.sql.Date.valueOf(dec.getDateDeclaration()));
            ps.setInt(4, dec.getEmployeur().getId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dec.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verifierUniciteDeDeclaration(int employeurId, int mois, int annee) {
        String sql = "SELECT COUNT(*) FROM declarations WHERE employeur_id = ? AND mois = ? AND annee = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, employeurId);
            ps.setInt(2, mois);
            ps.setInt(3, annee);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void ajouterSalaires(Declaration dec) {
        String sqlSelect = "SELECT id, salaireMensuel FROM employes WHERE employeur_id = ?";
        CotisationDAO cotisDAO = new CotisationDAO();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sqlSelect)) {

            ps.setInt(1, dec.getEmployeur().getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employe e = new Employe();
                e.setId(rs.getInt("id"));
                e.setSalaireMensuel(rs.getDouble("salaireMensuel"));

                Cotisation c = cotisDAO.calculCotisation(e);
                c.setDeclaration(dec);

                cotisDAO.enregistrerCotisationEnBase(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Declaration consulterDeclaration(int id) {
        String sql = "SELECT * FROM declarations WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Declaration d = new Declaration();
                d.setId(rs.getInt("id"));
                d.setAnnee(rs.getInt("annee"));
                d.setMois(rs.getInt("mois"));
                d.setDateDeclaration(rs.getDate("dateDeclaration").toLocalDate());
                return d;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}