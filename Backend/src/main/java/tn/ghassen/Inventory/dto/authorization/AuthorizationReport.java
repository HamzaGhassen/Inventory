package tn.ghassen.inventory.dto.authorization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorizationReport {
    private String subject;
    private String description;
    private LocalDateTime date;
    private String userEmail;
    private String companyName;
    private Long userId;
    private Long transactionId;
    private String confirmationStatus;
}
