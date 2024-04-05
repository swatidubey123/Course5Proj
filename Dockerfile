FROM openjdk:11
RUN java -version
EXPOSE 8080
ADD target/HeathCarePhase5-0.0.1-SNAPSHOT.war HeathCarePhase5-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/HeathCarePhase5-0.0.1-SNAPSHOT.war" ]