package ufc.quixada;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class compactaArquivo {
    private String caminhoDoArquivo = "C:\\Users\\55889\\Documents\\JavaParaPersistencia\\dspersist\\Livros.csv";

    public compactaArquivo(String caminhoDoArquivo) {
        this.caminhoDoArquivo = caminhoDoArquivo;
    }

    public void compactarArquivo() {
        try {
            File arquivo = new File(caminhoDoArquivo);

            String nomeArquivo = arquivo.getName();

            FileInputStream fis = new FileInputStream(arquivo);

            String nomeArquivoZip = nomeArquivo.replaceFirst("[.][^.]+$", "");

            FileOutputStream fos = new FileOutputStream(nomeArquivoZip + ".zip");

            ZipOutputStream zipOut = new ZipOutputStream(fos);

            ZipEntry zipEntry = new ZipEntry(arquivo.getName());
            
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }

            zipOut.closeEntry();
            zipOut.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}