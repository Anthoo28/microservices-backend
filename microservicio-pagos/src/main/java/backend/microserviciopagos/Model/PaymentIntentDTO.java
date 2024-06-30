package backend.microserviciopagos.Model;

import lombok.Builder;
import lombok.Data;

import java.util.Currency;

@Builder
@Data
public class PaymentIntentDTO {
    public  enum  Currency{
        USD, PEN
    }

    private String description;
    private Double amount;
    private Currency currency;
    private Long boletoId;
}
