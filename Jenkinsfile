pipeline {
    agent any
     tools {
          maven 'maven'

        }
    stages {
        stage('Clean') {
            steps {

                       sh  'mvn clean'



            }
            }


   stage('Compile') {
            steps {

                       sh  'mvn compile'



            }
            }

    stage('Test') {
            steps {
                       sh  'mvn test'
                  }
            }





  stage('SonarQube analysis') {
            steps {
                        sh 'mvn  sonar:sonar -Dsonar.login=admin -Dsonar.password=Gad67689@v -Dsonar.projectKey=Devops'
                  }
            }
stage('Build') {
            steps {
                        sh 'mvn package '
                  }
            }


stage('Deploy') {
            steps {
                        sh 'mvn deploy'
                  }
            }


 stage('build docker image') {
                steps {
                    script {
                        docker.build("achat:latest")
                    }
                }
            }






        }

    }
