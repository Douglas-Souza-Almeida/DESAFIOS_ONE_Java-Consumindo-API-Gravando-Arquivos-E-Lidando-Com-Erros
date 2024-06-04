import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args)  {
        System.out.println("01. Crie uma classe Pessoa usando o conceito de Record em Java, com atributos como nome, " +
                "idade e cidade. Em seguida, implemente um programa que utiliza a biblioteca Gson para converter um " +
                "JSON representando uma pessoa em um objeto do tipo Pessoa.");

        //definindo o json
        String sJson = """
                {
                "name": "Paulo",
                "age": 21,
                "city": "Curitiba"
                }
                """;

        //instanciando o gson
        Gson gson = new Gson();

        //definindo person e obtendo json
        Person person = gson.fromJson(sJson, Person.class);

        //exibindo dados
        System.out.println(person);

        System.out.println("\n\n02.Modifique o programa do Exercício anterior para permitir a conversão de um JSON " +
                "mesmo se alguns campos estiverem ausentes ou se houver campos adicionais não representados no objeto" +
                " Pessoa. Consulte a documentação da biblioteca Gson para flexibilizar a conversão.");

        //alterando json
        String sJson1 = """
                    {
                    "name": "Juliana",
                    "city": "Uberlândia"
                    }
                """;

        //definindo gson
        Gson gson1 = new GsonBuilder().setLenient().create();

        //definindo person
        Person person1 = gson1.fromJson(sJson1, Person.class);

        //exibindo dados
        System.out.println(person1);

        System.out.println("\n\n03. Crie uma classe Livro que contenha atributos como título, autor e um objeto " +
                "representando a editora. Em seguida, implemente um programa que utiliza a biblioteca Gson para " +
                "converter um JSON aninhado representando um livro em um objeto do tipo Livro.");

        //definindo json
        String sJsonBook = """
                {
                    "title" : "Clean Code",
                    "author" : "Robert C. Martin",
                    "publisher" :
                        {
                            "name" : "Prentice Hall",
                            "city" : "Upper Saddle River"
                        }
                }
                """;

        //definindo gson
        Gson gson2 = new Gson();
        Book book = gson2.fromJson(sJsonBook, Book.class);

        //exibindo dados
        System.out.println(book);

    }
}
