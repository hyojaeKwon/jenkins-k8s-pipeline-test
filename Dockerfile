FROM openjdk:17
COPY ./ /usr/src/myapp/
WORKDIR /usr/src/myapp
ENTRYPOINT ["sh", "-c", "java -Dapplication.role=${application_role} -jar $(ls -t /usr/src/myapp/*.jar | head -n 1)"]
EXPOSE 8080