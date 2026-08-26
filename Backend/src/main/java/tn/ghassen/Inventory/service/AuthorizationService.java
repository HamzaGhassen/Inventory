package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.authorization.AuthorizationRequest;
import tn.ghassen.inventory.dto.authorization.AuthorizationResponse;

public interface AuthorizationService {
    AuthorizationResponse checkAuthorization(AuthorizationRequest request);
}
