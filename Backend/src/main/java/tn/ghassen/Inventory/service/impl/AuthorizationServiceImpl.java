package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.authorization.AuthorizationRequest;
import tn.ghassen.inventory.dto.authorization.AuthorizationResponse;
import tn.ghassen.inventory.entity.FinancialTransaction;
import tn.ghassen.inventory.entity.User;
import tn.ghassen.inventory.enums.Role;
import tn.ghassen.inventory.repository.FinancialTransactionRepository;
import tn.ghassen.inventory.repository.UserRepository;
import tn.ghassen.inventory.service.AuthorizationService;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    private final UserRepository userRepository;
    private final FinancialTransactionRepository financialTransactionRepository;

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

        // Verify company ownership and structure
        if (user.getCompany() == null || transaction.getCompany() == null) {
            return new AuthorizationResponse(false);
        }

        if (!user.getCompany().getId().equals(transaction.getCompany().getId())) {
            return new AuthorizationResponse(false);
        }

        // Only managers can authorize transactions within their company
        if (Role.MANAGER.equals(user.getRole())) {
            return new AuthorizationResponse(true);
        }

        return new AuthorizationResponse(false);
    }
}
