

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Teste da classe Compromisso
 */
class testCompromisso {
//*Testa Construtor com todos os parametros */
    @Test 
    public void testConstrutor() { 
        Compromisso compromisso = new Compromisso("Academia",9,9,2022,1);
        assertEquals("Academia", compromisso.getNome());
        assertEquals("09/09/2022", compromisso.getData().dataFormatada());
        assertEquals(1, compromisso.getRepete());     
         }


//*Testa construtor que recebe os valores de nome e a data, sem o parametro de repetição. */
    @Test 
    public void testConstrutor2() {
        Compromisso compromisso = new Compromisso("Academia",9,9,2022);
        assertEquals("Academia", compromisso.getNome());
        assertEquals("09/09/2022", compromisso.getData().dataFormatada());
    }


//*Testa contrutor sem parametros. Atributos default. */
    @Test 
    public void testConstrutor3() {
        Compromisso compromisso = new Compromisso();
        Data novaData = new Data();
        assertEquals("Novo Compromisso", compromisso.getNome());
        assertEquals(novaData.dataFormatada(), compromisso.getData().dataFormatada());
        assertEquals(0, compromisso.getRepete());
    }

    //*Testa se o metodo de clonar compromisso esta funcionando corretamente */
    @Test
    public void testCopia() {
        Compromisso compromisso = new Compromisso("Academia",9,9,2022);
        Compromisso clone = new Compromisso();
        clone = compromisso.copia(); 
        assertEquals("Academia", clone.getNome());
        assertEquals("09/09/2022", clone.getData().dataFormatada());
    }

    
}