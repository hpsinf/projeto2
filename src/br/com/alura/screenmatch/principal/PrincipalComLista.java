package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComLista {
    public static void main(String[] args) {        
        Filme meuFilme = new Filme("O poderoso chefão", 1970); 
        meuFilme.avalia(10);

        Serie lost = new Serie("Lost", 2000);        

        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(8);        

        var filmeDoPaulo = new Filme("DogVille", 2022);        
        filmeDoPaulo.avalia(5);
        ArrayList<Titulo> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        listaDeFilmes.add(lost);
        for (Titulo titulo : listaDeFilmes) {            
            System.out.println(titulo.getNome());
            if (titulo instanceof Filme filme && filme.getClassificacao() >= 5) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        ArrayList<String> nomes = new ArrayList();
        nomes.add("Henrique");
        nomes.add("Eliana");
        nomes.add("Lena");
        nomes.add("Veveu");

        System.out.println(nomes);

        Collections.sort(nomes);
        System.out.println("Depois de ordenar");
        System.out.println(nomes);


        Collections.sort(listaDeFilmes);
        System.out.println(listaDeFilmes);

        listaDeFilmes.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(listaDeFilmes);
    }

}
