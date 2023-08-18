import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String nome, celular;
        int opcao;
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha [1]Escrever [2]Ler: ");
        opcao = sc.nextInt();

        if (opcao == 1) {
            System.out.println("Digite seu nome: ");
            nome = sc.next();
            System.out.println("Digite seu celular: ");
            celular = sc.next();

            Agenda contato = new Agenda(nome, celular);

            try {
                FileWriter agenda = new FileWriter("agenda.txt", true);
                BufferedWriter escrita = new BufferedWriter(agenda);

                escrita.write(contato.getNome() + ";" + contato.getCelular());
                escrita.newLine();
                escrita.close();

                agenda.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                FileReader leitor = new FileReader("agenda.txt");
                BufferedReader bwLeitor = new BufferedReader(leitor);

                while (bwLeitor.ready()) {
                    String linha = bwLeitor.readLine();

                    nome = linha.split(";")[0];
                    celular = linha.split(";")[1];

                    System.out.println("Nome: " + nome + " Celular: " + celular);
                }

                leitor.close();
                bwLeitor.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
