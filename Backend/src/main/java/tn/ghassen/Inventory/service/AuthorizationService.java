package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.authorization.AuthorizationReport;
import tn.ghassen.inventory.dto.authorization.AuthorizationRequest;
import tn.ghassen.inventory.dto.authorization.AuthorizationResponse;
import tn.ghassen.inventory.entity.FinancialTransaction;
import tn.ghassen.inventory.entity.User;

public interface AuthorizationService {

    // 1/ Report(): Creates request report sent by CurrentUser
    AuthorizationReport createReport(User currentUser, FinancialTransaction transaction, String subject);

    // 2/ getAuthorization(): Layer checking sender details before report reaches HelpDesk
    boolean getAuthorization(AuthorizationReport report);

    // 3/ Confirmation(): Treats HelpDesk confirmation ("VALID" vs "REJECT"). Returns true if VALID, throws RuntimeException if REJECT
    boolean processConfirmation(AuthorizationReport report, String confirmationStatus);

    // Backward compatibility check
    AuthorizationResponse checkAuthorization(AuthorizationRequest request);
}
