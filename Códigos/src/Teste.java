import java.time.LocalDate;


public class Teste {

    public static void main(String[] args) throws Exception {
        LocalDate data = LocalDate.of(2000, 10, 5);
        LocalDate data2 = LocalDate.of(2005, 11, 5);
        LocalDate data3 = LocalDate.of(2005, 11, 20);
        Despesa teste = new Despesa(data, "Anos 2000", 5000);
        Despesa teste2 = new Despesa(data2, "Anos 2005", 2000);
        Despesa teste3 = new Despesa(data3, "Anos 2010", 4000);
        DespesaPessoal despesas = new DespesaPessoal("12345");
        despesas.despesas.add(teste);
        despesas.despesas.add(teste2);
        despesas.despesas.add(teste3);
        despesas.imprime();

        System.out.println(despesas.getTotal(data));
        System.out.println(despesas.getTotal(11, 2005));
        System.out.println(despesas.getTotal());
        despesas.imprime(11, 2005);
        }
    }

