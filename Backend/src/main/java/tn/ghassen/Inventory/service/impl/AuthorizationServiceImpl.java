package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.authorization.AuthorizationReport;
import tn.ghassen.inventory.dto.authorization.AuthorizationRequest;
import tn.ghassen.inventory.dto.authorization.AuthorizationResponse;
import tn.ghassen.inventory.entity.FinancialTransaction;
import tn.ghassen.inventory.entity.User;
import tn.ghassen.inventory.enums.Role;
import tn.ghassen.inventory.repository.FinancialTransactionRepository;
import tn.ghassen.inventory.repository.UserRepository;
import tn.ghassen.inventory.service.AuthorizationService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    private final UserRepository userRepository;
    private final FinancialTransactionRepository financialTransactionRepository;

    /**
     * 1/ Report(): Creates authorization request report sent by CurrentUser.
     * Restricts VISITOR role from requesting authorization.
     */
    @Override
    public AuthorizationReport createReport(User currentUser, FinancialTransaction transaction, String subject) {
        if (currentUser == null) {
            throw new RuntimeException("Current user cannot be null when creating authorization request report");
        }

        if (Role.VISITOR.equals(currentUser.getRole())) {
            throw new RuntimeException("Visitor role is restricted and cannot request authorization to update or delete transactions");
        }

        String companyName = currentUser.getCompany() != null ? currentUser.getCompany().getName() : null;
        String description = transaction != null ? transaction.getDescription() : "Transaction authorization request";
        Long transactionId = transaction != null ? transaction.getId() : null;

        return AuthorizationReport.builder()
                .subject(subject)
                .description(description)
                .date(LocalDateTime.now())
                .userEmail(currentUser.getEmail())
                .companyName(companyName)
                .userId(currentUser.getId())
                .transactionId(transactionId)
                .build();
    }

    /**
     * 2/ getAuthorization(): Layer that comes after the report is created and sent.
     * Checks sender details before the report reaches HELPDESK. Returns true or false.
     */
    @Override
    public boolean getAuthorization(AuthorizationReport report) {
        if (report == null || report.getUserId() == null || report.getTransactionId() == null) {
            return false;
        }

        User user = userRepository.findById(report.getUserId()).orElse(null);
        FinancialTransaction transaction = financialTransactionRepository.findById(report.getTransactionId()).orElse(null);

        if (user == null || transaction == null) {
            return false;
        }

        // Restrict VISITOR role
        if (Role.VISITOR.equals(user.getRole())) {
            return false;
        }

        // Check sender details & company matching
        if (user.getCompany() == null || transaction.getCompany() == null) {
            return false;
        }

        if (!user.getCompany().getId().equals(transaction.getCompany().getId())) {
            return false;
        }

        return true;
    }

    /**
     * 3/ Confirmation(): HelpDesk treats the report and gives confirmation ("VALID" or "REJECT").
     * Opens access if VALID.
     * Keeps access closed and throws RuntimeException if REJECT.
     */
    @Override
    public boolean processConfirmation(AuthorizationReport report, String confirmationStatus) {
        if (report != null) {
            report.setConfirmationStatus(confirmationStatus);
        }

        if ("VALID".equalsIgnoreCase(confirmationStatus)) {
            return true;
        }

        throw new RuntimeException("Authorization request rejected by HelpDesk for user: " 
                + (report != null ? report.getUserEmail() : "unknown"));
    }

    @Override
    public AuthorizationResponse checkAuthorization(AuthorizationRequest request) {
        if (request == null || request.getUserId() == null || request.getTransactionId() == null) {
            return new AuthorizationResponse(false);
        }

        User user = userRepository.findById(request.getUserId()).orElse(null);
        FinancialTransaction transaction = financialTransactionRepository.findById(request.getTransactionId()).orElse(null);

        if (user == null || transaction == null) {
            return new AuthorizationResponse(false);
        }

        try {
            AuthorizationReport report = createReport(user, transaction, request.getAction() != null ? request.getAction() : "UPDATE");
            boolean isAuthorized = getAuthorization(report);
            if (!isAuthorized) {
                return new AuthorizationResponse(false);
            }
            boolean result = processConfirmation(report, "VALID");
            return new AuthorizationResponse(result);
        } catch (RuntimeException e) {
            return new AuthorizationResponse(false);
        }
    }
}
