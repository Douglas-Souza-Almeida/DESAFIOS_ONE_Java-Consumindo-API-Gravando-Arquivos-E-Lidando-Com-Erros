public class InvalidPasswordException extends Exception {
    //definindo mensagem de erro
    private String message = "Senha inválida";

    //método get
    public String getMessage () {
        return message;
    }
}
