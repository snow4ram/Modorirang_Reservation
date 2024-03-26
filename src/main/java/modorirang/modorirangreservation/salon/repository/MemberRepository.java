package modorirang.modorirangreservation.salon.repository;


import modorirang.modorirangreservation.salon.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
