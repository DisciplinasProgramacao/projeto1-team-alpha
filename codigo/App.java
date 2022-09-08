public class App {

	public static void main(String[] args) {
		Calendario calendario = new Calendario();
		Compromisso compromisso1 = new Compromisso("Futebol",1,1,2022,5);
		calendario.adicionarCompromissoRepetido(compromisso1, 3);

		calendario.mostrarTodosCompromissos();
	}

}
