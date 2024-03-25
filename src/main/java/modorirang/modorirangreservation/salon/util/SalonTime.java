package modorirang.modorirangreservation.salon.util;


import lombok.*;

import java.time.LocalTime;

@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SalonTime {

    private boolean reservation;//예약 여부

    private LocalTime time; //예약 시작 시간
}
