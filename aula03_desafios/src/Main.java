import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("01.Crie um programa simples que solicita dois números ao usuário e realiza a divisão do " +
                "primeiro pelo segundo. Utilize o bloco try/catch para tratar a exceção que pode ocorrer caso o " +
                "usuário informe 0 como divisor.");

        //instanciando a classe para leitura
        Scanner scanner = new Scanner(System.in);

        //solicitando dados ao usuário
        System.out.printf("Informe o numero do Dividendo: ");

        //armazenando o dado
        Double dividend = scanner.nextDouble();

        //solicitando dado ao usuário
        System.out.printf("Informe o número do Divisor: ");

        //armazenando o dado
        Double divider = scanner.nextDouble();

        //definindo variável para controle
        boolean control = false;

        //laço de repetição
        while(!control) {
            //realizando a divisão
            try {
                //verifica se o valor de divisor é zero
                if (divider == 0) {
                    //retorna erro caso verdadeirp (mesmo informando 0, não retorna erro e sim 'infinity'
                    throw new ArithmeticException ();
                }
                //caso falso, retorna mensagem com valor de divisão
                System.out.println("O valor da divisão é : " + dividend/divider);
                control = true;

                //caso seja informado um dado inválido, como letra para alguma variável
            } catch (InputMismatchException e) {
                System.out.println("ERRO: O valor informado não é válido - " + e.getMessage());
                //caso o valor de divisor seja zero
            } catch (ArithmeticException e) {
                //retorna a mensagem de erro em tela
                System.out.println("ERRO: O valor informado para divisor não é válido");
                //solicita ao usuário para que informe um novo dado
                System.out.printf("Informe o número do Divisor: ");
                //leitura do valor digitado
                divider = scanner.nextDouble();
            }
        }
        System.out.println("\n\n02. Crie um programa que lê uma senha do usuário. Utilize o bloco try/catch para " +
                "capturar a exceção SenhaInvalidaException, uma classe de exceção personalizada que deve ser lançada " +
                "caso a senha não atenda a critérios específicos (por exemplo, ter pelo menos 8 caracteres).");

        //definindo a senha
        String password = "ABC123";

        //solicitando ao usuário que informe a senha
        System.out.printf("Informe a senha: ");

        //realizando a leitura do dado informado
        String userPassword = scanner.next();

        //comparando o dado informado com o definido para senha
        boolean access = false;

        //laço de repetição
        while (!access) {
            try {
                if (!(password.equals(userPassword))) {
                    throw new InvalidPasswordException ();
                }
                System.out.println("Acesso liberado!");
                access = true;

            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());
                //solicitando ao usuário que informe a senha
                System.out.printf("Informe a senha: ");

                //realizando a leitura do dado informado
                userPassword = scanner.next();
            }
        }

        System.out.println("\n\n03.Desenvolva um programa em Java que permite aos usuários consultar informações " +
                "sobre um usuário do GitHub (utilize a API pública do GitHub para obter os dados). Crie uma classe de" +
                " exceção personalizada, ErroConsultaGitHubException, que estende RuntimeException. Lance essa " +
                "exceção quando o nome de usuário não for encontrado. No bloco catch, trate de forma específica essa " +
                "exceção, exibindo uma mensagem amigável.");

        //solicitando ao usuário que informe o dado
        System.out.printf("Informe o nome de perfil para realizar a busca: ");

        //leitura de dado
        String username = scanner.next();

        //definindo variável de endereço para consulta
        String url = "https://api.github.com/users/" + username;

        //definindo a variável para controle
        boolean connection = false;

        while(!connection) {
            try{
                //criando o client para enviar e receber requisição
                HttpClient client = HttpClient.newHttpClient();

                //criando o objeto para requisição
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

                //criando objeto de resposta da requisição
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                //definindo variável com resposta da requisição
                String responseJson = response.body();

                if(response.statusCode() != 404) {
                    //exibindo os dados na tela
                    System.out.println(responseJson);

                    //alterando o valor da variável de controle
                    connection = true;
                } else {
                    throw new QueryErrorGitHubExcepetion("Poxa... Não encontrei este perfil... :(");

                }
                //caso ocorra erro na pesquisa
            } catch (IllegalArgumentException | IOException | InterruptedException | QueryErrorGitHubExcepetion e) {
                //exibin mensagem em tela
                System.out.println(e.getMessage());

                //solicita dados
                System.out.printf("Informe o nome de perfil para realizar a busca, ou digite 's' para sair:  ");

                //leitura de dados
                username = scanner.next();

                //verificando o valor informado
                if(username.equals("s")) {
                    System.out.println("Até logo...    ;)");
                    connection = true;
                }
            }
        }
    }
}
