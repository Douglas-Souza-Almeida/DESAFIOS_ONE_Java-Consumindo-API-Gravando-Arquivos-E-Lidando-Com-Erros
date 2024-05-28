import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("01. Crie um programa em Java que utilize as classes HttpClient, HttpRequest e " +
                        "HttpResponse para fazer uma consulta à API do Google Books. Solicite ao usuário que insira o" +
                " título de um livro, e exiba as informações disponíveis sobre o livro retornado pela API.");

        //iniciando a classe Scanner para leitura de dados
        Scanner scanner = new Scanner(System.in);

        //solicitando ao usuário que informe o nome do livro para realizar a busca
        System.out.printf("Informe o título de um livro para realizar a busca: ");
        //armazenando valor e alterando caracteres de espaço por +
        String sTitle = scanner.next().replace(" ", "+");

        //definindo url para busca
        String sUrlBook = "https://www.googleapis.com/books/v1/volumes?q=" + sTitle;

        //definindo classe client
        HttpClient client = HttpClient.newHttpClient();

        //definindo classe request com o endereço url definido
        HttpRequest requestBook = HttpRequest.newBuilder().uri(URI.create(sUrlBook)).build();

        //definindo classe response
        HttpResponse<String> responseBook = client.send(requestBook, HttpResponse.BodyHandlers.ofString());

        //exibindo os dados do livro
        System.out.println(responseBook.body());

        System.out.println("\n\n02.Crie um programa Java que utiliza as classes HttpClient, HttpRequest e " +
                "HttpResponse para fazer uma consulta à API CoinGecko e exiba a cotação atual de uma criptomoeda " +
                "escolhida pelo usuário.");

        //solicitando ao usuário dados
        System.out.printf("Informe qual criptomoeda deseja exibir dados: ");

        //armazenando dado
        String sCripto = scanner.next().replace(" ", "+");

        //definindo url para busca
        String sUrlCripto = "https://api.coingecko.com/api/v3/simple/price?ids=" + sCripto + "&vs_currencies=usd";

        //definindo classe request com o endereço url definido
        HttpRequest requestCripto = HttpRequest.newBuilder().uri(URI.create(sUrlCripto)).build();

        //definindo classe response
        HttpResponse<String> responseCripto = client.send(requestCripto, HttpResponse.BodyHandlers.ofString());

        //exibindo os dados do livro
        System.out.println(responseCripto.body());

        System.out.println("\n\n03. Crie um programa Java que faça uma consulta à API do TheMealDB utilizando as " +
                "classes HttpClient, HttpRequest e HttpResponse. Solicite ao usuário que insira o nome de uma receita" +
                " e exiba as informações disponíveis sobre essa receita.");

        //solicitando ao usuário que informe o dado
        System.out.printf("Informe qual receita deseja exibir: ");

        //armazenando dado
        String sRecipe = scanner.next().replace(" ","+");

        //definindo url de pesquisa
        String sUrlRecipe = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + sRecipe;

        //definindo classe request com o endereço url definido
        HttpRequest requestRecipe = HttpRequest.newBuilder().uri(URI.create(sUrlRecipe)).build();

        //definindo classe response
        HttpResponse<String> responseRecipe = client.send(requestRecipe, HttpResponse.BodyHandlers.ofString());

        //exibindo os dados do livro
        System.out.println(responseRecipe.body());


    }

}
