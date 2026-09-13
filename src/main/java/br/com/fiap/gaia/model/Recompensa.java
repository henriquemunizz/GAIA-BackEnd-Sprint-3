package br.com.fiap.gaia.model;

public class Recompensa {

    private int idRecompensa, nrCustoPontos;
    private String nmRecompensa, dsRecompensa, tpAcessorio, dsImagem;
    private char stRecompensa;

    public Recompensa() {
    }

    public Recompensa(
            String n,
            String d,
            String t,
            int c,
            String i,
            char s
    ) {
        nmRecompensa = n;
        dsRecompensa = d;
        tpAcessorio = t;
        nrCustoPontos = c;
        dsImagem = i;
        stRecompensa = s;
    }

    public Recompensa(
            int id,
            String n,
            String d,
            String t,
            int c,
            String i,
            char s
    ) {
        this(n, d, t, c, i, s);
        idRecompensa = id;
    }

    public int getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(int v) {
        idRecompensa = v;
    }

    public String getNmRecompensa() {
        return nmRecompensa;
    }

    public void setNmRecompensa(String v) {
        nmRecompensa = v;
    }

    public String getDsRecompensa() {
        return dsRecompensa;
    }

    public void setDsRecompensa(String v) {
        dsRecompensa = v;
    }

    public String getTpAcessorio() {
        return tpAcessorio;
    }

    public void setTpAcessorio(String v) {
        tpAcessorio = v;
    }

    public int getNrCustoPontos() {
        return nrCustoPontos;
    }

    public void setNrCustoPontos(int v) {
        nrCustoPontos = v;
    }

    public String getDsImagem() {
        return dsImagem;
    }

    public void setDsImagem(String v) {
        dsImagem = v;
    }

    public char getStRecompensa() {
        return stRecompensa;
    }

    public void setStRecompensa(char v) {
        stRecompensa = v;
    }
}