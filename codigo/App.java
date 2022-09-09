public class App {

	public static void main(String[] args) {
		Calendario calendario = new Calendario();
		System.out.println("Adicionando compromisso futebol na data 10/10/2022:");
		Compromisso futebol = new Compromisso("Futebol",10,10,2022);
		calendario.adicionarCompromisso(futebol);
		System.out.println("Mostrando calendário:");
		calendario.mostrarTodosCompromissos();


		System.out.println("\nAdicionando compromisso pilates na data 12/09/2022");
		Compromisso pilates = new Compromisso("Pilates",12,9,2022);
		calendario.adicionarCompromisso(pilates);
		System.out.println("Mostrando calendário:");
		calendario.mostrarTodosCompromissos();


		System.out.println("\nRemovendo o compromisso pilates");
		try {
			calendario.removerCompromisso("Pilates");
		} catch (Exception e) {
			e.toString();
		}
		System.out.println("Mostrando calendário:");
		calendario.mostrarTodosCompromissos();


		System.out.println("\nAdicionando o compromisso basquete de 7 em 7 dias durante 4 semanas:");
		Compromisso basquete = new Compromisso("Basquete",3,11,2022,12);
		calendario.adicionarCompromissoRepetido(basquete,30);
		System.out.println("Mostrando calendário:");
		calendario.mostrarTodosCompromissos();

		
		System.out.println("\nMostrando os compromissos entre as datas 07/10/2022 e 20/11/2022");
		Data dataInicial = new Data(7,10,2022);
		Data dataFinal = new Data(20,11,2022);
		calendario.mostrarCompromissosIntervalo(dataInicial, dataFinal);
	}

}
