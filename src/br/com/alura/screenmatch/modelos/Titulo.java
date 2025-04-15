package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ExceptionAnoLancamento;


public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
//    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private String duracaoEmMinutos;


    public Titulo (String nome, int anoDeLancamento){
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TitulosOmbd titulosOmbd) {
        this.nome = titulosOmbd.title();

        if (titulosOmbd.year().length() > 4){
            throw new ExceptionAnoLancamento("Erro de conversão de Ano, Ano inválido com mais de 4 caracteres.");
        }
        this.anoDeLancamento = Integer.parseInt((titulosOmbd.year().substring(0,4).trim()));
        this.duracaoEmMinutos = titulosOmbd.runtime();
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

//    public boolean isIncluidoNoPlano() {
//        return incluidoNoPlano;
//    }

    public String getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

//    public void setNome(String nome) {
//        this.nome = nome;
//    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

//    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
//        this.incluidoNoPlano = incluidoNoPlano;
//    }

    public void setDuracaoEmMinutos(String duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo tituloAComparar) {
        return this.getNome().compareTo(tituloAComparar.getNome());
    }

    @Override
    public String toString() {
        return "(nome :'" + nome +
                ", anoDeLancamento: " + anoDeLancamento +
                ", duracaoEmMinutos: " + duracaoEmMinutos +")"                ;
    }
}
