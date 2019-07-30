package bcntec.training.mappers.entity;


import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Transaction {

    private Long id;
    private String uuid = UUID.randomUUID().toString();
    private BigDecimal total;

}
