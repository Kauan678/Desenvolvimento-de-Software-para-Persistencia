package ufc.quixada;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class inserirEntidade {
    private String caminhoArquivo = "C:\\Users\\55889\\Documents\\JavaParaPersistencia\\dspersist\\Livros.csv";

        public inserirEntidade(String caminhoArquivo) {
            this.caminhoArquivo = caminhoArquivo;
        }

        public void inserirLivros() {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite o titulo do livro:");
            String titulo = sc.nextLine();

            System.out.println("Digite o autor do livro:");
            String autor = sc.nextLine();

            System.out.println("Digite o ISBN do livro:");
            String isbn = sc.nextLine();

            System.out.println("Digite a editora do livro:");
            String editora = sc.nextLine();

            System.out.println("Digite o ano de publicação do livro:");
            String anoPublicacao = sc.nextLine();

            Livro livro = new Livro(titulo, autor, isbn, editora, anoPublicacao);

            try {
                File arquivo = new File(caminhoArquivo);
                if(!arquivo.exists()) {
                    arquivo.createNewFile();
                }

                FileWriter fw = new FileWriter(arquivo, true);
                fw.append("\n");
                fw.append(livro.getTitulo());
                fw.append(",");
                fw.append(livro.getAutor());
                fw.append(",");
                fw.append(livro.getIsbn());
                fw.append(",");
                fw.append(livro.getEditora());
                fw.append(",");
                fw.append(livro.getAnoPublicacao());

                fw.flush();
                fw.close();
                sc.close();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }
    }