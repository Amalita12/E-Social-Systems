package dao;

import model.Employe;
import model.Employeur;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeDAO {

    public void ajouterEmploye(Employe emp) {
        String sql = "INSERT INTO employes (nom, salaireMensuel, employeur_id) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emp.getNom());
            ps.setDouble(2, emp.getSalaireMensuel());
            ps.setInt(3, emp.getEmployeur().getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierSalaire(int id, double nouveauSalaire) {
        String sql = "UPDATE employes SET salaireMensuel = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, nouveauSalaire);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employe> consulterListeDesEmployes() {
        List<Employe> liste = new ArrayList<>();
        String sql = "SELECT * FROM employes";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Employe e = new Employe();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setSalaireMensuel(rs.getDouble("salaireMensuel"));

                Employeur boss = new Employeur();
                boss.setId(rs.getInt("employeur_id"));
                e.setEmployeur(boss);

                liste.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    public Employe consulterEmploye(int id) {
        String sql = "SELECT * FROM employes WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employe e = new Employe();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setSalaireMensuel(rs.getDouble("salaireMensuel"));

                Employeur boss = new Employeur();
                boss.setId(rs.getInt("employeur_id"));
                e.setEmployeur(boss);

                return e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Employe consulterDroit(int idAssure) {
        Employe emp = null;
        String sql = "SELECT e.nom, e.salaireMensuel, " +
                "COUNT(DISTINCT d.id) as nbMois, " +
                "SUM(c.montantSalarial + c.montantPatronal) as totalCotis " +
                "FROM employes e " +
                "LEFT JOIN cotisations c ON e.id = c.employe_id " +
                "LEFT JOIN declarations d ON c.declaration_id = d.id " +
                "WHERE e.id = ? " +
                "GROUP BY e.id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idAssure);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new Employe();
                emp.setId(idAssure);
                emp.setNom(rs.getString("nom"));
                emp.setSalaireMensuel(rs.getDouble("salaireMensuel"));
                emp.setNbMoisDeclares(rs.getInt("nbMois"));
                emp.setTotalCotisations(rs.getDouble("totalCotis"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }
}