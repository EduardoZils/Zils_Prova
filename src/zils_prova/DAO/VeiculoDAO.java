/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zils_prova.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import zils_prova.jdbc.ConnectionFactory;
import zils_prova.model.Veiculo;

/**
 *
 * @author eduar
 */
public class VeiculoDAO implements GenericDAO<Veiculo> {

    private Connection connection = null;

    @Override
    public void save(Veiculo entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO VEICULO(CD_VEICULO, NR_PLACA, NR_ANO, NR_PASSAGEIROS)")
                    .append(" VALUES (?,?,?,?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getNr_placa());
            pstm.setInt(3, entity.getNr_ano());
            pstm.setInt(4, entity.getNr_passageiros());
            pstm.execute();
            pstm.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao salvar Funcionario!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao salvar Funcionario!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public void update(Veiculo entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE VEICULO SET NR_PLACA = ?")
                    .append(", NR_ANO = ?, NR_PASSAGEIROS = ? WHERE CD_VEICULO = ?");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getNr_placa());
            pstm.setInt(2, entity.getNr_ano());
            pstm.setInt(3, entity.getNr_passageiros());
            pstm.setInt(4, entity.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Cliente!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao atualizar Cliente!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "DELETE FROM VEICULO WHERE CD_VEICULO =" + id;
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao deletar VEICULO!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao deletar Veiculo!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public Veiculo getById(int id) throws SQLException {
        Veiculo f = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM VEICULO WHERE CD_VEICULO = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            f = new Veiculo() {
            };
            while (rs.next()) {
                f.setCodigo(rs.getInt("CD_VEICULO"));
                f.setNr_ano(rs.getInt("NR_ANO"));
                f.setNr_passageiros(rs.getInt("NR_PASSAGEIROS"));
                f.setNr_placa(rs.getString("NR_PLACA"));
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Veiculo pelo ID!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Veiculo pelo ID!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return f;
    }

    @Override
    public List<Veiculo> getByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Veiculo> getAll() throws SQLException {
        List<Veiculo> listaVeiculo = null;
        Veiculo f = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM VEICULO ORDER BY CD_VEICULO ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaVeiculo = new ArrayList<>();
            while (rs.next()) {
                f = new Veiculo();
                f.setCodigo(rs.getInt("CD_VEICULO"));
                f.setNr_ano(rs.getInt("NR_ANO"));
                f.setNr_passageiros(rs.getInt("NR_PASSAGEIROS"));
                f.setNr_placa(rs.getString("NR_PLACA"));
                listaVeiculo.add(f);
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Veiculo(s)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Veiculo(s)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return listaVeiculo;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT COALESCE(MAX(CD_VEICULO),0)+1 AS MAIOR FROM VEICULO ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar VEICULO(s)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar VEICULO(s)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return 1;
    }

}
