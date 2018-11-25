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
import zils_prova.model.Funcionario;

/**
 *
 * @author eduar
 */
public class FuncionarioDAO implements GenericDAO<Funcionario> {

    private Connection connection = null;

    @Override
    public void save(Funcionario entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO FUNCIONARIO(CD_FUNCIONARIO, NM_FUNCIONARIO, NR_MATRICULA)")
                    .append(" VALUES (?,?,?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getNm_funcionario());
            pstm.setInt(3, entity.getNr_matricula());
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
    public void update(Funcionario entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE FUNCIONARIO SET NM_FUNCIONARIO = ?")
                    .append(", NR_MATRICULA = ? WHERE CD_FUNCIONARIO = ?");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getNm_funcionario());
            pstm.setInt(2, entity.getNr_matricula());
            pstm.setInt(3, entity.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Funcionario!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao atualizar Funcionario!");
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
            String sql = "DELETE FROM FUNCIONARIO WHERE CD_FUNCIONARIO =" + id;
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao deletar Func!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao deletar Func!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }}

    @Override
    public Funcionario getById(int id) throws SQLException {
    Funcionario f = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM FUNCIONARIO WHERE CD_FUNCIONARIO = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            f = new Funcionario() {};
            while (rs.next()) {
                f.setCodigo(rs.getInt("CD_FUNCIONARIO"));
                f.setNm_funcionario(rs.getString("NM_FUNCIONARIO"));
                f.setNr_matricula(rs.getInt("NR_MATRICULA"));
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Funcionario pelo ID!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Funcionario pelo ID!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return f;}

    @Override
    public List<Funcionario> getByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> getAll() throws SQLException {
        List<Funcionario> listaFuncionario = null;
        Funcionario f = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM FUNCIONARIO ORDER BY CD_FUNCIONARIO ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaFuncionario = new ArrayList<>();
            while (rs.next()) {
                f = new Funcionario() {
                };
                f.setCodigo(rs.getInt("CD_FUNCIONARIO"));
                f.setNm_funcionario(rs.getString("NM_FUNCIONARIO"));
                f.setNr_matricula(rs.getInt("NR_MATRICULA"));
                listaFuncionario.add(f);
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Cliente(s)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Cliente(s)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return listaFuncionario;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT COALESCE(MAX(CD_FUNCIONARIO),0)+1 AS MAIOR FROM FUNCIONARIO ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Funcionario(s)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Funcionario(s)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return 1;
    }

}
