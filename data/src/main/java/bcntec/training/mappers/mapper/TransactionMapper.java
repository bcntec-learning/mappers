package bcntec.training.mappers.mapper;

import bcntec.training.mappers.dto.TransactionDTO;
import bcntec.training.mappers.entity.Transaction;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public abstract class TransactionMapper {

    public TransactionDTO toTransactionDTO(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setUuid(transaction.getUuid());
        transactionDTO.setTotalInCents(transaction.getTotal().multiply(new BigDecimal("100")).longValue());
        return transactionDTO;
    }

    public abstract List<TransactionDTO> toTransactionDTO(Collection<Transaction> transactions);
}
