public class Sorteios{
    
    public static int sorteiaNumero(int max){  /** Sorteia número - solicita um int que é o numero máximo do sorteio */ 
        int numero = (int)(Math.random() * max + 1); 
        return numero;
    }
    
    public static void preencheArray(int[] array){ /** Método para preencher Array já verificando números repetidos */ 
        for (int i = 0; i < array.length; i++){
            while (true){
                int numero = Sorteios.sorteiaNumero(60);
                boolean repetido = false;
                for (int j = 0; j < array.length; j++){
                    if (numero == array[j])
                        repetido = true;
                }
                
                if (!repetido){
                    array[i] = numero;
                    break;
                }
                
            }
        }
        
    }
    
    public static String sorteiaNome(){ // método para sortear os nomes
        String[] primeiroNome = {"Rodrigo", "Lorenzo", "Augusto", "Moises", "Davi", "Francisco", "Jader", "Luciano", "Valdecir",
                                 "Ricardo", "Claudia", "Gabriela", "Sueli", "Renata", "Franciele", "Carolina", "Vanessa", "Anita",
                                 "Juliana", "Janete"};
        String[] segundoNome = {"Marion", "Eron", "Silva", "Ferreira", "Von", "De", "Luz", "Quadros", "Da", "Quinta", "III", "Atz",
                                "Rodrigues", "Pico", "Pentz", "Lux", "Bonteri", "Bridger", "Dume", "Calrissian"};
        String[] sobrenome = {"Skywalker", "Organa", "Lars", "Kenobi", "Solo", "Vader", "Tarkin","Palpatine", "Mandalorian", "Hutt",
                              "Fett", "Amidala", "Maul", "Tano", "Dookan", "Windu", "Jinn", "Kryze", "Ohnaka", "Jarrus"};       
        
        String nome = "";
        nome += primeiroNome[sorteiaNumero(20)-1]; // subtraído 1 para aproveitar o metodo sorteiaNumero() e incluir a posição 0 do array
        nome += " "+segundoNome[sorteiaNumero(20)-1];
        nome += " "+sobrenome[sorteiaNumero(20)-1];
               
        return nome;
    }   
}