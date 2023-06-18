import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class DespesaPessoal {
    private String cpf;
    ArrayList<Despesa> despesas = new ArrayList<>(); //Array para ter uma composição com a classe Despesa. Onde DespesaPessoa tem muitas despesas. 
    public DespesaPessoal(){
        
    }
    public DespesaPessoal(String cpf){
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public double getTotal(){ //Obeter o valor total dos objertos despesas.
        double valorTotal = 0; //Variável local para ser retornada.
        for (Despesa despesa : despesas) { //Aqui está sendo feito um loop onde no foreach a var "despesa" está passando pela lista "despesas".
            valorTotal+= despesa.getValor(); //Como a var despesa não tem acesso ao atributo da classe Despesa, é utilizado o método get que está como público, para pegar o valor dessa var.
        }
        return valorTotal; //Retorno da var valor total logo acima que foi incrementada.
    }
    public double getTotal(int mes, int ano){ //Mesma coisa que o de cima, mas agora só retornará para anos e meses específicos.
        double valorTotalDoMesEAno=0;
        for (Despesa despesa : despesas) {
                if (despesa.getData().getMonthValue() == mes && despesa.getData().getYear() ==ano){ //a var (objeto) despesa está pegando o método get que retorna a data para ter acesso ao valor do mês e ano.
                    valorTotalDoMesEAno+=despesa.getValor(); //Ou seja, esse valor só será retornado se passar um mês e ano que exista dentro do obj despesa.
                }

        }
        return valorTotalDoMesEAno;
    }
    public double getTotal(LocalDate data){ //Mesmo que o de cima, mas utilizando um parâmetro LocalDate, o método equals é usado para poder comparar os atributos do parâmetro (obj data) e  da classe Despesa.
        double valorTotalDeterminadaData = 0;
        for (Despesa despesa : despesas) {
            if (despesa.getData().equals(data)){
                valorTotalDeterminadaData+= despesa.getValor();
            }
        }
        return valorTotalDeterminadaData;
    }
    public void imprime(){ //Esse método todos os objetos e o imprime pelo método toString da classe Despesa, ou seja imprime todas as informações destes objetos.
        String imprimir = "";
        int contador = 1;
        for (Despesa despesa : despesas) {

            imprimir= imprimir+"O cliente do CPF "+this.cpf+" e da despesa número "+contador+" tem como registrado a seguinte despesa: "+despesa;
            contador+=1;
        }
        JOptionPane.showMessageDialog(null, imprimir ); //pequeno menu de mensagem para imprimir as informações.
    }
    public void imprime(int mes, int ano){ //Mesma coisa que o de cima, mas agora é utilizado parâmetros mês e ano.
        String imprimir = "";
        int contador = 1;
        for (Despesa despesa : despesas) {
            if (despesa.getData().getMonthValue() == mes && despesa.getData().getYear() ==ano){
                imprimir= imprimir+"O cliente do CPF "+this.cpf+" e da despesa número "+contador+" tem como registrado a seguinte despesa: "+despesa;
                contador+=1;
            }

    }
    JOptionPane.showMessageDialog(null, imprimir );
    }
    public void imprime(LocalDate data){
        String imprimir = "";
        int contador = 1;
        for (Despesa despesa : despesas) {
            if (despesa.getData().equals(data)){
                imprimir= imprimir+"O cliente do CPF "+this.cpf+" e da despesa número "+contador+" tem como registrado a seguinte despesa: "+despesa;
                contador+=1;
            }
        }
        JOptionPane.showMessageDialog(null, imprimir );
    }
    @Override
    public String toString() {
        return "DespesaPessoal [cpf=" + cpf + ", despesas=" + despesas + "]";
    }
    

}
