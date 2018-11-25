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
import zils_prova.model.Agendamento;

/**
 *
 * @author eduar
 */
public class AgendamentoDAO implements GenericDAO<Agendamento> {

    private Connection connection = null;

    @Override
    public void save(Agendamento entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO AGENDAMENTO(CD_AGENDAMENTO, CD_VEICULO, DS_ORIGEM, DS_DESTINO, CD_MOTORISTA, CD_FUNCIONARIO, DT_SAIDA, DT_RETORNO, NR_PASSAGEIROS, DS_OBSERVACAO)")
                    .append(" VALUES (?,?,?,?,?,?,?,?,?,?)");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());

            pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCd_agendamento());
            pstm.setInt(2, entity.getCd_veiculo());
            pstm.setString(3, entity.getDs_origem());
            pstm.setString(4, entity.getDs_destino());
            pstm.setInt(5, entity.getCd_motorista());
            pstm.setInt(6, entity.getCd_funcionario());
            pstm.setDate(7, new Date(entity.getDt_saida().getYear(), entity.getDt_saida().getMonth(), entity.getDt_saida().getDay()));
            pstm.setDate(8, new Date(entity.getDt_retorno().getYear(), entity.getDt_retorno().getMonth(), entity.getDt_retorno().getDay()));
            pstm.setInt(9, entity.getNr_passageiros());
            pstm.setString(10, entity.getDs_observacao());
            pstm.execute();
            pstm.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao salvar Agendamento!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao salvar Agendamento!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public void update(Agendamento entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE MOTORISTA SET CD_VEICULO = ?, DS_ORIGEM = ?, DS_DESTINO = ?, CD_MOTORISTA = ?, CD_FUNCIONARIO = ?, DT_SAIDA = ?, DT_RETORNO = ?, NR_PASSAGEIROS = ?, DS_OBSERVACAO = ? WHERE CD_AGENDAMENTO = ?");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCd_veiculo());
            pstm.setString(2, entity.getDs_origem());
            pstm.setString(3, entity.getDs_destino());
            pstm.setInt(4, entity.getCd_motorista());
            pstm.setInt(5, entity.getCd_funcionario());
            pstm.setDate(6, new Date(entity.getDt_saida().getYear(), entity.getDt_saida().getMonth(), entity.getDt_saida().getDay()));
            pstm.setDate(7, new Date(entity.getDt_retorno().getYear(), entity.getDt_retorno().getMonth(), entity.getDt_retorno().getDay()));
            pstm.setInt(8, entity.getNr_passageiros());
            pstm.setString(9, entity.getDs_observacao());
            pstm.setInt(10, entity.getCd_agendamento());
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
            String sql = "DELETE FROM AGENDAMENTO WHERE CD_AGENDAMENTO =" + id;
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao deletar AGENDAMENTO!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao deletar AGENDAMENTO!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public Agendamento getById(int id) throws SQLException {
        Agendamento f = null;
        MotoristaDAO motoDAO = null;
        VeiculoDAO veicDAO = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM AGENDAMENTO WHERE CD_AGENDAMENTO = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            f = new Agendamento() {
            };
            while (rs.next()) {
                //CD_AGENDAMENTO, CD_VEICULO, DS_ORIGEM, DS_DESTINO, CD_MOTORISTA, CD_FUNCIONARIO, DT_SAIDA, DT_RETORNO, NR_PASSAGEIROS, DS_OBSERVACAO
                motoDAO = new MotoristaDAO();
                veicDAO = new VeiculoDAO();
                f.setCd_agendamento(rs.getInt("CD_AGENDAMENTO"));
                f.setCd_funcionario(rs.getInt("CD_FUNCIONARIO"));
                f.setMotorista(motoDAO.getById(rs.getInt("CD_MOTORISTA")));
                f.setCd_motorista(rs.getInt("CD_MOTORISTA"));
                f.setVeiculo(veicDAO.getById(rs.getInt("CD_VEICULO")));
                f.setCd_veiculo(rs.getInt("CD_VEICULO"));
                f.setDs_destino(rs.getString("DS_DESTINO"));
                f.setDs_observacao(rs.getString("DS_OBSERVACAO"));
                f.setDs_origem(rs.getString("DS_ORIGEM"));
                f.setNr_passageiros(rs.getInt("NR_PASSAGEIROS"));
                f.setDt_retorno(rs.getDate("DT_RETORNO"));
                f.setDt_saida(rs.getDate("DT_SAIDA"));

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
    public List<Agendamento> getByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Agendamento> getAll() throws SQLException {
        List<Agendamento> listaAgendamento = null;
        Agendamento f = null;
        MotoristaDAO motoDAO = null;
        VeiculoDAO veicDAO = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT CD_AGENDAMENTO, CD_VEICULO, DS_ORIGEM, DS_DESTINO, CD_MOTORISTA, CD_FUNCIONARIO, DT_SAIDA, DT_RETORNO, NR_PASSAGEIROS, DS_OBSERVACAO FROM AGENDAMENTO ORDER BY CD_AGENDAMENTO";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaAgendamento = new ArrayList<>();
            while (rs.next()) {
                f = new Agendamento();
                motoDAO = new MotoristaDAO();
                veicDAO = new VeiculoDAO();
                f.setCd_agendamento(rs.getInt("CD_AGENDAMENTO"));
                f.setCd_funcionario(rs.getInt("CD_FUNCIONARIO"));
                f.setMotorista(motoDAO.getById(rs.getInt("CD_MOTORISTA")));
                f.setCd_motorista(rs.getInt("CD_MOTORISTA"));
                f.setVeiculo(veicDAO.getById(rs.getInt("CD_VEICULO")));
                f.setCd_veiculo(rs.getInt("CD_VEICULO"));
                f.setDs_destino(rs.getString("DS_DESTINO"));
                f.setDs_observacao(rs.getString("DS_OBSERVACAO"));
                f.setDs_origem(rs.getString("DS_ORIGEM"));
                f.setNr_passageiros(rs.getInt("NR_PASSAGEIROS"));
                f.setDt_retorno(rs.getDate("DT_RETORNO"));
                f.setDt_saida(rs.getDate("DT_SAIDA"));
                listaAgendamento.add(f);
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Agendamento(s)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Agendamento(s)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return listaAgendamento;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT COALESCE(MAX(CD_AGENDAMENTO),0)+1 AS MAIOR FROM AGENDAMENTO ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar AGENDAMENTO(s)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar AGENDAMENTO(s)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return 1;
    }

}
