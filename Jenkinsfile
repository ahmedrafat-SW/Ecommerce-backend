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
                    mvn clean package -DskipTest
                    ls -la
                  '''
            }
        }
    }

}