public class TeleSena{
    private double valor;
    private int um[],dois[]; // cartelas um e dois da tele sena
    private int cartUmAcertos, cartDoisAcertos; // PARA SOMAR OS ACERTOS DE CADA CARTELA - valor pecisa ser zerado a cada contagem
    
    public TeleSena(){ // método construtor - não recebe nenhuma entrada pois todos valores são padrão
        this.valor = 10;
        this.um = new int[25]; 
        this.dois = new int[25];
        Sorteios.preencheArray(um); /** Preenche os arrays com números */
        Sorteios.preencheArray(dois);
    }
    
    public String toString(){ // método toString retorna os numeros existentes em cada tele sena
        String mostraTS = "Cartela 1 |";
        for (int i = 0; i < um.length; i++)
            mostraTS += um[i]+"|";
        mostraTS += "\nCartela 2 |";
        for (int i = 0; i < dois.length; i++)
            mostraTS += dois[i]+"|";
        mostraTS += "\n";
        return mostraTS;
    }
    
    public int[] getUm(){ // método para acessar os numeros da cartela 1
        return um;
    }
    
    public int[] getDois(){ // método para acessar os numeros da cartela 2
        return dois;
    }
    
    public void setCartUmAcertos(int cartUmAcertos){ // método para alterar a contabilização dos pontos da cartela 1
        this.cartUmAcertos = cartUmAcertos;
    }
    
    public int getCartUmAcertos(){ // método para acessar os acertos da cartela 1
        return cartUmAcertos;
    }
    
    public void setCartDoisAcertos(int cartDoisAcertos){ // método para alterar a contabilização dos pontos da cartela 2
        this.cartDoisAcertos = cartDoisAcertos;
    }
    
    public int getCartDoisAcertos(){ // método para acessar os acertos da cartela 2
        return cartDoisAcertos;
    }
    
    public double getValor(){ // retorna o valor da tele sena - para calcular o valor total das vendas
        return valor;
    }
}