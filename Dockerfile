FROM  openjdk:8-jre-alpine
EXPOSE 8080
ADD /target/names-convertor-*.jar names-convertor.jar
CMD ["/usr/bin/java","-jar","names-convertor.jar"]