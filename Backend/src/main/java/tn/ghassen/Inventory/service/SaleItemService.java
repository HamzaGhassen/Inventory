package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.Sale_Item.SaleItemCreateDTO;
import tn.ghassen.inventory.dto.Sale_Item.SaleItemResponseDTO;
import tn.ghassen.inventory.dto.Sale_Item.SaleItemUpdateDTO;
import tn.ghassen.inventory.entity.SaleItem;

import java.util.List;

public interface SaleItemService {

    SaleItemResponseDTO createSaleItem(SaleItemCreateDTO dto);

    SaleItemResponseDTO getSaleItemById(Long id);

    List<SaleItemResponseDTO> getAllSaleItem();

    SaleItemResponseDTO updateSaleItem(Long id , SaleItemUpdateDTO dto);

    void deleteSaleItem(Long id);
}
