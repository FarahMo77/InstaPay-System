**Instapay System - Backend Demo** :raised_hands: <br> 
_Project Overview_ :eyes: <br>  
This project aims to build a demo backend system inspired by the Instapay system, providing core features of a digital payment platform. This platform will allow users to register and make various types of financial transactions, such as transferring money to other accounts, transferring to bank accounts, paying bills, and transferring to mobile wallets. <br>

The backend is developed in Java using Spring Boot, designed as a RESTful API to manage user accounts, payments, and bill processing. <br>

**Description** :four_leaf_clover:
The Instapay-like backend demo provides functionality for real-time transactions, including inter-account transfers, transfers to external bank accounts, wallet transfers, and utility bill payments. These services target different user types: those registered with bank accounts and those registered with mobile wallets provided by telecoms, banks, or electronic payment providers.

**Key Services** :eyes:
_Transfer to Another Instapay Account:_ <br>
Users can transfer funds to other users within the Instapay platform by specifying their Instapay account ID. <br>

_Transfer to Bank Account:_ <br>
Users registered with their bank accounts can transfer funds to other bank accounts, providing flexibility for interbank transfers. <br>

_Transfer to Mobile Wallet:_<br>
Users can transfer funds to mobile wallets linked to telecom companies (e.g., Vodafone Cash), banks (e.g., CIB Wallet), or electronic payment providers (e.g., Fawry).<br>

_Utility Bill Payment:_ <br>
Users can pay for utilities, including Gas, Electricity, and Water. Each utility bill is created with specific details and deducted from the user’s account upon payment.
User Requirements<br>

_User Registration:_<br>

_Users can register with either:_
Bank Account: The system verifies the user's mobile number through the bank’s API.<br>

Mobile Wallet: The system verifies the mobile number through the wallet provider.<br>

After initial verification, the system sends an OTP to verify ownership of the mobile number.
Users create a unique username and a complex password upon successful verification. <br>

_User Sign-In:_<br>

Users log in with their Instapay username and password, and the system loads their profile based on their registration type (bank or wallet).<br>

**Account Features:** <br>

_After logging in, users can:_<br>

Transfer to Wallet: Transfer funds to a mobile wallet using the recipient’s mobile number.<br>

Transfer to Another Instapay Account: Transfer funds to another Instapay user.<br>

Check Balance: Retrieve the current balance in their account.<br>

Pay Bills: Pay utility bills for Gas, Electricity, and Water.<br>

**Transaction Restrictions:**<br>
Only users registered with their bank accounts can transfer funds to other bank accounts.<br>

**Tech Stack** :pushpin: <br> 

**Java 11/17:** Core language for backend development.<br>

**Spring Boot:** Provides structure for RESTful APIs and application configuration.<br>

**Spring Security:** Manages authentication, authorization, and password hashing.<br>

**JPA/Hibernate:** For database interaction and persistence.<br>

**H2 Database:** In-memory database for testing and demo purposes.<br>

JUnit and Mockito: Frameworks for unit and integration testing.<br>
