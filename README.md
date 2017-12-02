# MandatoryTwo
SWC3 + TECH 2 Mandatory 

DEPLOY
===========
What We Implemented:
------------
-EC2 

-RDS

-VPC with 3 subnets

EC2
=====
    -Running Ubuntu on 18.195.195.79:8080
    -5 Security groups running TCP protocol on ports 22, 80, 8080, 8081, and 3306
    -Elastic IP
RDS
====
    -VPC with 3 subnets on port 3306
    
VPC
====
    -Public subnet
    -Private subnet
    -Availability subnet
    
    
Procedure
========

-   Open Cmd'er and ssh into the ubuntu ec2 (ssh -i [keypair] [username] @ [IPAddress])
-   gain root user access with 'sudo su'
-   using a fileuploading program, like filezilla, manually upload the jar
-   Naviagte to the remote path where the .jar was uploaded (In this instance, /opt/spring-app)
-   Run the java .jar
-   (java –jar –Dspring.profiles.active=prod mandatorytwo-0.0.1-SNAPSHOT.jar)
-   Navigate to the IP and port of the ec2 instance (18.195.195.79:8080)
