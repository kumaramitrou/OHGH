# SETUP STEPS TO RUN WEBSITE IN YOUR LOCAL SYSTEM

  ## Below is the list of Softwares and tools you need to run this website locally.

   * [ ] **Step 1.** Use Ninite and install JRE and Eclipse

   * [ ] **Step 2.** Download and Setup Apache tomcat v8.5
  
   * [ ] **Step 3.** Download SSMS and execute initial script.
  
   * [ ] **Step 4.** Install JEE perspective if not available with your Eclipse.(optional)
   
   * [ ] **Step 5.** Link Apache Tomcat Server to Eclipse.
  
  
  
  ### **Step 1.** Install JRE and Eclipse.
  
   To install JRE and Eclipse at once you can use [ninite](https://ninite.com/).
   Navigate to the above mentioned link and click on _Java (AdoptOpenJDK) x64 11_ and _Eclipse_ checkbox, next click on _Get your Ninite_     button.
  
   ![Ninite reference 1](documentImages/ninite1.png)
   
   On Clicking  **Get Ninite** an exe file will be downloaded.
   
   ![Ninite Exe reference 2](documentImages/screenshot001.png)
   
   Double click on downloaded exe, I will start installing **JRE** and **Eclipse**
   
   ![Ninite installing reference 3](documentImages/screenshot002.png)
  
   Congratulations, you have just setup 25% of development environment.
  
   * [x] **Step 1.**

### **Step 2.** Download Apache tomcat v8.5.

  To install Apache Tomcat v8.5, open your browser and navigate to [tomcat](http://tomcat.apache.org/)
  
  You will be redirected to page shown below
  
  ![Tomcat Url](documentImages/tomcatDownload.png)
  
  Click ![download](https://tomcat.apache.org/download-80.cgi) button under **Tomcat 8.5.47 Released**
  
  ![Tomcat doc and source Code](documentImages/downloaddocAndzip.png)
  
  Download both [Binary Distribution](http://apachemirror.wuchna.com/tomcat/tomcat-8/v8.5.47/bin/apache-tomcat-8.5.47-windows-x64.zip) and [Source Code Distribution](http://apachemirror.wuchna.com/tomcat/tomcat-8/v8.5.47/bin/embed/apache-tomcat-8.5.47-embed.zip)
  
  Once it is downloaded, extract downloaded zip folder as shown below
  
  ![Tomcat Extract](documentImages/extractTomcat.png)
  
  Next step will be to include server in Eclipse.
  
  * [x] **Step 2.**
  
### **Step 3.** Download SSMS.

  To View Database and data in Tables you need an interface. SSMS(SQL Server Management Studio) is a tool where you can query to your database. Since we are using Azure SQL here we will be skipping the installation of SQL Server locally and this also means that to access the database (even to run this website locally) you need an **internet Connection**. If you don't want to use Azure SQL then please install SQL Server into your local machine and create all required Tables into it, update credentials in [DatabaseCredentials.java](OHGH/project/src/com/ohdgh/db/DatabaseCredentials.java) file of the project.
  
  To install SSMS, open your browser and navigate to "https://docs.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver15" url
  
  ![SSMS Download](documentImages/ssmsDownload.png)
  
  Click on the [link](https://aka.ms/ssmsfullsetup) as shown above
  
  Once it is downloaded please double click to run the exe file and start the installation
  
  ![ssms installation](documentImages/runDownloadedExe.png)
  
  It will ask you the location for SSMS keep as it is.
  
  ![ssms location](documentImages/installssms.png)
  
  Click on install, it will start installation.
  
  ![installation started](documentImages/installedssms.png)
  
  SSMS is installed successfully, next step is to connect database with SSMS.
  
  For that first open SSMS.
  
  Windows -> Type SSMS -> <kbd>Enter</kbd>
  
  ![installation started](documentImages/openssms001.png)
  
  As SSMS opens select Connect -> Database Engine on top left corner.
  
  ![database engine](documentImages/connectdb001.png)
  
  Enter your details and select Authentication type as **SQL Server Authentication** and click Connect.
  
  ![connect db](documentImages/connectDB.png)
  
  You are all set to access database.
  
  To query to database click on new query and select your database as it is shown in image below.
  
  ![new query](documentImages/newQuery.png)
  
### **Step 4.** Install JEE perspective if not available with your Eclipse.(optional)

### **Step 5.** Link Apache Tomcat Server to Eclipse.
  
Java 11 and Eclipse latest (2019-09)
