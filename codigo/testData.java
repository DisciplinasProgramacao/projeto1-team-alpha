

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Teste da classe Compromisso
 */
class testData {

//*Testa se a data atual é menor que a data Teste */
    @Test 
    public void testEmenor() { 
        Data dataAtual = new Data();
        Data comparaFalse = new Data(28,10,2022);
        Data comparaTrue = new Data(28,6,2022);
        
        assertEquals(comparaTrue.eMenor(dataAtual), true);
        assertEquals(comparaFalse.eMenor(dataAtual), false);
    }

    //* Testa se o metodo de adicionar dia esta funcionando corretamente */
    @Test 
    public void testAdicionaDia() {
        Data dataAtual = new Data();
        dataAtual.adicionaDias(8);
        assertEquals("16/09/2022", dataAtual.dataFormatada());
    }

}