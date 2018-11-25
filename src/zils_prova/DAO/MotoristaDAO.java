/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zils_prova.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import zils_prova.jdbc.ConnectionFactory;
import zils_prova.model.Funcionario;
import zils_prova.model.Motorista;

/**
 *
 * @author eduar
 */
public class MotoristaDAO implements GenericDAO<Motorista> {

    private Connection connection = null;

    @Override
    public void save(Motorista entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO MOTORISTA(CD_FUNCIONARIO, CD_MOTORISTA, NR_CNH, DT_VENCIMENTO)")
                    .append(" VALUES (?,?,?,?)");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            
            pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getFuncionario().getCodigo());
            pstm.setInt(2, entity.getCodigo());
            pstm.setInt(3, entity.getNr_cnh());
            pstm.setDate(4, new Date(entity.getDt_vencimento().getYear(), entity.getDt_vencimento().getMonth(), entity.getDt_vencimento().getDay()));
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
    public void update(Motorista entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE MOTORISTA SET NR_CNH = ?, DT_VENCIMENTO = ? WHERE CD_MOTORISTA = ?");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getNr_cnh());
            pstm.setDate(2, new Date(entity.getDt_vencimento().getYear(), entity.getDt_vencimento().getMonth(), entity.getDt_vencimento().getDay()));
            pstm.setInt(3, entity.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Motorista!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao atualizar Motorista!");
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
            String sql = "DELETE FROM MOTORISTA WHERE CD_MOTORISTA =" + id;
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao deletar MOTORISTA!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao deletar MOTORA!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public Motorista getById(int id) throws SQLException {
        Motorista f = null;
        FuncionarioDAO funcionarioDAO = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM MOTORISTA WHERE CD_MOTORISTA = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            f = new Motorista() {
            };
            while (rs.next()) {
                f.setCodigo(rs.getInt("CD_MOTORISTA"));
                funcionarioDAO = new FuncionarioDAO();
                f.setFuncionario(funcionarioDAO.getById(rs.getInt("CD_FUNCIONARIO")));
                f.setNr_cnh(rs.getInt("NR_CNH"));
                f.setDt_vencimento(rs.getDate("DT_VENCIMENTO"));
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
        return f;
    }

    @Override
    public List<Motorista> getByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Motorista> getAll() throws SQLException {
        List<Motorista> listaMotoristas = null;
        Motorista m = null;
        FuncionarioDAO funDAO = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM MOTORISTA ORDER BY CD_FUNCIONARIO";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaMotoristas = new ArrayList<>();
            while (rs.next()) {
                m = new Motorista() {
                };
                m.setCodigo(rs.getInt("CD_MOTORISTA"));
                funDAO = new FuncionarioDAO();
                m.setFuncionario(funDAO.getById(rs.getInt("CD_FUNCIONARIO")));
                
                m.setDt_vencimento(rs.getDate("DT_VENCIMENTO"));
                m.setNr_cnh(rs.getInt("NR_CNH"));
                listaMotoristas.add(m);
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Motoras(s)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Motoras(s)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return listaMotoristas;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT COALESCE(MAX(CD_FUNCIONARIO),0)+1 AS MAIOR FROM MOTORISTA ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Motorista(s)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Motorista(s)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return 1;
    }

}
