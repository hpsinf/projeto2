package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TitulosOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
//import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) {
        String busca = "";
        List<Titulo> titulos = new ArrayList<Titulo>();
        Scanner scanner = new Scanner(System.in);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {
            try {

                System.out.println("Informe o nome do filme para a busca: ");
                busca = scanner.nextLine();

                if (busca.equalsIgnoreCase("sair")){
                    break;
                }

                String enderecoBusca = "http://www.omdbapi.com/?t=" + busca + "&apikey=ad8d0888";

                HttpClient client = HttpClient
                        .newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(enderecoBusca))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                var respJson = response.body();
                System.out.println(respJson);

                TitulosOmbd respTituloOmdb = gson.fromJson(respJson, TitulosOmbd.class);
                Titulo meutitulo = new Titulo(respTituloOmdb);
                titulos.add(meutitulo);
//        } catch (NumberFormatException e) {
//            System.out.println("Erro:");
//            System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro:");
                System.out.println(e.getMessage());
            }
        }

        try {
            FileWriter writer = new FileWriter("titulos.json");
            writer.write(gson.toJson(titulos));
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(titulos);
        System.out.println("Finalizado.");
    }

}
