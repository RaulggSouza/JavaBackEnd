public class Costumer {
    private final String cpf;
    private String name;
    private String email;

    public Costumer(String cpf, String name, String email) {
        this.cpf = (cpf != null && !cpf.isBlank() && checkCpfLenght(cpf) ? cpf : "Default");
        setName(name);
        setEmail(email);
    }

    private static boolean checkCpfLenght(String cpf) {
        return (cpf.replace(".", "").replace("-", "").length() == 11);
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = validateInput(name);
    }

    public void setEmail(String email) {
        this.email = validateEmail(email);
    }

    private static String validateInput(String input) {
        return input == null || input.isBlank() ? "Default" : input;
    }

    private static String validateEmail(String email){
        String input = validateInput(email);
        return (input.contains("@") && (input.endsWith(".com") || input.endsWith(".br")) ? input : "Not@email.com");
    }
}
