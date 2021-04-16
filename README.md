# debtors_system_springboot_demo

Project Description

This is a simple springboot project to create a debtors system.

Technologies Used

- vscode code editor / Intellij
- springboot framework
- postgresql
- Git version control
- Java

API Layers

model

debtors model and the properties

- Name
- Surname
- Email
- Age
- DOB - (Date of birth)
- ComapnyName
- Assets
- Quantity
- Balance

RestController

- @GetMapping - Get all debtors in database
- @GetMapping(path = "{id}") - Get debtor by id
- @PostMapping = Register debtor
- @DeleteMapping(path =  "delete{id}") = Delete debtor by id
- @PutMapping(path = "updateDebtor/{id})

Services

This is the business where you put the business logic 

- getDebtors -> function to get all debtors and returns a list
- getDebtorById -> get debtor details by id
- addNewDebtor -> Register new debtor
- updateDebtorDetails - updating debtor information in the database by id

Domain

DebtorDoa class used to interact with the database

Configuration

- Swagger configuration


Installation Instruction

1. clone repository link : https://github.com/lmolaodi/debtors_system_springboot_demo.git
2. add repo to IDE workspace
3. clean project with maven lifecycle
4. build project
5. run DebtorDemoApplication
