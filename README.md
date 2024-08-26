
# Medex Hospital Management System

## Project Overview

Medex is a comprehensive hospital management system developed using JavaFX. The system facilitates patient management, appointment scheduling, and doctor registration, aiming to streamline the operations within a hospital setting. This application features role-based access, allowing both doctors and patients to interact with the system according to their roles. The project showcases my skills in JavaFX, UI/UX design, and backend development.

## Key Features

- **Doctor and Patient Management**: Register, update, and manage doctor and patient information.
- **Appointment Scheduling**: Patients can schedule appointments with available doctors.
- **Role-Based Access Control**: Different views and functionalities based on user roles (Doctor/Patient).
- **Responsive UI**: Intuitive and user-friendly interface designed with JavaFX.

## Technologies Used

- **Java**
- **JavaFX**
- **SQLite Database**

## Project Structure and Code Explanation

1. **Doctor and Patient Registration**:
   - Allows users to register as either a doctor or a patient, storing the relevant information in the database.
   - Provides a clean and straightforward interface for data entry.
   ```java
   public class RegistrationController {
       // Handles the registration logic
   }
   ```

2. **Appointment Scheduling**:
   - Patients can schedule appointments, which are then managed and viewed by the doctors.
   - The system checks for availability and prevents double-booking.
   ```java
   public class AppointmentController {
       // Handles the appointment scheduling logic
   }
   ```

3. **Role-Based Access Control**:
   - Upon login, users are directed to their respective dashboards based on their roles.
   - Doctors have access to patient management and appointment viewing, while patients can manage their appointments.
   ```java
   public class LoginController {
       // Handles role-based redirection post-login
   }
   ```

## Project Output

Here are some screenshots showing the key features and output of the application:


<h4>01) Login</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/L.png" width="50%" >

<h4>02) Signup</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/S.png" width="50%" >

<h4>03) Doctor Signup</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/dS.png" width="50%" >

<h4>04) Paitent Signup</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/pS.png" width="50%" >

<h4>05) Doctor Login</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/dL.png" width="50%" >

<h4>06) Paitent Login</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/pL.png" width="50%" >

<h4>07) Doctor Registration</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/dR1.png" width="50%" >
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/dR2.png" width="50%" >

<h4>08) Paitent Registration</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/pR1.png" width="50%" >
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/pR2.png" width="50%" >

<h4>09) Doctor Dashboard</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/dD.png" width="50%" >

<h4>10) Paitent Dashboard</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/pD.png" width="50%" >

<h4>11) Patient Management</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/dPM1.png" width="50%" >
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/dPM2.png" width="50%" >

<h4>12) Check Appointments</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/dA1.png" width="50%" >
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/dA2.png" width="50%" >

<h4>13) Add Appointments</h4>
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/pA1.png" width="50%" >
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/pA2.png" width="50%" >
<img src="https://github.com/MalingaBandara/Medex/blob/master/screenshots/pA3.png" width="50%" >


## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/MalingaBandara/Medex.git
   ```
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Build and run the project.
4. Ensure the SQLite database file is correctly linked in the project settings.

## Purpose and Future Enhancements

The Medex project was developed to demonstrate my capabilities in JavaFX and building a comprehensive hospital management system. Future enhancements may include integrating online payments for appointments, implementing more advanced security features, and expanding the system to manage inventory and billing.

## License

This project is licensed under the MIT License.
