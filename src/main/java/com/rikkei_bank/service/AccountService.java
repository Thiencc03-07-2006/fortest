package com.rikkei_bank.service;

import com.rikkei_bank.model.dto.response.AccountResponse;
import com.rikkei_bank.model.dto.request.TransferRequest;
import com.rikkei_bank.model.dto.response.TransactionResponseDto;
import com.rikkei_bank.model.dto.request.ChangePinRequest;
import com.rikkei_bank.model.entity.Transaction;
import com.rikkei_bank.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
    // Vấn tin số dư tài khoản của người dùng (FR-06)
    AccountResponse getBalance(User user);

    // Chuyển tiền nội bộ/liên ngân hàng (FR-07)
    Transaction transfer(User user, TransferRequest request);

    // Xem sao kê lịch sử giao dịch (FR-08)
    Page<TransactionResponseDto> getStatement(User user, Pageable pageable);

    // Đổi mã PIN giao dịch (FR-10)
    void changePin(User user, ChangePinRequest request);
}