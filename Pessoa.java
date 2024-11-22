public class Pessoa {
    private static int kp = 0;

    private String nome;
    private char sexo;
    private int idade;

    public Pessoa() {
        kp++; 
    }

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        kp++;
    }

    public void setKp() {
        kp++;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
        } else {
            System.out.println("Sexo inválido. Use 'M' ou 'F'.");
        }
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getKp() {
        return kp; 
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }
}