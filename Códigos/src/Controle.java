/*  
 ===================================================================================
 FATEC FERRAZ DE VASCONCELOS 
 Matéria: Programação orientada ao objeto
 Professora: ANA ROSA COIAHY TONÃO
 Programador:    VAGNER DA SILVA MATIAS
                   
 Programa: CONTROLE DE DESPESAS
 Entrada: Dados do usuário: cpf, nome valor, data de nascimento etc...
 Saída: Valor total ou parcial das despesas acumuladas.
 =====================================================================================    
 */
import javax.swing.JOptionPane;
import java.time.LocalDate;
public class Controle {
    protected static int dia;
    protected static int mes;
    protected static int ano;
    protected static String itemDespesa;
    protected static double valor;
    protected static String cpf;
    protected static LocalDate data;
   protected static DespesaPessoal despesas = new DespesaPessoal();
    public Controle(){

    }
    public static void main(String[] args) {
        //String cpf;
        
        while (true){ //loop para que prevenir erros na inserção do número de cpf.
            
            try{
                cpf = JOptionPane.showInputDialog("Digite o seu CPF"); //menu para inserir o número de cpf.
                int cpfN = Integer.parseInt(cpf); //conversão da variável cpf para int por meio de outra var
                System.out.println(cpf);
                
                if ((cpf!=null && cpfN>0)) //Se a var cpf for diferente de nula e fpr maior do que 0, o loop quebrará.
                
                break;
            }catch(Exception err){
                JOptionPane.showMessageDialog(null, "Informe o cpf corretamente");
            }
            
        }
        despesas.setCpf(cpf); //método para alterar o valor privado de cpf do obj da classe DespesaPessoal.
        System.out.println(despesas.getCpf());
        controleDespesas();
        System.out.println(valor);
        System.out.println(dia+" "+ mes+" "+ ano);
    }
 
    public static void controleDespesas(){

        
        String option; //String para pegar o valor da lista de menu criada abaixo.
        int selecionado = 0; //Var para controlar a lista que o usuário escolherá.
		while (true) {
            
                option = JOptionPane.showInputDialog(
			"1 - Lançamento de despesa\n2 - Total geral de despesas\n3 - Total de despesas mês/ano\n4 - Total de espesas dia/mês/ano\n5 - Imprimir todas as despesas\n6 - Imprimir despesas de um mês/ano\n7 - Imprimir despesas de um dia/mês/ano\n8-Sair");
                int local = Integer.parseInt(option);//conversão da var option e int na nova variável chamada "local".
                selecionado = local; //Transformação da var selecionado no valor da var local.
                switch (selecionado){ //Switch para pegar todos os 8 possíveis casos.
                    case 1:
                    if (selecionado == 1){
                        //Se selecionado for = 1, então rodará o método abaixo.
                        entradaDespesa();
                        break;
                    }
                    case 2:
                    if (selecionado ==2){
                        if (despesas.despesas.size()>0){
                            JOptionPane.showMessageDialog(null, "Valor total das despesas do mês e ano inseridos " + despesas.getTotal()+"R$");
                        }else{
                            JOptionPane.showMessageDialog(null, "Não há nenhuma despesa.");
                        }
                        
                    }
                    case 3:
                    if (selecionado ==3){
                        int mesLocal;
                        int anoLocal;
                        while (true){
                            try {
                                mesLocal = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês"));
                                anoLocal = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano"));
                                if (mesLocal!=0 && anoLocal!=0)
                                break;
                            } catch (Exception err) {
                                JOptionPane.showMessageDialog(null,"Houve um erro, tente novamente." );
                            }
                        }
                        if (despesas!=null){
                            JOptionPane.showMessageDialog(null, "Valor total das despesas é de " + despesas.getTotal(mesLocal, anoLocal)+"R$");
                        } 
                        
                    }
                    case 4:
                    if (selecionado ==4){
                        int mesLocal;
                        int anoLocal;
                        int diaLocal;
                        while (true){
                            try {
                                diaLocal = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia"));
                                mesLocal = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês"));
                                anoLocal = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano"));
                                
                                if (diaLocal!=0 && mesLocal!=0 && anoLocal!=0)
                                break;
                            }catch (Exception err){
                                JOptionPane.showMessageDialog(null,"Houve um erro, tente novamente." );
                            }
                            
                        }
                        if (despesas!=null){
                            JOptionPane.showMessageDialog(null, "Valor total das despesas é de " + despesas.getTotal(LocalDate.of(anoLocal, mesLocal, diaLocal))+"R$");
                        }
                    }
                    case 5:       
                    if (selecionado ==5){
                        if (despesas.despesas.size()>0){
                            despesas.imprime();
                        }else{
                            JOptionPane.showMessageDialog(null, "Não há despesas registradas!");
                        }
                        
                    }
                    case 6:
                    if (selecionado ==6){
                        int mesLocal;
                        int anoLocal;
                        boolean VddFls = false;
                        while (true){
                           // int contador1 = despesas.despesas.size();
                            //int contador2 = 0;
                            try{
                                mesLocal = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês"));
                                anoLocal = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano"));
                                break;
                            }catch(Exception err){
                                JOptionPane.showMessageDialog(null,"Houve um erro, tente novamente." );
                            }
                        }
                        for (Despesa i: despesas.despesas){
                            if (i.getData().getMonthValue() == mesLocal && i.getData().getYear() ==anoLocal){
                                VddFls = true;
                            }
                        
                        }
                        if(VddFls==true){
                            despesas.imprime(mesLocal, anoLocal);
                        }else{
                            JOptionPane.showMessageDialog(null,"Não há despesas registradas com este mês e este ano!" );
                        }
                            
                        
                    }
                    case 7:
                    if (selecionado ==7){
                        int diaLocal;
                        int mesLocal;
                        int anoLocal;
                        LocalDate data;
                        boolean VddFls = false;
                        while (true){
                            try{
                                diaLocal = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia"));
                                mesLocal = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês"));
                                anoLocal = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano"));
                                break;
                            }catch (Exception err){
                                JOptionPane.showMessageDialog(null,"Houve um erro, tente novamente." );
                            }
                        }
                        data = LocalDate.of(anoLocal, mesLocal, diaLocal);
                        for (Despesa i: despesas.despesas){
                            if (i.getData().equals(data)){
                                VddFls = true;

                            }
                        }
                        if (VddFls==true){
                            despesas.imprime(data);
                        }else{
                            JOptionPane.showMessageDialog(null,"Não há despesas registradas para esta data!" );
                        }
                    }
                    case 8:
                    if (selecionado ==8){
                        JOptionPane.showMessageDialog(null,"Obrigado por usar o aplicativo(:" );
                        System.exit(0);
                        itemDespesa ="8"; 
                        
                        break;
                    }
                    
                }
                
            }
            
        }
           
				
		
    
    
    public static void entradaDespesa(){ //Método para entrada de dados, onde são inseridos valor da empresa, descrição e data.
        String valorS = JOptionPane.showInputDialog("Digite o valor da despesa");
        int valorVar = Integer.parseInt(valorS);
        
        String descDespesa = JOptionPane.showInputDialog("Coloque a descrição da despesa");
        entradaAno();
        entradaMes();
        entradaDia();
        data = LocalDate.of(ano, mes, dia);
        despesas.despesas.add(new Despesa(data, descDespesa, valorVar));

        
    }
    public static void entradaDia(){ //Método para alterar o valor das variáveis estáticas acima.
        int diaS = 0;
        while (true){
            diaS = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia"));
            try{
                
                if(diaS!=0)
                break;
            }catch(Exception err){
                JOptionPane.showMessageDialog(null,"Algo errado, tente novamente." );
            }
        }
        
        
        //int valorVar = Integer.parseInt(diaS); 
        dia = diaS;
        
    }
    public static void entradaMes(){
        int mesS = 0;
        while (true){
            try{
                mesS = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês"));
                if (mesS!=0)
                break;
            }catch (Exception err){
                JOptionPane.showMessageDialog(null,"Houve um erro, tente novamente." );
            }
        }
        mes = mesS;
    }
    public static void entradaAno(){

        int anoS = 0;
        while (true){
            try{
                anoS = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano"));
                if(anoS!=0)
                    break;
                }catch (Exception err){
                    JOptionPane.showMessageDialog(null,"Houve um erro, tente novamente." );
            }
            
            }
            ano = anoS;
        }
    

}
