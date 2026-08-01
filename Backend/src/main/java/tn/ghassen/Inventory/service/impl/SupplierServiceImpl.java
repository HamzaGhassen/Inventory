package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.entity.Supplier;
import tn.ghassen.inventory.repository.SupplierRepository;
import tn.ghassen.inventory.service.SupplierService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{
    private final SupplierRepository supplierRepository;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {

        Supplier existing = getSupplierById(id);

        existing.setName(supplier.getName());
        existing.setEmail(supplier.getEmail());
        existing.setPhone(supplier.getPhone());
        existing.setAddress(supplier.getAddress());
        existing.setTaxNumber(supplier.getTaxNumber());
        existing.setLogo(supplier.getLogo());

        existing.setCompany(supplier.getCompany());

        return supplierRepository.save(existing);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}