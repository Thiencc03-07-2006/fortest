package com.rikkei_bank.service;

import com.rikkei_bank.model.dto.request.ForgotPasswordRequest;
import com.rikkei_bank.model.entity.KycProfile;
import com.rikkei_bank.model.entity.Status;
import com.rikkei_bank.model.entity.User;
import com.rikkei_bank.model.dto.request.RegisterRequest;
import com.rikkei_bank.model.dto.response.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

public interface UserService {
    // Đăng ký tài khoản người dùng mới (Public)
    User registerCustomer(RegisterRequest request);

    // Tải lên hồ sơ eKYC kèm ảnh chụp CCCD gửi lên Cloudinary (Customer)
    KycProfile uploadKyc(User user, String idNumber, String fullName, LocalDate dob,
                         String sex, String address, MultipartFile file) throws IOException;

    // Phê duyệt hồ sơ định danh eKYC và mở tài khoản ngân hàng (Staff)
    KycProfile approveKyc(Long kycProfileId, Status status);

    // Lấy danh sách người dùng phân trang dùng JPQL Constructor Projection (Admin/Staff)
    Page<UserResponseDto> getAllUsers(Pageable pageable);

    // Thêm phương thức Update và Delete để hoàn thiện CRUD
    User updateUserStatus(Long userId, Boolean isActive);
    void deleteUser(Long userId);

    // Quên mật khẩu (FR-10)
    String forgotPassword(ForgotPasswordRequest request);
}