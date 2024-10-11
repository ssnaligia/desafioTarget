/* 3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, 
na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. 
Estes dias devem ser ignorados no cálculo da média; */

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class FaturamentoDistribuidora {
    public static void main(String[] args) {
        ArrayList<Double> faturamentos = new ArrayList<>();
        double menorValor = Double.MAX_VALUE, maiorValor = Double.MIN_VALUE, somaFaturamento = 0.0;
        int diasComFaturamento = 0, diasAcimaMedia = 0;

        try {
            JSONParser parser = new JSONParser();
            JSONArray dados = (JSONArray) parser.parse(new FileReader("data/dados.json"));

            for (Object obj : dados) {
                JSONObject registro = (JSONObject) obj;
                double valor = (double) registro.get("valor");

                if (valor > 0) {  
                    faturamentos.add(valor);
                    somaFaturamento += valor;
                    diasComFaturamento++;

                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }
                }
            }

            double mediaMensal = somaFaturamento / diasComFaturamento;

            for (double faturamento : faturamentos) {
                if (faturamento > mediaMensal) {
                    diasAcimaMedia++;
                }
            }

            System.out.printf("Menor valor de faturamento: %.2f\n", menorValor);
            System.out.printf("Maior valor de faturamento: %.2f\n", maiorValor);
            System.out.printf("Número de dias com faturamento acima da média mensal: %d\n", diasAcimaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
