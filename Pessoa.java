public class Pessoa{
    private String nome;
    private TeleSena teleSenas[];
    private double premio; // Recebe o valor do premio
    private int ganhador; //Acumula a quantidade de TS premiadas para calcular frações correspondentes do premio
    
    public Pessoa (String nome) { // construtor - recebe um nome vindo de um array padrão na classe ControleTS
        this.nome = nome;
        this.teleSenas = new TeleSena[Sorteios.sorteiaNumero(15)];
        this.premio = 0;
        for (int i = 0; i < teleSenas.length; i++)
            teleSenas[i] = new TeleSena();
    }
    
    public void mostraTS(){ // mostra as tele senas - foi usado só para teste
    for (int i = 0; i < teleSenas.length; i++)
            System.out.println(teleSenas[i]);
    } 
    
    public String toString(){ // toString retorna nome da Pessoa
        return nome;
    }
    
    public TeleSena[] getTeleSenas(){ // método que permite acessar o array de tele senas da pessoa
        return teleSenas;
    }
    
    public void setGanhador(int ganhador){ // metodo para alterar a quantidade de tele senas premiadas
        this.ganhador = ganhador;
    }
    
    public int getGanhador(){ // metodo para acessar a quantidade de tele senas premiadas
        return ganhador;
    }
    
    public void setPremio(double premio){ // metodo par alterar o valor do premio
        this.premio = premio;
    }
    
    public double getPremio(){ // método para acessar o premio da pessoa
        return premio;
    }
}