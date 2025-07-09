# 🚀 Job Provider - Online Recruitment Platform

<div align="center">
  
  [![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
  [![JSP](https://img.shields.io/badge/JSP-007396?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/technologies/jspt.html)
  [![SQL Server](https://img.shields.io/badge/Microsoft%20SQL%20Server-CC2927?style=for-the-badge&logo=microsoft%20sql%20server&logoColor=white)](https://www.microsoft.com/en-us/sql-server)
  [![Apache Ant](https://img.shields.io/badge/Apache%20Ant-A81C7D?style=for-the-badge&logo=Apache%20Ant&logoColor=white)](https://ant.apache.org/)
</div>

## 📋 Overview

**Job Provider** is a comprehensive online recruitment platform developed with Java Web Technologies, providing an efficient solution to connect employers and job seekers.

### 🌟 Key Features

- **👥 Multi-role Account Management**: Support for 3 account types (Admin, Employer, Candidate)
- **📋 Job Posting and Management**: Create, edit, and manage job postings
- **🔍 Smart Job Search**: Filter by position, salary, location
- **📄 CV and Profile Management**: Upload and manage candidate CVs
- **📊 Admin Dashboard**: Monitor and manage the entire system
- **🔐 Security**: MD5 password encryption, email password recovery
- **📱 Responsive Interface**: Compatible with all devices

## 🏗️ System Architecture

### Backend Architecture
```
src/java/
├── Controller/          # Servlet Controllers
│   ├── Account/        # Account management
│   ├── Admin/          # Admin functions
│   ├── Post/           # Post management
│   └── PostDetail/     # Post details
├── Dal/                # Data Access Layer
│   ├── DBContext.java  # Database connection
│   ├── AccountDAO.java # Account CRUD
│   ├── PostDAO.java    # Post CRUD
│   └── ...
├── Model/              # Entity Models
│   ├── Account.java    # Account model
│   ├── Post.java       # Post model
│   ├── Company.java    # Company model
│   └── ...
└── Model_Data/         # Data Transfer Objects
```

### Frontend Structure
```
web/
├── jsp files/          # JSP Views
├── css/               # Stylesheets
├── js/                # JavaScript files
├── images/            # Static images
└── Header and Footer/ # Shared components
```

## 🛠️ Technologies Used

### Backend
- **Java SE 8+** - Main programming language
- **Java Servlet & JSP** - Web framework
- **JSTL** - JSP Standard Tag Library
- **SQL Server** - Database management system
- **JDBC** - Database connectivity
- **Apache Ant** - Build tool

### Frontend
- **HTML5/CSS3** - Markup and styling
- **JavaScript** - Client-side scripting
- **Bootstrap** - CSS framework
- **Boxicons** - Icon library
- **Google Maps API** - Map integration

### Database
- **Microsoft SQL Server** - Main database
- **JDBC Driver** - sqljdbc42.jar

## 📦 Installation and Setup

### System Requirements
- **Java JDK 8+**
- **Apache Tomcat 9+**
- **Microsoft SQL Server 2019+**
- **NetBeans IDE** (recommended)

### Installation Guide

1. **Clone the project**
   ```bash
   git clone <repository-url>
   cd JobProvider
   ```

2. **Database Configuration**
   - Create `Job_Provider2` database on SQL Server
   - Update connection information in `src/java/Dal/DBContext.java`:
   ```java
   String url = "jdbc:sqlserver://localhost:1433;databaseName=Job_Provider2";
   String username = "your_username";
   String password = "your_password";
   ```

3. **Build the project**
   ```bash
   ant clean
   ant build
   ```

4. **Deploy on Tomcat**
   - Copy WAR file from `dist/` folder to Tomcat's `webapps/`
   - Or deploy directly from NetBeans IDE

5. **Access the application**
   ```
   http://localhost:8080/JobProvider/HomePage.jsp
   ```

## 🎯 Main Features

### 👤 For Candidates
- Register/Login account
- Search jobs by multiple criteria
- View job posting details
- Upload and manage CV
- Apply for positions
- Manage personal profile

### 🏢 For Employers
- Register company account
- Post job openings
- Manage candidate list
- View and download candidate CVs
- Manage company information

### 👨‍💼 For Admin
- Manage all accounts
- Manage job postings
- Manage advertisements
- Statistics and reporting
- System management

## 📂 Database Structure

### Main Tables
- **Account**: User account information
- **Company**: Company information
- **Employer**: Employer information
- **Candidate**: Candidate information
- **Post**: Job postings
- **PostDetail**: Job posting details
- **CV**: Candidate CV information
- **Ads**: Advertisements
- **Feedback**: User feedback

## 🔒 Security

- MD5 password encryption
- User authentication via sessions
- Role-based access control
- Secure password recovery via email

## 🎨 User Interface

The project uses modern, responsive design with:
- User-friendly, easy-to-use interface
- Multi-device compatibility
- Professional color scheme
- Optimized UX/UI for each user type


## 🚀 Outstanding Features

- **🔍 Smart Search**: Filter jobs by position, salary, experience
- **📱 Responsive Design**: Works smoothly on all devices
- **⚡ Performance**: Optimized page loading and database queries
- **🔐 Security**: Secure user information and data
- **📊 Analytics**: Detailed statistics for admin

## 🎯 Roadmap

### Phase 2 - Extended Features
- [ ] Online payment integration
- [ ] Real-time chat system
- [ ] Mobile App (Android/iOS)
- [ ] RESTful API
- [ ] Machine Learning for job recommendations

### Phase 3 - Optimization
- [ ] Microservices architecture
- [ ] Cloud deployment
- [ ] Advanced analytics
- [ ] Multi-language support

## 🤝 Contributing

This project is developed and maintained by **Pham Nam Khanh**.

### Bug Reports
If you find any bugs, please create an issue with detailed information about:
- Environment (OS, Java version, Database version)
- Steps to reproduce the bug
- Log files or error messages

## 📞 Contact

**Author**: Pham Nam Khanh  
**Email**: [your-email@example.com]  
**Project**: Job Provider - SWP391

---

<div align="center">
  <b>⭐ If this project is useful, don't forget to give it a star! ⭐</b>
</div>
