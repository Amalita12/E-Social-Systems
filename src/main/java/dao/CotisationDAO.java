package dao;

import model.Cotisation;
import model.Employe;
import java.sql.*;

public class CotisationDAO {

    public Cotisation calculCotisation(Employe emp) {
        double salaire = emp.getSalaireMensuel();

        double partSalariale = salaire * 0.0675;
        double partPatronale = salaire * 0.135;

        Cotisation cot = new Cotisation();
        cot.setEmploye(emp);
        cot.setMontantSalarial(partSalariale);
        cot.setMontantPatronal(partPatronale);

        return cot;
    }

    public double calculTotalParEmployeur(int employeurId, int declarationId) {
        double total = 0;
        String sql = "SELECT SUM(c.montantSalarial + c.montantPatronal) as totalCumule " +
                "FROM cotisations c " +
                "JOIN employes e ON c.employe_id = e.id " +
                "WHERE e.employeur_id = ? AND c.declaration_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, employeurId);
            ps.setInt(2, declarationId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getDouble("totalCumule");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void enregistrerCotisationEnBase(Cotisation cot) {
        String sql = "INSERT INTO cotisations (montantSalarial, montantPatronal, employe_id, declaration_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, cot.getMontantSalarial());
            ps.setDouble(2, cot.getMontantPatronal());
            ps.setInt(3, cot.getEmploye().getId());
            ps.setInt(4, cot.getDeclaration().getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}