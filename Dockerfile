From yahyaqandel/mvn11-chrome
COPY . /app
WORKDIR /app
EXPOSE 9515
CMD mvn -B package --file pom.xml