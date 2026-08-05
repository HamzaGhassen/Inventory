package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.entity.StockMovement;
import tn.ghassen.inventory.repository.StockMovementRepository;
import tn.ghassen.inventory.service.StockMovementService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StockMovementServiceImpl implements StockMovementService {

    private final StockMovementRepository stockMovementRepository;
    @Override
    public StockMovement createStockMovement(StockMovement stockMovement) {
        return stockMovementRepository.save(stockMovement);
    }

    @Override
    public StockMovement getStockMovementById(Long id) {
        return stockMovementRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Stock_movement not found"));
    }

    @Override
    public List<StockMovement> getAllStockMovements() {
        return stockMovementRepository.findAll();
    }

    @Override
    public StockMovement updateStockMovement(Long id, StockMovement stockMovement) {

        StockMovement existing = getStockMovementById(id);

        existing.setQuantity(stockMovement.getQuantity());
        existing.setAction(stockMovement.getAction());
        existing.setDescription(stockMovement.getDescription());



        return stockMovementRepository.save(existing);
    }

    @Override
    public void deleteStockMovement(Long id) {
    stockMovementRepository.deleteById(id);
    }
}
