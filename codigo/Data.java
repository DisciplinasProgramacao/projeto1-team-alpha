import java.time.LocalDateTime;

/** Classe data simples para fundamentos de POO */
public class Data{
    //#region atributos
    //constante: dias de cada mês
    private static final int[] DIASDOMES = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static final String[] DIASDASEMANA = {"Sábado", "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"}; //2022 começa em um sábado

    //atributos 
    private int dia;
    private int mes;
    private int ano; 
    //#endregion
    
    //#region Construtores   

    /**
     * Inicializador privado. É utilizado pelos construtores. Faz a validação e, em caso de data inválida, retorna 01/01/1900.
     * @param dia Dia para a data
     * @param mes Mês para a data
     * @param ano Ano para a data
     */
    private void init(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        if (!this.dataValida()){
            this.dia = this.mes = 1;
            this.ano = 1900;
        }

        if(eAnoBissexto())
            DIASDOMES[1] = 29;
    }
    
    /**
     * Construtor completo: recebe dia, mês e ano e valida a data. Datas inválidas vão para 01/01/1900
     * @param dia Dia para a data
     * @param mes Mês para a data
     * @param ano Ano para a data
     */
    public Data(int dia, int mes, int ano){
        this.init(dia, mes, ano);
    }

    /**
     * Construtor para data padrão: data atual
     */
    public Data(){
        LocalDateTime dataAtual = LocalDateTime.now();

        this.init(dataAtual.getDayOfMonth(), dataAtual.getMonthValue(), dataAtual.getYear());
    }        
    //#endregion

    //#region Métodos GET

    /**
     * Retorna o dia estipulado
     * @return int com o dia
     */
    public int getDia(){
        return this.dia;
    }

    /**
     * Retorna o mes estipulado
     * @return int com o mes
     */
    public int getMes(){
        return this.mes;
    }

    /**
     * Retorna o ano estipulado
     * @return int com o ano
     */
    public int getAno(){
        return this.ano;
    }
    //#endregion

    //#region Métodos Booleanos

    /**  
    * Verifica se o ano da data armazenada é bissexto.
    * @return Se o ano é bissexto (true) ou não (false)
    */
    public boolean eAnoBissexto(){

        if(this.ano % 400 == 0) 
              return true;
        else if(this.ano % 4 == 0 && this.ano % 100 != 0)
              return true;

        return false;
    }

    /**
    * Verifica se a data armazenada é válida (método privado). Só valem datas de 1900 em diante.
    * @return Se a data é válida (true) e se não é válida (false)
    */
    private boolean dataValida(){
        int maximoDeDias = 0;

        if(this.ano < 1900)
            return false;
        else{
           if (this.mes < 1 || this.mes > 12)
               return false;
           else { 
                    maximoDeDias = DIASDOMES[mes];
                   if (this.eAnoBissexto() && mes == 2)
                          maximoDeDias++;
                   if (this.dia > maximoDeDias)
                           return false;
                }
        }

        return true;               
    }
    
    /**
     * Método booleano que compara o parâmetro do tipo Data com o atributo data do próprio objeto para verificar se é menor
     * @param data param do tipo Data
     * @return Se data parametrizada é menor (true) e se é igual ou maior (false)
     */
    public boolean eMenor(Data data){
        if(this.getAno() == data.getAno() && this.getMes() == data.getMes() && this.getDia() == data.getDia()){
            return false;
        }else{
            if (this.getAno() < data.getAno()){
                return true;
            }else{
                if (this.getMes() < data.getMes()){
                    return true;
                }else{
                    if(this.getDia() <data.getDia()){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }
        

    }
    //#endregion

    //#region Métodos principais

    /**
     * Método que adiciona a quantidade de dias informada a partir da data estipulada
     * @param dias param do tipo inteiro
     */
    public void adicionaDias(int dias){
        int mes = DIASDOMES[(this.mes - 1) % 12];

        if(dias > 0)
            this.dia += dias;

        if(this.dia > mes){
            while (this.dia > mes){

                if(eAnoBissexto()){ 
                    DIASDOMES[1] = 29; 
                } else {
                    DIASDOMES[1] = 28; 
                }

                this.dia -= mes;
                this.mes++;

                if(this.mes > 12){
                    this.ano++;
                    this.mes -= 12; 
                }

                mes = DIASDOMES[(this.mes - 1) % 12];
            }
        }
    }

    /**
     * Método que retorna a quantidade de dias no mês a partir da data informada
     * @return quantidade de dias no mês
     */
    public int diasNoMes(){
        return DIASDOMES[this.mes];
    }

    /**
     * Método que calcula o dia da semana da data correspondente (ignora o ano caso seja diferente).
     * Datas inválidas retornam e são calculadas como 01/01/2022
     * @return O dia da semana da data parametrizada.
     */
    public String diaDaSemana(){

        int deslocamento = 0;
        int totalDias = 0;
        int mesParaSomar = 1;
        
        while(mesParaSomar < this.mes){
            totalDias += DIASDOMES[mesParaSomar - 1];
            mesParaSomar++;
        }

        totalDias += (this.dia - 1);
        deslocamento = totalDias % 7;

        return DIASDASEMANA[deslocamento];
    }

    /**
     * Método que adiciona um dia à data correspondente
     */
    public void proximoDia(){
        if(this.dia == DIASDOMES[this.mes - 1]){
            if(this.mes == 12){

                this.ano++;
                this.mes = 1;
    
            } else 
                this.mes++;
            
            this.dia = 1;
        } else
            this.dia++;
    }

    /**
    * Retorna a data formatada
    * @return String com a data no formato dd/mm/aaaa
    */
    public String dataFormatada(){
        
        return (String.format("%02d",this.dia)+ 
          "/" + String.format("%02d",this.mes)+ 
          "/" + String.format("%4d",this.ano));
    }
}