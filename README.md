# OHGH.(Online Help Desk and Grievance Handling System)

### Objective
  From this Website we are trying to make facilities available online to students in College.
By using this website users will be able to raise request to avail facility from Facility Heads and can raise complaints.

## Information
  This Website is developed using JSP and Servlet and tried following MVC(Model View Controller) pattern. Java is used as basic language for development, and is hosted in Apache Tomcat. Bootstrap is majorly used to design header and Navigation bar. Azure SQL Database is used for storing Relational Data, hence Azure subscription is also needed to create SQL Server (can use your own local or hosted SQL Server). Please Note that complex queries has been avoided in most of the places, and Tables are not normalized (which should be). There is a major code repetitions which could have been avoided. Basic HTML validations are used in forms.

## Technologies

- Languages.
  * Java(Primary)
  * JavaScript
  * HTML
  * SQL
  
- Server : Apache Tomcat v8.5.
- Styling
  * Basic CSS
  * Bootstrap
- Tools
  * Eclipse.
  * SSMS(SQL Server Management Studio).
    
## Documents
  There are few documents in this [repository](https://github.com/kumaramitrou/OHGH) which might be useful for setting up or using this website. 
  * [DevelopersManual.md](DevelopersManual.md).
    This Document will help you to modify the existing code and how to use it, you can always add new features or change design of this website. :slightly_smiling_face:
  * [UserManual.md](UserManual.md).
    This Document has instructions to use this website. There are 3 main users Admin, Students, and FacilityHead, whose flows are described.
  * [SetupInstructions.md](SetupInstructions.md).
    This Document will help you in setting up your system to run this code locally.

## Setup
  You need to keep your system ready, inorder to run this website.
 
Few Softwares and Tools which you need are
  * SSMS. (SQL Server Management Studio)
  * JRE. (Java Runtime Environment)
  * Eclipse. (Integrated Development Environment)
  * Apache Tomcat Server. (Server)
  
__Note:__ ***Please refer [SetupInstructions.md](SetupInstructions.md) file for setting up environment in your local system.***

## Future Scope
  * Can view uploaded documents in portal.
  * Notified over email or message for any updates(once in a day, if any).
  * Use of Encryption for password.
  * UI - Use of sticky navbar.
  * Use Footer for copyright.
  * Caching for performance improvement.

## Improvements
  * Database should be normalized.
  * Code could be made more generic.
  * Website could have been more responsive.
  * Could have used Collated Database.
  * Exception Logging.
  * Unit Test Cases.
  * Use of AppSettings file.
