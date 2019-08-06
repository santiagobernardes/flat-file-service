# Flat File Service

The Flat File Service is a service able to read flat files, analyze and output a report file to the user.

## The Problem

The Flat File Service was created in order to solve the problem of the Example Company, that has it's sales registered in flat files.
These flat files (.dat) contains the 3 resources that the company wants to be processed and analyzed - Salesmen, Customers and Sales.
The information that the company needs to be summarized from the input files is the following:
  - The amount of customers
  - The amount of salesmen
  - The ID of the most expensive sale
  - The worst salesman ever
  
  
The data inside the flat files follow patterns according to each kind of resource. See below:

## The Resources

### Salesman
Pattern:
```
001çCPFçNameçSalary
```
Example:
```
001ç03650364042çRenatoç40000.99
```

---

### Customer
Pattern:
```
002çCNPJçNameçBusiness Area
```
Example:
```
002ç23456754345443çJose da SilvaçRural
```

---

### Sale
Pattern:
```
003çSaleIDç[ItemID-ItemQuantity-ItemPrice]çSalesman name
```
Example:
```
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çRenato
```

## The Solution

To solve the problem of Example Company, the Flat File Service follows some steps, which are:

1. Search for all .dat files located in the input directory (./data/in/) and read their contents, returning a list that contains all the lines of the files;
2. As some of the lines could contain more than one information, the system breaks it all in different lines, separating each resource per line;
3. The system then reads all the lines and stores the data according to each resources' type;
4. Each resource has it's own processor with the logic responsible for reading, analyzing and outputting the needed information;
5. After processing all the data, the system then generates the output file in the output directory (./data/out/) with the summaryzed information.
