package modorirang.modorirangreservation.salon.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import modorirang.modorirangreservation.salon.api.request.SalonCreationRequest;
import modorirang.modorirangreservation.salon.application.SalonServiceImpl;
import modorirang.modorirangreservation.salon.entity.Salon;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/salon")
@RequiredArgsConstructor
public class SalonController {

    private final SalonServiceImpl salonService;


    @PostMapping
    public ResponseEntity<Salon> schedule(@RequestBody SalonCreationRequest request) {
        Salon salon = salonService.create(request.getDayOfMonths(), request.getStartTime(), request.getEndTime());
        return ResponseEntity.ok(salon);
    }
}
