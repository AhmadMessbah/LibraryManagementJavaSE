package answers.farahani;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Payment {
    private Long id;
    private TransactionType transactionType;
    private PaymentType paymentType;
    private double amount;
    private LocalDateTime dateTime;
    private Employee employee;
    private Customer customer;
    private String description;
}
