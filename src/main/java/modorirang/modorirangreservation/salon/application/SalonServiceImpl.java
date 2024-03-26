package modorirang.modorirangreservation.salon.application;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import modorirang.modorirangreservation.salon.entity.Salon;
import modorirang.modorirangreservation.salon.repository.SalonRepository;
import modorirang.modorirangreservation.salon.util.SalonTime;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.*;

import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalonServiceImpl {

    private final SalonRepository salonRepository;

    public Salon create(List<LocalDate> dayOfMonths, LocalTime startTime, LocalTime endTime) {
        Map<String, List<SalonTime>> times = new HashMap<>();

        for (LocalDate date : dayOfMonths) {

            String dayOfMonth = String.valueOf(date.getDayOfMonth()); // `일`

            List<SalonTime> dailyTimes = Stream.iterate(
                    startTime, time -> !time.isAfter(endTime), time -> time.plusMinutes(30))
                    .map(time -> SalonTime.builder()
                            .reservation(false)
                            .time(time)
                            .build())
                    .toList();

            times.put(dayOfMonth, dailyTimes);
        }

        Salon salon = Salon.builder()
                .time(times)
                .build();

        return salonRepository.save(salon);
    }

    public boolean makeReservation(LocalDate date, LocalTime time) {

        List<Salon> salons = salonRepository.findAll();

        List<SalonTime> salonTimes = salons.stream()
                .flatMap(salon -> salon.getTime().get(String.valueOf(date.getDayOfMonth())).stream())
                .toList();

        for (SalonTime salonTime : salonTimes) {
            System.out.println(salonTime);
        }

        return false; // 예약 실패
    }
}
