package br.com.ekan.avaliacao.ekan.utils.localdatetime;

import lombok.experimental.UtilityClass;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class LocalDateTimeUtils {

  @Named("convertDateStringToLocalDateTime")
  public static LocalDateTime convertDateStringToLocalDateTime(String date) {
    if(date == null || date.isEmpty()) return null;
    DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return LocalDate.parse(date, parser).atStartOfDay();
  }
}
