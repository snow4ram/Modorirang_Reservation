package modorirang.modorirangreservation.salon.entity;


import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import modorirang.modorirangreservation.salon.util.BaseEntity;
import modorirang.modorirangreservation.salon.util.SalonTime;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Entity
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Salon extends BaseEntity {


    @Type(JsonType.class)
    @Comment("예약 시간")
    @Column(name = "time", columnDefinition ="json")
    private Map<String , List<SalonTime>> time = new HashMap<>();
}
