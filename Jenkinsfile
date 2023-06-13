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
                        sh 'mvn clean verify sonar:sonar -Dsonar.login=admin -Dsonar.password=Gad67689@v -Dsonar.projectKey=Devops'
                  }
            }













        }

    }
