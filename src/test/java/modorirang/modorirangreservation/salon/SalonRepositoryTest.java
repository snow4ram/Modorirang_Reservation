package modorirang.modorirangreservation.salon;

import modorirang.modorirangreservation.salon.repository.MemberRepository;
import modorirang.modorirangreservation.salon.repository.SalonDetailRepository;
import modorirang.modorirangreservation.salon.repository.SalonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SalonRepositoryTest {

    @Autowired
    private SalonRepository salonRepository;
    @Autowired
    private SalonDetailRepository salonDetailRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void init() {
        memberRepository.deleteAll();
        salonRepository.deleteAll();
        salonDetailRepository.deleteAll();
    }



}
