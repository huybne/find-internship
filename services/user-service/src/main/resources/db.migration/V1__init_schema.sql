CREATE TABLE users (
                       id UUID PRIMARY KEY DEFAULT UUID(),
                       full_name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       phone VARCHAR(50) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       dob DATE NOT NULL,
                       address VARCHAR(255) NOT NULL,
                       is_active BOOLEAN NOT NULL DEFAULT TRUE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE roles (
                       id VARCHAR(50) PRIMARY KEY, -- Có thể dùng UUID nếu muốn
                       role_name VARCHAR(100) NOT NULL UNIQUE,
                       description TEXT
);

CREATE TABLE user_roles (
                            user_id UUID,
                            role_id VARCHAR(50),
                            PRIMARY KEY (user_id, role_id),
                            FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                            FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

CREATE TABLE cvs (
                     id UUID PRIMARY KEY DEFAULT UUID(),
                     user_id UUID NOT NULL,
                     title_cv VARCHAR(255) NOT NULL,
                     cv_detail TEXT, -- Hoặc BLOB nếu bạn lưu file PDF
                     target_job VARCHAR(255),
                     university VARCHAR(255),
                     experience TEXT,
                     status ENUM('Inactive', 'Pending', 'HR_APPROVED', 'AU_APPROVED') NOT NULL,
                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                     FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);