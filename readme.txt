Instruções para Instalação
Instalar Java 17.0.6-zulu
curl -s "https://get.sdkman.io" | bash
source ~/.sdkman/bin/sdkman-init.sh
sdk install java 17.0.6-zulu

Instalar Maven 3.8.7
sdk install maven 3.8.7


Buildar projeto (executar do diretorio base do projeto t1-distribuida)
mvn clean package

Executar teste local
java -jar target/trabalho1-0.0.1-SNAPSHOT.jar
