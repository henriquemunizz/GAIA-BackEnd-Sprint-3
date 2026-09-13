package br.com.fiap.gaia.model;

public class Missao {

    private int idMissao;
    private String nmMissao;
    private String dsMissao;
    private int tpDificuldade;
    private int nrPontosRecompensa;
    private String dsImagem;
    private char stMissao;

    public Missao() {
    }

    public Missao(
            String nmMissao,
            String dsMissao,
            int tpDificuldade,
            int nrPontosRecompensa,
            String dsImagem,
            char stMissao
    ) {
        this.nmMissao = nmMissao;
        this.dsMissao = dsMissao;
        this.tpDificuldade = tpDificuldade;
        this.nrPontosRecompensa = nrPontosRecompensa;
        this.dsImagem = dsImagem;
        this.stMissao = stMissao;
    }

    public Missao(
            int idMissao,
            String nmMissao,
            String dsMissao,
            int tpDificuldade,
            int nrPontosRecompensa,
            String dsImagem,
            char stMissao
    ) {
        this(
                nmMissao,
                dsMissao,
                tpDificuldade,
                nrPontosRecompensa,
                dsImagem,
                stMissao
        );

        this.idMissao = idMissao;
    }

    public int getIdMissao() {
        return idMissao;
    }

    public void setIdMissao(int idMissao) {
        this.idMissao = idMissao;
    }

    public String getNmMissao() {
        return nmMissao;
    }

    public void setNmMissao(String nmMissao) {
        this.nmMissao = nmMissao;
    }

    public String getDsMissao() {
        return dsMissao;
    }

    public void setDsMissao(String dsMissao) {
        this.dsMissao = dsMissao;
    }

    public int getTpDificuldade() {
        return tpDificuldade;
    }

    public void setTpDificuldade(int tpDificuldade) {
        this.tpDificuldade = tpDificuldade;
    }

    public int getNrPontosRecompensa() {
        return nrPontosRecompensa;
    }

    public void setNrPontosRecompensa(int nrPontosRecompensa) {
        this.nrPontosRecompensa = nrPontosRecompensa;
    }

    public String getDsImagem() {
        return dsImagem;
    }

    public void setDsImagem(String dsImagem) {
        this.dsImagem = dsImagem;
    }

    public char getStMissao() {
        return stMissao;
    }

    public void setStMissao(char stMissao) {
        this.stMissao = stMissao;
    }
}