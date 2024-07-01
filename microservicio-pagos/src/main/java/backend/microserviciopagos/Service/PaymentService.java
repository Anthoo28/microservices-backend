package backend.microserviciopagos.Service;

import backend.microserviciopagos.Client.BoletoClient;
import backend.microserviciopagos.Model.BoletoDto;
import backend.microserviciopagos.Model.PaymentIntentDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
 @Value("${stripe.api.key}")
    String secretKey;

    @Autowired
    BoletoClient boletoClient;

    public PaymentIntent paymentIntent(PaymentIntentDTO paymentIntentDTO) throws StripeException {
        BoletoDto boletoDto = boletoClient.getBoleto(paymentIntentDTO.getBoletoId());
        if (boletoDto == null) {
            throw new IllegalArgumentException("BoletoDto not found for id: " + paymentIntentDTO.getBoletoId());
        }
        Double amount = boletoDto.getPrecioFinal();
        Stripe.apiKey = secretKey;

        // Crear parámetros para el PaymentIntent
        Map<String, Object> params = new HashMap<>();
       Long amount1 =Math.round(boletoDto.getPrecioFinal() * 100);
        params.put("amount", amount1);
        params.put("currency", paymentIntentDTO.getCurrency());
        params.put("description", paymentIntentDTO.getDescription());

        // Crear el PaymentIntent con los parámetros configurados
        return PaymentIntent.create(params);
    }



    public PaymentIntent confirm(String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent=PaymentIntent.retrieve(id);
        Map<String,Object> params= new HashMap<>();
        params.put("payment_method", "pm_card_visa");
        paymentIntent.confirm(params);
        return paymentIntent;
    }

    public PaymentIntent cancel(String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent=PaymentIntent.retrieve(id);
        paymentIntent.cancel();
        return paymentIntent;
    }
}
