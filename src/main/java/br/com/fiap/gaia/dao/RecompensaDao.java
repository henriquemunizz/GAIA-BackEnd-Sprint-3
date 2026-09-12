package br.com.fiap.gaia.dao;
import br.com.fiap.gaia.factory.ConnectionFactory;
import br.com.fiap.gaia.exception.*;
import br.com.fiap.gaia.model.*;
import java.sql.*;
import java.util.*;
public class RecompensaDao {
    private Connection c;
    public RecompensaDao() throws Exception{
        c=ConnectionFactory.getConnection();
    }
    private Recompensa map(ResultSet r)throws SQLException{
        return new Recompensa(r.getInt("id_recompensa"), r.getString("nm_recompensa"), r.getString("ds_recompensa"), r.getString("tp_acessorio"), r.getInt("nr_custo_pontos"), r.getString("ds_imagem"), r.getString("st_recompensa").charAt(0));
    }
    public void cadastrar(Recompensa x)throws SQLException{
        try(PreparedStatement s=c.prepareStatement("insert into t_recompensa values(sq_recompensa.nextval, ?, ?, ?, ?, ?, ?)", new String[]{
            "id_recompensa"}
            )){
                s.setString(1, x.getNmRecompensa());
                s.setString(2, x.getDsRecompensa());
                s.setString(3, x.getTpAcessorio());
                s.setInt(4, x.getNrCustoPontos());
                s.setString(5, x.getDsImagem());
                s.setString(6, String.valueOf(x.getStRecompensa()));
                s.executeUpdate();
                try(ResultSet r=s.getGeneratedKeys()){
                    if(r.next())x.setIdRecompensa(r.getInt(1));
                }
            }
        }
        public Recompensa buscarPorId(int id)throws Exception{
            try(PreparedStatement s=c.prepareStatement("select * from t_recompensa where id_recompensa=?")){
                s.setInt(1, id);
                try(ResultSet r=s.executeQuery()){
                    if(!r.next())throw new EntidadeNaoEncontradaException("Recompensa não encontrada");
                    return map(r);
                }
            }
        }
        public List<Recompensa> listar()throws SQLException{
            List<Recompensa> l=new ArrayList<>();
            try(PreparedStatement s=c.prepareStatement("select * from t_recompensa order by id_recompensa");
            ResultSet r=s.executeQuery()){
                while(r.next())l.add(map(r));
            }
            return l;
        }
        public Recompensa atualizar(Recompensa x)throws Exception{
            try(PreparedStatement s=c.prepareStatement("update t_recompensa set nm_recompensa=?, ds_recompensa=?, tp_acessorio=?, nr_custo_pontos=?, ds_imagem=?, st_recompensa=? where id_recompensa=?")){
                s.setString(1, x.getNmRecompensa());
                s.setString(2, x.getDsRecompensa());
                s.setString(3, x.getTpAcessorio());
                s.setInt(4, x.getNrCustoPontos());
                s.setString(5, x.getDsImagem());
                s.setString(6, String.valueOf(x.getStRecompensa()));
                s.setInt(7, x.getIdRecompensa());
                if(s.executeUpdate()==0)throw new EntidadeNaoEncontradaException("Recompensa não existe");
                return x;
            }
        }
        public void deletar(int id)throws Exception{
            try(PreparedStatement s=c.prepareStatement("delete from t_recompensa where id_recompensa=?")){
                s.setInt(1, id);
                if(s.executeUpdate()==0)throw new EntidadeNaoEncontradaException("Recompensa não encontrada");
            }
        }
    }


