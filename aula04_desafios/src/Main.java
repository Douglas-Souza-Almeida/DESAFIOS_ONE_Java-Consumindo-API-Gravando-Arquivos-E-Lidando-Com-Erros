import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("01. Crie um programa em Java que escreva a seguinte mensagem em um arquivo chamado " +
                "\"arquivo.txt\": \"Conteúdo a ser gravado no arquivo.\" Utilize as classes do pacote java.io.");

        //criando a classe para escrita e o arquivo a ser salvo
        FileWriter writer = new FileWriter("arquivo.txt");

        //solicitando ao usuário que digite um texto
        System.out.print("Quem é você? Digite algo para te definir: ");

        //leitura do texto
        Scanner scanner = new Scanner(System.in);

        //armazenando o texto em variável
        String text = scanner.nextLine();

        //gravando o texto no arquivo
        writer.write("Quem sou eu: " + text + "\n") ;
        //writer.close();

        System.out.println("\n\n02. Defina uma classe chamada Titulo com os atributos necessários. Em seguida, crie " +
                "um programa que instancia um objeto Titulo, serializa esse objeto para JSON usando a biblioteca Gson" +
                " e imprime o resultado.");

        //solicitando ao usuário que informe o título
        System.out.printf("Qual é seu livro preferido? ");

        //leitura e gravação do dado
        String title = scanner.nextLine();

        //solicitando ao usuário que informe o autor
        System.out.printf("Qual o autor deste livro? ");

        //leitura e gravação
        String author = scanner.nextLine();

        //instanciando o objeto
        Title book = new Title(title, author);

        //instanciando o Gson
        Gson gson = new Gson();
        System.out.println("Livro preferido:\n" + gson.toJson(book));

        System.out.println("\n\n03. Modifique o programa anterior para que o JSON gerado seja formatado de maneira " +
                "mais elegante. Utilize o método setPrettyPrinting para alcançar esse resultado.");

        //aplicando o PrettyPrinting
        gson = new GsonBuilder().setPrettyPrinting().create();
        writer.write("Livro Preferido:\n" + gson.toJson(book) + "\n");

        //exibindo os dados após mudança
        System.out.println("Exibindo os dados do livro informado, após aplicar o método 'Pretty Printing':\n" + gson.toJson(book));

        System.out.println("\n\n04. Defina uma classe chamada Veiculo com os atributos necessários. Em seguida, crie " +
                "um programa que instancia um objeto Veiculo, serializa esse objeto para JSON usando a biblioteca " +
                "Gson e imprime o resultado.");

        //solicitando dados ao usuário
        System.out.printf("Você possui veículo próprio?\nDigite 'S' para Sim ou 'N' para Não:  ");

        //leitura
        String option = scanner.next().toUpperCase();
        scanner.nextLine();

        //validação
        if(option.equals("S")) {

            //solicitando dados do modelo
            System.out.printf("Qual o modelo do seu veículo? ");

            //leitura e gravação
            String model = scanner.nextLine();

            //solicitando dados do ano de fabricação
            System.out.printf("Qual o ano de fabricação? ");

            //leitura e gravação
            String year = scanner.nextLine();

            //solicitando dados do tipo
            System.out.printf("E qual o tipo deste veículo, (moto, carro, caminhão, etc)? ");

            //leitura e gravação
           String type = scanner.nextLine();

            //instanciando a classe
            Vehicle vehicle = new Vehicle(model, year, type);

            //exibindo dados na tela
            System.out.println("Este é o veículo:\n" + gson.toJson(vehicle));

            //gravando os dados no arquivo
            writer.write("Veículo:\n" + gson.toJson(vehicle));
            writer.close();

            System.out.println("Muito obrigado! Até mais!");
        } else {
            System.out.println("Muito obrigado! Até mais!");
            writer.close();
        }
        scanner.close();
    }
}
