    package tn.ghassen.inventory.service.impl;

    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;
    import tn.ghassen.inventory.entity.RawMaterial;
    import tn.ghassen.inventory.repository.RawMaterialRepository;
    import tn.ghassen.inventory.service.RawMaterialService;

    import java.util.List;
    @Service
    @RequiredArgsConstructor
    public class RawMaterialServiceImpl implements RawMaterialService {
        private final RawMaterialRepository rawMaterialRepository;

        @Override
        public RawMaterial createRawMaterial(RawMaterial rawMaterial) {
            return rawMaterialRepository.save(rawMaterial);
        }

        @Override
        public RawMaterial getRawMaterialById(Long id) {
            return rawMaterialRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Raw material not found"));
        }

        @Override
        public List<RawMaterial> getAllRawMaterials() {
            return rawMaterialRepository.findAll();
        }

        @Override
        public RawMaterial updateRawMaterial(Long id, RawMaterial rawMaterial) {

            RawMaterial existing = getRawMaterialById(id);

            existing.setName(rawMaterial.getName());
            existing.setLogo(rawMaterial.getLogo());
            existing.setCostPrice(rawMaterial.getCostPrice());
            existing.setQuantity(rawMaterial.getQuantity());
            existing.setUnit(rawMaterial.getUnit());
            existing.setCompany(rawMaterial.getCompany());

            return rawMaterialRepository.save(existing);
        }

        @Override
        public void deleteRawMaterial(Long id) {
            rawMaterialRepository.deleteById(id);
        }
    }
