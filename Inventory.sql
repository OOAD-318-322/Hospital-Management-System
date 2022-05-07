drop database Hospital;
create database Hospital;
\c hospital
CREATE TABLE Inventory (
    EqpmtName varchar(250) NOT NULL,
    Type varchar(250) NOT NULL,
    Doctor varchar(250) NOT NULL,
    Issue_qty NUMERIC NOT NULL,
    PRIMARY KEY(EqpmtName)) ;


CREATE TABLE Report (
    PatientName varchar(250) NOT NULL,
    ApptDate DATE NOT NULL,
    DoctorName varchar(250) NOT NULL,
    Diagnosis varchar(250) NOT NULL,	
    Treatment varchar(250) NOT NULL,
    Prescription varchar(250) NOT NULL,
    PRIMARY KEY(PatientName));


create table listOfdoctors(Name varchar(30), Degree varchar(35), Department varchar(40), Available varchar(25));
insert into listOfdoctors(Name, Degree, Department, Available) values('Ashok Agarwal', 'M.D. Pediatrics', 'Pediatrics', '10:30am-4:00pm');
insert into listOfdoctors(Name, Degree, Department, Available) values('Sarita Gupta', 'M.D. Pediatrics', 'Pediatrics', '5:30pm-7:00pm');
insert into listOfdoctors(Name, Degree, Department, Available) values('Abhishek Sharma', 'MBBS', 'OB/GYN', '12:30pm-8:00pm');
insert into listOfdoctors(Name, Degree, Department, Available) values('Aditi Jose', 'MBBS, DNB', 'OB/GYN', '1:00pm-8:30pm');
insert into listOfdoctors(Name, Degree, Department, Available) values('Aditya Kumar', 'MBBS, M.D', ' Endocrinology', '2:30pm-6:00pm');
insert into listOfdoctors(Name, Degree, Department, Available) values('Prashanth R', 'MBBS, MS-Orthopaedics', 'Orthopedic Surgery', '3:00pm-7:30pm');
insert into listOfdoctors(Name, Degree, Department, Available) values('Shanti Reddy', 'MS-General Surgery', 'General Surgery', '10:00am-9:00pm');
insert into listOfdoctors(Name, Degree, Department, Available) values('Venkat Rao', 'MBBS, FRCS-General Surgery', 'General Surgery', '3:00pm-7:30pm');
insert into listOfdoctors(Name, Degree, Department, Available) values('Geet Singh', MS-'Ophthalmology', 'Ophthalmology', '10:00am-12:30pm');
insert into listOfdoctors(Name, Degree, Department, Available) values('Raghavendra', 'DM-Nephrology', 'Nephrology', '10:00am-3:30pm');


create table patients(Name varchar(30), PhoneNo varchar(15));
insert into patients(Name, PhoneNo) values('Shyam', '9876543120');
insert into patients(Name, PhoneNo) values('Ali', '8676443224');
insert into patients(Name, PhoneNo) values('Jo', '9776613258');
insert into patients(Name, PhoneNo) values('Mani', '8856512031');
insert into patients(Name, PhoneNo) values('Chethan', '7616154199');
insert into patients(Name, PhoneNo) values('Lalith', '8851318900');

create table DoctorCred(Name varchar(30), password varchar(10));
insert into DoctorCred(Name, password) values('Ashok Agarwal', 'Agarwal');
insert into DoctorCred(Name, password) values('Sarita Gupta', 'Gupta');
insert into DoctorCred(Name, password) values('Abhishek Sharma', 'Sharma');
insert into DoctorCred(Name, password) values('Aditi Jose', 'Jose');
insert into DoctorCred(Name, password) values('Aditya Kumar', 'Kumar');
insert into DoctorCred(Name, password) values('Prashant R', 'RPrashant');
insert into DoctorCred(Name, password) values('Shanti Reddy', 'Reddy');
insert into DoctorCred(Name, password) values('Venkat Rao', 'Rao');
insert into DoctorCred(Name, password) values('Geet Singh', 'Singh');
insert into DoctorCred(Name, password) values('Raghavendra', 'Raghav');

create table AdminCred(Name varchar(30), password varchar(10));
insert into AdminCred(Name, password) values('SwethaR', 'R123');
insert into AdminCred(Name, password) values('Mohini', 'M123');
insert into AdminCred(Name, password) values('Jaya', 'J123');
insert into AdminCred(Name, password) values('Rohit', 'Ro123');
insert into AdminCred(Name, password) values('Balu', 'B123');

