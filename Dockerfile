FROM amazoncorretto:11-alpine-jdk
COPY target/*.jar app.jar
# open port 8080
EXPOSE 8080
ENTRYPOINT ["java","-jar", "--add-opens java.base/java.lang=ALL-UNNAMED" ,"/app.jar"]
#Set up the above command but formatted properly so it can be used in the dockerfile
