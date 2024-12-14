pipeline {
    agent any

    stages {
        stage('build-database-image') {
            steps {
                script {
                    def ecommerce_db = docker.build("ecommerce_db:${env.BUILD_ID}", "-f ./Dockerfile .")
                }
            }
        }

        stage('run-database-image') {
            steps {
                script {
                    sh '''bash -c '
                        docker images
                        docker run -d -p 5433:5432 ecommerce_db:${env.BUILD_ID}
                    ' '''
                }
            }
        }

        stage('build') {
            agent {
                docker {
                    image 'maven:latest'
                    reuseNode true
                }
            }
            steps {
                sh '''
                    ls -la
                    mvn --version
                    mvn clean package -DskipTests
                    ls -la
                '''
            }
        }
    }
}
