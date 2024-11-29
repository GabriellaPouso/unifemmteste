import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AgendaEletronica {

    private static final String ARQUIVO = "agenda.txt";
    private static final SimpleDateFormat FORMATO_DATA = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean sair = false;
            
            while (!sair) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Inserir novo evento");
                System.out.println("2. Listar eventos em ordem de data");
                System.out.println("3. Deletar um evento");
                System.out.println("4. Sair");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                
                switch (opcao) {
                    case 1 -> inserirEvento(scanner);
                    case 2 -> listarEventosOrdenados();
                    case 3 -> deletarEvento(scanner);
                    case 4 -> sair = true;
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
        System.out.println("Programa encerrado.");
    }

    private static void inserirEvento(Scanner scanner) {
        try (FileWriter writer = new FileWriter(ARQUIVO, true)) {
            System.out.print("Digite o título do evento: ");
            String titulo = scanner.nextLine();

            Date dataEvento = null;
            boolean dataValida = false;
            
            while (!dataValida) {
                System.out.print("Digite a data de início (dd/MM/yyyy): ");
                String dataInicio = scanner.nextLine();
                
                try {
                    dataEvento = FORMATO_DATA.parse(dataInicio);
                    Date dataAtual = new Date();
                    
                    // Normaliza as datas para comparar apenas as datas sem horário
                    Calendar calEvento = Calendar.getInstance();
                    calEvento.setTime(dataEvento);
                    calEvento.set(Calendar.HOUR_OF_DAY, 0);
                    calEvento.set(Calendar.MINUTE, 0);
                    calEvento.set(Calendar.SECOND, 0);
                    calEvento.set(Calendar.MILLISECOND, 0);
                    
                    Calendar calAtual = Calendar.getInstance();
                    calAtual.setTime(dataAtual);
                    calAtual.set(Calendar.HOUR_OF_DAY, 0);
                    calAtual.set(Calendar.MINUTE, 0);
                    calAtual.set(Calendar.SECOND, 0);
                    calAtual.set(Calendar.MILLISECOND, 0);
                    
                    if (calEvento.before(calAtual)) {
                        System.out.println("Não é possível registrar eventos em datas passadas!");
                        continue;
                    }
                    dataValida = true;
                } catch (ParseException e) {
                    System.out.println("Formato de data inválido. Use dd/MM/yyyy");
                }
            }

            System.out.print("Digite a duração do evento (em minutos): ");
            int duracao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            String evento = String.format("%s;%s;%d%n", titulo, FORMATO_DATA.format(dataEvento), duracao);
            writer.write(evento);

            System.out.println("Evento registrado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar o evento: " + e.getMessage());
        }
    }

    private static void listarEventosOrdenados() {
        List<Evento> eventos = new ArrayList<>();

        // Ler eventos do arquivo
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    try {
                        String titulo = partes[0];
                        Date dataInicio = FORMATO_DATA.parse(partes[1]);
                        int duracao = Integer.parseInt(partes[2]);
                        eventos.add(new Evento(titulo, dataInicio, duracao));
                    } catch (ParseException e) {
                        System.out.println("Erro ao interpretar a data: " + partes[1]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum evento encontrado. O arquivo ainda não foi criado.");
        } catch (IOException e) {
            System.out.println("Erro ao ler os eventos: " + e.getMessage());
        }

        // Ordenar os eventos por data
        eventos.sort(Comparator.comparing(Evento::getDataInicio));

        // Exibir eventos
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento registrado.");
        } else {
            System.out.println("\nEventos registrados (em ordem de data):");
            for (Evento evento : eventos) {
                System.out.println("Título: " + evento.getTitulo());
                System.out.println("Data de Início: " + FORMATO_DATA.format(evento.getDataInicio()));
                System.out.println("Duração: " + evento.getDuracao() + " minutos");
                System.out.println("-----------------------");
            }
        }
    }

    private static void deletarEvento(Scanner scanner) {
        List<String> eventos = new ArrayList<>();

        // Ler eventos do arquivo
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                eventos.add(linha);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum evento encontrado. O arquivo ainda não foi criado.");
            return;
        } catch (IOException e) {
            System.out.println("Erro ao ler os eventos: " + e.getMessage());
            return;
        }

        System.out.print("Digite o título do evento que deseja deletar: ");
        String tituloParaDeletar = scanner.nextLine();

        // Filtrar eventos que não têm o título especificado
        boolean encontrado = false;
        List<String> eventosAtualizados = new ArrayList<>();
        for (String evento : eventos) {
            String[] partes = evento.split(";");
            if (partes.length > 0 && partes[0].equalsIgnoreCase(tituloParaDeletar)) {
                encontrado = true;
                continue; // Pular o evento que será deletado
            }
            eventosAtualizados.add(evento);
        }

        if (!encontrado) {
            System.out.println("Evento com o título '" + tituloParaDeletar + "' não encontrado.");
            return;
        }

        // Reescrever o arquivo com os eventos restantes
        try (FileWriter writer = new FileWriter(ARQUIVO)) {
            for (String evento : eventosAtualizados) {
                writer.write(evento + System.lineSeparator());
            }
            System.out.println("Evento deletado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
        }
    }

    // Classe interna para representar um evento
    static class Evento {
        private final String titulo;
        private final Date dataInicio;
        private final int duracao;

        public Evento(String titulo, Date dataInicio, int duracao) {
            this.titulo = titulo;
            this.dataInicio = dataInicio;
            this.duracao = duracao;
        }

        public String getTitulo() {
            return titulo;
        }

        public Date getDataInicio() {
            return dataInicio;
        }

        public int getDuracao() {
            return duracao;
        }
    }
}