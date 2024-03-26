package modorirang.modorirangreservation.salon.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

import lombok.*;
import lombok.experimental.SuperBuilder;
import modorirang.modorirangreservation.salon.util.BaseEntity;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member extends BaseEntity {
    @Comment("회원 메일")
    @Column(unique = true, length = 50)
    private String email;

    @Comment("회원 본명")
    @Column(length = 50)
    private String name;

    @Comment("회원 별명")
    @Column(length = 50)
    private String nickname;

    @Comment("회원 연락처")
    private Long phone;

}
