package {{project_base_package}}.samples.aws.sqs;

import {{project_base_package}}.samples.aws.sqs.model.Customer;

import java.time.LocalDateTime;
import java.util.UUID;

public record CustomerCreatedEvent(
        UUID id,
        String name,
        String phoneNumber,
        LocalDateTime createdAt
) {

    public Customer toModel() {
        return new Customer(id, name, phoneNumber, createdAt);
    }
}
