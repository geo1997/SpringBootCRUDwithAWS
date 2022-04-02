FROM openjdk:11

EXPOSE 3000

ADD target/exam-portal.jar exam-portal.jar

ENTRYPOINT ["java", "-jar" , "exam-portal.jar"]