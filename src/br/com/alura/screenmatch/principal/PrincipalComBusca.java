package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TitulosOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (Scanner scanner = new Scanner(System.in);
             HttpClient client = HttpClient.newHttpClient()) {

            System.out.println("Informe o nome do filme para a busca: ");
            var busca = scanner.nextLine();
            String enderecoBusca = "http://www.omdbapi.com/?t=" + busca + "&apikey=ad8d0888";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(enderecoBusca))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            var respJson = response.body();
            System.out.println(respJson);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TitulosOmbd respTituloOmdb = gson.fromJson(respJson, TitulosOmbd.class);

            Titulo meutitulo = new Titulo(respTituloOmdb);

            System.out.println(meutitulo);


//        } catch (NumberFormatException e) {
//            System.out.println("Erro:");
//            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro:");
            System.out.println(e.getMessage());
        }

        System.out.println("Finalizado.");
    }
}
