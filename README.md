# Automobile_Servicing_Portal


Create database named as "asp" in mysql 5.0


Create database tables as follows - 
1. CREATE TABLE acc(id INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY, pwd TEXT NOT NULL, cpwd TEXT NOT NULL, name TEXT NOT NULL, addr TEXT NOT NULL, mail TEXT NOT NULL, mno BIGINT(10) NOT NULL);
2. create table card(cardno BIGINT(16) NOT NULL, cvv INT(3) NOT NULL);
3. CREATE TABLE feedback(name TEXT NOT NULL, rating INT(2) NOT NULL, rev TEXT NOT NULL);
4. CREATE TABLE griev(gid INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY, serno INT(5) NOT NULL, prob TEXT  NOT NULL, status VARCHAR(10) NOT NULL);
5. CREATE TABLE newseradmin(sid INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY, vehtyp VARCHAR(10) TEXT NOT NULL, sername TEXT NOT NULL, serprice INT(5) NOT NULL, descr TEXT NOT NULL);
6. CREATE TABLE serreqcust(serid INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY, reqby TEXT NOT NULL, stat VARCHAR(10) NOT NULL, vehtyp VARCHAR(10) NOT NULL, sertyp TEXT NOT NULL, bdate TEXT NOT NULL, serprice INT(5) NOT NULL);
