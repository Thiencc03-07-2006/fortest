package com.rikkei_bank.aspect;

import com.rikkei_bank.model.entity.Transaction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(AuditLoggingAspect.class);

    // 1. AOP tự động chạy SAU KHI phương thức chuyển tiền (transfer) thành công và trả về kết quả
    @AfterReturning(
            pointcut = "execution(* com.rikkei_bank.service.impl.AccountServiceImpl.transfer(..))",
            returning = "result"
    )
    public void logTransferSuccess(JoinPoint joinPoint, Object result) {
        if (result instanceof Transaction) {
            Transaction tx = (Transaction) result;
            String fromAcc = tx.getFromAccount().getAccountNumber();
            String toAcc = tx.getToAccount().getAccountNumber();
            
            // Ghi dòng log Audit giao dịch thành công theo đúng yêu cầu đặc tả UC-04
            logger.info("[AUDIT] Account {} transferred {} to Account {}. Transaction Code: {}", 
                    fromAcc, tx.getAmount(), toAcc, tx.getTransactionCode());
        }
    }

    // 2. AOP tự động chạy SAU KHI phương thức chuyển tiền (transfer) xảy ra lỗi và ném ra Exception
    @AfterThrowing(
            pointcut = "execution(* com.rikkei_bank.service.impl.AccountServiceImpl.transfer(..))",
            throwing = "ex"
    )
    public void logTransferFailure(JoinPoint joinPoint, Throwable ex) {
        // Ghi dòng log Audit giao dịch thất bại kèm nguyên nhân lỗi
        logger.error("[AUDIT] Transfer transaction failed! Reason: {}", ex.getMessage());
    }
}
