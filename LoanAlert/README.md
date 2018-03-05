to run program use commandline: 

myprogram2.bat http://alert-generation-question.rockall-laser.com/ffc9c8e9-f929-46db-ac5c-7c483c647568/marketdata.json http://alert-generation-question.rockall-laser.com/ffc9c8e9-f929-46db-ac5c-7c483c647568/loandata.json http://alert-generation-question.rockall-laser.com/ffc9c8e9-f929-46db-ac5c-7c483c647568/creditpolicy.json

or 

./myprogram2.sh http://alert-generation-question.rockall-laser.com/ffc9c8e9-f929-46db-ac5c-7c483c647568/marketdata.json http://alert-generation-question.rockall-laser.com/ffc9c8e9-f929-46db-ac5c-7c483c647568/loandata.json http://alert-generation-question.rockall-laser.com/ffc9c8e9-f929-46db-ac5c-7c483c647568/creditpolicy.json

(please note github converts newLine character)




To build program use commandline: 

mvn clean package

----------------------------------------
I don't fully understand terminology used in requrements
Therefore, I'm not sure if I'm doing the correct logic

This is my understanding:
1) Each loan has general data and list of equities
2) Loan general data is appended with currency and minimumSharePrice per policy
3) ListOfEquities is appended with shareUnitPrice and shareCurrency
4) if ShareCurrency doesnt match LoanCurrency or shareUnitPrice is lower than minimumSharePrice, then shareCollateral is ignored (=0)
5)  else shareCollateral is shareUnitPrice x shareNumbers
6) LoanCollateralSum collects all individual shareCollaterals
7) if LoanCollateralSum is smaller than LoanAmount it is printed

There is a lot of space for java improvements and testing options
but I don't want to go too far, if this logic is incorrect
