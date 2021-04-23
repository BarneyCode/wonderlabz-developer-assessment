# wonderlabz-developer-assessment

# Assumptions
1.	We should have a CASH account to have the corresponding cash deposits or cash withdrawals in the system.
2.	The System is a full backed service accessed via REST endpoints.
3.	CIF is customer identification Number and should be unique for each customer and is the first 5 digits of a customer account.  (NB logic to autoincrement not yet implemented)
    
    a.	Savings account (has trailing 0000)
    
    b.	Current account (has trailing 1111)
4.	The data.sql has been added to the resources path to add cash account foe development purposes.
5.	When creating a customer each account must be initialized with an initial balance
    
    a.	Savings account initial must be 1000.00.
    
    b.	Current is not required. Pass 0.0 as initial deposit if there is no initial deposit.

# Testing the API with Postman
There is a publicly accessible Collection which implements all methods below. 
https://www.getpostman.com/collections/57e1beb4a64eca44df24 

Methods include:
1.	Create Customer (also creates customer savings and current account)
2.	Cash Withdrawal
3.	Cash Deposit
4.	Funds Transfer

Alternatively, you can use the Swagger UI documentation as a guide.
http://localhost:9403/developer-test/swagger-ui.html

*NB replace IP address with appropriate IP address deployed.

# Improvements
1.	Create a Configuration Entity to save all the configuration i.e., CASH DEPOSIT ACCOUNT, Minimum balance for CURRENT and SAVINGS account etc.
2.	Add method that can show current account balance before customer transacts so that when wired with the frontend customer cannot withdraw amount less than one specified by rules
3.	Add more unit tests to the code.
