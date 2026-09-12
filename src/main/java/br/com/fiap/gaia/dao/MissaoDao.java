package br.com.fiap.gaia.dao;
import br.com.fiap.gaia.factory.ConnectionFactory;
import br.com.fiap.gaia.exception.*;
import br.com.fiap.gaia.model.*;
import java.sql.*;
import java.util.*;
public class MissaoDao {
    private Connection conexao;
    public MissaoDao() throws Exception{
        conexao=ConnectionFactory.getConnection();
    }
    private Missao map(ResultSet r)throws SQLException{
        return new Missao(r.getInt("id_missao"), r.getString("nm_missao"), r.getString("ds_missao"), r.getInt("tp_dificuldade"), r.getInt("nr_pontos_recompensa"), r.getString("ds_imagem"), r.getString("st_missao").charAt(0));
    }
    public void cadastrar(Missao m)throws SQLException{
        try(PreparedStatement s=conexao.prepareStatement("insert into t_missao (id_missao, nm_missao, ds_missao, tp_dificuldade, nr_pontos_recompensa, ds_imagem, st_missao) values (sq_missao.nextval, ?, ?, ?, ?, ?, ?)", new String[]{
            "id_missao"}
            )){
                s.setString(1, m.getNmMissao());
                s.setString(2, m.getDsMissao());
                s.setInt(3, m.getTpDificuldade());
                s.setInt(4, m.getNrPontosRecompensa());
                s.setString(5, m.getDsImagem());
                s.setString(6, String.valueOf(m.getStMissao()));
                s.executeUpdate();
                try(ResultSet r=s.getGeneratedKeys()){
                    if(r.next())m.setIdMissao(r.getInt(1));
                }
            }
        }
        public Missao buscarPorId(int id)throws Exception{
            try(PreparedStatement s=conexao.prepareStatement("select * from t_missao where id_missao=?")){
                s.setInt(1, id);
                try(ResultSet r=s.executeQuery()){
                    if(!r.next())throw new EntidadeNaoEncontradaException("Missão não encontrada");
                    return map(r);
                }
            }
        }
        public List<Missao> listar()throws SQLException{
            List<Missao> l=new ArrayList<>();
            try(PreparedStatement s=conexao.prepareStatement("select * from t_missao order by id_missao");
            ResultSet r=s.executeQuery()){
                while(r.next())l.add(map(r));
            }
            return l;
        }
        public Missao atualizar(Missao m)throws Exception{
            try(PreparedStatement s=conexao.prepareStatement("update t_missao set nm_missao=?, ds_missao=?, tp_dificuldade=?, nr_pontos_recompensa=?, ds_imagem=?, st_missao=? where id_missao=?")){
                s.setString(1, m.getNmMissao());
                s.setString(2, m.getDsMissao());
                s.setInt(3, m.getTpDificuldade());
                s.setInt(4, m.getNrPontosRecompensa());
                s.setString(5, m.getDsImagem());
                s.setString(6, String.valueOf(m.getStMissao()));
                s.setInt(7, m.getIdMissao());
                if(s.executeUpdate()==0)throw new EntidadeNaoEncontradaException("Missão não existe");
                return m;
            }
        }
        public void deletar(int id)throws Exception{
            try(PreparedStatement s=conexao.prepareStatement("delete from t_missao where id_missao=?")){
                s.setInt(1, id);
                if(s.executeUpdate()==0)throw new EntidadeNaoEncontradaException("Missão não encontrada");
            }
        }
        public List<Missao> buscarPorDificuldade(int d)throws SQLException{
            List<Missao> l=new ArrayList<>();
            try(PreparedStatement s=conexao.prepareStatement("select * from t_missao where tp_dificuldade=?")){
                s.setInt(1, d);
                try(ResultSet r=s.executeQuery()){
                    while(r.next())l.add(map(r));
                }
            }
            return l;
        }
    }


