import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Question3 {
    public static void main(String[] args) {
        try {
            // Carrega o conteúdo do arquivo JSON
            String conteudo = new String(Files.readAllBytes(Paths.get("faturamento.json")));
            JSONArray faturamentoMensal = new JSONArray(conteudo);

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0;
            int diasComFaturamento = 0;
            int diasAcimaDaMedia = 0;

            // Primeiro loop: Calcula menor, maior, soma, e também já conta dias acima da média
            for (int i = 0; i < faturamentoMensal.length(); i++) {
                double faturamento = faturamentoMensal.getJSONObject(i).getDouble("faturamento");

                // Ignora dias sem faturamento (faturamento == 0)
                if (faturamento > 0) {
                    // Atualiza o menor e maior faturamento
                    if (faturamento < menorFaturamento) {
                        menorFaturamento = faturamento;
                    }
                    if (faturamento > maiorFaturamento) {
                        maiorFaturamento = faturamento;
                    }

                    // Soma os valores e conta dias válidos
                    somaFaturamento += faturamento;
                    diasComFaturamento++;
                }
            }

            // Calcula a média somente agora
            double mediaFaturamento = somaFaturamento / diasComFaturamento;

            // Segundo loop: Apenas para contar dias acima da média
            for (int i = 0; i < faturamentoMensal.length(); i++) {
                double faturamento = faturamentoMensal.getJSONObject(i).getDouble("faturamento");

                // Ignora dias sem faturamento
                if (faturamento > mediaFaturamento) {
                    diasAcimaDaMedia++;
                }
            }

            // Exibe os resultados
            System.out.println("Menor faturamento: " + menorFaturamento);
            System.out.println("Maior faturamento: " + maiorFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
