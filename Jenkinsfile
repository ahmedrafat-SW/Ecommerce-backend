pipeline {
    agent any

    stages {
        stage('build') {
            agent {
                docker{
                    image 'maven:eclipse-temurin:17-jdk-alpine'
                    reuseNode true
                }
            }
            steps {
                  sh '''
                    ls -la
                    mvn --version
                    mvn clean package -DskipTest
                    ls -la
                  '''
            }
        }
    }

}