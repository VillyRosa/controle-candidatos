package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
            System.out.println();
        }
    }
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else System.out.println("CONTATO REALIZADO COM SUCESSO!");
        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        } else System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");

    }
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        System.out.println("Candidatos selecionados:");
        for (String candidato : candidatos) {
            System.out.println(candidato);
        }
    }
    static void selecaoCandidatos() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("\nO candidato(a) " + candidato + " solicitou este valor de salário R$ " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato(a) " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            } else System.out.println("O candidato(a) " + candidato + " não foi selecionado para a vaga.");
            candidatoAtual++;
        }
    }
    static double valorPretendido() {
        double valor = ThreadLocalRandom.current().nextDouble(1800, 2200);
        return Math.round(valor * 100.0) / 100.0;
    }
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO PARA CONTRA PROPOSTA");
        } else System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
    }
}