package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.Expense.ExpenseCreateDTO;
import tn.ghassen.inventory.dto.Expense.ExpenseResponseDTO;
import tn.ghassen.inventory.dto.Expense.ExpenseUpdateDTO;
import tn.ghassen.inventory.entity.Expense;

@Component
public class ExpenseMapper {

    public Expense toEntity(ExpenseCreateDTO dto) {

        Expense expense = new Expense();
        expense.setDescription(dto.description());
        expense.setAmount(dto.amount());
        expense.setCategory(dto.category());
        expense.setPaymentMethod(dto.paymentMethod());
        expense.setPaymentStatus(dto.paymentStatus());

        return expense;
    }

    public ExpenseResponseDTO toResponseDTO(Expense expense) {

        return new ExpenseResponseDTO(
                expense.getId(),
                expense.getDescription(),
                expense.getAmount(),
                expense.getCategory(),
                expense.getPaymentMethod(),
                expense.getPaymentStatus(),
                expense.getUser() != null ? expense.getUser().getId() : null,
                expense.getCompany() != null ? expense.getCompany().getId() : null,
                expense.getSupplier() != null ? expense.getSupplier().getId() : null,
                expense.getCreatedAt(),
                expense.getUpdatedAt()
        );
    }

    public void updateEntity(Expense expense, ExpenseUpdateDTO dto) {
        if (expense == null || dto == null) {
            return;
        }

        if (dto.description() != null) {
            expense.setDescription(dto.description());
        }
        if (dto.amount() != null) {
            expense.setAmount(dto.amount());
        }
        if (dto.category() != null) {
            expense.setCategory(dto.category());
        }
        if (dto.paymentMethod() != null) {
            expense.setPaymentMethod(dto.paymentMethod());
        }
        if (dto.paymentStatus() != null) {
            expense.setPaymentStatus(dto.paymentStatus());
        }
    }
}
