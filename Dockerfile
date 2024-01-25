FROM openjdk:11
LABEL maintainer="Ashish Gautam"
ADD target/SpringMVCCRUDApp.war KhataBook.war
EXPOSE 8082
ENTRYPOINT ["java","-jar","KhataBook.war"]