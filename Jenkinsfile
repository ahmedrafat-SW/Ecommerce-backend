pipeline {
    agent any

    stages {
        stage('build') {
            agent {
                docker{
                    image 'maven:latest'
                    reuseNode true
                }
            }
            steps {
                  sh '''
                    ls -la
                    mvn --version
                    docker build -t postgres_ecommerce_db .
                    docker images
                    docker run -p 5433:5432 postgres_ecommerce_db:latest
                    mvn clean package -DskipTest
                    ls -la
                  '''
            }
        }
    }

}