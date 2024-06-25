CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role ENUM('admin', 'expert', 'teacher') NOT NULL,
    name VARCHAR(50) NOT NULL,
    contact_info VARCHAR(100)
);

CREATE TABLE competitions (
    competition_id INT PRIMARY KEY AUTO_INCREMENT,
    competition_name VARCHAR(100) NOT NULL,
    description TEXT,
    competition_date DATE
);

CREATE TABLE submissions (
    submission_id INT PRIMARY KEY AUTO_INCREMENT,
    submission_name VARCHAR(100) NOT NULL,
    category ENUM('思政课程组', '公共基础课程组', '专业技能课程一组', '专业技能课程二组') NOT NULL,
    school VARCHAR(100) NOT NULL,
    team TEXT NOT NULL,
    material_path VARCHAR(255) NOT NULL,
    submission_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE reviews (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
    submission_id INT,
    expert_id INT,
    score INT NOT NULL,
    comment TEXT,
    review_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (submission_id) REFERENCES submissions(submission_id),
    FOREIGN KEY (expert_id) REFERENCES users(user_id)
);

CREATE TABLE logs (
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    operation TEXT,
    operation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
