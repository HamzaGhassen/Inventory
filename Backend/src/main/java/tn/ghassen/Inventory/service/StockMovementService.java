package tn.ghassen.inventory.service;

import tn.ghassen.inventory.entity.StockMovement;

import java.util.List;

public interface StockMovementService {

    StockMovement createStockMovement(StockMovement stockMovement);

    StockMovement getStockMovementById(Long id);

    List<StockMovement> getAllStockMovements();

    StockMovement updateStockMovement(Long id , StockMovement stockMovement);

    void deleteStockMovement(Long id);

}
