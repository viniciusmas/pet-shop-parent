package br.edu.infnet.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

    private Util() {}

    public static LocalDateTime convertStingTolocalDateTime(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(data, formatter);
        LocalDateTime localDateTime = localDate.atStartOfDay();

        return localDateTime;
    }

    public static String convertlocalDateTimeToString(LocalDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatter);

        return dataFormatada;
    }
}
