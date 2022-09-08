import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testaCalendario {
	public static Calendario calendario;
	public static Compromisso futebol;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    
    /**
     * Método executado antes de cada teste, criando um objeto do tipo calendario e adicionando o compromisso futebol na data 10/10/2022
     * @throws Exception
     */
	@BeforeEach
	void setUp() throws Exception {
		calendario = new Calendario();
		futebol = new Compromisso("Futebol",10,10,2022,0);
		calendario.adicionarCompromisso(futebol);
        PrintStream novoFluxoDeImpressao = new PrintStream(output, true, "UTF-8");
        System.setOut(novoFluxoDeImpressao);
	}
	
    @AfterEach
    public void cleanUp()  {
        output.reset();
    }
    
    /**
     * Método que testa a adição de compromissos no calendário
     */
    @Test
    void testAdicionarCompromisso() {
    	Calendario calendarioVazio = new Calendario();
    	Compromisso academia = new Compromisso("Academia",10,10,2022);
    	calendarioVazio.adicionarCompromisso(academia);
    	calendarioVazio.mostrarTodosCompromissos();
    	assertEquals("Academia - 10/10/2022", output.toString());
    }
	
    /**
     * Método que testa a remoção de compromissos no calendário
     */
	@Test
	void testRemoverCompromisso() {
		try {
			assertEquals(futebol,calendario.removerCompromisso("Futebol"));
		} catch (Exception e) {
			e.toString();
		}
	}
	
    /**
     * Método que testa se o calendário está vazio
     */
	@Test
	void testCalendarioVazio() {
		assertFalse(calendario.calendarioVazio());
		try {
			calendario.removerCompromisso("Futebol");
		} catch (Exception e) {
			e.toString();
		}
		assertTrue(calendario.calendarioVazio());
	}

}
