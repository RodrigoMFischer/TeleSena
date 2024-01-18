public class ControleTS{
    private Pessoa pessoas[]; // array qua armazena as pessoas
    private int[] sorteio; // array que armazena os numeros sorteados
    private double valorArrecadado; // recebe o total arrecadado com a venda de TS
    
    public ControleTS(){  // contrutor da classe de controle das tele senas
        this.pessoas = new Pessoa[Sorteios.sorteiaNumero(20)];   /** Cria array de no maximo 20 pessoas*/ 
        for (int i = 0; i < pessoas.length; i++)
            pessoas[i] = new Pessoa(Sorteios.sorteiaNome());
    }
    
    
    public void mostraPessoas(){ // metodo criado para teste  e acompanhamento do programa - mostra as pessoas e suas tele senas
    for (int i = 0; i < pessoas.length; i++){
            System.out.println(pessoas[i]+"\n");
            pessoas[i].mostraTS();
        }
    } 
    
    public void sorteioPrincipal(){    /** Sorteia 25 numeros*/ 
        this.sorteio = new int[60];
        for (int i = 0; i < 25; i++){
            while (true){
                int numero = Sorteios.sorteiaNumero(60);
                boolean repetido = false;
                for (int j = 0; j < sorteio.length; j++){
                    if (numero == sorteio[j])
                        repetido = true;
                }
                
                if (!repetido){
                    sorteio[i] = numero;
                    break;
                }
            }
            System.out.print(sorteio[i]+"|");
        }
        System.out.println("");
    }
           
    public void continuaSorteio(){   //  Continuação do sorteio caso não tenha ganhador - parte deste método retirado do preencheArray() 
        
        for (int i = 25; i < sorteio.length; i++){
            while (true){
                int numero = Sorteios.sorteiaNumero(60);
                boolean repetido = false;
                for (int j = 0; j < sorteio.length; j++){
                    if (numero == sorteio[j])
                        repetido = true;
                }
                
                if (!repetido){
                    sorteio[i] = numero;
                    break;
                }
          
            }
            contaPontos();
            if (verificaGanhador())
                break;
        }
        
    }
    
    public void contaPontos(){ // busca as tele senas, compara numero a numero com o sorteio e incrementa a variável de acertos dentro da telesena
        for(int i = 0; i < pessoas.length; i++){ // percorre o array de pessoas
            for (int j = 0; j < pessoas[i].getTeleSenas().length; j++){ // percorre o array de telesenas
                pessoas[i].getTeleSenas()[j].setCartUmAcertos(0); //zera os pontos antes de contar novamente cartela 1
                pessoas[i].getTeleSenas()[j].setCartDoisAcertos(0); //zera os pontos antes de contar novamente cartela 2
                for (int k = 0; k < pessoas[i].getTeleSenas()[j].getUm().length; k++){ // percorre o array da cartela 1 da TS
                    int compara = pessoas[i].getTeleSenas()[j].getUm()[k];                    
                    for (int L = 0; L < sorteio.length; L++){  // percorre o array de numeros sorteados comparando com a cartela 1
                        if (compara == sorteio[L])
                            pessoas[i].getTeleSenas()[j].setCartUmAcertos(pessoas[i].getTeleSenas()[j].getCartUmAcertos() + 1);  
                    }
                }
                for (int k = 0; k < pessoas[i].getTeleSenas()[j].getDois().length; k++){ // percorre o array da cartela 2 da TS
                    int compara = pessoas[i].getTeleSenas()[j].getDois()[k];
                    for (int L = 0; L < sorteio.length; L++){  // percorre o array de numeros sorteados comparando com a cartela 2
                        if (compara == sorteio[L])
                            pessoas[i].getTeleSenas()[j].setCartDoisAcertos(pessoas[i].getTeleSenas()[j].getCartDoisAcertos() + 1);  
                    }
                }
                System.out.println("");  // imprime todas as pessoas, suas tele senas e os acertos em cada uma
                System.out.println("Nome: "+pessoas[i]); // deixei estas linhas para conferencia se necessário
                System.out.println("TeleSena: "+j);
                System.out.println("Cartela 1: "+pessoas[i].getTeleSenas()[j].getCartUmAcertos());
                System.out.println("Cartela 2: "+pessoas[i].getTeleSenas()[j].getCartDoisAcertos());                
            }
        }
        System.out.println("**************************************************************************************");
    }
    
    public boolean verificaGanhador(){  // verifica se alguma telesena tem 25 pontos e incrementa a variavel ganhador da pessoa
        boolean ganha = false;
        for(int i = 0; i < pessoas.length; i++){
            for (int j = 0; j < pessoas[i].getTeleSenas().length; j++){
                if (pessoas[i].getTeleSenas()[j].getCartUmAcertos() >= 25 || pessoas[i].getTeleSenas()[j].getCartDoisAcertos() >= 25){
                    pessoas[i].setGanhador(pessoas[i].getGanhador() + 1);
                    ganha = true;
                }
            }
        }
        return ganha;
    }
    
    public void quantTeleSena(){ // método que contabiliza a quantidade de tele senas vendidas e total arrecadado
        int quant = 0;        
        for(int i = 0; i < pessoas.length; i++)
            quant += pessoas[i].getTeleSenas().length;
        valorArrecadado = quant*pessoas[0].getTeleSenas()[0].getValor();
        System.out.println("Quantidade de Tele Senas vendidas: "+quant);
        System.out.println("Valor total arrecadado: "+ (valorArrecadado));
        
    }
    
    public void mostraNumerosSorteados(){ // método que imprime na tela os numeros sorteados
        int totalNumSorteados = 0;
        System.out.print("Os numeros Sorteados foram |");
        for (int i = 0; i < sorteio.length; i++){
            if (sorteio[i] == 0){
                totalNumSorteados = i+1;
                break;                
            }
            else
                System.out.print(sorteio[i]+"|");            
        }
        System.out.println("\nUm total de "+totalNumSorteados+" números"); 
    }
    
    public void mostraGanhador(){  // Método que verifica os ganhadores e já distribui o premio 
        int quantPremios = 0;
        double premio = valorArrecadado * 0.8;
        double lucroSilvio = valorArrecadado * 0.2;
        String dadosGanhadores = "";
        for(int i = 0; i < pessoas.length; i++) // acumula a quantidade de telesenas premiadas na variavel
            quantPremios += pessoas[i].getGanhador();            
        
        for(int i = 0; i < pessoas.length; i++){ // paga o premio para a pessoa na mesma fração de TS premiada
            if (pessoas[i].getGanhador() > 0){
                pessoas[i].setPremio((premio / quantPremios)*pessoas[i].getGanhador());
                dadosGanhadores += "Nome do Ganhador: " + pessoas[i].toString() + "   Valor do Prêmio: "+ pessoas[i].getPremio()+"\n";
            }
        }
        if (quantPremios == 1) // IF só para colocar o texto no plural caso necessário
            System.out.println("Foi Sorteada 1 Tele Sena.");
        else
            System.out.println("Foram Sorteadas " + quantPremios + " Tele Senas.");
        System.out.println("O valor total do premio foi de R$" + premio);
        System.out.println(dadosGanhadores);
        System.out.println("O Lucro do Silvio Santos foi de R$ " + lucroSilvio);
    }
}
