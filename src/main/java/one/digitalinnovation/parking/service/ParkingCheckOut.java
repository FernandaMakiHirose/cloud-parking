package one.digitalinnovation.parking.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import one.digitalinnovation.parking.model.Parking;

public class ParkingCheckOut {

    // horários e valores a se pagar por horário
    public static final int ONE_HOUR = 60;
    public static final int TWENTY_FOUR_HOUR = 24 * ONE_HOUR;
    public static final double ONE_HOUR_VALUE = 5.00;
    public static final double ADDITIONAL_PER_HOUR_VALUE = 2.00;
    public static final double DAY_VALUE = 20.00;

    private static Double getBill(LocalDateTime entryDate, LocalDateTime exitDate) {
        long minutes = entryDate.until(exitDate, ChronoUnit.MINUTES);

        // se os minutos forem menor ou igual a uma hora, vai comer o valor mínimo

        Double bill = 0.0;
        if (minutes <= ONE_HOUR) {
            return ONE_HOUR_VALUE;
        }

        // se os minutos forem menor ou igual a 24 horas adiciona o acréscimo

        if (minutes <= TWENTY_FOUR_HOUR) {
            bill = ONE_HOUR_VALUE;
            int hours = (int) (minutes / ONE_HOUR);
            System.out.println(hours);
            for (int i = 0; i < hours; i++) {
                bill += ADDITIONAL_PER_HOUR_VALUE;
            }
            return bill;
        }

        // se ficou mais de um dia vai calcular o valor diário

        int days = (int) (minutes / TWENTY_FOUR_HOUR);
        System.out.println(days);
        for (int i = 0; i < days; i++) {
            bill += DAY_VALUE;
        }
        return bill;
    }

    public static Double getBill(Parking parking) {
        return getBill(parking.getEntryDate(), parking.getExitDate());
    }

}
