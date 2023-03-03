FROM openjdk:17
COPY target/UserFinalTaskBoot-0.0.1-SNAPSHOT.jar UserFinalTaskBoot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserFinalTaskBoot-0.0.1-SNAPSHOT.jar"]

#run commands

#create docker image
#sudo docker build -t userfinaltaskboot .

#see image
#sudo docker images

#run image
#sudo docker run -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 userfinaltaskboot