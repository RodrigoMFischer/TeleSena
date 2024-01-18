/** Aluno: Rodrigo Marion Fischer
 *  Algoritmos e programação: Fundamentos Módulo 5 */

public class Principal{
    public static void main (String [] args){
        ControleTS cts = new ControleTS(); // instancia o controle de tele senas
        
        cts.sorteioPrincipal(); // realiza o sorteio
        if(cts.verificaGanhador()){  // verifica ganhador, caso se verdadeiro já imprime os dados do sorteio 
            System.out.println("      MAAA OOIIII, TEMOS UM OU MAIS GANHADORES\n      OS AUDITORES ESTÃO CONTABILIZANDO OS DADOS\n");
            cts.mostraNumerosSorteados();
            cts.quantTeleSena();
            cts.mostraGanhador();
        }
        else{  // continua o sorteio até aparecer ganhadores
            cts.continuaSorteio();
            System.out.println('\u000C'); // comentar essa linha para ver a auditoria do sistema
            System.out.println("      MAAA OOIIII, TEMOS UM OU MAIS GANHADORES\n      OS AUDITORES ESTÃO CONTABILIZANDO OS DADOS\n");
            cts.mostraNumerosSorteados();
            cts.quantTeleSena();
            cts.mostraGanhador();
        }
        
        
    }
}