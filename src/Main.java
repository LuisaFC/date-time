import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        //Instant -> global

        //Instanciação de data hoje
        LocalDate d01 = LocalDate.now();
        System.out.println("Hoje é: " + d01);

        //Instanciação data-hora de agora loca
        LocalDateTime d02 = LocalDateTime.now();
        System.out.println("Hoje é dia e são: " + d02);

        //Instanciação da data-hora de agora global -> com fuso
        Instant d03 = Instant.now();
        System.out.println("Com fuso: " + d03);

        //Gerar data-hora atráves do ISO 8601
        LocalDate d04 = LocalDate.parse("2024-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2024-07-20T01:30:26");
        Instant d06 = Instant.parse("2024-07-20T01:30:26Z");
        Instant d07 = Instant.parse("2024-07-20T01:30:26-03:00");
        System.out.println("Iso 8601 data: " + d04);
        System.out.println("Iso 8601 data-hora: " + d05);
        System.out.println("Iso 8601 data-hora com Instante global: " + d06);
        System.out.println("Iso 8601 data-hora com Instante global e fuso Brasil: " + d07);

        //Textoo customizado para virar data-hora
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDate d08 = LocalDate.parse("20/07/2024", fmt1);
        LocalDate d09 = LocalDate.parse("20/07/2024 01:30", fmt2);
        System.out.println("Customizado: " + d08);
        System.out.println("Customizado data-hora: " + d09);

        // Dia, mes e ano isolados
        LocalDate d10 = LocalDate.of(2024, 7, 20);
        LocalDateTime d11 = LocalDateTime.of(2023, 10, 23, 14, 39);
        System.out.println("ISolados: " + d10);
        System.out.println("Isolados data-hora: " + d11);


        // Transformando Data-hora em texto
        System.out.println("Primeira formatação: " + d04.format(fmt1));
        System.out.println("Segunda formatação: " + d05.format(fmt2));

        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        System.out.println("Instant pegando horario local do usuario: " + fmt3.format(d06));

        // Dara-hora global para local

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);

        System.out.println("d04 dia = " + d04.getDayOfMonth());
        System.out.println("d04 mês = " + d04.getMonthValue());
        System.out.println("d04 ano = " + d04.getYear());

        System.out.println("d05 hora = " + d05.getHour());
        System.out.println("d05 minutos = " + d05.getMinute());

        //Operações com date-time

        LocalDate pastWeekDate = d04.minusDays(7);
        LocalDate nextWeekDate = d04.plusDays(7);

        LocalDateTime pastWeekLocalDate = d05.minusDays(7);
        LocalDateTime nextWeekLocalDate = d05.plusDays(7);

        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekDate = " + pastWeekDate);
        System.out.println("nextWeekDate = " + nextWeekDate);

        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);

        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);

        Duration t1 = Duration.between(pastWeekDate.atStartOfDay(), d04.atStartOfDay());
        Duration t2 = Duration.between(pastWeekLocalDate, d05);
        Duration t3 = Duration.between(pastWeekInstant, d06);
        Duration t4 = Duration.between(d06, pastWeekInstant);

        System.out.println("t1 dias = " + t1.toDays());
        System.out.println("t2 dias = " + t2.toDays());
        System.out.println("t3 dias = " + t3.toDays());
        System.out.println("t4 dias = " + t4.toDays());
    }
}