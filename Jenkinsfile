pipeline {
    agent any
    environment {
        registry = "momo5ms1/ValidationDevOps"
            registryCredential = 'DockerHubLogin'


        }
        tools {
          maven 'maven'

        }
        
    stages {

/*        stage('launch nexus & sonar') {

            steps {
                       sh  'cd sonar/ && docker-compose up -d'
            }

            }*/

        stage('Compile') {
            steps
            {
                sh  'mvn clean install -DskipTests && mvn compile'
            }
        }

        stage('Test') {
            steps 
            {
                sh  'mvn test'
            }
        }


        stage('SonarQube analysis') {
            steps {
                        sh 'mvn  sonar:sonar -Dsonar.login=admin -Dsonar.password=momo102030 -Dsonar.projectKey=MohamedDevOps'
                  }
            }
        stage('Build') {
            steps {
                        sh 'mvn package -DskipTests'
                  }
            }


        stage('Deploy') {
            steps {
                        sh 'mvn deploy -DskipTests'
                  }
            }


        stage('build docker image') {
                steps {
                    script {
                        dockerImage = docker.build registry + ":$BUILD_NUMBER"
                    }
                }
            }

        stage('push docker image') {
            steps {
                script {
                        docker.withRegistry( '', 'DockerHubLogin' ) {
                        dockerImage.push('latest')
                    }
                }
            }
        }

        stage('Cleaning up') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }

        stage('start Application ') {
            steps {
                sh 'docker compose up -d '
            }
        }

    }
}
